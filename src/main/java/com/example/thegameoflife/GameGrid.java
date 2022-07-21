package com.example.thegameoflife;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class GameGrid {

    int baseHeight;
    Canvas canvas;
    CellGrid cellGrid;

    public GameGrid() {
        this.canvas = new Canvas(baseHeight,baseHeight);
        this.baseHeight = 1000;
        this.cellGrid = new CellGrid(10,10);
    }

    public void scaleCanvas(int newScale) {
        double newHeight = baseHeight * newScale;
        this.canvas.setHeight(newHeight);
        this.canvas.setWidth(newHeight);
        drawCanvas(newScale);
    }

    public void drawCanvas(int scale) {
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

    public void fillCells(int scale) {
        //Receive a 2d array of which cells are alive
//        Cell[][] cellArr = new Cell[100][100];
//        for(int i = 0; i < 100; i++) {
//            for(int j = 0; j < 100; j++) {
//                cellArr[i][j] = new Cell();
//            }
//        }
//        for(int i = 10; i < 60; i++) {
//            cellArr[i][4] = new Cell(1);
//            cellArr[i][i] = new Cell(1);
//            cellArr[i+1][i] = new Cell(1);
//            cellArr[i-1][i] = new Cell(1);
//        }

        this.canvas.getGraphicsContext2D().setFill(Color.DARKRED);
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {

            }
        }
    }
/*
                if(cellGrid.cellChunkArr[i/10][j/10].cellArr[i][j].state == 1) {
                    this.canvas.getGraphicsContext2D().fillRect((1 + (i*10*scale)), (1 + (j*10*scale)),
                            (9.75*scale), (9.75*scale)); //I have no idea why 9.75*scale works but 10*scale doesn't
                }
 */

}
