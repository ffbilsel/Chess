package com.pieces;

import com.helper.PieceBlueprint;
import com.movement.MoveDiagonal;
import com.movement.MoveLine;
import com.movement.MoveType;
import org.jetbrains.annotations.NotNull;

public class Queen extends Piece {
    public Queen(@NotNull PieceBlueprint pieceBlueprint) {
        super(pieceBlueprint.getPieceColor(), new MoveType[]{new MoveDiagonal   (pieceBlueprint.getPos(), pieceBlueprint.getPieceColor()), new MoveLine(pieceBlueprint.getPos(), pieceBlueprint.getPieceColor())},pieceBlueprint.getPos(), new int[] {-1, -1}, pieceBlueprint.getPieceType());
    }
}