package it.sevenbits.workshop.queue;

import it.sevenbits.workshop.matrix.Matrix;

public class Node {
        public Matrix val;
        Node next,prev;

        public Node(Matrix matrix){
            val = matrix;
            next = null;
            prev = null;
        }

    }



