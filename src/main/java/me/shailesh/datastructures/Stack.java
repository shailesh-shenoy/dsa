package me.shailesh.datastructures;

public class Stack<T> {
    private Node<T> top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T item) {
        if(isEmpty()) {
            top = new Node<T>(item);
            return;
        }
        var n = new Node<T>(item);
        n.next = top;
        top = n;
    }

    public T top() {
        if(isEmpty()) {
            return null;
        }
        return top.value;
    }

    public T pop() {
        if(isEmpty()) {
            return null;
        }
        T item = top.value;
        top = top.next;
        return item;
    }

    static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        var stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
