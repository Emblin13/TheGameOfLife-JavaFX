package com.example.thegameoflife;

public class Chunk {
    public Cell[][] cellArr;
    public int size = 3;

    public Chunk () {
        this.cellArr = new Cell[size][size];

        for (int i = 0; i < size; i++) { //This loop may be redundant as Java may initialize to 0 in the above if loop
            for (int j = 0; j < size; j++) {
                cellArr[i][j] = new Cell();
            }
        }
        cellArr[0][0].state = 1; //Marks the top right corner of a chunk as 1
    }
}
