package com.pieces;

import com.helper.PieceBlueprint;
import com.movement.MoveKing;
import com.movement.MoveType;
import org.jetbrains.annotations.NotNull;

public class King extends Piece {
    public King(@NotNull PieceBlueprint pieceBlueprint) {
        super(pieceBlueprint.getPieceColor(), new MoveType[]{new MoveKing(pieceBlueprint.getPos(), pieceBlueprint.getPieceColor())}, pieceBlueprint.getPos(), new int[] {-1, -1}, pieceBlueprint.getPieceType() );
    }
}