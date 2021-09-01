package com.pieces;

import com.helper.PieceBlueprint;
import com.movement.MoveLine;
import com.movement.MoveType;
import org.jetbrains.annotations.NotNull;

public class Rook extends Piece {

    public Rook(@NotNull PieceBlueprint pieceBlueprint) {
        super(pieceBlueprint.getPieceColor(), new MoveType[]{new MoveLine(pieceBlueprint.getPos(), pieceBlueprint.getPieceColor())},pieceBlueprint.getPos(), new int[] {-1, -1}, pieceBlueprint.getPieceType() );
    }
}
