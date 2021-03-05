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
        ChessMatch partida = new ChessMatch();
        
        while(true){

            try{

                UI.clearScreen();
                UI.printBoard(partida.getPieces());
                System.out.println();
                System.out.println("Origem ");
                ChessPosition origem = UI.readChessPosition(sc);

                boolean[][] movimentosPossiveis = partida.possibleMoves(origem);
                UI.clearScreen();
                UI.printBoard(partida.getPieces(), movimentosPossiveis);
                   
                System.out.println();
                System.out.println("Alvo: ");
                ChessPosition alvo = UI.readChessPosition(sc);
                   
                ChessPiece pecaCapturada = partida.performChessMove(origem, alvo);
            
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