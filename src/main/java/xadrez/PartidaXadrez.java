package xadrez;

import jogo_tabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaXadrez {

    private Tabuleiro tabuleiro;

    public PartidaXadrez() {
        tabuleiro = new Tabuleiro(8, 8);
        layoutInicial();
    }

    public PecaXadrez[][] getPecas() {
        PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinha()][tabuleiro.getColuna()];
        for (int i = 0; i < tabuleiro.getLinha(); i++) {
            for (int j = 0; j < tabuleiro.getColuna(); j++) {
                mat[i][j] = (PecaXadrez) tabuleiro.peca(i, j);
            }
        }
        return mat;
    }

    private void colocarNovaPeca(char coluna, Integer linha, PecaXadrez peca) {
        tabuleiro.colocarPeca(peca, new PosicaoXadrez(coluna, linha).toPosicao());
    }

    public void layoutInicial() {
        colocarNovaPeca('c', 1, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('c', 2, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('d', 2, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('e', 2, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('e', 1, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('d', 1, new Rei(tabuleiro, Cor.BRANCO));

        colocarNovaPeca('c', 7, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('c', 8, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('d', 7, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('e', 7, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('e', 8, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('d', 8, new Rei(tabuleiro, Cor.BRANCO));
    }
}
