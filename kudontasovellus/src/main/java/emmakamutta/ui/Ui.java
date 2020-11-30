
package emmakamutta.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;
/**
 *
 * Tänne tulee käyttöliittymä
 */
public class Ui extends Application{

    public Ui(){
    }
    
    private Pane createNewDefaultLoom() {
        
        
        return null;
    }
    
    private Scene createDefaultScene() {
        //Luodaan näkymä uudelle kudontamallille oletuskangaspuilla
        GridPane weaveLayout = new GridPane();
        weaveLayout.add(new Label("Näkymä vaihtui"), 1, 1);
        weaveLayout.setPrefSize(300, 180);
        weaveLayout.setAlignment(Pos.CENTER);
        weaveLayout.setVgap(10);
        weaveLayout.setHgap(10);
        weaveLayout.setPadding(new Insets(20, 20, 20, 20));
        
        Scene defaultScene = new Scene(weaveLayout);
        
        return defaultScene;
    }
    
    private Scene createCustomScene() {
        //Luodaan näkymä uudelle kudontamallille itse määritellyillä kangaspuilla
        GridPane weaveLayout = new GridPane();
        weaveLayout.add(new Label("Tulossa pian :)"), 1, 1);
        weaveLayout.setPrefSize(300, 180);
        weaveLayout.setAlignment(Pos.CENTER);
        weaveLayout.setVgap(10);
        weaveLayout.setHgap(10);
        weaveLayout.setPadding(new Insets(20, 20, 20, 20));
        
        Scene defaultScene = new Scene(weaveLayout);
        
        return defaultScene;
    }

    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("Kudontasovellus");
        
        //Luodaan ensin tervetulonäkymä
        GridPane layout = new GridPane();
        VBox menu = new VBox();
        Button createNew = new Button("Uusi kudontamalli");
        Button createCustom = new Button("Uusi kudontamalli omilla asetuksilla");
        
        menu.getChildren().addAll(createNew,createCustom);
        layout.add(menu,1,1);
        
        layout.setPrefSize(300, 180);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        Scene welcome = new Scene(layout);
        
        
        //Lisätään toiminnallisuudet tervetulonäkymän napeille
        createNew.setOnAction( (event) ->{
            window.setScene(createDefaultScene());
        });
        
        createCustom.setOnAction( (event) ->{
            window.setScene(createCustomScene());
        });
      

        window.setScene(welcome);
        window.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
