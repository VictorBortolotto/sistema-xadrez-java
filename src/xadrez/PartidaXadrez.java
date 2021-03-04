package xadrez;

import boardgame.Tabuleiro;

public class PartidaXadrez {
    
    private Tabuleiro tabuleiro;

    public PartidaXadrez(){

        tabuleiro = new Tabuleiro(8, 8);

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

}
