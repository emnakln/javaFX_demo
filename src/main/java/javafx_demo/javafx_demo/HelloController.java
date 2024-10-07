package javafx_demo.javafx_demo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import static javafx.application.Application.launch;

public class HelloController {
    @FXML
    private Canvas canvas;

    @FXML
    private Slider sliderColorR;

    @FXML
    private Slider sliderColorG;

    @FXML
    private Slider sliderColorB;

    int r;
    int g;
    int b;

    @FXML
    public void clearImage(ActionEvent actionEvent) {

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
    }

    @FXML
    public void initialize(){

        sliderColorR.valueProperty().addListener((observable, oldValue, newValue) -> {
            r=newValue.intValue();
        });

        sliderColorG.valueProperty().addListener((observable, oldValue, newValue) -> {
            g=newValue.intValue();
        });

        sliderColorB.valueProperty().addListener((observable, oldValue, newValue) -> {
            b=newValue.intValue();
        });

        EventHandler<MouseEvent> drawEventHandler =
                new EventHandler<javafx.scene.input.MouseEvent>() {
                    @Override
                    public void handle(javafx.scene.input.MouseEvent e) {
                        GraphicsContext gc = canvas.getGraphicsContext2D();
                        gc.setFill(Color.rgb(r,g,b));
                        gc.fillOval(e.getX(),e.getY(),5,5);
                    }
                };
        canvas.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED,drawEventHandler);
    }
}