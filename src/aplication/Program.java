package aplication;

import java.util.InputMismatchException;
import java.util.Scanner;

import boardgame.*;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program{

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        
        while(true){

            try{

                UI.clearScreen();
                UI.printMatch(chessMatch);
                System.out.println();
                System.out.println("Origem ");
                ChessPosition source = UI.readChessPosition(sc);

                boolean[][] movimentosPossiveis = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), movimentosPossiveis);
                   
                System.out.println();
                System.out.println("Alvo: ");
                ChessPosition alvo = UI.readChessPosition(sc);
                   
                ChessPiece pecaCapturada = chessMatch.performChessMove(source, alvo);
            
            }catch (ChessException e){

                System.out.println(e.getMessage());
                sc.nextLine();

            }catch (InputMismatchException e){

                System.out.println(e.getMessage());
                sc.nextLine();

            }

        }    
    }

}