package com.example.linkedlist;


import java.util.ArrayList;

public class SingleDriver {

    public static void main(String[] args) {

        LinkedList<String> list = new SinglyLinkedList<>();

        System.out.println(list.size());
        list.addFirst("1st");
        list.addFirst("2nd");
        list.addFirst("3rd");
        list.addFirst("4th");
        list.addFirst("5th");

        list.addLast("6th");
        list.addLast("7th");
        list.addLast("8th");


        System.out.println(list);
        System.out.println(list.size());

        System.out.println(list.peekFirst());
        System.out.println(list.peekLast());

        System.out.println(list.pollFirst());
        System.out.println(list);

        System.out.println(list.pollLast());
        System.out.println(list);

        System.out.println(list.size());

        System.out.println(list.contains("5th"));
        System.out.println(list.contains("1st"));
        System.out.println(list.contains("7th"));
        System.out.println(list.contains("4th"));

        list.clear();
        System.out.println(list);
    }
}
