import javafx.application.Application;
import javafx.stage.Stage;
import kmeans.KMeans;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws InterruptedException {

        KMeans kmeans = new KMeans();
        kmeans.init();
        kmeans.calculate();

    }
}
