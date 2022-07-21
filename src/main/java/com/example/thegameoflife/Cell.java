package com.example.thegameoflife;

public class Cell {
    int state;
    int neighbors;

    public Cell() {
        this.state = 0;
        this.neighbors = 0;
    }

    public Cell(int state) {
        this.state = state;
        this.neighbors = 0;
    }
}
