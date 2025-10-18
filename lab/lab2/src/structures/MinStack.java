package structures;

import java.util.Scanner;

public class MinStack {

    private MinStackNode head;

    public MinStack() {
        head = null;
    };

    /**
     * Добавление элемента в вершину стека.
     * При добавлении нового элемента вычисляется его локальное минимальное значение.
     * Если стек пуст, то это добавляемое значение, если нет - минимум из добавляемого
     * и текущего минимального значения вершины стека
     */
    public void push(int value) {
        if (head == null) {
            head = new MinStackNode(value, value);
        } else {
            head = new MinStackNode(value, Math.min(value, head.min), head);
        };
    };

    public int pop() {
        if (head == null) {
            throw new Error("Error while pop(): stack is empty");
        };
        int value = head.value;
        head = head.next;
        return value;
    };

    public int peek() {
        if (head == null) {
            throw new Error("Error while peek(): stack is empty");
        }
        return head.value;
    };

    public int getMin() {
        if (head == null) {
            throw new Error("Error while getMin(): stack is empty");
        };
        return head.min;
    };

    public boolean isEmpty() {
        return head == null;
    };

    public void fill() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число элементов в стеке: ");
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.printf("Введите элемент №%d: ", i+1);
            this.push(sc.nextInt());
        };
    };

    public void print() {
        if (head == null) {
            System.out.println("[]");
            return;
        };
        MinStackNode current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.print("]\n");
    };

    public int size() {
        MinStackNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        };
        return count;
    };

};
