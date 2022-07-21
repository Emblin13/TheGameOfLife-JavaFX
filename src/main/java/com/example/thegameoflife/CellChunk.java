package com.example.thegameoflife;

public class CellChunk {
    public Cell[][] cellArr;
    public int chunkSize = 10;

    public CellChunk() {
        this.cellArr = new Cell[chunkSize][chunkSize];

        for (int i = 0; i < chunkSize; i++) { //This loop may be redundant as Java may initialize to 0 in the above if loop
            for (int j = 0; j < chunkSize; j++) {
                cellArr[i][j] = new Cell();
            }
        }
        cellArr[0][0].state = 1; //Marks the top right corner of a chunk as 1
    }
}
