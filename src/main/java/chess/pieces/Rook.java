package chess.pieces;

import boardgame.Board;
import chess.Color;
import chess.ChessPiece;

public class Rook extends ChessPiece {

    public Rook(Board tabuleiro, Color cor) {
        super(tabuleiro, cor);
    }

    @Override
    public String toString() {
        return "T";
    }
}
