package structures;

class MinStackNode {
    int value;
    int min;
    MinStackNode next;

    MinStackNode(int value, int min, MinStackNode next) {
        this.value = value;
        this.min = min;
        this.next = next;
    };

    MinStackNode(int value, int min) {
        this.value = value;
        this.min = min;
        this.next = null;
    };
};
