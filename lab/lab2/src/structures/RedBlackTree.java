package structures;

enum Color {
    RED, BLACK;
};

public class RedBlackTree {
    private RedBlackTreeNode root;
    private final RedBlackTreeNode TNULL;

    public RedBlackTree() {
        TNULL = new RedBlackTreeNode(null);
        TNULL.color = Color.BLACK;
        root = TNULL;
    };

    /*
    * Левый поворот относительно заданного узла.
    * Смещает правого потомка вверх, делая его новым родителем.
    * */
    private void rotateLeft(RedBlackTreeNode node) {
        RedBlackTreeNode rightNode = node.right;
        node.right = rightNode.left;
        if (rightNode.left != TNULL) {
            rightNode.left.parent = node;
        };
        rightNode.parent = node.parent;
        if (node.parent == null) {
            this.root = rightNode;
        } else if (node == node.parent.left) {
            node.parent.left = rightNode;
        } else {
            node.parent.right = rightNode;
        };
        rightNode.left = node;
        node.parent = rightNode;
    };

    /*
    * Правый поворот относительно заданного узла.
    * Смещает левого потомка вверх, делая его новым родителем
    * */
    private void rotateRight(RedBlackTreeNode node) {
        RedBlackTreeNode leftNode = node.left;
        node.left = leftNode.right;
        if (leftNode.right != TNULL) {
            leftNode.right.parent = node;
        };
        leftNode.parent = node.parent;
        if (node.parent == null) {
            this.root = leftNode;
        } else if (node == node.parent.right) {
            node.parent.right = leftNode;
        } else {
            node.parent.left = leftNode;
        };
        leftNode.right = node;
        node.parent = leftNode;
    };

