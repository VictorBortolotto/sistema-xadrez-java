package xadrez;

import boardgame.Posicao;

public class PosicaoXadrez {
    
    private char coluna;
    private int linha;

    public PosicaoXadrez(char coluna, int linha){

        if(coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8){

            throw new XadrezException("Erro instanciando posição no xadrez, valores válidos vão de a1 até h8.");

        }

        this.coluna = coluna;
        this.linha = linha;
        
    }

    public int getColunas() {
        
        return coluna;

    }

    public int getLinhas(){

        return linha;

    }

    protected Posicao toPosicao(){

        return new Posicao(8 - linha, coluna - 'a');
        
    }

    protected static PosicaoXadrez fromPosicao(Posicao posicao){

        return new PosicaoXadrez((char) ('a'- posicao.getColunas()), 8 - posicao.getLinhas());

    }

    @Override
    public String toString(){

        return "" + coluna + linha;

    }

}
