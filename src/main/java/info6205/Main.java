package info6205;

import info6205.datastructures.lists.LinkedList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello world!");

        LinkedList<Integer> ll = new LinkedList<Integer>();
        System.out.println(ll.size());
        System.out.println(ll);
        ll.add(3);
        System.out.println(ll.size());
        System.out.println(ll);
        ll.add(7);
        System.out.println(ll.size());
        System.out.println(ll);
        ll.addFirst(27);
        System.out.println(ll.size());
        System.out.println(ll);
        ll.add(17);
        System.out.println(ll.size());
        System.out.println(ll);
        ll.add(1);

        System.out.println("GET: " + ll.get(-1));
        System.out.println("GET: " + ll.get(0));
        System.out.println("GET: " + ll.get(2));
        System.out.println("GET: " + ll.get(8));

        System.out.println(ll.size());
        System.out.println(ll);

        System.out.println("-" + ll.removeLast());
        System.out.println(ll.size());
        System.out.println(ll);

        System.out.println("-f" + ll.removeFirst());
        System.out.println(ll.size());
        System.out.println(ll);
        System.out.println("-" + ll.removeLast());
        System.out.println(ll.size());
        ll.addFirst(19);
        ll.addFirst(99);
        System.out.println("GET: " + ll.get(0));
        System.out.println("GET: " + ll.get(3));
        System.out.println(ll);

        System.out.println("Reverse Copy: " + ll.reverseCopy());
        ll.reverse();
        System.out.println("Reversed ll: " + ll);

        System.out.println("ReReverse Copy: " + ll.reverseCopy());
        ll.reverse();
        System.out.println("ReReversed ll: " + ll);

//        System.out.println("-" + ll.removeLast());
//        System.out.println(ll.size());
//        System.out.println(ll);
//        System.out.println("-f" + ll.removeFirst());
//        System.out.println(ll.size());
//        System.out.println(ll);
//        ll.addFirst(32);
//        System.out.println(ll.size());
//        System.out.println(ll);
//        System.out.println("-" + ll.removeLast());
//        System.out.println(ll);
//        System.out.println(ll.size());
//        System.out.println("-f" + ll.removeFirst());
//        System.out.println(ll);
//        System.out.println(ll.size());
//        System.out.println("-" + ll.removeLast());
//        System.out.println(ll);
//        System.out.println(ll.size());
    }
}