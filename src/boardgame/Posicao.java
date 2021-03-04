package boardgame;

public class Posicao {
    
    private int linhas;
    private int colunas;

    public Posicao(int linhas, int colunas){

        this.linhas = linhas;
        this.colunas = colunas;

    }

    public int getColunas(){

        return colunas;

    }
   
    public void setColunas(int colunas){

        this.colunas = colunas;

    }

    public int getRow(){

        return linhas;

    }
   
    public void setRow(int linhas){

        this.linhas = linhas;

    }

    @Override
    public String toString(){

        return linhas + ", " + colunas;

    }

}
