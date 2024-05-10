package me.shailesh.algorithms.stack;

class MinStack {
    private Node top;
    private Node minTop;

    public MinStack() {

    }

    public void push(int val) {
        Node n1 = new Node(val);
        Node n2 = new Node(val);
        if(top == null) {
            top = n1;
            minTop = n2;
            return;
        }
        n1.next = top;
        top = n1;

        n2.value = Math.min(val, minTop.value);
        n2.next = minTop;
        minTop = n2;
    }

    public void pop() {
        top = top.next;
        minTop = minTop.next;
    }

    public int top() {
        return top.value;
    }

    public int getMin() {
        return minTop.value;
    }

    static class Node{
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        var minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}

