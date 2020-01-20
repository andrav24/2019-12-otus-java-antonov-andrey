package tech.andrav.hw02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DIYArrayList<Integer> list1 = new DIYArrayList<>();

        System.out.println("****** Test Collections.addAll() ********");
        Collections.addAll(list1, 1, 2, 3, 4, 5);
        for (Integer i : list1) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println();
        System.out.println("****** Test Collections.copy() ********");
        list1.clear();
        int NUMBER_OF_ELEMENTS = 21;
        for (int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
            list1.add(NUMBER_OF_ELEMENTS - i - 1);
        }
        System.out.println("list1 capacity: " + list1.getCapacity());
        System.out.println("list1 size: " + list1.size());
        System.out.println("list1 elements: ");
        for (Integer i : list1) {
            System.out.print(i + " ");
        }
        System.out.println();
        List<Integer> list2 = new DIYArrayList<>();
        for (int i = 0; i < list1.size() ; i++) {
            list2.add(0);
        }

        Collections.copy(list2, list1);
        System.out.println("list1 size: " + list2.size());
        System.out.println("list2 elements: ");
        for (Integer i : list2) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println();
        System.out.println("****** Test Collections.sort() ********");


        List<Integer> list3 = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
            list3.add(NUMBER_OF_ELEMENTS - i - 1);
        }
        System.out.println("Before:");
        for (Integer i : list3) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("After:");
        Collections.sort(list3, (s1, s2) -> s1 - s2);
        for (Integer i : list3) {
            System.out.print(i + " ");
        }
    }
}
