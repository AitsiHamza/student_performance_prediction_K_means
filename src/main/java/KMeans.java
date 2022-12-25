import java.util.*;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.ScatterChart;
import javafx.stage.Stage;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
public class KMeans {

    //Number of Clusters. This metric should be related to the number of points
    private int NUM_CLUSTERS = 5;
    //Number of Points
    private int NUM_POINTS = 100;
    //Min and Max X and Y
    private static final int MIN_COORDINATE = 1;
    private static final int MAX_COORDINATE = 100;

    private List<Point> points;
    private List<Cluster> clusters;
    private Map<Integer,List<Point>> matClusters;

    public KMeans() {
        this.points = new ArrayList<Point>();
        this.clusters = new ArrayList<Cluster>();
        matClusters=new HashMap<Integer,List<Point>>();
		/*for (int i = 0; i < NUM_CLUSTERS; i++) {
			matClusters.put(i,null);
		}*/
    }



    //Initializes the process
    public void init() {
        //Create Points
        points = Point.createRandomPoints(MIN_COORDINATE,MAX_COORDINATE,NUM_POINTS);

        //Create Clusters
        //Set Random Centroids
        for (int i = 0; i < NUM_CLUSTERS; i++) {
            Cluster cluster = new Cluster(i);
            Point centroid = Point.createRandomPoint(MIN_COORDINATE,MAX_COORDINATE);
            cluster.setCentroid(centroid);
            clusters.add(cluster);
        }

        //Print Initial state
        plotClusters();
    }

    private void plotClusters() {
        for (int i = 0; i < NUM_CLUSTERS; i++) {
            Cluster c = clusters.get(i);
            matClusters.put(i,c.plotCluster());
        }
    }

    //The process to calculate the K Means, with iterating method.
    public void calculate() throws InterruptedException {
        boolean finish = false;
        int iteration = 0;

        // Add in new data, one at a time, recalculating centroids with each new one.
        while(!finish) {
            //Clear cluster state
            clearClusters();

            List<Point> lastCentroids = getCentroids();

            //Assign points to the closer cluster
            assignCluster();

            //Calculate new centroids.
            calculateCentroids();

            iteration++;

            List<Point> currentCentroids = getCentroids();

            //Calculates total distance between new and old Centroids
            double distance = 0;
            for(int i = 0; i < lastCentroids.size(); i++) {
                distance += Point.distance(lastCentroids.get(i),currentCentroids.get(i));
            }
/*        	System.out.println("#################");
        	System.out.println("Iteration: " + iteration);
        	System.out.println("Centroid distances: " + distance);
        	plotClusters();*/
            System.out.println("***************New iteration***************");
            plotClusters_JavaFX(iteration);
            if(distance == 0) {
                finish = true;
            }
        }
    }

    private void clearClusters() {
        for(Cluster cluster : clusters) {
            cluster.clear();
        }
    }

    private List<Point> getCentroids() {
        List<Point> centroids = new ArrayList<Point>(NUM_CLUSTERS);
        for(Cluster cluster : clusters) {
            Point aux = cluster.getCentroid();
            Point point = new Point(aux.getList());
            centroids.add(point);
        }
        return centroids;
    }

    private void assignCluster() {
        double max = Double.MAX_VALUE;
        double min = max;
        int cluster = 0;
        double distance = 0.0;

        for(Point point : points) {
            min = max;
            for(int i = 0; i < NUM_CLUSTERS; i++) {
                Cluster c = clusters.get(i);
                distance = Point.distance(point, c.getCentroid());
                if(distance < min){
                    min = distance;
                    cluster = i;
                }
            }
            point.setCluster(cluster);
            clusters.get(cluster).addPoint(point);
        }
    }

    private void calculateCentroids() {
        for(Cluster cluster : clusters) {

            List<Point> list = cluster.getPoints();
            int n_points = list.size();
            List<Double> sum = new ArrayList<Double>();



            for(Point point : list) {

                if(sum.isEmpty())
                    for(int start=0;start<2;start++)
                        sum.add(point.getList().get(start));
                else
                    for(int start=0;start<2;start++)
                        sum.set(start,point.getList().get(start)+sum.get(start));

            }

            Point centroid = cluster.getCentroid();
            if(n_points > 0) {
                for(int start=0;start<2;start++)
                    centroid.getList().set(start,sum.get(start)/n_points);
            }
        }
    }

    private void plotClusters_JavaFX(int iteration){
        Stage stage = new Stage();
        stage.setTitle("Scatter Chart Sample");
        final NumberAxis xAxis = new NumberAxis(0, 100, 1);
        final NumberAxis yAxis = new NumberAxis(0, 100, 1);
        final ScatterChart<Number,Number> sc = new
                ScatterChart<Number,Number>(xAxis,yAxis);
        xAxis.setLabel("X");
        yAxis.setLabel("Y");
        sc.setTitle("Iteration :"+iteration);

        XYChart.Series[] listSeries = new XYChart.Series[]{new XYChart.Series(),new XYChart.Series(),new XYChart.Series(),new XYChart.Series(),new XYChart.Series()};
        XYChart.Series[] listSeries_centroid = new XYChart.Series[]{new XYChart.Series(),new XYChart.Series(),new XYChart.Series(),new XYChart.Series(),new XYChart.Series()};

        for (int i = 0; i < NUM_CLUSTERS; i++) {
            listSeries[i].setName("Cluster"+i);
            List<Point> points = matClusters.get(i);
            for (Point p : points) {
                System.out.println("->"+p.getList());
                listSeries[i].getData().add(new XYChart.Data(p.getList().get(0),p.getList().get(1) ));
            }
            listSeries_centroid[i].getData().add(new XYChart.Data(clusters.get(i).centroid.getList().get(0),clusters.get(i).centroid.getList().get(1)));
        }
        //listSeries[0].getChart().setStyle("-fx-stroke: black; -fx-stroke-width: 1px; -fx-effect: null; -fx-stroke-dash-array: 10 10 10 10;");

        System.out.println(listSeries[0].getChart());

        if(listSeries[0].getNode()!=null){
            System.out.println("#############################");
            System.out.println("\tnode not null");
            System.out.println("#############################");

            //Node line = listSeries[0].getNode().lookup(".chart-series-line");
            //line.setStyle("-fx-stroke: black; -fx-stroke-width: 1px; -fx-effect: null; -fx-stroke-dash-array: 10 10 10 10;");
        }else{
        }
        sc.getData().addAll(listSeries[0],listSeries[1],listSeries[2],listSeries[3],listSeries[4],
                listSeries_centroid[0],listSeries_centroid[1],listSeries_centroid[2],listSeries_centroid[3],listSeries_centroid[4]);


        Scene scene  = new Scene(sc, 600, 600);
        scene.getStylesheets().add("styles/style.css");
        stage.setScene(scene);
        stage.show();
    }
}
