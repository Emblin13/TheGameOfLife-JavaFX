package com.example.thegameoflife;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    GameGrid gameGrid;
    GameSpeed gameSpeed;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Conway's Game of Life!");

        this.gameGrid = new GameGrid();
        gameGrid.scaleCanvas(2); //Default scale of 2
        this.gameSpeed = new GameSpeed(gameGrid);

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

        //CycleSpeed buttons HBox
        Button speed0 = new Button("Pause");
        speed0.setOnAction(e -> {
            gameSpeed.shutdownCycle();
        });
        Button speed1 = new Button("1x Speed");
        speed1.setOnAction(e -> {
            gameSpeed.shutdownCycle();
            this.gameSpeed.gameSpeed(2000);
        });
        Button speed2 = new Button("2x Speed");
        speed2.setOnAction(e -> {
            gameSpeed.shutdownCycle();
            this.gameSpeed.gameSpeed(1000);
        });
        Button speed4 = new Button("4x Speed");
        speed4.setOnAction(e -> {
            gameSpeed.shutdownCycle();
            this.gameSpeed.gameSpeed(500);
        });
        Button speed8 = new Button("8x Speed");
        speed8.setOnAction(e -> {
            gameSpeed.shutdownCycle();
            this.gameSpeed.gameSpeed(250);
        });
        Button speed16 = new Button("16x Speed");
        speed16.setOnAction(e -> {
            gameSpeed.shutdownCycle();
            this.gameSpeed.gameSpeed(125);
        });
        Button speed32 = new Button("32x Speed");
        speed32.setOnAction(e -> {
            gameSpeed.shutdownCycle();
            this.gameSpeed.gameSpeed(60);
        });
        Button speed64 = new Button("64x Speed");
        speed64.setOnAction(e -> {
            gameSpeed.shutdownCycle();
            this.gameSpeed.gameSpeed(30);
        });
        HBox speedBox = new HBox(speed0, speed1, speed2, speed4, speed8, speed16, speed32, speed64);
        speedBox.setSpacing(5);
        speedBox.setAlignment(Pos.CENTER);

        //VBox for the HBoxes
        VBox topBox = new VBox(scaleBox, speedBox);

        //ScrollPane for Canvas
        ScrollPane sp = new ScrollPane(gameGrid.canvas);
        sp.setMaxWidth(1000);
        sp.setMaxHeight(800);

        //NextCycle Button
        Button cycleButton = new Button("Next Generation");
        cycleButton.setOnAction(e -> this.gameGrid.nextCycle());

        //SpawnGlider Button
        Button gliderButton = new Button("Spawn Glider");
        gliderButton.setOnAction(e -> {
            gameGrid.cellGrid.spawnGlider(1,0,5,6);
            gameGrid.cellGrid.spawnCube(2,2);
            gameGrid.drawCanvas(gameGrid.scale);
        });

        //HBox for bottom buttons
        HBox miscBox = new HBox(cycleButton, gliderButton);
        miscBox.setSpacing(5);
        miscBox.setAlignment(Pos.CENTER);

        //BorderPane for layout
        BorderPane bp = new BorderPane();
        bp.setCenter(sp);
        bp.setTop(topBox);
        bp.setBottom(miscBox);

        return bp;
    }
}
