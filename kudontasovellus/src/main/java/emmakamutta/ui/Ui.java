package emmakamutta.ui;

import emmakamutta.domain.Fabric;
import emmakamutta.domain.Grid;
import emmakamutta.domain.Loom;
import emmakamutta.domain.UniversalGrid;
import java.util.HashMap;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
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
    
    private Stage window;

    public Ui() {
    }

    private Scene createWeaveScene() {
        //Luodaan näkymä uudelle kudontamallille
        GridPane weaveLayout = new GridPane();

        weaveLayout.setPrefSize(800, 600);
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
            treadPane.setLockedColors();
        });

        confirmHeddles.setOnAction((event) -> {
            hedPane.setModifiable(false);
            loom.setHeddles(hedPane.convertToHeddles());
            this.heddlesLocked = true;
            if (treadlesLocked && heddlesLocked) {
                this.readyToWeave = true;
            }
            hedPane.setLockedColors();
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
            if (this.loom.fabric.weavedRows > 0) {

                this.loom.undo();
                fabPane.visualizeFabric(this.loom.fabric);
                toPane.clearLatestRow();
            }
        });

        weavingButtons.getChildren().add(undoButton);

        weaveLayout.add(weavingButtons, 1, 4);
        
        HBox clearingButtons = new HBox();
        clearingButtons.setSpacing(30);

        Button clearButton = new Button("Tyhjennä kangas");
        clearButton.setOnAction((event) -> {
            this.loom.fabric = new Fabric(this.loom.fabricWidth);
            fabPane.visualizeFabric(this.loom.fabric);
            toPane.clear();
        });
        
        clearingButtons.getChildren().add(clearButton);
        weaveLayout.add(clearingButtons, 1, 0);

        Button clearAllButton = new Button("Tyhjennä kaikki");
        clearAllButton.setOnAction((event) -> {
            Loom clearedLoom = new Loom(this.loom.shafts, this.loom.treadleAmount);
            this.loom = clearedLoom;
            createWeaveScene();
        });
        
        clearingButtons.getChildren().add(clearAllButton);
        
        Button newModelButton = new Button("Uusi malli");
        newModelButton.setOnAction((event) -> {
            
        });
        

        Scene weaveScene = new Scene(weaveLayout);

        return weaveScene;
    }

    private Scene createCustomScene() {
        //Luodaan näkymä uudelle kudontamallille itse määritellyillä kangaspuilla
        GridPane layout = new GridPane();
        layout.setPrefSize(300, 300);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        Slider heddlesSlider = new Slider();
        heddlesSlider.setMin(2);
        heddlesSlider.setMax(8);
        heddlesSlider.setValue(4);
        heddlesSlider.setShowTickLabels(true);
        heddlesSlider.setShowTickMarks(true);
        heddlesSlider.setMajorTickUnit(1);
        heddlesSlider.setMinorTickCount(0);
        heddlesSlider.setSnapToTicks(true);
        heddlesSlider.setBlockIncrement(1);

        layout.add(new Label("Niisivarsia: "), 0, 2);
        layout.add(heddlesSlider, 1, 2);

        Slider treadlesSlider = new Slider();
        treadlesSlider.setMin(2);
        treadlesSlider.setMax(8);
        treadlesSlider.setValue(4);
        treadlesSlider.setShowTickLabels(true);
        treadlesSlider.setShowTickMarks(true);
        treadlesSlider.setMajorTickUnit(1);
        treadlesSlider.setMinorTickCount(0);
        treadlesSlider.setSnapToTicks(true);
        treadlesSlider.setBlockIncrement(1);

        layout.add(new Label("Polkusia: "), 0, 3);
        layout.add(treadlesSlider, 1, 3);

        this.loom = new Loom(3, 5);

        Button continueButton = new Button("Luo");
        continueButton.setOnAction((event) -> {
            int shafts = (int) heddlesSlider.getValue();
            int treadles = (int) treadlesSlider.getValue();
            this.loom = new Loom(shafts, treadles);
            this.window.setScene(createWeaveScene());
        });

        layout.add(continueButton, 1, 4);
        Scene customizeScene = new Scene(layout);
        return customizeScene;
    }
    


    @Override
    public void start(Stage window) throws Exception {
        this.window = window;
        window.setTitle("Kudontasovellus");

        //Luodaan ensin tervetulonäkymä
        GridPane layout = new GridPane();
        VBox menu = new VBox();
        menu.setSpacing(10);
        Button createButton = new Button("Uusi kudontamalli");

        menu.getChildren().addAll(createButton);
        layout.add(menu, 1, 1);

        layout.setPrefSize(300, 180);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(20, 20, 20, 20));

        Scene welcome = new Scene(layout);

        createButton.setOnAction((event) -> {
            this.window.setScene(createCustomScene());
        });

        window.setScene(welcome);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
