package chess;

import boardgame.Piece;
import boardgame.Position;
import chess.chessPieces.King;
import chess.chessPieces.Tower;
import boardgame.Board;

public class ChessMatch {
    
    private Board board;

    public ChessMatch(){

        board = new Board(8, 8);
        setupInicial();

    }

    public ChessPiece[][] getPieces(){

        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];

        for(int i = 0; i < board.getRows(); i++){

            for(int j = 0; j < board.getColumns(); j++){

                mat[i][j] = (ChessPiece) board.piece(i, j);
                
            }

        }

        return mat;

    }

    public boolean[][] possibleMoves(ChessPosition sourcePosition){

        Position position = sourcePosition.toPosition();
        validateSoucePosition(position);

        return board.piece(position).possibleMoves();

    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition){

        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSoucePosition(source);
        validateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source, target);
        return (ChessPiece) capturedPiece;


    }

    private Piece makeMove(Position source, Position target){

        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);

        return capturedPiece;

    }

    private void validateSoucePosition(Position position){

        if(!board.thereIsAPiece(position)){

            throw new ChessException("Não há peça na posição de origem.");

        }

        if(!board.piece(position).isThereAnyPossibleMove()){

            System.out.println(!board.piece(position).isThereAnyPossibleMove());
            throw new ChessException("Não há movimentos para peça selecionada");

        }

    }

    private void validateTargetPosition(Position source, Position target){

        if(!board.piece(source).possibleMove(target)){

            throw new ChessException("A peça escolhida não pode se mover para a posição escolhida.");

        }

    }

    private void placeNewPiece(char column, int row, ChessPiece piece){

        board.placePiece(piece, new ChessPosition(column, row).toPosition());

    }

    private void setupInicial(){

        placeNewPiece('c', 2, new King(board, Color.WHITE));
       placeNewPiece('c', 1, new Tower(board, Color.WHITE));
       placeNewPiece('d', 2, new Tower(board, Color.WHITE));
       placeNewPiece('e', 2, new Tower(board, Color.WHITE));
       placeNewPiece('e', 1, new Tower(board, Color.WHITE));
       placeNewPiece('d', 1, new Tower(board, Color.WHITE));

        placeNewPiece('c', 7, new King(board, Color.BLACK));
       placeNewPiece('c', 8, new Tower(board, Color.BLACK));
       placeNewPiece('d', 7, new Tower(board, Color.BLACK));
       placeNewPiece('e', 7, new Tower(board, Color.BLACK));
       placeNewPiece('e', 8, new Tower(board, Color.BLACK));
       placeNewPiece('d', 8, new Tower(board, Color.BLACK));

    }

}
