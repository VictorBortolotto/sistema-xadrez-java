package boardgame;

public class Tabuleiro {
 
    private int linhas;
    private int colunas;
    private Peca[][] pecas;

    public Tabuleiro(int linhas, int colunas){

        this.linhas = linhas;
        this.colunas = colunas;
        pecas = new Peca[linhas][colunas];

    }

    public int getColunas(){

        return colunas;

    }

    public void setColunas(int colunas){

       this.colunas = colunas;

    }

    public int getLinhas(){

        return linhas;

    }

    public void setLinhas(int linhas){

       this.linhas = linhas;

    }

    public Peca pecas(int linhas, int colunas){

        return pecas[linhas] [colunas];

    }

    public Peca pecas(Posicao posicao){

        return pecas[posicao.getLinhas()][posicao.getColunas()];

    }

}
