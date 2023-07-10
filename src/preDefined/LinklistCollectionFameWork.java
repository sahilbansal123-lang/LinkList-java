package preDefined;

import java.util.*;

public class LinklistCollectionFameWork {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addLast(4);
        list.add(5);
        list.add(6);
        list.add(7);
        System.out.println(list);
        System.out.println(list.size());
        for (Integer integer : list) {
            System.out.print(integer + "->");
        }
        System.out.println("null");

        list.removeFirst();
        list.removeLast();
        System.out.println(list);
        System.out.println(list.size());
        list.remove(2);
        System.out.println(list);
        list.clear();
        System.out.println(list);
    }
}
