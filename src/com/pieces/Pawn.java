package com.pieces;

import com.helper.PieceBlueprint;
import com.movement.MovePawn;
import com.movement.MoveType;
import org.jetbrains.annotations.NotNull;

public class Pawn extends Piece {

    public Pawn(@NotNull PieceBlueprint pieceBlueprint) {
        super(pieceBlueprint.getPieceColor(), new MoveType[]{new MovePawn(pieceBlueprint.getPos(), pieceBlueprint.getPieceColor())}, pieceBlueprint.getPos(), new int[] {-1, -1}, pieceBlueprint.getPieceType() );
    }
}
