package it.sevenbits.workshop;

import it.sevenbits.workshop.matrix.Matrix;
import it.sevenbits.workshop.queue.DoubleEndedQueue;

public class Main {
    public static void main(String[] args){
        Matrix matrix = new Matrix(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        System.out.println(matrix.toString());
        matrix.inverseMatrix();
        System.out.println(matrix);

        Matrix matrix2 = new Matrix(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        Matrix matrix3 = new Matrix(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        DoubleEndedQueue queue = new DoubleEndedQueue();
        queue.addFirst(matrix);
        queue.addFirst(matrix2);
        queue.addLast(matrix3);
        queue.addLast(matrix);
        queue.addLast(matrix);


        System.out.println("Get last and first\n" + queue.getLast().val);
        System.out.println(queue.getFirst().val);

        System.out.println("queue\n" + queue.toString());
    }
}
