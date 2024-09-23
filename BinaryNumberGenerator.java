package Queue_ProblemStatements;

import java.util.LinkedList;
import java.util.Queue;

class BinaryNumberGenerator {

    public static void generateBinaryNumbers(int n) {
        Queue<String> queue = new LinkedList<>();

        queue.add("1");

        for (int i = 1; i <= n; i++) {
            String current = queue.poll();

            System.out.println(current);

            queue.add(current + "0");
            queue.add(current + "1");
        }
    }

    public static void main(String[] args) {
        int n = 10; 
        generateBinaryNumbers(n);
    }
}

