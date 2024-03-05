package info6205.datastructures.lists;

import info6205.datastructures.Node;

public class LinkedList<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    /**
     * Constructor to create empty linked list
     * No need to initialize anything as members will be initialized to default values
     */
    public LinkedList() {

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
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
    }

    @Override
    public void addFirst(E el) {
        Node<E> newNode = new Node<>(el);
        size += 1;
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

    }

    @Override
    public boolean add(int index, E el) {
        if (index < 0 || index > size) {
            return false;
        }
        if (index == 0) {
            // Add at the start of the list
            // Gets executed in case of empty list
            this.addFirst(el);
            return true;
        }
        if (index == size) {
            // Attempting to add at the end of the Linked List
            // This part also gets executed in case the linked list is empty
            this.add(el);
            return true;
        }
        size += 1;
        Node<E> newNode = new Node<>(el);
        Node<E> current = head;
        Node<E> prev = head;
        int i = 0;
        while (current != null) {
            if (index == i) {
                break;
            }
            prev = current;
            current = current.next;
            i++;
        }
        prev.next = newNode;
        newNode.next = current;
        if (current == null) {
            tail = newNode;
        }
        return true;
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
        if (!isValidIndex(index)) return null;
        Node<E> current = head;
        int i = 0;
        while (current != null) {
            if (i == index) {
                return current.value;
            }
            i++;
            current = current.next;
        }
        return null;
    }

    @Override
    public int indexOf(E el) {
        Node<E> current = head;
        int i = 0;
        while (current != null) {
            if (current.value.equals(el)) {
                return i;
            }
            current = current.next;
            i += 1;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return (head == null);
    }

    @Override
    public int lastIndexOf(E el) {
        Node<E> current = head;
        int i = 0;
        int lastIndexFound = -1;
        while (current != null) {
            if (current.value.equals(el)) {
                lastIndexFound = i;
            }
            current = current.next;
            i += 1;
        }
        return lastIndexFound;
    }

    @Override
    public E removeFirst() {
        if (head == null) {
            // TODO: Handle error?
            return null;
        }
        Node<E> temp;
        temp = head;
        size -= 1;
        head = head.next;
        // If head becomes null means the list is empty, so tail should also become null
        if (head == null) {
            tail = null;
        }
        return temp.value;
    }

    @Override
    public E removeLast() {
        Node<E> current;
        Node<E> prev;

        if (head == null) {
            // TODO: Handle error?
            return null;
        }
        size -= 1;
        current = head;
        prev = head;

        if (head.next == null) {
            head = null;
            tail = null;
            prev = null;
            return current.value;
        }

        while (current.next != null) {
            prev = current;
            current = current.next;
        }
        tail = prev;
        tail.next = null;
        return current.value;
    }

    @Override
    public boolean remove(E el) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            if (head.value.equals(el)) {
                head = null;
                tail = null;
                size -= 1;
                return true;
            }
        }
        Node<E> current = head;
        Node<E> prev = head;

        while (current.next != null) {
            if (current.value.equals(el)) {
                prev.next = current.next;
                size -= 1;
                return true;
            }
            prev = current;
            current = current.next;
        }
        if (current.value.equals(el)) {
            prev.next = null;
            tail = prev;
            size -= 1;
            return true;
        }
        return false;

    }

    @Override
    public E remove(int index) {
        if (!isValidIndex(index)) return null;
        if (index == 0) return removeFirst();
        if (index == size - 1) return removeLast();

        int i = 0;
        Node<E> prev = head;
        Node<E> current = head;

        while (current.next != null) {
            if (i == index) {
                size -= 1;
                E temp = current.value;
                prev.next = current.next;
                return temp;
            }
            prev = current;
            current = current.next;
            i += 1;
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E set(int index, E el) {
        // Index goes from o to size - 1
        if (!isValidIndex(index)) return null;

        Node<E> current = head;
        int i = 0;
        while (current != null) {
            if (i == index) {
                E temp = current.value;
                current.value = el;
                return temp;


            }
            i++;
            current = current.next;
        }
        return null;
    }

    @Override
    public String toString() {
        if (head == null) return "[]";
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = head;
        while (current != null) {
            sb.append(current.value);
            sb.append(", ");
            current = current.next;
        }
        sb.setLength(sb.length() - 2
        );
        sb.append("]");

        return sb.toString();
    }

    private boolean isValidIndex(int index) {
        return (index >= 0 || index < size);
    }

    // Get a reversed copy
    public LinkedList<E> reverseCopy() {
        LinkedList<E> reversed = new LinkedList<>();
        if (head == null) return reversed;

        reversed.add(head.value);
        var current = head.next;
        while (current != null) {
            reversed.addFirst(current.value);
            current = current.next;
        }
        return reversed;
    }

    // Reverse this linked list
    public void reverse() {
        // List with 0 or 1 element aren't affected on reverse
        // [99, 19, 3, 7]
        if (head == null || head.next == null) return;
        var prev = head;
        var current = prev.next;
        var temp = head;
        head = tail;
        tail = temp;
        tail.next = null;

        while (current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
    }
}
