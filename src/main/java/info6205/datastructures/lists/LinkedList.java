package info6205.datastructures.lists;

import info6205.datastructures.Node;

public class LinkedList<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    /**
     * Constructor to create empty linked list
     */
    public LinkedList() {
        this.size = 0;
    }

    /**
     * Constructor to create linked list with one element
     */
    public LinkedList(E el) {
        this.size = 1;
        Node<E> newNode = new Node<E>(el);
        head = newNode;
        tail = newNode;
    }

    /**
     * Add element to end of the list
     */
    @Override
    public void add(E el) {
        Node<E> newNode = new Node<E>(el);
        size += 1;
        if(head == null || tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
        }
    }

    @Override
    public void add(int index, E el) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if(index == size) {
            // Attempting to add at the end of the Linked List
            this.add(el);
            return;
        }
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(E el) {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int indexOf(E el) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int lastIndexOf(E el) {
        return 0;
    }

    @Override
    public boolean remove(E el) {
        return false;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E set(int index, E el) {
        return null;
    }
}
