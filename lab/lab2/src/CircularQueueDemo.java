/*
    Реализовать «Циклическую очередь» (Circular Queue). Прокомментировать логику.
*/
import structures.CircularQueue;

public class CircularQueueDemo {

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(10);
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        circularQueue.print();
        int element = circularQueue.dequeue();
        if (element != -1) {
            System.out.println("Deleted element is " + element);
        };
    };

};
