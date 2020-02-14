package ru.maks.springcource;

public class MyLinkedList {

    private int size;
    private Node head;

    public void add(int value) {
        size++;
        if (head == null) {
            head = new Node(value);
            return;
        }

        Node tmp = head;
        while(tmp.getNext() != null) {
            tmp = tmp.getNext();
        }

        tmp.setNext(new Node(value));
    }

    public void showMyLinkedList() {
        String val = "";
        Node tmp = head;
        while(tmp != null) {
            System.out.println(tmp.getValue());
            tmp = tmp.getNext();
        }
    }

    public int get(int index) {
        int currentIndex = 0;

        if (index > (size - 1)
            || index < 0)
            throw new IllegalArgumentException();

        Node tmp = head;
        while (currentIndex != index) {
            tmp = tmp.getNext();
            currentIndex++;
        }

        return tmp.getValue();
    }

    public void remove(int index) {
        int currentIndex = 0;
        Node tmp = head;

        if (index < 0 || size < index)
            throw new IllegalArgumentException();

        if (index == 0) {
            head = tmp.getNext();
            return;
        }

        while (currentIndex != (index - 1)) {
            currentIndex++;
            tmp = tmp.getNext();
        }

        tmp.setNext(tmp.getNext().getNext());
    }

    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
