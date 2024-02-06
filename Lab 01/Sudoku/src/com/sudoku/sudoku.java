package com.sudoku;

import BasicIO.ASCIIDataFile;
import BasicIO.ASCIIDisplayer;


public class sudoku {
    ASCIIDataFile file;
    ASCIIDisplayer displayer;
    int[][] sudoku;
    boolean correct = true;
    public sudoku(){
    loadPuzzle();
    displayPuzzle();
    checkRows();
    checkColumns();
    checkQuads();
    if(correct){
        displayer.writeString("the puzzle is complete and correct");
    }

    }
    private void loadPuzzle(){
        file = new ASCIIDataFile();
        sudoku = new int[9][9];
        int number;
       for(int i = 0; i<9; i++){
           for(int j=0; j<9; j++){
               number = file.readInt();
               sudoku[i][j]= number;
           }
       }


    }
    private void displayPuzzle(){
        displayer = new ASCIIDisplayer();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                displayer.writeInt(sudoku[i][j]);
                displayer.writeString(" ");
            }
            displayer.writeLine("");
        }
    }
    private void checkRows(){
        for(int i=1; i<10;i++){
            for(int j=0; j<9;j++) {
                if(!findInRow(i, j)){
                    int row = j+1;
                    correct = false;
                    displayer.writeLine("number: "+i +" is missing in row "+row);
                }
            }
        }
    }
    private boolean findInRow(int checkFor, int inRow){
        for(int i=0; i<9;i++){
            if(checkFor==sudoku[inRow][i]){
                return true;
            }
        }
        return false;
    }
    private boolean findInCol(int checkFor, int inCol){
        for(int i=0; i<9;i++){
            if(checkFor==sudoku[i][inCol]){
                return true;
            }
        }
        return false;
    }
    private void checkColumns(){
        for(int i=1; i<10;i++){
            for(int j=0; j<9;j++) {
                if(!findInCol(i, j)){
                    int column = j+1;
                    correct = false;
                    displayer.writeLine("number: "+i +" is missing in column "+column);
                }
            }
            }
    }
    private boolean findInQuad(int checkFor, int x, int y){
        for(int j=y; j<y+3;j++) {
            for(int k=x; k<x+3;k++) {
                if(checkFor==sudoku[k][j]){
                    return true;
                }
            }
        }
        return false;
    }
    private void checkQuads(){
        int indexX;
        int indexY;
        int[] locationsX = {0,0,0,3,3,3,6,6,6};
        int[] locationsY = {0,3,6,0,3,6,0,3,6};
        for(int i=1;i<10;i++){
            for(int j=0;j<9;j++){
                indexX = locationsX[j];
                indexY = locationsY[j];
                if(!findInQuad(i,indexX,indexY)){
                    correct = false;
                    displayer.writeLine("number: "+i +" is missing in quadrant "+indexX+" "+indexY);
                }
            }
        }
    }

    public static void main(String[] args) {
        sudoku t = new sudoku();
    }
}
