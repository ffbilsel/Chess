package com.pieces;

import com.game.Piece;
import com.helper.Helper;
import com.helper.PieceColor;
import com.helper.PieceType;

public class Pawn extends Piece {

    public Pawn(PieceColor color) {
        super(color, PieceType.PAWN, Helper.createId());
    }

    //TODO move function
    @Override
    public void move() {
    }
}
