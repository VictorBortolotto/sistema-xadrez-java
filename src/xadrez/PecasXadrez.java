package xadrez;

import boardgame.Peca;
import boardgame.Posicao;
import boardgame.Tabuleiro;

public abstract class PecasXadrez extends Peca {
    
    private CoresPecas cores;

    public PecasXadrez(Tabuleiro tabuleiro, CoresPecas cores){

        super(tabuleiro);
        this.cores = cores;

    }

    public CoresPecas getCores(){

        return cores;

    }

    protected boolean possuiPecaDoOponente(Posicao posicao){

        PecasXadrez p = (PecasXadrez) getTabuleiro().pecas(posicao);

        return p != null && p.getCores() != cores;

    }

}
