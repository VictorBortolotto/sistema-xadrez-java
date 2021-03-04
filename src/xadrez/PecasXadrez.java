package xadrez;

import boardgame.Peca;
import boardgame.Tabuleiro;

public class PecasXadrez extends Peca {
    
    private CoresPecas cores;

    public PecasXadrez(Tabuleiro tabuleiro, CoresPecas cores){

        super(tabuleiro);
        this.cores = cores;

    }

    public CoresPecas getCores(){

        return cores;

    }

}
