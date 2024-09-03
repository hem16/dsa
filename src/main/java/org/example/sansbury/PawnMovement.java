package org.example.sansbury;

public class PawnMovement {
    public String findEndPosition(String startPos, int rows, int columns) {
        char column = startPos.charAt(1);
        int row = Character.getNumericValue(startPos.charAt(0));
        int colIndex = column - 'a';
        int newRow = (row  + rows) % 8;
        int newCol = (colIndex + columns) % 8;
        char newColumn = (char) ('a' + newCol);
        int newRowIndex = (newRow ==0 ) ? 8 : newRow;
        return newRowIndex + "" + newColumn;
    }
    
    public static void main(String[] args) {
        PawnMovement pawnMovement = new PawnMovement();
        String output = pawnMovement.findEndPosition("2b",3,2);
        System.out.println("output = " + output);
    }
}
