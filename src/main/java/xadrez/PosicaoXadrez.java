package xadrez;

import jogo_tabuleiro.Posicao;

public class PosicaoXadrez {

    private Integer linha;
    private char coluna;

    public PosicaoXadrez() {
    }

    public PosicaoXadrez(char coluna, Integer linha) {
        if (coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {
            throw new XadrezException("Erro ao instanciar posição. Valores válidos vão de a1 a h8.");
        }
        this.linha = linha;
        this.coluna = coluna;
    }

    public Integer getLinha() {
        return linha;
    }

    public char getColuna() {
        return coluna;
    }

     protected Posicao toPosicao() {
        return new Posicao(8 - linha, coluna - 'a');
     }

     protected static PosicaoXadrez fromPosicao(Posicao posicao) {
        return new PosicaoXadrez((char)('a' - posicao.getColuna()),8 - posicao.getLinha());
     }

     @Override
    public String toString() {
        return "" + coluna + linha;
     }
}
