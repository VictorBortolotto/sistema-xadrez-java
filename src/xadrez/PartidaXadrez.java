package xadrez;

import boardgame.Posicao;
import boardgame.Tabuleiro;
import xadrez.pecasXadrez.Rei;
import xadrez.pecasXadrez.Torre;

public class PartidaXadrez {
    
    private Tabuleiro tabuleiro;

    public PartidaXadrez(){

        tabuleiro = new Tabuleiro(8, 8);
        setupInicial();

    }

    public PecasXadrez[][] getPecas(){

        PecasXadrez[][] mat = new PecasXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];

        for(int i = 0; i < tabuleiro.getLinhas(); i++){

            for(int j = 0; j < tabuleiro.getColunas(); j++){

                mat[i][j] = (PecasXadrez) tabuleiro.pecas(i, j);
                
            }

        }

        return mat;

    }

    private void setupInicial(){

        tabuleiro.lugarPeca(new Torre(tabuleiro, CoresPecas.BRANCAS), new Posicao(2, 1));
        tabuleiro.lugarPeca(new Rei(tabuleiro, CoresPecas.PRETAS), new Posicao(0, 4));
        tabuleiro.lugarPeca(new Rei(tabuleiro, CoresPecas.BRANCAS), new Posicao(7, 4));
    }

}
