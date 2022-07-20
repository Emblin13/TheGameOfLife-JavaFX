package com.example.thegameoflife;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    int scale;
    int baseHeight = 1000;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Conway's Game of Life!");

        Canvas canvas = new Canvas(baseHeight,baseHeight);
        scaleCanvas(canvas, 2); //Default scale of 2

        //Scale buttons HBox
        Button scale1 = new Button("1x Zoom");
        scale1.setOnAction(e -> scaleCanvas(canvas, 1));
        Button scale2 = new Button("2x Zoom");
        scale2.setOnAction(e -> scaleCanvas(canvas, 2));
        Button scale4 = new Button("4x Zoom");
        scale4.setOnAction(e -> scaleCanvas(canvas, 4));
        Button scale8 = new Button("8x Zoom");
        scale8.setOnAction(e -> scaleCanvas(canvas, 8));
        HBox scaleBox = new HBox(scale1, scale2, scale4, scale8);
        scaleBox.setSpacing(5);
        scaleBox.setAlignment(Pos.CENTER);

        //ScrollPane for Canvas
        ScrollPane sp = new ScrollPane(canvas);
        sp.setMaxWidth(1000);
        sp.setMaxHeight(800);
        //sp.setHmax(400);
        //sp.setVmax(800);

        //BorderPane for layout
        BorderPane bp = new BorderPane();
        bp.setCenter(sp);
        bp.setTop(scaleBox);

        Scene scene = new Scene(bp, 1920, 1010);
        scene.getStylesheets().add("gentleDark.css");
        window.setScene(scene);
        window.show();
    }

    public void scaleCanvas(Canvas canvas, int newScale) {
        double newHeight = baseHeight * newScale;
        canvas.setHeight(newHeight);
        canvas.setWidth(newHeight);
        drawCanvas(canvas, newScale);
    }

    public void drawCanvas(Canvas canvas, int scale) {
        double height = canvas.getHeight();
        canvas.getGraphicsContext2D().setFill(Color.WHITE);
        canvas.getGraphicsContext2D().fillRect(0,0,height,height);
        canvas.getGraphicsContext2D().setStroke(Color.BLACK);
        for(int i = 0; i < 100; i++) {
            canvas.getGraphicsContext2D().strokeLine((i*10*scale),0, (i*10*scale), height);
            canvas.getGraphicsContext2D().strokeLine(0, (i*10*scale), height, (i*10*scale));
        }
    }
}
