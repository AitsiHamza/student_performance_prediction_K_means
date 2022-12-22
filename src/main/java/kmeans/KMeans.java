package kmeans;

import entities.Student;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KMeans {

    //Number of Clusters. This metric should be related to the number of points
    private int NUM_CLUSTERS = 5;
    //Min and Max X and Y
    private static final int MIN_COORDINATE = 0;
    private static final int MAX_COORDINATE = 100;

    private List<Student> students;
    private List<Cluster> clusters;
    private Map<Integer,List<Student>> matClusters;

    public KMeans() {
        this.students = new ArrayList<>();
        this.clusters = new ArrayList<>();
        matClusters=new HashMap<Integer,List<Student>>();
    }



    //Initializes the process
    public void init() {
        CsvToList csvToList=new CsvToList();
        students = csvToList.getAllStudents();

        //Create Clusters
        //Set Random Centroids
        for (int i = 0; i < NUM_CLUSTERS; i++) {
            Cluster cluster = new Cluster(i);
            Student centroid = new Student();
            centroid=centroid.randomStudent();
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

            List<Student> lastCentroids = getCentroids();

            //Assign points to the closer cluster
            assignCluster();

            //Calculate new centroids.
            calculateCentroids();

            iteration++;

            List<Student> currentCentroids = getCentroids();

            //Calculates total distance between new and old Centroids
            double distance = 0;
            for(int i = 0; i < lastCentroids.size(); i++) {
                distance += Student.distance(lastCentroids.get(i),currentCentroids.get(i));
            }
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

    private List<Student> getCentroids() {
        List<Student> centroids = new ArrayList<>(NUM_CLUSTERS);
        for(Cluster cluster : clusters) {
            Student student = cluster.getCentroid();
            centroids.add(student);
        }
        return centroids;
    }

    private void assignCluster() {
        double max = Double.MAX_VALUE;
        double min = max;
        int cluster = 0;
        double distance = 0.0;

        for(Student student : students) {
            min = max;
            for(int i = 0; i < NUM_CLUSTERS; i++) {
                Cluster c = clusters.get(i);
                distance = Student.distance(student, c.getCentroid());
                if(distance < min){
                    min = distance;
                    cluster = i;
                }
            }
            student.setCluster(cluster);
            clusters.get(cluster).addStudent(student);
        }
    }

    private void calculateCentroids() {
        for(Cluster cluster : clusters) {

            List<Student> list = cluster.getStudents();
            int n_points = list.size();
            List<Integer> sum = new ArrayList<>();



            for(Student student : list) {

                if(sum.isEmpty())
                    for(int start=0;start<7;start++)
                        sum.add(student.getList().get(start));
                else
                    for(int start=0;start<7;start++)
                        sum.set(start,student.getList().get(start)+sum.get(start));

            }

            Student centroid = cluster.getCentroid();
            if(n_points > 0) {
                for(int start=0;start<7;start++)
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
            listSeries[i].setName("test.Cluster"+i);
            List<Student> students = matClusters.get(i);
            for (Student s : students) {
                System.out.println("->"+s.getList());
                listSeries[i].getData().add(new XYChart.Data(s.getList().get(5),s.getList().get(7) ));
            }
            listSeries_centroid[i].getData().add(new XYChart.Data(clusters.get(i).centroid.getList().get(5),clusters.get(i).centroid.getList().get(7)));
        }

        sc.getData().addAll(listSeries[0],listSeries[1],listSeries[2],listSeries[3],listSeries[4],
                listSeries_centroid[0],listSeries_centroid[1],listSeries_centroid[2],listSeries_centroid[3],listSeries_centroid[4]);

        Scene scene  = new Scene(sc, 600, 600);
        scene.getStylesheets().add("styles/style.css");
        stage.setScene(scene);
        stage.show();
    }
}
