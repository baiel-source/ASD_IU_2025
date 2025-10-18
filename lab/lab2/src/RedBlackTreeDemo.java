/*
* Реализовать красно-черное дерево. Прокомментировать логику.
* */
import structures.RedBlackTree;

public class RedBlackTreeDemo {

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);

        tree.insert(2);
        tree.insert(4);
        tree.insert(20);
        tree.insert(16);

        tree.preorder();

        tree.delete(2);

        tree.preorder();
    };

};
