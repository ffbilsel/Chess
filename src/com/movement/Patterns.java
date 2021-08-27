//package com.movement;
//
//import com.game.Cell;
//import com.game.Game;
//import com.helper.PieceColor;
//import org.jetbrains.annotations.NotNull;
//
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.function.Supplier;
//
//public class Patterns {
//
//    private final PieceColor color;
//    private final int x;
//    private final int y;
//    private final LinkedList<Integer[]> possibleCollisions = new LinkedList<>();
//    private final HashMap<Integer[],Boolean> possibleMoves = new HashMap<>(64);
//
//    public Patterns(Integer @NotNull [] pos){
//        this.x = pos[0]; this.y = pos[1];
//        color = Game.board[x][y].getCurrentPiece().getColor();
//        for(int i = 0; i < Game.boardSize; i++){
//            for(int j = 0; j < Game.boardSize; j++){
//                possibleMoves.put(new Integer[] {i,j}, false);
//            }
//        }
//    }
//
//    public void moveLine(int x,int y) {
//
//        final AtomicInteger xTemp = new AtomicInteger(x - 1);
//        moveHelper(xTemp.get(), y, () -> xTemp.get() > 0, () -> xTemp::getAndDecrement;
//        moveHelper(x + 1, y, () -> x < Game.boardSize, () -> x++);
//        moveHelper(x, y - 1, () -> x > 0, () -> y--);
//        moveHelper(x, y + 1, () -> x < Game.boardSize, () -> y++);
//
//    }
//
//    public void moveDiagonal(int x, int y){
//
//        moveHelper(x - 1, y-1, () -> x > 0 && y > 0, () -> x--; y--;);
//        moveHelper(x + 1, y +1 , () -> x < Game.boardSize && y < Game.boardSize, () -> x++; y++);
//        moveHelper(x + 1, y - 1, () -> x < Game.boardSize && y > 0, () -> x++; y--);
//        moveHelper(x - 1, y + 1, () -> x > 0 && y < Game.boardSize, () -> x--;y++);
//    }
//
//    private void moveHelper(int x, int y, @NotNull Supplier<Boolean> condition, Runnable runnable){
//
//        while(condition.get()){
//
//            Integer[] currentPos = new Integer[]{x,y};
//            Cell currentCell = Game.board[x][y];
//            if(currentCell.isEmpty()){
//                possibleMoves.put(currentPos,true);
//                runnable.run();
//            }
//
//            else if(currentCell.getCurrentPiece().getColor() != color){
//                possibleMoves.put(currentPos,true);
//                possibleCollisions.add(currentPos);
//                break;
//            }
//            else{
//                return;
//            }
//
//        }
//
//    }
//
//}
