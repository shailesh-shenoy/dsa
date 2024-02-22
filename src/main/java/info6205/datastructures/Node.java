package info6205.datastructures;

public class Node<E> {
    public E value;
    public Node<E> next;

    public Node() {

    }
    public Node(E value) {
        this.value = value;
    }
}
