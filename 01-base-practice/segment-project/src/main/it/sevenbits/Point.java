package main.it.sevenbits;

public class Point {
    private int x;
    private int y;

    private Point(){}

    public Point(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
