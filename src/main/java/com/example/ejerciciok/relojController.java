package com.example.ejerciciok;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.WindowEvent;

/**
 * Clase relojController que maneja la lógica del reloj.
 */
public class relojController {

    @FXML
    private ImageView imgH1;

    @FXML
    private ImageView imgH2;

    @FXML
    private ImageView imgM1;

    @FXML
    private ImageView imgM2;

    @FXML
    private ImageView imgP1;

    @FXML
    private ImageView imgP2;

    @FXML
    private ImageView imgReloj;

    @FXML
    private ImageView imgS1;

    @FXML
    private ImageView imgS2;

    @FXML
    private ImageView imp3;

    @FXML
    private ImageView imp4;

    @FXML
    private AnchorPane panelAncla;

    @FXML
    private AnchorPane panelAncla2;

    @FXML
    private AnchorPane panelAncla3;

    @FXML
    private HBox panelNum;

    @FXML
    private StackPane rootPane;

    /** El timer para actualizar el reloj. */
    private Timer timer;

    /**
     * Inicializa el reloj y configura el evento de cierre de la ventana.
     */
    @FXML
    public void initialize() {
        app.getStage().setOnCloseRequest((WindowEvent event) -> {
            parar();
            Platform.exit();
        });
        iniciarReloj();
    }

    /**
     * Inicia el reloj, actualizando cada segundo.
     */
    private void iniciarReloj() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                actualizarReloj();
            }
        }, 0, 1000);
    }

    /**
     * Actualiza las imágenes del reloj con la hora actual.
     */
    private void actualizarReloj() {
        Platform.runLater(() -> {
            LocalDateTime currentTime = LocalDateTime.now();
            int hours = currentTime.getHour();
            int minutes = currentTime.getMinute();
            int seconds = currentTime.getSecond();
            actualizarImagen(imgH1, hours / 10);
            actualizarImagen(imgH2, hours % 10);
            actualizarImagen(imgM1, minutes / 10);
            actualizarImagen(imgM2, minutes % 10);
            actualizarImagen(imgS1, seconds / 10);
            actualizarImagen(imgS2, seconds % 10);
        });
    }

    /**
     * Actualiza la imagen del número en la vista.
     *
     * @param imagen La imagen que se debe actualizar.
     * @param i El dígito a mostrar (0-9).
     */
    private void actualizarImagen(ImageView imagen, int i) {
        String num = "";
        switch (i) {
            case 0: num = "ZERO"; break;
            case 1: num = "ONE"; break;
            case 2: num = "TWO"; break;
            case 3: num = "THREE"; break;
            case 4: num = "FOUR"; break;
            case 5: num = "FIVE"; break;
            case 6: num = "SIX"; break;
            case 7: num = "SEVEN"; break;
            case 8: num = "EIGHT"; break;
            case 9: num = "NINE"; break;
        }
        imagen.setImage(new Image(getClass().getResourceAsStream("/com/example/ejerciciok/images/" + num + ".png")));
    }

    /**
     * Detiene el reloj al cerrar la aplicación.
     */
    private void parar() {
        if (timer != null) {
            timer.cancel();
        }
    }
}
