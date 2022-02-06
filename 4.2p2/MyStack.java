package com.company;

public class MyStack<T> {
    private class Node {
        Node next = null;
        T data;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private int size;

    boolean empty() {
        return head == null;
    }

    void push(T data) {
        if (empty()) head = new Node(data);
        else {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    T peek() {
        if (empty()) return null;
        return head.data; // NPE
    }

    T pop() { // NPE
        if (empty()) return null;
        T resultData = head.data;
        head = head.next;
        size--;
        return resultData;
    }

}
