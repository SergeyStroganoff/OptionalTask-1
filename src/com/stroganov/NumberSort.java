package com.stroganov;

import java.util.*;
import java.lang.Comparable.*;
import java.util.Comparator.*;

public class NumberSort {

    private ArrayList<Integer> numbers;


    public     NumberSort (ArrayList<Integer> numbers){

    this.numbers = numbers; //    как коректно проверить входящий масив на заполненость ?


        long start, end;
        start = System.nanoTime(); // замеряем время сортировки

       // Collections.sort(numbers); //альтернативное решение - вопрос почему в три раза дольше ?
        sort2();

        end = System.nanoTime(); // замеряем время сортировки
        System.out.println(end-start); // выводим время

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


    private void swapArray(ArrayList<Integer> arrayForSwap, int ind1, int ind2) {  // замена двух значений
        int tmp = arrayForSwap.get(ind1);
        arrayForSwap.set(ind1,arrayForSwap.get(ind2)) ;
        arrayForSwap.set(ind2,tmp);

    }



    private void sort2() {                                 // альтернативная сортировка пузырьком быстреее !!!

        for (int bigLength = numbers.size() - 1; bigLength >= 0; bigLength--) {
            for (int i = 0; i < bigLength; i++) {
                if (numbers.get(i)  > numbers.get(i+1))
                    swapArray(numbers, i, i + 1);
            }


        }
    }




        private int numberLength (int anyNumber){ // метод определения длинны числа в символах
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


        private ArrayList<Integer> lessMediumLength(){

        ArrayList<Integer> smallaray = new ArrayList<>();

        int allLengs = 0;
        int mediumLength;

            for (int indexInt:numbers) {

                allLengs +=numberLength(indexInt);
            }

            mediumLength = allLengs/numbers.size();
           // System.out.println(mediumLength);

            for (int indexInt:numbers) {

               if (numberLength(indexInt)<mediumLength) {

                  smallaray.add(indexInt);
               }



            }
            return smallaray;
        }


        public void printLessMediumLength(){

        ArrayList<Integer> array = lessMediumLength();

            for (int index:array) {

                System.out.println("Число:" + index+ " меньше средней длинны введенных чисел" + " его длинна:" + numberLength(index));

            }

        }


   // Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.

    /*
    - перебираем список
    -
     */


    public int findMinDifferrentNumbers(){


        HashMap <Integer,Integer> hashMap = new HashMap<>(); // временный список

        Set<String> set = new HashSet<>();

        for (int index:numbers) {

            if (index < 10 && index > -10) {return index;} // если однозначное число, возвращаем именно его

            String s = String.valueOf(index);
            String[] arr = s.split("");
            int m = 0;

            int count;

            for(int i=0; i<s.length(); i++) {
               if (!arr[i].equals("-")) {set.add(arr[i]);}
                }

            count = set.size();
            set.clear();
            System.out.println("В числе:"+ index +" уникальных цифр" + count);

            hashMap.put(index,count);

            }


        List list = new ArrayList(hashMap.entrySet());
        Collections.sort(list, new Comparator() {

            @Override
            public int compare(Map.Entry e1, Map.Entry e2) {

                return e1.getValue().compareTo(e2.getValue());
            }



        });


        return 0; // пока так !
        }



    }




