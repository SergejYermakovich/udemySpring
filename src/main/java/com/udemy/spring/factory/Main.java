package com.udemy.spring.factory;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Main {

    //    5 6 7 8 32 5 6
    public static int count(int[] array, int targetSum) {
        int quantityOfCounts = 0;
        Set<Integer> set = new HashSet<>();

        Arrays.stream(array).forEach(set::add);

        for (int j : set) {
            if (set.contains(targetSum - j)) {
                quantityOfCounts++;
            }
        }

        return quantityOfCounts / 2;
    }


    public static void main(String[] args) {
        int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        int result = count(testArray, 5);

        System.out.println(result);
    }
}
