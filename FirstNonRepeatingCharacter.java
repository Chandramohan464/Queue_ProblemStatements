package Queue_ProblemStatements;

import java.util.LinkedList;
import java.util.Queue;

class FirstNonRepeatingCharacter {

    public static void findFirstNonRepeating(String stream) {
        int[] freq = new int[26];

        Queue<Character> queue = new LinkedList<>();

        for (char ch : stream.toCharArray()) {
            freq[ch - 'a']++;

            queue.add(ch);

            while (!queue.isEmpty() && freq[queue.peek() - 'a'] > 1) {
                queue.poll();
            }

            if (!queue.isEmpty()) {
                System.out.println("First non-repeating character: " + queue.peek());
            } else {
                System.out.println("No non-repeating character.");
            }
        }
    }

    public static void main(String[] args) {
        String stream = "aabcdeacb"; 
        findFirstNonRepeating(stream);
    }
}

