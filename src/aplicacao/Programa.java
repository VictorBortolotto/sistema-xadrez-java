package aplicacao;

import boardgame.*;
import xadrez.PartidaXadrez;

public class Programa{

    public static void main(String[] args) {
        
        PartidaXadrez partida = new PartidaXadrez();
        UI.mostrarTabuleiro(partida.getPecas());

    }

}