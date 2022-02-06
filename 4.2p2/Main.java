package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
//        System.out.println("Work with ArrayList");
//        workWithList(arrayList);
//        System.out.println("----------------------");
//        System.out.println("Work with LinkedList");
//        workWithList(linkedList);
//        System.out.println("----------------------");
//        workWithQueue(linkedList);
        workWithStack(new MyStack<>());
    }

    public static void workWithStack(MyStack<String> stack) {
        stack.push("first");
        stack.push("second");
        stack.push("third");
        stack.push("fourth");
        stack.push("0"); // LIFO
        while (!stack.empty())
            System.out.println(stack.pop());

    }

    public static void workWithQueue(Deque<String> deque) {
        deque.offer("Man0");
        deque.offer("Man1");
        deque.offer("Man2");
        deque.offer("Man3");
        deque.offer("Man4");
        deque.offerFirst("Man-1");
        while (!deque.isEmpty()) {
            System.out.println(deque.pollLast()); // poll = peek + remove
        }
    }


    public static void workWithList(List<String> someList) {
        someList.add("1");
        someList.add("2");
        someList.add("3");
        someList.add(0, "0"); // 0 1 2 3 0
        someList.add("0");
        someList.remove("2"); // 0 1 3 0
//        System.out.println(someList.indexOf("0"));
//        System.out.println(someList.lastIndexOf("0"));
        System.out.println("Итерация по листу в прямом порядке");
        ListIterator<String> listIterator = someList.listIterator();
        while (listIterator.hasNext()) {
            System.out.println("Следующий индекс: " + listIterator.nextIndex() +
                    " Следующий элемент:  " + listIterator.next());
        }
        System.out.println("-----");

        System.out.println("Итерация по листу в обратном порядке");
        listIterator = someList.listIterator(someList.size());
        while (listIterator.hasPrevious()) {
            System.out.println("Предыдущий индекс: " + listIterator.previousIndex() +
                    " Предыдущий элемент:  " + listIterator.previous());
        }


    }
}
