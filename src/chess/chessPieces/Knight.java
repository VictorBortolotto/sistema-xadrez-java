package chess.chessPieces;

import boardgame.Position;
import chess.Color;
import chess.ChessPiece;
import boardgame.Board;

public class Knight extends ChessPiece{
    
    public Knight(Board board, Color color){

        super(board, color);

    }

    @Override
    public String toString(){

        return "C";

    }

    private boolean canMove(Position position){

        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();

    }
   
    @Override
    public boolean[][] possibleMoves(){

        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];		

        Position p = new Position(0, 0);

        // Mover para cima
        p.setValues(position.getRow() - 1, position.getColumn() - 2);

        if(getBoard().positionExists(p) && canMove(p)){
        
            mat[p.getRow()][p.getColumn()] = true;

        }

        // Mover para baixo
        p.setValues(position.getRow() - 2, position.getColumn() - 1);

        if(getBoard().positionExists(p) && canMove(p)){
        
            mat[p.getRow()][p.getColumn()] = true;

        }

        // Mover para esquerda
        p.setValues(position.getRow() - 2, position.getColumn() + 1);

        if(getBoard().positionExists(p) && canMove(p)){
        
            mat[p.getRow()][p.getColumn()] = true;

        }

        // Mover para direita
        p.setValues(position.getRow() - 1, position.getColumn() + 2);

        if(getBoard().positionExists(p) && canMove(p)){
        
            mat[p.getRow()][p.getColumn()] = true;

        }

        // Mover para diagonais
        p.setValues(position.getRow() + 1, position.getColumn() + 2);

        if(getBoard().positionExists(p) && canMove(p)){
        
            mat[p.getRow()][p.getColumn()] = true;

        }
        
        p.setValues(position.getRow() + 2, position.getColumn() + 1);

        if(getBoard().positionExists(p) && canMove(p)){
        
            mat[p.getRow()][p.getColumn()] = true;

        }

        p.setValues(position.getRow() + 2, position.getColumn() - 1);

        if(getBoard().positionExists(p) && canMove(p)){
        
            mat[p.getRow()][p.getColumn()] = true;

        }

        p.setValues(position.getRow() + 1, position.getColumn() - 2);

        if(getBoard().positionExists(p) && canMove(p)){
        
            mat[p.getRow()][p.getColumn()] = true;

        }

        return mat;

    }

}
