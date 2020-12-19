package emmakamutta.ui;

import emmakamutta.domain.Fabric;
import emmakamutta.domain.Loom;
import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * Kudontasovelluksen graafisesta käyttöliittymästä vastaava luokka.
 */
public class Ui extends Application {

    private int squareSize = 25;

    private Loom loom;
    private Boolean readyToWeave = false;
    private Boolean treadlesLocked = false;
    private Boolean heddlesLocked = false;

    private Stage window;

    public Ui() {
    }

    /**
     * Metodi rakentaa graafisen kudontanäkymän valmiiksi määritellyille
     * kangaspuille. Näkymä sisältää neljä erilaista ruudukkoa ja usita nappeja.
     *
     * @return Scene jossa on valmis kudontanäkymä toiminnallisuuksineen
     */
    private Scene createWeaveScene() {
        
        ScrollPane root = new ScrollPane();
        root.setPrefSize(800, 800);

        GridPane weaveLayout = new GridPane();
        root.setContent(weaveLayout);
        Scene weaveScene = new Scene(root);

        weaveLayout.setAlignment(Pos.TOP_LEFT);
        weaveLayout.setVgap(15);
        weaveLayout.setHgap(15);
        weaveLayout.setPadding(new Insets(20, 20, 20, 20));

        TreadlesPane treadlesPane = new TreadlesPane(loom, squareSize);
        FabricPane fabricPane = new FabricPane(loom, squareSize);
        HeddlesPane heddlesPane = new HeddlesPane(loom, squareSize);
        TreadOrderPane treadOrderPane = new TreadOrderPane(loom, squareSize);

        weaveLayout.add(fabricPane, 1, 1);
        weaveLayout.add(treadOrderPane, 2, 1);
        weaveLayout.add(heddlesPane, 1, 2);
        weaveLayout.add(treadlesPane, 2, 2);

        fabricPane.setRotate(180);
        heddlesPane.setRotate(180);

        Button confirmTreadles = new Button("Lukitse sidonta");
        Button confirmHeddles = new Button("Lukitse niisintä");

        weaveLayout.add(confirmTreadles, 2, 3);
        weaveLayout.add(confirmHeddles, 1, 3);

        confirmTreadles.setOnAction((event) -> {
            treadlesPane.setModifiable(false);
            loom.setTreadles(treadlesPane.convertToTreadles());
            this.treadlesLocked = true;
            if (treadlesLocked && heddlesLocked) {
                this.readyToWeave = true;
            }
            treadlesPane.setLockedColors();
        });

        confirmHeddles.setOnAction((event) -> {
            heddlesPane.setModifiable(false);
            loom.setHeddles(heddlesPane.convertToHeddles());
            this.heddlesLocked = true;
            if (treadlesLocked && heddlesLocked) {
                this.readyToWeave = true;
            }
            heddlesPane.setLockedColors();
        });

        HBox weavingButtons = new HBox();
        weavingButtons.setSpacing(30);

        HBox treadleButtons = new HBox();
        for (int i = 0; i < loom.treadleAmount; i++) {
            Button treadleButton = new Button("Poljin " + (i + 1));
            int buttonNmbr = Integer.parseInt(treadleButton.getText().substring(7)) - 1;

            treadleButton.setOnAction((event) -> {
                if (this.readyToWeave) {

                    this.loom.weave(buttonNmbr);
                    fabricPane.visualizeFabric(this.loom.fabric);
                    treadOrderPane.visualize(buttonNmbr);
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
                fabricPane.visualizeFabric(this.loom.fabric);
                treadOrderPane.clearLatestRow();
            }
        });

        weavingButtons.getChildren().add(undoButton);

        weaveLayout.add(weavingButtons, 1, 4);

        HBox controlButtons = createControlButtons(fabricPane, treadOrderPane, weaveScene);
        weaveLayout.add(controlButtons, 1, 0);

        return weaveScene;
    }

    /**
     * Metodi luo käyttöliittymää varten tarvittavat hallintanappulat.
     *
     * @param fabricPane käyttöliittymän kangasta esittävä FabricPane
     * @param treadOrderPane käyttöliittymän poljentajärjestystä kuvaava
     * TreadOrderPane
     * @param layout Scene, johon palautettava HBox sijoitetaan
     * @return HBox, joka sisältää tarvittavat nappulat toiminnallisuuksineen
     */
    private HBox createControlButtons(FabricPane fabricPane, TreadOrderPane treadOrderPane, Scene scene) {
        HBox controlButtons = new HBox();
        controlButtons.setSpacing(30);
        Button clearButton = new Button("Tyhjennä kangas");
        clearButton.setOnAction((event) -> {
            this.loom.fabric = new Fabric(this.loom.fabricWidth);
            fabricPane.visualizeFabric(this.loom.fabric);
            treadOrderPane.clear();
        });

        controlButtons.getChildren().add(clearButton);

        Button clearAllButton = new Button("Tyhjennä kaikki");
        clearAllButton.setOnAction((event) -> {
            Loom clearedLoom = new Loom(this.loom.shafts, this.loom.treadleAmount, this.loom.fabricWidth);
            this.loom = clearedLoom;
            this.readyToWeave = false;
            this.treadlesLocked = false;
            this.heddlesLocked = false;
            this.window.setScene(createWeaveScene());
        });

        controlButtons.getChildren().add(clearAllButton);

        Button newModelButton = new Button("Uusi malli");
        newModelButton.setOnAction((event) -> {
            this.window.setScene(createCustomizeScene());
        });

        controlButtons.getChildren().add(newModelButton);

        Button saveButton = new Button("Tallenna kuvana");
        saveButton.setOnAction((event) -> {
            saveAsImage(scene);
        });

        controlButtons.getChildren().add(saveButton);
        return controlButtons;
    }

    /**
     * Metodi toteuttaa toiminnallisuuden, jolla käyttäjä voi tallentaa
     * sovelluksen näkymän haluamaansa paikalliseen kansioon tietokoneellaan
     * png-kuvana.
     *
     * @param scene näkymä, joka tallennetaan
     */
    private void saveAsImage(Scene scene) {
        WritableImage image = scene.snapshot(null);
        FileChooser fileChooser1 = new FileChooser();
        fileChooser1.setTitle("Tallenna kuvana");

        FileChooser.ExtensionFilter pngFilter = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.png");
        fileChooser1.getExtensionFilters().add(pngFilter);
        File file = fileChooser1.showSaveDialog(this.window);
        if (file != null) {
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(image,
                        null), "PNG", file);
            } catch (IOException ex) {
            }
        }
    }

    /**
     * Metodi rakentaa graafisen näkymän, jossa voi konfiguroida käytettävät
     * kangaspuut. Scenen toiminnallisuuksiin kuuluu kaksi slideria, joilla voi
     * määritellä niisivastien ja polkusten lukumäärän välillä 4-8.
     *
     * @return Scene, joka sisältää valmiin näkymän toiminnallisuuksineen
     */
    private Scene createCustomizeScene() {

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

        Slider fabricSlider = new Slider();
        fabricSlider.setMin(15);
        fabricSlider.setMax(35);
        fabricSlider.setValue(20);
        fabricSlider.setShowTickLabels(true);
        fabricSlider.setShowTickMarks(true);
        fabricSlider.setMajorTickUnit(5);
        fabricSlider.setMinorTickCount(0);
        fabricSlider.setSnapToTicks(true);
        fabricSlider.setBlockIncrement(5);

        layout.add(new Label("Kankaan leveys ruutuina: "), 0, 4);
        layout.add(fabricSlider, 1, 4);

        Button createButton = new Button("Luo");
        createButton.setOnAction((event) -> {
            int shafts = (int) heddlesSlider.getValue();
            int treadles = (int) treadlesSlider.getValue();
            int fabricWidth = (int) fabricSlider.getValue();
            this.loom = new Loom(shafts, treadles, fabricWidth);
            if (fabricWidth >= 30) {
                this.squareSize = 20;
            }
            this.window.setScene(createWeaveScene());
        });

        layout.add(createButton, 1, 5);
        Scene customizeScene = new Scene(layout);
        return customizeScene;
    }

    /**
     * Metodi käynnistää käyttöliittymän ja asettaa ensin näkyville
     * tervetulonäkymän.
     *
     * @param window
     * @throws Exception
     */
    @Override
    public void start(Stage window) throws Exception {
        this.window = window;
        window.setTitle("Kudontasovellus");

        createWelcomeScene();
        window.show();
    }

    /**
     * Metodi luo käyttöliittymän tervetulonäkymän.
     */
    private void createWelcomeScene() {

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
            this.window.setScene(createCustomizeScene());
        });
        this.window.setScene(welcome);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
