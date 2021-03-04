package boardgame;

public class Tabuleiro {
 
    private int linhas;
    private int colunas;
    private Peca[][] pecas;

    public Tabuleiro(int linhas, int colunas){

        if(linhas < 1 || colunas < 1){

            throw new TabuleiroExceptions("Erro criando o tabuleiro: é necessário que haja pelo menos 1 linha e 1 coluna");

        }

        this.linhas = linhas;
        this.colunas = colunas;
        pecas = new Peca[linhas][colunas];

    }

    public int getColunas(){

        return colunas;

    }

    public int getLinhas(){

        return linhas;

    }

    public Peca pecas(int linhas, int colunas){

        

        return pecas[linhas] [colunas];

    }

    public Peca pecas(Posicao posicao){

        
        return pecas[posicao.getLinhas()][posicao.getColunas()];

    }

    public void lugarPeca(Peca peca, Posicao posicao){

        if(existePeca(posicao)){

            throw new TabuleiroExceptions("Posição já ocupada por outra peça." + posicao);

        }

        pecas[posicao.getLinhas()][posicao.getColunas()] = peca;
        peca.posicao = posicao;

    }

    private boolean posicaoExistente(int linhas, int colunas){

       return linhas >= 0 && linhas < linhas && colunas > 0 && colunas < colunas;

    }

    public boolean posicaoExistente(Posicao posicao){

        return posicaoExistente(posicao.getLinhas(), posicao.getColunas());

    }

    public boolean existePeca(Posicao posicao){    

        return pecas(posicao) != null;

    }

}
