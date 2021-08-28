package com.pieces;

import com.game.Piece;
import com.helper.Helper;
import com.helper.PieceBlueprint;
import com.helper.PieceType;
import com.movement.MoveKing;
import com.movement.MoveType;
import org.jetbrains.annotations.NotNull;

public class King extends Piece {
    public King(@NotNull PieceBlueprint pieceBlueprint) {
        super(pieceBlueprint.getPieceColor(), PieceType.KING, Helper.createId(), new MoveType[]{new MoveKing(pieceBlueprint.getPos())},pieceBlueprint.getX(), pieceBlueprint.getY() );
    }
}