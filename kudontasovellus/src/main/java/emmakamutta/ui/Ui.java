package emmakamutta.ui;

import emmakamutta.domain.Grid;
import emmakamutta.domain.Loom;
import emmakamutta.domain.UniversalGrid;
import java.util.HashMap;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * Tänne tulee käyttöliittymä
 */
public class Ui extends Application {

    private static final int SQUARE_SIZE = 30;

    private Loom loom;

    public Ui() {
    }

    private Scene createWeaveScene() {
        //Luodaan näkymä uudelle kudontamallille
        GridPane weaveLayout = new GridPane();

        weaveLayout.setPrefSize(800, 800);
        weaveLayout.setAlignment(Pos.TOP_LEFT);
        weaveLayout.setVgap(20);
        weaveLayout.setHgap(20);
        weaveLayout.setPadding(new Insets(20, 20, 20, 20));

        TreadlesPane treadPane = new TreadlesPane(loom, SQUARE_SIZE);
        FabricPane fabPane = new FabricPane(loom, SQUARE_SIZE);
        HeddlesPane hedPane = new HeddlesPane(loom, SQUARE_SIZE);
        TreadOrderPane toPane = new TreadOrderPane(loom, SQUARE_SIZE);

        weaveLayout.add(fabPane, 1, 1);
        weaveLayout.add(toPane, 2, 1);
        weaveLayout.add(hedPane, 1, 2);
        weaveLayout.add(treadPane, 2, 2);

        Button confirmTreadles = new Button("Lukitse sidonta");
        Button confirmHeddles = new Button("Lukitse niisintä");

        weaveLayout.add(confirmTreadles, 2, 3);
        weaveLayout.add(confirmHeddles, 1, 3);

        confirmTreadles.setOnAction((event) -> {
            treadPane.setModifiable(false);
            loom.setTreadles(treadPane.convertToTreadles());
            
        });

        confirmHeddles.setOnAction((event) -> {
            hedPane.setModifiable(false);
            loom.setHeddles(hedPane.convertToHeddles()); 
           
        });

        HBox treadleButtons = new HBox();
        for (int i = 0; i < loom.treadleAmount; i++) {
            Button treadleButton = new Button("Poljin " + (i + 1));
            
            treadleButton.setOnAction((event) -> {
                //loom.weave(i);
            });

            treadleButtons.getChildren().add(treadleButton);
        }
        weaveLayout.add(treadleButtons, 1, 4);
        
        final Label info = new Label("Vinkki: klikkaa ruutuja");

        weaveLayout.add(info, 2, 4);
        
        Scene weaveScene = new Scene(weaveLayout);

        return weaveScene;
    }

    private Scene createCustomScene() {
        //Luodaan näkymä uudelle kudontamallille itse määritellyillä kangaspuilla
        GridPane weaveLayout = new GridPane();
        weaveLayout.add(new Label("Tulossa pian ;)"), 1, 1);
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

        menu.getChildren().addAll(createNew, createCustom);
        layout.add(menu, 1, 1);

        layout.setPrefSize(300, 180);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        Scene welcome = new Scene(layout);

        //Lisätään toiminnallisuudet tervetulonäkymän napeille
        createNew.setOnAction((event) -> {
            this.loom = new Loom();
            window.setScene(createWeaveScene());
        });

        createCustom.setOnAction((event) -> {
            window.setScene(createCustomScene());
        });

        window.setScene(welcome);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
