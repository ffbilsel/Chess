package com.pieces;

import com.game.Piece;
import com.helper.Helper;
import com.helper.PieceBlueprint;
import com.helper.PieceType;
import com.movement.MoveDiagonal;
import com.movement.MoveLine;
import com.movement.MoveType;
import org.jetbrains.annotations.NotNull;

public class Queen extends Piece {
    public Queen(@NotNull PieceBlueprint pieceBlueprint) {
        super(pieceBlueprint.getPieceColor(), PieceType.KING, Helper.createId(), new MoveType[]{new MoveDiagonal(pieceBlueprint.getPos()), new MoveLine(pieceBlueprint.getPos())},pieceBlueprint.getX(), pieceBlueprint.getY() );
    }
}