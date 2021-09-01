package com.pieces;

import com.helper.PieceBlueprint;
import com.movement.MoveKnight;
import com.movement.MoveType;
import org.jetbrains.annotations.NotNull;

public class Knight extends Piece {

    public Knight(@NotNull PieceBlueprint pieceBlueprint) {
        super(pieceBlueprint.getPieceColor(), new MoveType[]{new MoveKnight(pieceBlueprint.getPos(), pieceBlueprint.getPieceColor())}, pieceBlueprint.getPos(), new int[] {-1, -1}, pieceBlueprint.getPieceType() );
    }
}
