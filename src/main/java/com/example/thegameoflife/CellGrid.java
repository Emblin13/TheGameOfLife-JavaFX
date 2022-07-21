package com.example.thegameoflife;

public class CellGrid {

    public CellChunk[][] cellChunkArr;

    public CellGrid(int chunkRows, int chunkCols) {
        this.cellChunkArr = new CellChunk[chunkRows][chunkCols]; //Make this round up to the nearest chunk
        for(int i = 0; i < chunkRows; i++) {
            for(int j = 0; j < chunkCols; j++) {
                cellChunkArr[i][j] = new CellChunk();
            }
        }
    }
}
