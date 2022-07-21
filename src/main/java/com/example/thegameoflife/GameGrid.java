package com.example.thegameoflife;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class GameGrid {

    int baseHeight;
    int scale;
    Canvas canvas;
    CellGrid cellGrid;

    public GameGrid() {
        this.canvas = new Canvas(baseHeight,baseHeight);
        this.baseHeight = 1000;
        this.cellGrid = new CellGrid(10,10);

    }

    public void nextCycle() {
        cellGrid.countNeighbors();
        cellGrid.deathAndBirth();
        drawCanvas(this.scale);
    }

    public void scaleCanvas(int newScale) {
        this.scale = newScale;
        double newHeight = baseHeight * newScale;
        this.canvas.setHeight(newHeight);
        this.canvas.setWidth(newHeight);
        drawCanvas(newScale);
    }

    public void drawCanvas(int scale) { //Consider removing scale as a passed-in variable
        double height = this.canvas.getHeight();
        this.canvas.getGraphicsContext2D().setFill(Color.WHITE);
        this.canvas.getGraphicsContext2D().fillRect(0,0,height,height);
        this.canvas.getGraphicsContext2D().setStroke(Color.GREY);
        for(int i = 0; i < 100; i++) {
            this.canvas.getGraphicsContext2D().strokeLine((i*10*scale),0, (i*10*scale), height);
            this.canvas.getGraphicsContext2D().strokeLine(0, (i*10*scale), height, (i*10*scale));
        }
        this.canvas.getGraphicsContext2D().setStroke(Color.BLACK);
        for(int i = 0; i < 10; i++) {
            this.canvas.getGraphicsContext2D().strokeLine((i*100*scale), 0, (i*100*scale), height);
            this.canvas.getGraphicsContext2D().strokeLine(0, (i*100*scale), height, (i*100*scale));
        }
        fillCells(scale);
    }

    public void fillCells(int scale) { //Consider removing scale as a passed-in variable
        this.canvas.getGraphicsContext2D().setFill(Color.DARKRED);
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                for(int k = 0; k < 10; k++) {
                    for(int l = 0; l < 10; l++) {
                        if(cellGrid.cellChunkArr[i][j].cellArr[k][l].state == 1) {
                            //I have no idea why 9.75*scale works but 10*scale doesn't
                            this.canvas.getGraphicsContext2D().fillRect(1 + 10*scale*((j*10)+l), (1 + 10*scale*((i*10)+k)),
                                    (9.75*scale), (9.75*scale));
                        }
                    }
                }
            }
        }
    }
}
