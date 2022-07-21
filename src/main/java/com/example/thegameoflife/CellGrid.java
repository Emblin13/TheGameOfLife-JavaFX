package com.example.thegameoflife;

public class CellGrid {

    public CellChunk[][] cellChunkArr;

    public CellGrid(int chunkRows, int chunkCols) {
        //Temporarily swapping rows and cols. Fix this properly later
        this.cellChunkArr = new CellChunk[chunkRows][chunkCols]; //Make this round up to the nearest chunk
        for(int i = 0; i < chunkRows; i++) {
            for(int j = 0; j < chunkCols; j++) {
                cellChunkArr[i][j] = new CellChunk();
            }
        }
    }

    public void spawnGlider(int chunkRow, int chunkCol, int cellRow, int cellCol) {
        cellChunkArr[chunkRow][chunkCol].cellArr[cellRow][cellCol].state = 1;
        cellChunkArr[chunkRow][chunkCol].cellArr[cellRow + 1][cellCol + 1].state = 1;
        cellChunkArr[chunkRow][chunkCol].cellArr[cellRow + 2][cellCol].state = 1;
        cellChunkArr[chunkRow][chunkCol].cellArr[cellRow + 2][cellCol + 1].state = 1;
        cellChunkArr[chunkRow][chunkCol].cellArr[cellRow + 2][cellCol - 1].state = 1;
        cellChunkArr[0][9].cellArr[0][9].state = 1;
    }

    public void spawnCube(int chunkRow, int chunkCol) {
        cellChunkArr[chunkRow][chunkCol].cellArr[0][0].state = 1; //center

        cellChunkArr[chunkRow-1][chunkCol-1].cellArr[9][9].state = 1;
        cellChunkArr[chunkRow-1][chunkCol].cellArr[9][0].state = 1;
        cellChunkArr[chunkRow-1][chunkCol].cellArr[9][1].state = 1;
        cellChunkArr[chunkRow][chunkCol-1].cellArr[0][9].state = 1;
        cellChunkArr[chunkRow][chunkCol].cellArr[0][1].state = 1;
        cellChunkArr[chunkRow][chunkCol-1].cellArr[1][9].state = 1;
        cellChunkArr[chunkRow][chunkCol].cellArr[1][0].state = 1;
        cellChunkArr[chunkRow][chunkCol].cellArr[1][1].state = 1;
    }

