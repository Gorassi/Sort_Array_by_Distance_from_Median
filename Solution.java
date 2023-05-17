package com.javarush.task.task26.task2601;

import java.util.*;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {
        Integer[] myArray = {91, 16, 5, 11, 33, 20, 10, 17, 14, 15, 16};

        Integer[] result = Solution.sort(myArray);
//        Arrays.stream(result).forEach(x -> System.out.print(x + " "));
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        int len = array.length;
        float med = -1.0f;
        if(len%2 == 1) {
            med = array[len/2];
        } else {
            med = (array[len/2 -1] + array[len/2])/2.0f;
        }

        List<Integer> collection = Arrays.asList(array);
        final float medianum = med;

        Comparator<Integer> simpleComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };

        Comparator<Integer> comparatorMedianum = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                float difference1 = Math.abs((float) o1 - medianum);
                float difference2 = Math.abs((float) o2 - medianum);
                if ((difference1 - difference2) < 0) return -1;
                if ((difference1 - difference2) > 0) return 1;
                return  0;
            }
        };

        Collections.sort(collection, comparatorMedianum.thenComparing(simpleComparator));

        return collection.toArray(new Integer[collection.size()]);
    }
}
