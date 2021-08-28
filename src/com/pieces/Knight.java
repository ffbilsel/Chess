package com.pieces;

import com.game.Piece;
import com.helper.Helper;
import com.helper.PieceBlueprint;
import com.helper.PieceType;
import com.movement.MoveKnight;
import com.movement.MoveType;
import org.jetbrains.annotations.NotNull;

public class Knight extends Piece {

    public Knight(@NotNull PieceBlueprint pieceBlueprint) {
        super(pieceBlueprint.getPieceColor(), PieceType.KNIGHT, Helper.createId(), new MoveType[]{new MoveKnight(pieceBlueprint.getPos())},pieceBlueprint.getX(), pieceBlueprint.getY() );
    }
}
