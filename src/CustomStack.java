public class CustomStack {

    private int[] values;
    private int size;

    public int getSize() {
        return size;
    }

    public CustomStack(int maxSize) {
        values = new int[maxSize];
    }

    public void push(int x) {
        if (size < values.length) {
            values[size++] = x;
        }
    }

    public int pop() {

        if (size > 0) {
            return values[--size];

        }
        return -1;
    }

    public void increment(int k, int val) {
        for (int i = 0; i < (k > size ? size : k); i++) {
            values[i] += val;
        }
    }

    private static void printStack(CustomStack customStack) {
        if (customStack.size > 0) {
            for (int i = 0; i < customStack.size; i++) {
                System.out.print("[" + customStack.values[i] + "] ");
            }
        } else {
            System.out.print("[ ]");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3); // Stack is Empty []
        printStack(customStack);
        customStack.push(1);                          // stack becomes [1]
        printStack(customStack);
        customStack.push(2);                          // stack becomes [1, 2]
        printStack(customStack);
        customStack.pop();                            // return 2 --> Return top of the stack 2, stack becomes [1]
        printStack(customStack);
        customStack.push(2);                          // stack becomes [1, 2]
        printStack(customStack);
        customStack.push(3);                          // stack becomes [1, 2, 3]
        printStack(customStack);
        customStack.push(4);                          // stack still [1, 2, 3], Don't add another elements as size is 4
        printStack(customStack);
        customStack.increment(5, 100);                // stack becomes [101, 102, 103]
        printStack(customStack);
        customStack.increment(2, 100);                // stack becomes [201, 202, 103]
        printStack(customStack);
        customStack.pop();                            // return 103 --> Return top of the stack 103, stack becomes [201, 202]
        printStack(customStack);
        customStack.pop();                            // return 202 --> Return top of the stack 102, stack becomes [201]
        printStack(customStack);
        customStack.pop();                            // return 201 --> Return top of the stack 101, stack becomes []
        printStack(customStack);
        customStack.pop();                            // return -1 --> Stack is empty return -1.
    }
}
