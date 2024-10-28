package com.example.ejerciciok;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * Clase principal de la aplicación MINI COOPER, que extiende {@link Application} para iniciar la interfaz gráfica.
 * La clase carga el archivo FXML, configura la escena, la ventana principal y añade un ícono.
 */
public class app extends Application {

    /**
     * Método start, que inicializa y muestra la ventana principal de la aplicación.
     *
     * @param stage El escenario principal en el que se mostrará la interfaz.
     * @throws IOException Si hay un error al cargar el archivo FXML.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(app.class.getResource("/com/example/ejerciciok/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setResizable(false);
        stage.setWidth(679);
        stage.setHeight(620);
        try {
            Image img = new Image(getClass().getResource("/com/example/ejerciciok/images/Icono.ico").toString());
            stage.getIcons().add(img);
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
        }

        stage.setTitle("RELOJ");
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Método main que lanza la aplicación.a
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        launch();
    }
}