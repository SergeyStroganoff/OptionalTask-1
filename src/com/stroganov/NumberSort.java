package com.stroganov;

import java.util.ArrayList;
import java.util.Collections;

public class NumberSort {

    private ArrayList<Integer> numbers;



    public     NumberSort (ArrayList<Integer> numbers){



        this.numbers = numbers; // как коректно проверить входящий масив на заполненость ?

    }

    public void minmaxprint(){

        Collections.sort(numbers);

        Integer min = numbers.get(0);
        Integer max = numbers.get(numbers.size()-1);

        int minLengs = min.toString().length();
        int maxLengs = max.toString().length();

        System.out.println("Минимальное число: "+ min + " его длинна: " + minLengs);
        System.out.println("Максимальное число: " + max + " его длинна: " +  maxLengs);

    }


}
