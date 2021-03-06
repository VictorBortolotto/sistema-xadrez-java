package chess.chessPieces;

import boardgame.Position;
import chess.Color;
import chess.ChessMatch;
import chess.ChessPiece;
import boardgame.Board;

public class King extends ChessPiece{
    
    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch){

        super(board, color);
        this.chessMatch = chessMatch;

    }

    @Override
    public String toString(){

        return "K";

    }

    private boolean canMove(Position position){

        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();

    }

    private boolean testTowerCasteling(Position position){

        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null && p instanceof Tower &&p.getColor() == getColor() && p.getMoveCount() == 0;

    }
   
    @Override
    public boolean[][] possibleMoves(){

        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];		

        Position p = new Position(0, 0);

        // Mover para cima
        p.setValues(position.getRow() - 1, position.getColumn());

        if(getBoard().positionExists(p) && canMove(p)){
        
            mat[p.getRow()][p.getColumn()] = true;

        }

        // Mover para baixo
        p.setValues(position.getRow() + 1, position.getColumn());

        if(getBoard().positionExists(p) && canMove(p)){
        
            mat[p.getRow()][p.getColumn()] = true;

        }

        // Mover para esquerda
        p.setValues(position.getRow(), position.getColumn() - 1);

        if(getBoard().positionExists(p) && canMove(p)){
        
            mat[p.getRow()][p.getColumn()] = true;

        }

        // Mover para direita
        p.setValues(position.getRow(), position.getColumn() + 1);

        if(getBoard().positionExists(p) && canMove(p)){
        
            mat[p.getRow()][p.getColumn()] = true;

        }

        // Mover para diagonais
        p.setValues(position.getRow() - 1, position.getColumn() - 1);

        if(getBoard().positionExists(p) && canMove(p)){
        
            mat[p.getRow()][p.getColumn()] = true;

        }
        
        p.setValues(position.getRow() - 1, position.getColumn() + 1);

        if(getBoard().positionExists(p) && canMove(p)){
        
            mat[p.getRow()][p.getColumn()] = true;

        }

        p.setValues(position.getRow() + 1, position.getColumn() - 1);

        if(getBoard().positionExists(p) && canMove(p)){
        
            mat[p.getRow()][p.getColumn()] = true;

        }

        p.setValues(position.getRow() + 1, position.getColumn() + 1);

        if(getBoard().positionExists(p) && canMove(p)){
        
            mat[p.getRow()][p.getColumn()] = true;

        }

        // Casteling

        if (getMoveCount() == 0 && !chessMatch.getCheck()){

            Position positionTowerOne = new Position(position.getRow(), position.getColumn() + 3);

            if(testTowerCasteling(positionTowerOne)){

                Position p1 = new Position(position.getRow(), position.getColumn() + 1);
                Position p2 = new Position(position.getRow(), position.getColumn() + 2);

                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null){

                    mat[position.getRow()][position.getColumn() + 2] = true;

                }

            }

            Position positionTowerTwo = new Position(position.getRow(), position.getColumn() - 4);

            if(testTowerCasteling(positionTowerTwo)){

                Position p1 = new Position(position.getRow(), position.getColumn() - 1);
                Position p2 = new Position(position.getRow(), position.getColumn() - 2);
                Position p3 = new Position(position.getRow(), position.getColumn() - 3);

                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null){

                    mat[position.getRow()][position.getColumn() - 2] = true;

                }

            }

        }

        return mat;

    }

}
