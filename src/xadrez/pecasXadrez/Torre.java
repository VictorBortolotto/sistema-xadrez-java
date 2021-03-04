package xadrez.pecasXadrez;

import boardgame.Posicao;
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

        Posicao p = new Posicao(0, 0);

        // Move peça para cima
        p.setValues(posicao.getLinhas() - 1, posicao.getColunas());

        while(getTabuleiro().posicaoExistente(p) && !getTabuleiro().existePeca(p)){

            mat[p.getLinhas()][p.getColunas()] = true;
            p.setLinhas(p.getLinhas() - 1);

        }

        if (getTabuleiro().posicaoExistente(p) && possuiPecaDoOponente(p)){

            mat[p.getLinhas()][p.getColunas()] = true;

        }

        // Move peça para esquerda
        p.setValues(posicao.getLinhas(), posicao.getColunas() - 1);

        while(getTabuleiro().posicaoExistente(p) && !getTabuleiro().existePeca(p)){

            mat[p.getLinhas()][p.getColunas()] = true;
            p.setColunas(p.getColunas() - 1);

        }

        if (getTabuleiro().posicaoExistente(p) && possuiPecaDoOponente(p)){

            mat[p.getLinhas()][p.getColunas()] = true;

        }

        // Move peça para direita
        p.setValues(posicao.getLinhas(), posicao.getColunas() + 1);
        
        while(getTabuleiro().posicaoExistente(p) && !getTabuleiro().existePeca(p)){

            mat[p.getLinhas()][p.getColunas()] = true;
            p.setColunas(p.getColunas() + 1);

        }

        if (getTabuleiro().posicaoExistente(p) && possuiPecaDoOponente(p)){

            mat[p.getLinhas()][p.getColunas()] = true;

        }

        // Move peça para baixo
        p.setValues(posicao.getLinhas() + 1, posicao.getColunas());
        
        while(getTabuleiro().posicaoExistente(p) && !getTabuleiro().existePeca(p)){
        
            mat[p.getLinhas()][p.getColunas()] = true;
            p.setLinhas(p.getLinhas() + 1);
        
        }
    
        if (getTabuleiro().posicaoExistente(p) && possuiPecaDoOponente(p)){
        
            mat[p.getLinhas()][p.getColunas()] = true;
        
        }

        return mat;

    }


}   
