package com.movement;

import java.util.HashMap;

public interface MoveType {
    HashMap<Integer,Boolean> move();
    void setPos(int[] pos);
}
