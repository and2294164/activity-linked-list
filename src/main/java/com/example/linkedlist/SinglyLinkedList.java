package com.example.linkedlist;

import java.util.StringJoiner;

public class SinglyLinkedList<E> implements LinkedList<E> {

    private Node head;
    private Node tail;
    private int size = 0;

    public SinglyLinkedList() {
        head = null;
        tail = null;
    }


    @Override
    public void addFirst(E element) {

        size++;
        Node node = new Node(element, head);        // create a new node, tell it that head follows it

        if (head == null) {
            head = node;                            // make the node the new head
            tail = head;
        } else {
            head = node;                            // make the node the new head
        }
    }

    @Override
    public void addLast(E element) {

        size++;
        Node node = new Node(element, null);        // create node, tell it nothing follows it
        tail.next = node;                           // thing that follows the tail is the new node
        tail = node;                                // makes the new node the tail
    }

    @Override
    public E pollFirst() {

        size--;
        E element;
        if(head == null) {                          // if list is empty return null
            element = null;
        } else {
            element = head.element;

            if (head == tail) {                     // if we only have one element
                head = null;
                tail = null;
            } else {
                Node next = head.next;              // create new node, it equals the 2nd node
                head.next = null;                   // empty the head node
                head = next;                        // set the move the head to the 2nd node
            }
        }
        return element;
    }

    @Override
    public E pollLast() {

        size--;
        E element;
        if (tail == null) {
            element = null;
        } else {

            element = tail.element;
            if (head == tail) {
                head = null;
                tail = null;
            } else {

                Node current = head;
                Node previous = head;

                while (current.next != null) {   // while we're not at the end of the list
                    previous = current;          // step previous forward
                    current = current.next;      // step current forward
                }
                tail = previous;                 // move the tail reference backwards
                tail.next = null;                // tail is the final reference
            }
        }



        return element;
    }

    @Override
    public E peekFirst() {
        return head.element;
    }

    @Override
    public E peekLast() {
        return tail.element;
    }

    @Override
    public void clear() {

        size = 0;
        Node current = head;

        while (current.next != null) {          // while we're not on the tail
            Node next = current.next;           // make a node equal to the next node
            current.next = null;                // sever current's reference to the next node
            current = next;                     // set current to the created node
        }

        head = null;
        tail = null;
    }

    @Override
    public boolean contains(Object element) {

        boolean contains = false;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            if (current.element == element) {
                contains = true;
                break;
            }
            current = next;
        }



        return contains;
    }

    @Override
    public int size() {
        /*int counter = 0;
        if (head != null) {
            if (head == tail) {
                counter = 1;
            } else {
                Node current = head;
                while (current != null) {
                    counter++;
                    current = current.next;
                }
            }
        }*/
        return size;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder("[");         // creates string / holds the string
        StringJoiner joiner = new StringJoiner(", ");           // joins elements together

        Node current = head;
        if (current != null) {
            while (current != null) {                           // while we still have stuff
                joiner.add(current.element.toString());         // adds what the current element contains TO THE JOINER
                current = current.next;                         // moves onto the next element
            }
        }
        builder.append(joiner);                                 // combine BUILDER and JOINER
        builder.append("]");
        return builder.toString();

    }


    private class Node {

        E element;
        Node next;

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }

    }
}
