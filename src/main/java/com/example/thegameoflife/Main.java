package com.example.thegameoflife;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    GameGrid gameGrid;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Conway's Game of Life!");

        this.gameGrid = new GameGrid();
        gameGrid.scaleCanvas(2); //Default scale of 2

        BorderPane bp = buildGUI();

        Scene scene = new Scene(bp, 1920, 1010);
        scene.getStylesheets().add("gentleDark.css");
        window.setScene(scene);
        window.show();
    }

    public BorderPane buildGUI() {
        //Scale buttons HBox
        Button scale1 = new Button("1x Zoom");
        scale1.setOnAction(e -> gameGrid.scaleCanvas(1));
        Button scale2 = new Button("2x Zoom");
        scale2.setOnAction(e -> gameGrid.scaleCanvas(2));
        Button scale4 = new Button("4x Zoom");
        scale4.setOnAction(e -> gameGrid.scaleCanvas(4));
        Button scale8 = new Button("8x Zoom");
        scale8.setOnAction(e -> gameGrid.scaleCanvas(8));
        HBox scaleBox = new HBox(scale1, scale2, scale4, scale8);
        scaleBox.setSpacing(5);
        scaleBox.setAlignment(Pos.CENTER);

        //ScrollPane for Canvas
        ScrollPane sp = new ScrollPane(gameGrid.canvas);
        sp.setMaxWidth(1000);
        sp.setMaxHeight(800);

        //BorderPane for layout
        BorderPane bp = new BorderPane();
        bp.setCenter(sp);
        bp.setTop(scaleBox);

        return bp;
    }
}
