package jogo_tabuleiro;

public class Tabuleiro {

    private Integer linha;
    private Integer coluna;
    private Peca[][] pecas;

    public Tabuleiro() {
    }

    public Tabuleiro(Integer linha, Integer coluna) {
        if (linha < 1 || coluna < 1) {
            throw new TabuleiroException("Erro ao criar quadro: deve haver pelo menos 1 linha e 1 coluna");
        }
        this.linha = linha;
        this.coluna = coluna;
        pecas = new Peca[linha][coluna];
    }

    public Integer getLinha() {
        return linha;
    }

    public Integer getColuna() {
        return coluna;
    }

    public Peca peca(Integer linha, Integer coluna) {
        if (!posicaoExistente(linha, coluna)) {
            throw new TabuleiroException("Posição fora do tabuleiro");
        }
        return pecas[linha][coluna];
    }

    public Peca peca(Posicao posicao) {
        if (!posicaoExistente(posicao)) {
            throw new TabuleiroException("Posição fora do tabuleiro");
        }
        return pecas[posicao.getLinha()][posicao.getColuna()];
    }

    public void colocarPeca(Peca peca, Posicao posicao) {
        if (temUmaPeca(posicao)) {
            throw new TabuleiroException("Já existe uma peça na posição " + posicao);
        }
        pecas[posicao.getLinha()][posicao.getColuna()] = peca;
        peca.posicao = posicao;
    }

    public Peca removerPeca(Posicao posicao) {
        if (!posicaoExistente(posicao)) {
            throw new TabuleiroException("Posição fora do tabuleiro");
        }
        if (peca(posicao) == null) {
            return null;
        }
        Peca aux = peca(posicao);
        aux.posicao = null;
        pecas[posicao.getLinha()][posicao.getColuna()] = null;
        return aux;
    }

    private boolean posicaoExistente(Integer linha, Integer coluna) {
        return linha >= 0 && linha < this.linha && coluna >= 0 && coluna < this.coluna;
    }

    public boolean posicaoExistente(Posicao posicao) {
        return posicaoExistente(posicao.getLinha(), posicao.getColuna());
    }

    public boolean temUmaPeca(Posicao posicao) {
        if (!posicaoExistente(posicao)) {
            throw new TabuleiroException("Posição fora do tabuleiro");
        }
        return peca(posicao) != null;
    }
}
