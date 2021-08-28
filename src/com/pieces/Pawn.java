package com.pieces;

import com.game.Piece;
import com.helper.Helper;
import com.helper.PieceBlueprint;
import com.helper.PieceType;
import com.movement.MovePawn;
import com.movement.MoveType;
import org.jetbrains.annotations.NotNull;

public class Pawn extends Piece {

    public Pawn(@NotNull PieceBlueprint pieceBlueprint) {
        super(pieceBlueprint.getPieceColor(), PieceType.KING, Helper.createId(), new MoveType[]{new MovePawn(pieceBlueprint.getPos())},pieceBlueprint.getX(), pieceBlueprint.getY() );
    }
}
