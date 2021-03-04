package xadrez;

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

    private void lugarNovaPeca(char coluna, int linha, PecasXadrez peca){

        tabuleiro.lugarPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());

    }

    private void setupInicial(){

        lugarNovaPeca('b', 6, new Torre(tabuleiro, CoresPecas.BRANCAS));
        lugarNovaPeca('c', 1, new Rei(tabuleiro, CoresPecas.BRANCAS));
        lugarNovaPeca('a', 6, new Torre(tabuleiro, CoresPecas.BRANCAS));

    }

}
