package com.movement;

public class MoveKnight extends Move implements MoveType{

    private final int x;
    private final int y;

    public MoveKnight(Integer[] pos){
        super(pos);
        x = pos[0];
        y = pos[1];
    }

    @Override
    public void move() {  }
}
