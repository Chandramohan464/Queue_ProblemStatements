package Queue_ProblemStatements;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class SlidingWindowMaximum {

    public static List<Integer> findMaxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new LinkedList<>();  
        Deque<Integer> deque = new LinkedList<>();  

        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            deque.addLast(i);

            if (i >= k - 1) {
                result.add(nums[deque.peekFirst()]);  
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7}; 
        int k = 3;  
        List<Integer> maxValues = findMaxSlidingWindow(nums, k);

        System.out.println("Sliding window maximums: " + maxValues);
    }
}

