package emmakamutta.ui;

import emmakamutta.domain.Fabric;
import emmakamutta.domain.Grid;
import emmakamutta.domain.Loom;
import emmakamutta.domain.UniversalGrid;
import java.util.HashMap;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
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

    private static final int SQUARE_SIZE = 25;

    private Loom loom;
    private Boolean readyToWeave = false;
    private Boolean treadlesLocked = false;
    private Boolean heddlesLocked = false;

    public Ui() {
    }

    private Scene createWeaveScene() {
        //Luodaan näkymä uudelle kudontamallille
        GridPane weaveLayout = new GridPane();

        weaveLayout.setPrefSize(800, 1200);
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

        fabPane.setRotate(180);

        Button confirmTreadles = new Button("Lukitse sidonta");
        Button confirmHeddles = new Button("Lukitse niisintä");

        weaveLayout.add(confirmTreadles, 2, 3);
        weaveLayout.add(confirmHeddles, 1, 3);

        confirmTreadles.setOnAction((event) -> {
            treadPane.setModifiable(false);
            loom.setTreadles(treadPane.convertToTreadles());
            this.treadlesLocked = true;
            if (treadlesLocked && heddlesLocked) {
                this.readyToWeave = true;
            }
        });

        confirmHeddles.setOnAction((event) -> {
            hedPane.setModifiable(false);
            loom.setHeddles(hedPane.convertToHeddles());
            this.heddlesLocked = true;
            if (treadlesLocked && heddlesLocked) {
                this.readyToWeave = true;
            }
        });

        HBox weavingButtons = new HBox();
        weavingButtons.setSpacing(30);
        
        HBox treadleButtons = new HBox();
        for (int i = 0; i < loom.treadleAmount; i++) {
            Button treadleButton = new Button("Poljin " + (i + 1));
            int buttonNmbr = Integer.parseInt(treadleButton.getText().substring(7)) - 1;

            treadleButton.setOnAction((event) -> {
                if (readyToWeave) {

                    this.loom.weave(buttonNmbr);
                    fabPane.visualizeFabric(this.loom.fabric);
                    toPane.visualize(buttonNmbr);
                } else {
                    Alert notReadyAlert = new Alert(AlertType.ERROR);
                    notReadyAlert.setTitle("Virhe");
                    notReadyAlert.setHeaderText("Ei valmis kutomaan");
                    notReadyAlert.setContentText("Lukitse ensin niisintä ja polkusten sidonta");

                    notReadyAlert.showAndWait();
                }
            });

            treadleButtons.getChildren().add(treadleButton);
        }
        
        weavingButtons.getChildren().add(treadleButtons);
        
        Button undoButton = new Button("Peruuta");
        undoButton.setOnAction((event) -> {
            this.loom.undo();
            fabPane.visualizeFabric(this.loom.fabric);
            toPane.clearLatestRow();
        });
        
        weavingButtons.getChildren().add(undoButton);
        
        weaveLayout.add(weavingButtons, 1, 4);

        Button clearButton = new Button("Tyhjennä kangas");
        clearButton.setOnAction((event) -> {
            this.loom.fabric = new Fabric(this.loom.fabricWidth);
            fabPane.visualizeFabric(this.loom.fabric);
            toPane.clear();
        });
        
        weaveLayout.add(clearButton, 1, 0);

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
        menu.setSpacing(10);
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
