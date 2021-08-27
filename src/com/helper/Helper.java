package com.helper;

import org.jetbrains.annotations.NotNull;

import java.util.TreeSet;

public class Helper {

    private static final TreeSet<Integer> ids = new TreeSet<>();

    static  {
        for(int i = 1; i <= 64; i++){
            ids.add(i);
        }
    }

    public static @NotNull String pieceTypeToString(@NotNull PieceType type){
        return switch (type) {
            case KING -> "King";
            case QUEEN -> "Queen";
            case ROOK -> "Rook";
            case KNIGHT -> "Knight";
            case BISHOP -> "Bishop";
            case PAWN -> "Pawn";
        };
    }

//    TODO Uncomment if needed
//    @Contract(pure = true)
//    public static int convertPosToInt(Integer @NotNull [] pos){ return pos[0] + 8*pos[1]; }
//    @Contract(value = "_ -> new", pure = true)
//    public static Integer @NotNull [] intToPos(int i){ return new Integer[] {i%8,i/8}; }

    public static Integer createId(){

        if(!ids.isEmpty() && ids.first() != null){
            return ids.pollFirst();
        }
        return -1;

    }

    public static void pushId(Integer i){ ids.add(i); }
}
