package xadrez.pecasXadrez;

import boardgame.Tabuleiro;
import xadrez.CoresPecas;
import xadrez.PecasXadrez;

public class Rei extends PecasXadrez{
    
    public Rei(Tabuleiro tabuleiro, CoresPecas cores){

        super(tabuleiro, cores);

    }

    @Override
    public String toString(){

        return "K";

    }

}
