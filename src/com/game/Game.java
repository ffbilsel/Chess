package com.game;

import com.gui.ChessBoard;
import com.helper.PieceBlueprint;
import com.helper.PieceType;
import com.movement.MoveType;
import com.pieces.Piece;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;

public class Game{

    private ChessBoard gameChessBoard;
    private boolean isFirstMove = false;
    private final HashMap<Integer,Boolean> possibleMoves = new HashMap<>();
    private int[] pos;
    public static final Stack<Path> log = new Stack<>();
    public static Cell[][] board = new Cell[8][8];
    public static final int boardSize = 8;

    public Game(){
        for(int i = 0; i < Game.boardSize; i++){
            for(int j = 0; j< Game.boardSize; j++){
                Game.board[i][j] = new Cell();
            }
        }
    }

    public void setGameChessBoard(ChessBoard gameChessBoard) {
        this.gameChessBoard = gameChessBoard;
    }

    public void addPiece(@NotNull PieceBlueprint pieceBlueprint) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Cell targetCell = board[pieceBlueprint.getX()][pieceBlueprint.getY()];
        if(targetCell == null){
            board[pieceBlueprint.getX()][pieceBlueprint.getY()] = new Cell();
            targetCell = board[pieceBlueprint.getX()][pieceBlueprint.getY()];
        }
        if(targetCell.isEmpty()){
            String className = "com.pieces." + pieceBlueprint.getType();
            targetCell.setCurrentPiece((Piece) Class.forName(className).getConstructor(PieceBlueprint.class).newInstance(pieceBlueprint));
            targetCell.getCurrentPiece().addLastPos(convertToIntegerArray(pieceBlueprint.getPos()));
        }
    }

    public void redo(){
        if(Game.log.isEmpty()){ return; }
        Path path = Game.log.pop();
        if(path.getCounter() < 1){
            return;
        }
        Cell lastCell = Game.board[path.getPos()[0]][path.getPos()[1]];
        Piece movedPiece = lastCell.getCurrentPiece();
        lastCell.getCurrentPiece().getLastPos().pop();
        movedPiece.setPos(Game.convertToIntArray(lastCell.getCurrentPiece().getLastPos().peek()));
        if(path.getCapturedPiece() == null){
            lastCell.setEmpty();
        }
        else{
            lastCell.setCurrentPiece(path.getCapturedPiece());
        }
        JButton chessBoardCell = gameChessBoard.getChessBoardSquares()[this.pos[0]][this.pos[1]];
        Piece piece = path.getCapturedPiece();
        if(Objects.isNull(piece)){
            chessBoardCell.setText(" ");
        }
        else {
            chessBoardCell.setText(Game.pieceTypeToString(piece.getPieceType()));
        }
        int[] movedPiecePos = movedPiece.getPos();
        gameChessBoard.getChessBoardSquares()[movedPiecePos[0]][movedPiecePos[1]].setText(Game.pieceTypeToString(movedPiece.getPieceType()));
    }

    //TODO correct cellIsClicked findPossibleMoves secondCellIsClicked
    public void cellIsClicked(int @NotNull [] pos) {
        if(isFirstMove){ secondCellIsClicked(pos); isFirstMove = false; return; }
        this.pos = pos;
        Cell currentCell = Game.board[pos[0]][pos[1]];
        if (currentCell.isEmpty()) { return; }
        findPossibleMoves(pos, currentCell.getCurrentPiece().getMoveType());
        isFirstMove = true;
        gameChessBoard.getChessBoardSquares()[pos[0]][pos[1]].setBackground(new Color(0x2D94A7));

    }
    private void findPossibleMoves(int[] pos, MoveType @NotNull [] moveTypes){
        possibleMoves.clear();
        for(MoveType moveType: moveTypes){
            moveType.setPos(pos);
            mergeHashes(possibleMoves, moveType.move());
        }
    }

    public void secondCellIsClicked(int @NotNull [] pos){
        Cell currentCell = Game.board[this.pos[0]][this.pos[1]];
        Cell targetCell = Game.board[pos[0]][pos[1]];
        if(possibleMoves.get(Game.generateHash(Game.convertToIntegerArray(pos)))){
            log.push(new Path(pos));
            currentCell.getCurrentPiece().getLastPos().push(Game.convertToIntegerArray(pos));
            targetCell.setCurrentPiece(currentCell.getCurrentPiece());
            currentCell.setEmpty();
            JButton chessBoardCell = gameChessBoard.getChessBoardSquares()[this.pos[0]][this.pos[1]];
            String text = chessBoardCell.getText();
            chessBoardCell.setBackground(new Color(0xFFFFFF));
            chessBoardCell.setText("");
            gameChessBoard.getChessBoardSquares()[pos[0]][pos[1]].setText(text);
        }
        else{
            JButton chessBoardCell = gameChessBoard.getChessBoardSquares()[this.pos[0]][this.pos[1]];
            chessBoardCell.setBackground(new Color(0xFFFFFF));
            this.pos[0] = -1;
            this.pos[1] = -1;
        }
    }

    public boolean isCheck(){

        return false;
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

    @Contract(pure = true)
    public static int @NotNull [] convertToIntArray(Integer @NotNull [] arr){ return Arrays.stream(arr).mapToInt(Integer::intValue).toArray(); }

    public static Integer @NotNull [] convertToIntegerArray(int [] arr){ return Arrays.stream(arr).boxed().toArray(Integer[]::new);}

    public void mergeHashes(HashMap<Integer, Boolean> first, @NotNull HashMap<Integer,Boolean> second){ second.forEach((key, value) ->first.merge( key, value, (v1, v2) -> v1 ||v2)); }

    public static void autoKeyListener(@NotNull Component component, Game game){
        component.setFocusable(true);
        component.addKeyListener((new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if((e.getKeyCode() == KeyEvent.VK_Z) && ((e.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) != 0)) {
                    game.redo();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        }));
    }
    @Contract(pure = true)
    public static @NotNull Integer generateHash(Integer @NotNull [] arr){
        return arr[0]*10 + arr[1];
    }
}
