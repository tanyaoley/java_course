package main.it.sevenbits;

import java.util.Random;

public class Main {
    static int ARRAY_SIZE = 10;

    public static void main(String[] args){
        Segment[] segments = new Segment[ARRAY_SIZE];
        double maxLength = 0;
        for (int i = 0; i < ARRAY_SIZE; i++){
            Random rand = new Random();
            Point start = new Point(rand.nextInt(), rand.nextInt());
            Point end = new Point(rand.nextInt(), rand.nextInt());
            segments[i] = new Segment(start,end);
            double currentLength = segments[i].getLength();
            System.out.println(String.format("%.3f",currentLength));
            if (maxLength < currentLength){
                maxLength = currentLength;
            }
        }
        System.out.println(String.format("Max length %.3f",maxLength));

    }
}
