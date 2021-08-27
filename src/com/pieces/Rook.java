package com.pieces;

import com.game.Piece;
import com.helper.Helper;
import com.helper.PieceColor;
import com.helper.PieceType;

public class Rook extends Piece {

    public Rook(PieceColor color) {
        super(color, PieceType.ROOK, Helper.createId());
    }

    //TODO move function
    @Override
    public void move() {
    }

}
