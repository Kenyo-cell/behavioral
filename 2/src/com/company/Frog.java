package com.company;

public class Frog {
    private final int MIN_POS = 0;
    private final int MAX_POS = 10;

    private int pos;

    public Frog() {
        pos = 5;
    }

    public boolean jump(int steps) {
        int nPos = pos + steps;
        if (nPos >= MIN_POS && nPos <= MAX_POS) {
            pos = nPos;
            return true;
        }

        return false;
    }

    public String toString() {
        return "_".repeat(pos) + "f" + "_".repeat(MAX_POS - pos);
    }
}
