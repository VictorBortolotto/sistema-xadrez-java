package aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import boardgame.*;
import xadrez.PartidaXadrez;
import xadrez.PecasXadrez;
import xadrez.PosicaoXadrez;
import xadrez.XadrezException;

public class Programa{

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        PartidaXadrez partida = new PartidaXadrez();
        
        while(true){

            try{

                UI.limparTela();
                UI.mostrarTabuleiro(partida.getPecas());
                System.out.println();
                System.out.println("Origem ");
                PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);

                boolean[][] movimentosPossiveis = partida.movimentosPossiveis(origem);
                UI.limparTela();
                UI.mostrarTabuleiro(partida.getPecas(), movimentosPossiveis);
                   
                System.out.println();
                System.out.println("Alvo: ");
                PosicaoXadrez alvo = UI.lerPosicaoXadrez(sc);
                   
                PecasXadrez pecaCapturada = partida.moverPeca(origem, alvo);
            
            }catch (XadrezException e){

                System.out.println(e.getMessage());
                sc.nextLine();

            }catch (InputMismatchException e){

                System.out.println(e.getMessage());
                sc.nextLine();

            }

        }    
    }

}