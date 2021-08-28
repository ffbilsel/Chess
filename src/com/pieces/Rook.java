package com.pieces;

import com.game.Piece;
import com.helper.Helper;
import com.helper.PieceBlueprint;
import com.helper.PieceType;
import com.movement.MoveLine;
import com.movement.MoveType;
import org.jetbrains.annotations.NotNull;

public class Rook extends Piece {

    public Rook(@NotNull PieceBlueprint pieceBlueprint) {
        super(pieceBlueprint.getPieceColor(), PieceType.BISHOP, Helper.createId(), new MoveType[]{new MoveLine(pieceBlueprint.getPos())},pieceBlueprint.getX(), pieceBlueprint.getY() );
    }
}
