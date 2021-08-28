package com.pieces;

import com.game.Piece;
import com.helper.Helper;
import com.helper.PieceBlueprint;
import com.helper.PieceType;
import com.movement.MoveDiagonal;
import com.movement.MoveType;
import org.jetbrains.annotations.NotNull;

public class Bishop extends Piece {
    public Bishop(@NotNull PieceBlueprint pieceBlueprint) {
            super(pieceBlueprint.getPieceColor(), PieceType.BISHOP, Helper.createId(), new MoveType[]{new MoveDiagonal(pieceBlueprint.getPos())},pieceBlueprint.getX(), pieceBlueprint.getY() );
    }

}