package com.example.thegameoflife;

public class Grid {
    public int rows;
    public int cols;
    public Chunk[][] chunkArr;
    public int size = 3;

    public Grid (int rows, int cols) {
        this.rows = (int) (Math.ceil(rows / size) * size); //Move this logic somewhere else
        this.cols = (int) (Math.ceil(cols / size) * size); //This logic doesn't seem to round up like it should

        this.chunkArr = new Chunk[rows][cols];

        for (int i = 0; i < (rows / size); i++) {
            for (int j = 0; j < (cols / size); j++) {
                chunkArr[i][j] = new Chunk();
            }
        }
    }
}
