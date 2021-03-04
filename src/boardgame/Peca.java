package boardgame;

public abstract class Peca {
    
    protected Posicao posicao;
    private Tabuleiro tabuleiro;

    public Peca(Tabuleiro tabuleiro){

        this.tabuleiro = tabuleiro;
        posicao = null;

    }

    protected Tabuleiro getTabuleiro(){

        return tabuleiro;

    }

    public abstract boolean[][] movimentosPossiveis();

    public boolean verificarSeMovimentoePossivel(Posicao posicao){

        return movimentosPossiveis()[posicao.getLinhas()][posicao.getColunas()];

    }

    public boolean existeMovimentoPossivel(){

        boolean[][] mat = movimentosPossiveis();

        for(int i = 0; i < mat.length; i++){

            for (int j = 0; j < mat.length; j++){

                if(mat[i][i]){

                    return true;

                }

            }            

        }

        return false;

    }

}