    public void countNeighbors() {
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                for(int k = 0; k < 10; k++) {
                    for(int l = 0; l < 10; l++) {
                        int neighbors = 0;
                        if (k == 0 && l == 0) { //Consider converting these to switch cases
                            if(i != 0 && j != 0) {
                                neighbors += cellChunkArr[i-1][j-1].cellArr[9][9].state;
                            }
                            if(i != 0) {
                                neighbors += cellChunkArr[i-1][j].cellArr[9][0].state;
                                neighbors += cellChunkArr[i-1][j].cellArr[9][1].state;
                            }
                            if(j != 0) {
                                neighbors += cellChunkArr[i][j-1].cellArr[0][9].state;
                                neighbors += cellChunkArr[i][j-1].cellArr[1][9].state;
                            }
                            neighbors += cellChunkArr[i][j].cellArr[1][0].state;
                            neighbors += cellChunkArr[i][j].cellArr[0][1].state;
                            neighbors += cellChunkArr[i][j].cellArr[1][1].state;
                        }else if (k == 9 && l == 9) {
                            if(i != 9 && j != 9) {
                                neighbors += cellChunkArr[i+1][j+1].cellArr[0][0].state;
                            }
                            if(i != 9) {
                                neighbors += cellChunkArr[i+1][j].cellArr[0][8].state;
                                neighbors += cellChunkArr[i+1][j].cellArr[0][9].state;
                            }
                            if(j != 9) {
                                neighbors += cellChunkArr[i][j+1].cellArr[8][0].state;
                                neighbors += cellChunkArr[i][j+1].cellArr[9][0].state;
                            }
                            neighbors += cellChunkArr[i][j].cellArr[8][9].state;
                            neighbors += cellChunkArr[i][j].cellArr[9][8].state;
                            neighbors += cellChunkArr[i][j].cellArr[8][8].state;
                        }else if (k == 9 && l == 0) {
                            if(i != 9 && j != 0) {
                                neighbors += cellChunkArr[i+1][j-1].cellArr[0][9].state;
                            }
                            if(i != 9) {
                                neighbors += cellChunkArr[i+1][j].cellArr[0][0].state;
                                neighbors += cellChunkArr[i+1][j].cellArr[0][1].state;
                            }
                            if(j != 0) {
                                neighbors += cellChunkArr[i][j-1].cellArr[9][9].state;
                                neighbors += cellChunkArr[i][j-1].cellArr[8][9].state;
                            }
                            neighbors += cellChunkArr[i][j].cellArr[8][0].state;
                            neighbors += cellChunkArr[i][j].cellArr[9][1].state;
                            neighbors += cellChunkArr[i][j].cellArr[8][1].state;
                        }else if (k == 0 && l == 9) {
                            if(i != 0 && j != 9) {
                                neighbors += cellChunkArr[i-1][j+1].cellArr[9][0].state;
                            }
                            if(i != 0) {
                                neighbors += cellChunkArr[i-1][j].cellArr[9][9].state;
                                neighbors += cellChunkArr[i-1][j].cellArr[9][8].state;
                            }
                            if(j != 9) {
                                neighbors += cellChunkArr[i][j+1].cellArr[0][0].state;
                                neighbors += cellChunkArr[i][j+1].cellArr[1][0].state;
                            }
                            neighbors += cellChunkArr[i][j].cellArr[0][8].state;
                            neighbors += cellChunkArr[i][j].cellArr[1][9].state;
                            neighbors += cellChunkArr[i][j].cellArr[1][8].state;
                        }
                        else if (k == 0) {
                            for(int m = -1; m < 2; m++) {
                                if(i != 0) {
                                    neighbors += cellChunkArr[i-1][j].cellArr[9][l+m].state;
                                }
                                neighbors += cellChunkArr[i][j].cellArr[0][l+m].state;
                                neighbors += cellChunkArr[i][j].cellArr[1][l+m].state;
                            }
                            neighbors -= cellChunkArr[i][j].cellArr[k][l].state; //Subtract itself from the count only if its alive
                        }else if (k == 9) {
                            for(int m = -1; m < 2; m++) {
                                if(i != 9) {
                                    neighbors += cellChunkArr[i+1][j].cellArr[0][l+m].state;
                                }
                                neighbors += cellChunkArr[i][j].cellArr[9][l+m].state;
                                neighbors += cellChunkArr[i][j].cellArr[8][l+m].state;
                            }
                            neighbors -= cellChunkArr[i][j].cellArr[k][l].state;
                        }else if (l == 0) {
                            for(int m = -1; m < 2; m++) {
                                if(j != 0) {
                                    neighbors += cellChunkArr[i][j-1].cellArr[k+m][9].state;
                                }
                                neighbors += cellChunkArr[i][j].cellArr[k+m][0].state;
                                neighbors += cellChunkArr[i][j].cellArr[k+m][1].state;
                            }
                            neighbors -= cellChunkArr[i][j].cellArr[k][l].state;
                        }else if (l == 9) {
                            for(int m = -1; m < 2; m++) {
                                if(j != 9) {
                                    neighbors += cellChunkArr[i][j+1].cellArr[k+m][0].state;
                                }
                                neighbors += cellChunkArr[i][j].cellArr[k+m][9].state;
                                neighbors += cellChunkArr[i][j].cellArr[k+m][8].state;
                            }
                            neighbors -= cellChunkArr[i][j].cellArr[k][l].state;
                        }else {
                            for(int m = -1; m < 2; m++) {
                                for(int n = -1; n < 2; n++) {
                                    neighbors += cellChunkArr[i][j].cellArr[k+m][l+n].state;
                                }
                            }
                            neighbors -= cellChunkArr[i][j].cellArr[k][l].state;
                        }
                        cellChunkArr[i][j].cellArr[k][l].neighbors = neighbors;
                        if(cellChunkArr[i][j].cellArr[k][l].state == 1) {
                            System.out.println("Chunk: " + i + "," + j + ". Cell: " + k + "," + l + ". Neighbors: "
                                    + cellChunkArr[i][j].cellArr[k][l].neighbors); //Delete this if-statement
                        }
                    }
                }
            }
        }

    }

    public void deathAndBirth() {
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                for(int k = 0; k < 10; k++) {
                    for(int l = 0; l < 10; l++) {
                        int neighbors = cellChunkArr[i][j].cellArr[k][l].neighbors;
                        if(neighbors < 2 || neighbors > 3) {
                            cellChunkArr[i][j].cellArr[k][l].state = 0; //Cell dies
                        }if(neighbors == 3 && cellChunkArr[i][j].cellArr[k][l].state == 0) {
                            cellChunkArr[i][j].cellArr[k][l].state = 1; //New cell is born
                        }//Remaining cells which have 2-3 neighbors and are alive are left unchanged.
                    }
                }
            }
        }
    }

}
