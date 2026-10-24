public class TransactionStack {
    private char[] data;
    private int top;
    
    public TransactionStack(int capacity) {
        data = new char[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == data.length - 1;
    }

    public void push(char c) {
        if (!isFull()) {
            data[++top] = c;
        } else {
            System.out.println("Stack is full. Cannot push " + c + " onto the stack.");
        }
    }

    public char pop() {
        if (!isEmpty()) {
            return data[top--];
        } else {
            System.out.println("Stack is empty. Cannot pop from the stack.");
            return '\0';
        }
    }

    public char peek() {
        if (!isEmpty()) {
            return data[top];
        } else {
            System.out.println("Stack is empty. Cannot peek.");
            return '\0'; // Return null character if stack is empty
        }
    }
}
