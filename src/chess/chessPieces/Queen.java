package chess.chessPieces;

import boardgame.Position;
import chess.Color;
import chess.ChessPiece;
import boardgame.Board;

public class Queen extends ChessPiece{
    
    public Queen(Board board, Color color){

        super(board, color);

    }

    @Override
    public String toString(){

        return "Q";

    }

    @Override
    public boolean[][] possibleMoves(){

        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        // Move peça para cima
        p.setValues(position.getRow() - 1, position.getColumn());

        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){

            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() - 1);

        }

        if (getBoard().positionExists(p) && isThereAnOppnentPiece(p)){

            mat[p.getRow()][p.getColumn()] = true;

        }

        // Move peça para esquerda
        p.setValues(position.getRow(), position.getColumn() - 1);

        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){

            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() - 1);

        }

        if (getBoard().positionExists(p) && isThereAnOppnentPiece(p)){

            mat[p.getRow()][p.getColumn()] = true;

        }

        // Move peça para direita
        p.setValues(position.getRow(), position.getColumn() + 1);
        
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){

            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() + 1);

        }

        if (getBoard().positionExists(p) && isThereAnOppnentPiece(p)){

            mat[p.getRow()][p.getColumn()] = true;

        }

        // Move peça para baixo
        p.setValues(position.getRow() + 1, position.getColumn());
        
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
        
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() + 1);
        
        }
    
        if (getBoard().positionExists(p) && isThereAnOppnentPiece(p)){
        
            mat[p.getRow()][p.getColumn()] = true;
        
        }

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
