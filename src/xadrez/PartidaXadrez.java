package xadrez;

import boardgame.Peca;
import boardgame.Posicao;
import boardgame.Tabuleiro;
import xadrez.pecasXadrez.Rei;
import xadrez.pecasXadrez.Torre;

public class PartidaXadrez {
    
    private Tabuleiro tabuleiro;

    public PartidaXadrez(){

        tabuleiro = new Tabuleiro(8, 8);
        setupInicial();

    }

    public PecasXadrez[][] getPecas(){

        PecasXadrez[][] mat = new PecasXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];

        for(int i = 0; i < tabuleiro.getLinhas(); i++){

            for(int j = 0; j < tabuleiro.getColunas(); j++){

                mat[i][j] = (PecasXadrez) tabuleiro.pecas(i, j);
                
            }

        }

        return mat;

    }

    public PecasXadrez moverPeca(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoAlvo){

        Posicao origem = posicaoOrigem.toPosicao();
        Posicao alvo = posicaoAlvo.toPosicao();
        validarPosicaoOrigem(origem);
        Peca pecaCapturada = realizarMovimento(origem, alvo);
        return (PecasXadrez) pecaCapturada;


    }

    private Peca realizarMovimento(Posicao posicaoOrigem, Posicao posicaoAlvo){

        Peca p = tabuleiro.removerPeca(posicaoOrigem);
        Peca pecaCapturada = tabuleiro.removerPeca(posicaoAlvo);
        tabuleiro.lugarPeca(p, posicaoAlvo);

        return pecaCapturada;

    }

    private void validarPosicaoOrigem(Posicao posicao){

        if(!tabuleiro.existePeca(posicao)){

            throw new XadrezException("Não há peça na posição de origem.");

        }

    }

    private void lugarNovaPeca(char coluna, int linha, PecasXadrez peca){

        tabuleiro.lugarPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());

    }

    private void setupInicial(){

       lugarNovaPeca('c', 1, new Torre(tabuleiro, CoresPecas.BRANCAS));
       lugarNovaPeca('c', 2, new Torre(tabuleiro, CoresPecas.BRANCAS));
       lugarNovaPeca('d', 2, new Torre(tabuleiro, CoresPecas.BRANCAS));
       lugarNovaPeca('e', 2, new Torre(tabuleiro, CoresPecas.BRANCAS));
       lugarNovaPeca('e', 1, new Torre(tabuleiro, CoresPecas.BRANCAS));
       lugarNovaPeca('d', 1, new Torre(tabuleiro, CoresPecas.BRANCAS));

       lugarNovaPeca('c', 7, new Torre(tabuleiro, CoresPecas.PRETAS));
       lugarNovaPeca('c', 8, new Torre(tabuleiro, CoresPecas.PRETAS));
       lugarNovaPeca('d', 7, new Torre(tabuleiro, CoresPecas.PRETAS));
       lugarNovaPeca('e', 7, new Torre(tabuleiro, CoresPecas.PRETAS));
       lugarNovaPeca('e', 8, new Torre(tabuleiro, CoresPecas.PRETAS));
       lugarNovaPeca('d', 8, new Torre(tabuleiro, CoresPecas.PRETAS));

    }

}
