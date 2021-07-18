package main.it.sevenbits;

public class Segment {
    private Point startPoint;
    private Point endPoint;

    private Segment() {}

    public Segment(Point start , Point end){
        startPoint = start;
        endPoint = end;
    }

    public double getLength(){
        double powX = Math.pow(startPoint.getX() - endPoint.getX(), 2);
        double powY = Math.pow(startPoint.getY() - endPoint.getY(), 2);
        return Math.sqrt(powX + powY);
    }

}
