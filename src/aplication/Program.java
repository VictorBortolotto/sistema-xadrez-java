package aplication;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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
        List <ChessPiece> capturedPieces = new ArrayList<>();
        
        while(!chessMatch.getCheckMate()){

            try{

                UI.clearScreen();
                UI.printMatch(chessMatch, capturedPieces);
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

                if (pecaCapturada != null){

                    capturedPieces.add(pecaCapturada);

                }

                if (chessMatch.getPromoted() != null){

                    System.out.println("Digite a nova peça: Q (Rainha), C (Cavalo), B (Bispo), T (Torre)");
                    String type = sc.nextLine().toUpperCase();
                    
                    while(!type.equals("B") && !type.equals("C") && !type.equals("T") & !type.equals("Q")){

                        System.out.println("Valor de peça inválida tente: Q (Rainha), C (Cavalo), B (Bispo), T (Torre)");
                        type = sc.nextLine().toUpperCase();

                    }   
                    
                    chessMatch.replacePromotedPiece(type);

                }
            
           }catch (ChessException e){

                System.out.println(e.getMessage());
                sc.nextLine();

            }catch (InputMismatchException e){

                System.out.println(e.getMessage());
                sc.nextLine();

            }

        }    

        UI.clearScreen();
        UI.printMatch(chessMatch, capturedPieces);

    }

}