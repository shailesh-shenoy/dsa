package info6205.datastructures.lists;

public interface List<E> {

    void add(E el);

    void addFirst(E el);

    boolean add(int index, E el);

    void clear();

    boolean contains(E el);

    E get(int index);

    int indexOf(E el);

    boolean isEmpty();

    int lastIndexOf(E el);

    E removeFirst();

    E removeLast();

    boolean remove(E el);

    E remove(int index);

    int size();

    E set(int index, E el);

}

