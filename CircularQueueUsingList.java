package Queue_ProblemStatements;

import java.util.LinkedList;
import java.util.List;

class CircularQueueUsingList {
    private List<Integer> queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public CircularQueueUsingList(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full");
            return false;
        }

        if (isEmpty()) {
            front = 0;
        }

        rear = (rear + 1) % capacity;

        if (size < queue.size()) {
            queue.set(rear, element);
        } else {
            queue.add(element);
        }
        size++;
        return true;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        int element = queue.get(front);
        front = (front + 1) % capacity;
        size--;

        if (size == 0) {
            front = -1;
            rear = -1;
        }

        return element;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return queue.get(front);
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        CircularQueueUsingList circularQueue = new CircularQueueUsingList(5);

        circularQueue.enqueue(10);
        circularQueue.enqueue(20);
        circularQueue.enqueue(30);
        circularQueue.enqueue(40);
        circularQueue.enqueue(50);

        System.out.println("Front element: " + circularQueue.peek());

        System.out.println("Dequeued: " + circularQueue.dequeue());
        System.out.println("Dequeued: " + circularQueue.dequeue());   

        circularQueue.enqueue(60);
        circularQueue.enqueue(70);

        System.out.println("Front element after enqueue: " + circularQueue.peek());  
    }
}

