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
}
