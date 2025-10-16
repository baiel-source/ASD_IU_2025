package structures;

class RedBlackTreeNode {
    int data;
    RedBlackTreeNode left, right, parent;
    Color color;

    RedBlackTreeNode(Integer data) {
        if (data != null) {
            this.data = data;
        };
        this.color = Color.RED;
        this.left = null;
        this.right = null;
        this.parent = null;
    };
};