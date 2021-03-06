package chess.chessPieces;

import boardgame.Position;
import chess.Color;
import chess.ChessPiece;
import boardgame.Board;

public class Bishop extends ChessPiece{
    
    public Bishop(Board board, Color color){

        super(board, color);

    }

    @Override
    public String toString(){

        return "B";

    }

    @Override
    public boolean[][] possibleMoves(){

        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        // Move peça para diagonais
        p.setValues(position.getRow() - 1, position.getColumn() - 1);

        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){

            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() - 1);

        }

        if (getBoard().positionExists(p) && isThereAnOppnentPiece(p)){

            mat[p.getRow()][p.getColumn()] = true;

        }

       
        p.setValues(position.getRow() - 1, position.getColumn() + 1);

        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){

            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() + 1);

        }

        if (getBoard().positionExists(p) && isThereAnOppnentPiece(p)){

            mat[p.getRow()][p.getColumn()] = true;

        }


        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){

            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn() + 1);

        }

        if (getBoard().positionExists(p) && isThereAnOppnentPiece(p)){

            mat[p.getRow()][p.getColumn()] = true;

        }

        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
        
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn() - 1);
        
        }
    
        if (getBoard().positionExists(p) && isThereAnOppnentPiece(p)){
        
            mat[p.getRow()][p.getColumn()] = true;
        
        }

        return mat;

    }


}   