    /*
    * Вставка в дерево.
    * Вставка происходит как в обычном двоичном дереве поиска, после вставки вызывается fixInsert для восстановления
    * свойств красно-чёрного дерева (оба потомка каждого красного узла должны быть чёрными)
    * */
    public void insert(int data) {
        RedBlackTreeNode newNode = new RedBlackTreeNode(data);
        newNode.left = newNode.right = TNULL;
        RedBlackTreeNode parent = null;
        RedBlackTreeNode current = this.root;
        while (current != TNULL) {
            parent = current;
            if (newNode.data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            };
        };
        newNode.parent = parent;
        if (parent == null) {
            this.root = newNode;
        } else if (newNode.data < parent.data) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        };
        fixInsert(newNode);
    };

    private void fixInsert(RedBlackTreeNode node) {
        while (node.parent != null && node.parent.color == Color.RED) {
            if (node.parent == node.parent.parent.left) {
                RedBlackTreeNode secondNode = node.parent.parent.right;
                if (secondNode.color == Color.RED) {
                    node.parent.color = Color.BLACK;
                    secondNode.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.right) {
                        node = node.parent;
                        rotateLeft(node);
                    };
                    node.parent.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    rotateRight(node.parent.parent);
                };
            } else {
                RedBlackTreeNode secondNode = node.parent.parent.left;
                if (secondNode.color == Color.RED) {
                    node.parent.color = Color.BLACK;
                    secondNode.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.left) {
                        node = node.parent;
                        rotateRight(node);
                    };
                    node.parent.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    rotateLeft(node.parent.parent);
                };
            };
        };
        this.root.color = Color.BLACK;
    };

    private RedBlackTreeNode search(RedBlackTreeNode node, int key) {
        if (node == TNULL || key == node.data) {
            return node;
        };
        if (key < node.data) {
            return search(node.left, key);
        };
        return search(node.right, key);
    };

    private RedBlackTreeNode minimum(RedBlackTreeNode node) {
        while (node.left != TNULL) {
            node = node.left;
        };
        return node;
    };

    private void transplant(RedBlackTreeNode firstNode, RedBlackTreeNode secondNode) {
        if (firstNode.parent == null) {
            this.root = secondNode;
        } else if (firstNode == firstNode.parent.left) {
            firstNode.parent.left = secondNode;
        } else {
            firstNode.parent.right = secondNode;
        };
        secondNode.parent = firstNode.parent;
    };

    /*
    * Удаление узла с заданным значением из дерева.
    * Удаление происходит так же, как и в обычном двоичном дереве поиска,
    * после удаления вызывается fixDelete для восстановления свойств
    * красно-чёрного дерева
    * */
    public void delete(int data) {
        RedBlackTreeNode node = search(this.root, data);
        if (node == TNULL) {
            throw new Error("Value not found in the tree");
        };
        RedBlackTreeNode x;
        RedBlackTreeNode y = node;
        Color yOriginalColor = y.color;
        if (node.left == TNULL) {
            x = node.right;
            transplant(node, node.right);
        } else if (node.right == TNULL) {
            x = node.left;
            transplant(node, node.left);
        } else {
            y = minimum(node.right);
            yOriginalColor = y.color;
            x = y.right;
            if (y.parent == node) {
                x.parent = y;
            } else {
                transplant(y, y.right);
                y.right = node.right;
                y.right.parent = y;
            };
            transplant(node, y);
            y.left = node.left;
            y.left.parent = y;
            y.color = node.color;
        };
        if (yOriginalColor == Color.BLACK) {
            fixDelete(x);
        };
    };

    private void fixDelete(RedBlackTreeNode node) {
        while (node != this.root && node.color == Color.BLACK) {
            if (node == node.parent.left) {
                RedBlackTreeNode w = node.parent.right;
                if (w.color == Color.RED) {
                    w.color = Color.BLACK;
                    node.parent.color = Color.RED;
                    rotateLeft(node.parent);
                };
                if (w.left.color == Color.BLACK && w.right.color == Color.BLACK) {
                    w.color = Color.RED;
                    node = node.parent;
                } else {
                    if (w.right.color == Color.BLACK) {
                        w.left.color = Color.BLACK;
                        w.color = Color.RED;
                        rotateRight(w);
                        w = node.parent.right;
                    };
                    w.color = node.parent.color;
                    node.parent.color = Color.BLACK;
                    w.right.color = Color.BLACK;
                    rotateLeft(node.parent);
                    node = this.root;
                };
            } else {
                RedBlackTreeNode w = node.parent.left;
                if (w.color == Color.RED) {
                    w.color = Color.BLACK;
                    node.parent.color = Color.RED;
                    rotateRight(node.parent);
                    w = node.parent.left;
                };
                if (w.right.color == Color.BLACK && w.left.color == Color.BLACK) {
                    w.color = Color.RED;
                    node = node.parent;
                } else {
                    if (w.left.color == Color.BLACK) {
                        w.right.color = Color.BLACK;
                        w.color = Color.RED;
                        rotateLeft(w);
                        w = node.parent.left;
                    };
                    w.color = node.parent.color;
                    node.parent.color = Color.BLACK;
                    w.left.color = Color.BLACK;
                    rotateRight(node.parent);
                    node = this.root;
                };
            };
        };
        node.color = Color.BLACK;
    };

    public void inorder() {
        inorderImpl(this.root);
        System.out.println();
    };

    private void inorderImpl(RedBlackTreeNode node) {
        if (node != TNULL) {
            inorderImpl(node.left);
            System.out.printf("%d (%s) ", node.data, node.color);
            inorderImpl(node.right);
        };
    };

    public void preorder() {
        preorderImpl(this.root);
        System.out.println();
    };

    private void preorderImpl(RedBlackTreeNode node) {
        if (node != TNULL) {
            System.out.printf("%d (%s) ", node.data, node.color);
            preorderImpl(node.left);
            preorderImpl(node.right);
        };
    };

    public void postorder() {
        postorderImpl(this.root);
        System.out.println();
    };

    private void postorderImpl(RedBlackTreeNode node) {
        if (node != TNULL) {
            postorderImpl(node.left);
            postorderImpl(node.right);
            System.out.printf("%d (%s) ", node.data, node.color);
        };
    };
};
