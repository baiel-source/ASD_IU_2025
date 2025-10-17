package structures;

public class CircularQueue {

    int[] items;
    int size, front, rear;

    public CircularQueue(int size) {
        this.front = -1;
        this.rear = -1;
        this.size = size;
        this.items = new int[size];
    };

    public boolean isEmpty() {
        return (this.front == -1);
    };

    public boolean isFull() {
        return ((front == 0 && rear == size-1) || (front == rear+1));
    };

    public void enqueue(int value) {
        if (isFull()) {
            front = (front + 1) % size;
        };
        if (front == -1) {
            front = 0;
        };
        rear = (rear + 1) % size;
        items[rear] = value;
    };

    public int dequeue() {
        int value;
        if (isEmpty()) {
            return -1;
        };
        value = items[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        };
        return value;
    };

    public void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        };
        System.out.println("Front -> " + front);
        System.out.print("Items -> ");
        int i;
        for (i = front; i != rear; i = (i+1) % size) {
            System.out.print(items[i] + " ");
        };
        System.out.print(items[i]);
        System.out.printf("\nRear -> %d\n", rear);
    };

}
