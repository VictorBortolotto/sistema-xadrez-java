package aplicacao;

import java.util.Scanner;

import boardgame.*;
import xadrez.PartidaXadrez;
import xadrez.PecasXadrez;
import xadrez.PosicaoXadrez;

public class Programa{

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        PartidaXadrez partida = new PartidaXadrez();
        
        while(true){

            UI.mostrarTabuleiro(partida.getPecas());
            System.out.println();
            System.out.println("Origem ");
            PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);

            System.out.println();
            System.out.println("Alvo: ");
            PosicaoXadrez alvo = UI.lerPosicaoXadrez(sc);

            PecasXadrez pecaCapturada = partida.moverPeca(origem, alvo);

        }    
    }

}