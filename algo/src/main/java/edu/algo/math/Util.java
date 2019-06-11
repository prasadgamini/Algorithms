package edu.algo.math;

public class Util {

    public static int computeGCD(int x, int y) {
        if (x == 0) return y;
        if (y == 0) return x;
        return computeGCD(y, x % y);
    }
}
