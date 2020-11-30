
package emmakamutta.ui;

import emmakamutta.domain.Loom;
import java.util.HashMap;
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

    private static final int SQUARE_SIZE = 40; 
    
    public Ui(){
    }
    
    private Pane makeTreadedPane(Loom loom) {
        Pane treadedPane = new Pane();
        treadedPane.setPrefSize(loom.fabricWidth*SQUARE_SIZE, loom.treadleAmount*SQUARE_SIZE);
        
        return treadedPane;
    }
    
    private Pane makeFabricPane(Loom loom) {
        Pane fabricPane = new Pane();
        fabricPane.setPrefSize(loom.fabricWidth*SQUARE_SIZE, loom.fabricWidth*SQUARE_SIZE);
        
        return fabricPane;
    }
    
    private Pane makeHeddlesPane(Loom loom) {
        Pane heddlesPane = new Pane();
        heddlesPane.setPrefSize(loom.shafts*SQUARE_SIZE, loom.fabricWidth*SQUARE_SIZE);
        
        return heddlesPane;
    }
    
    private Pane makeTreadlesPane(Loom loom) {
        Pane treadlesPane = new Pane();
        
        treadlesPane.setPrefSize(loom.shafts * SQUARE_SIZE, loom.treadleAmount * SQUARE_SIZE);
        
        return treadlesPane;
    }
    
    private HashMap<String, Pane> createLoomComponents(Loom loom) {
        HashMap<String, Pane> components = new HashMap<>();
        
        components.put("Treadles", makeTreadlesPane(loom));
        components.put("Heddles", makeHeddlesPane(loom));
        components.put("Fabric", makeFabricPane(loom));
        components.put("Treaded", makeTreadedPane(loom));
        
        return components;
    }
    
    private Scene createWeaveScene(Loom loom) {
        //Luodaan näkymä uudelle kudontamallille
        GridPane weaveLayout = new GridPane();
        
        weaveLayout.setPrefSize(300, 180);
        weaveLayout.setAlignment(Pos.CENTER);
        weaveLayout.setVgap(10);
        weaveLayout.setHgap(10);
        weaveLayout.setPadding(new Insets(20, 20, 20, 20));
        
        HashMap<String,Pane> components = createLoomComponents(loom);
        weaveLayout.add(components.get("Fabric"), 1, 1);
        weaveLayout.add(components.get("Treaded"), 1, 2);
        weaveLayout.add(components.get("Heddles"), 2, 1);
        weaveLayout.add(components.get("Treadles"), 2, 2);
        
        weaveLayout.add(new Label("Päästiin tänne"), 0, 0);
        
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
        createNew.setOnAction((event) ->{
            Loom loom = new Loom();
            window.setScene(createWeaveScene(loom));
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
