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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * Tänne tulee käyttöliittymä
 */
public class Ui extends Application {

    private static final int SQUARE_SIZE = 30;

    private boolean modifiableHeddles;
    private boolean modifiableTreadles;

    private int[][] userHeddles;
    private int[][] userTreadles;

    public Ui() {
        this.modifiableHeddles = true;
        this.modifiableTreadles = true;
    }

    private Pane makeTreadedPane(Loom loom) {
        Pane treadedPane = new Pane();
        treadedPane.setPrefSize(loom.fabricWidth * SQUARE_SIZE, loom.treadleAmount * SQUARE_SIZE);

        return treadedPane;
    }

    private GridPane makeFabricPane(Loom loom) {
        GridPane fabricPane = new GridPane();

        for (int i = 0; i < loom.fabricWidth; i++) {
            for (int j = 0; j < loom.fabricWidth; j++) {
                Rectangle rec = new Rectangle(SQUARE_SIZE - 2, SQUARE_SIZE - 2);
                rec.setStroke(Color.LIGHTGRAY);
                rec.setFill(Color.WHITE);

                fabricPane.add(rec, i, j);
            }
        }

        return fabricPane;
    }

    private void changeHeddles(int x, int y, int[][] grid, int value) {
        grid[x][y] = value;
    }

    private GridPane makeHeddlesPane(Loom loom) {
        this.userHeddles = new int[loom.shafts][loom.fabricWidth];
        GridPane heddlesPane = new GridPane();
        heddlesPane.setPrefSize(loom.shafts * SQUARE_SIZE, loom.fabricWidth * SQUARE_SIZE);

        for (int i = 0; i < loom.fabricWidth; i++) {
            for (int j = 0; j < loom.shafts; j++) {
                Rectangle rec = new Rectangle(SQUARE_SIZE - 2, SQUARE_SIZE - 2);
                rec.setStroke(Color.LIGHTGRAY);
                rec.setFill(Color.WHITE);

                rec.setOnMouseClicked((event) -> {
                    if (modifiableHeddles) {
                        if (rec.getFill() == Color.BLACK) {
                            rec.setFill(Color.WHITE);
                        } else {
                            rec.setFill(Color.BLACK);
                        }
                    }
                });

                heddlesPane.add(rec, i, j);
            }
        }

        return heddlesPane;
    }

    private GridPane createTreadlesPane(Loom loom) {
        GridPane treadlesPane = new GridPane();

        for (int i = 0; i < loom.shafts; i++) {
            for (int j = 0; j < loom.treadleAmount; j++) {
                Rectangle rec = new Rectangle(SQUARE_SIZE - 2, SQUARE_SIZE - 2);
                rec.setStroke(Color.LIGHTGRAY);
                rec.setFill(Color.WHITE);

                rec.setOnMouseClicked((event) -> {
                    if (modifiableTreadles) {

                        if (rec.getFill() == Color.BLACK) {
                            rec.setFill(Color.WHITE);
                        } else {
                            rec.setFill(Color.BLACK);
                        }
                    }

                });

                treadlesPane.add(rec, i, j);
            }
        }

        return treadlesPane;
    }

    private HashMap<String, GridPane> createLoomComponents(Loom loom) {
        HashMap<String, GridPane> components = new HashMap<>();

        components.put("Treadles", createTreadlesPane(loom));
        components.put("Heddles", makeHeddlesPane(loom));
        components.put("Fabric", makeFabricPane(loom));
//        components.put("Treaded", makeTreadedPane(loom));

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

        HashMap<String, GridPane> components = createLoomComponents(loom);
        weaveLayout.add(components.get("Fabric"), 1, 1);
//        weaveLayout.add(components.get("Treaded"), 1, 2);
        weaveLayout.add(components.get("Heddles"), 1, 2);
        weaveLayout.add(components.get("Treadles"), 2, 2);
        
        Button confirmTreadles = new Button("Polkusten sidonta valmis");
        Button confirmHeddles = new Button("Niisintä valmis");
        
        weaveLayout.add(confirmTreadles, 2, 3);
        weaveLayout.add(confirmHeddles, 1, 3);
        
        confirmTreadles.setOnAction((event) ->{
            this.modifiableTreadles = false;
        });
        
        confirmHeddles.setOnAction((event) -> {
            this.modifiableHeddles = false;
        });
        
        HBox treadleButtons = new HBox();
        for (int i = 0; i < loom.treadleAmount; i++) {
            Button treadleButton = new Button("Poljin " + i);
            
            treadleButtons.getChildren().add(treadleButton);
        }
        weaveLayout.add(treadleButtons, 1, 4);

        Scene defaultScene = new Scene(weaveLayout);

        return defaultScene;
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
            Loom loom = new Loom();
            window.setScene(createWeaveScene(loom));
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
