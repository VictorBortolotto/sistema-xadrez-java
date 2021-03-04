package xadrez.pecasXadrez;

import boardgame.Tabuleiro;
import xadrez.CoresPecas;
import xadrez.PecasXadrez;

public class Torre extends PecasXadrez{
    
    public Torre(Tabuleiro tabuleiro, CoresPecas cores){

        super(tabuleiro, cores);

    }

    @Override
    public String toString(){

        return "T";

    }

    @Override
    public boolean[][] movimentosPossiveis(){

        boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
        return mat;

    }


}   
