package com.pieces;

import com.helper.PieceBlueprint;
import com.movement.MoveDiagonal;
import com.movement.MoveType;
import org.jetbrains.annotations.NotNull;

public class Bishop extends Piece {
    public Bishop(@NotNull PieceBlueprint pieceBlueprint) {
            super(pieceBlueprint.getPieceColor(), new MoveType[]{new MoveDiagonal(pieceBlueprint.getPos(), pieceBlueprint.getPieceColor())}, pieceBlueprint.getPos(), new int[] {-1, -1}, pieceBlueprint.getPieceType() );
    }

}