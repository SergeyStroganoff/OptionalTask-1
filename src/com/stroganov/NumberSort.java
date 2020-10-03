package com.stroganov;

import java.util.ArrayList;
import java.util.Collections;

public class NumberSort {

    private ArrayList<Integer> numbers;



    public     NumberSort (ArrayList<Integer> numbers){

    this.numbers = numbers; //    как коректно проверить входящий масив на заполненость ?
    // Collections.sort(numbers); альтернативное решение
        sort();

}

    public void minmaxprint(){

        Integer min = numbers.get(0);
        Integer max = numbers.get(numbers.size()-1);

      //  int minLengs = min.toString().length(); //альтернативное решение расчета длинны числа
      //  int maxLengs = max.toString().length();

          int minLengs = numberLength(min); //альтернативное решение
          int maxLengs = numberLength(max);



        System.out.println("Минимальное число: "+ min + " его длинна: " + minLengs);
        System.out.println("Максимальное число: " + max + " его длинна: " +  maxLengs);

    }

    public void sortByLengs(){

        for (int currentNumber:numbers
             ) {
            System.out.println(currentNumber);
        }

    }

    public void sort(){                               // метод сортировки

        for (int j=0;j<numbers.size()-1;j++) {
            for (int i = 0; i < numbers.size() - 1; i++) {

                int numberOne = numbers.get(i);
                int numberTwo = numbers.get(i + 1);

                if (numberOne > numberTwo) {
                    numbers.set(i, numberTwo);
                    numbers.set(i + 1, numberOne);
                }

            }
        }

        }


        public int numberLength (int anyNumber){ // метод определения длинны числа в символах
            int result = 0;

            if (anyNumber < 0 ){anyNumber = -anyNumber;}

        if (anyNumber == 0){
            return result+1;}

        while (anyNumber>0) {
            anyNumber /= 10;
            result++;
        }

        return result;

        }


    }



