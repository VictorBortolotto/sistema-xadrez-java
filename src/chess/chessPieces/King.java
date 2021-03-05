package chess.chessPieces;

import boardgame.Position;
import chess.Color;
import chess.ChessPiece;
import boardgame.Board;

public class King extends ChessPiece{
    
    public King(Board board, Color color){

        super(board, color);

    }

    @Override
    public String toString(){

        return "K";

    }

    private boolean podeMover(Position position){

        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();

    }
   
    @Override
    public boolean[][] possibleMoves(){

        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];		

        Position p = new Position(0, 0);

        // Mover para cima
        p.setValues(position.getRow() - 1, position.getColumn());

        if(getBoard().positionExists(p) && podeMover(p)){
        
            mat[p.getColumn()][p.getRow()] = true;

        }

        //Mover para baixo
        p.setValues(position.getRow() + 1, position.getColumn());

        if(getBoard().positionExists(p) && podeMover(p)){
        
            mat[p.getColumn()][p.getRow()] = true;

        }

        return mat;

    }

}
