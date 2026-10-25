public class RequestQueue {
    private char[] data;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public RequestQueue(int capacity) {
        this.capacity = capacity;
        data = new char[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void enqueue(char c) {
        if (!isFull()) {
            data[rear] = c;
            rear = (rear + 1) % capacity;
            size++;
        } else {
            System.out.println("Queue is full. Cannot enqueue " + c + " into the queue.");
        }
    }

    public char dequeue() {
        if (!isEmpty()) {
            char item = data[front];
            front = (front + 1) % capacity;
            size--;
            return item;
        } else {
            System.out.println("Queue is empty. Cannot dequeue from the queue.");
            return '\0'; // Return null character if queue is empty
        }
    }

}
