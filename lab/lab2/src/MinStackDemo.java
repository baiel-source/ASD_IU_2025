/*
* Реализовать «Стек с минимумом» (Min Stack). Прокомментировать логику.
* */
import structures.MinStack;

public class MinStackDemo {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.fill();
        minStack.push(10);
        System.out.println("После добавления элемента 10:");
        minStack.print();
        minStack.pop();
        System.out.println("После удаления последнего элемента:");
        minStack.print();
    };

}
