package com.movement;

public class MovePawn extends Move implements MoveType{

    private final int x;
    private final int y;

    public MovePawn(Integer[] pos){
        super(pos);
        x = pos[0];
        y = pos[1];
    }

    private int retVar(int var, int operator){
        return operator == '-' ? var - 1 : var + 1;
    }

    @Override
    public void move() {  }
}
