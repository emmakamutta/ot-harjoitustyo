
package emmakamutta.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
/**
 *
 * Tänne tulee käyttöliittymä
 */
public class Ui extends Application{

    public Ui(){
    }

    @Override
    public void start(Stage ikkuna) throws Exception {
           Button nappi = new Button("Tämä on nappi");

        FlowPane komponenttiryhma = new FlowPane();
        komponenttiryhma.getChildren().add(nappi);

        Scene nakyma = new Scene(komponenttiryhma);

        ikkuna.setScene(nakyma);
        ikkuna.show();
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
