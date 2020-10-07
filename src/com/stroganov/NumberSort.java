package com.stroganov;

import java.util.*;


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

      //  int minLength = min.toString().length(); //альтернативное решение расчета длинны числа
      //  int maxLength = max.toString().length();

          int minLength = numberLength(min); //альтернативное решение
          int maxLength = numberLength(max);



        System.out.println("Минимальное число: "+ min + " его длинна: " + minLength);
        System.out.println("Максимальное число: " + max + " его длинна: " +  maxLength);

    }

    public void sortByLength(){

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

        int allLength = 0;
        int mediumLength;

            for (int indexInt:numbers) {

                allLength +=numberLength(indexInt);
            }

            mediumLength = allLength/numbers.size();
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
    - переводим число в строку и делим по символам в отдельные строки
    - вносим символы в set
    - размер каждого set вносим в переменную, а затем в спискок - подразумевая что списки будут синхронизированы
    - ищем индекс самого короткого числа из temp
     */


    public int findMinDifferentNumbers(){


        ArrayList <Integer> tempLIst = new ArrayList<>(); // временный список

        Set<String> set = new HashSet<>();

        for (int index:numbers) {

            if (index < 10 && index > -10) {return index;} // если однозначное число, возвращаем именно его

            String s = String.valueOf(index);
            String[] arr = s.split("");

            int count;

            for(int i=0; i<s.length(); i++) {
               if (!arr[i].equals("-")) {set.add(arr[i]);}
                }

            count = set.size();
            set.clear();
           // System.out.println("В числе:"+ index +" уникальных цифр: " + count);

            tempLIst.add(count);

            }
        ArrayList<Integer> newTemp =  (ArrayList<Integer>)tempLIst.clone();
        Collections.sort(newTemp);

        int index = tempLIst.indexOf(newTemp.get(0));

        //System.out.println("Индекс наименьшего значения во временном листе: " + index);

        return numbers.get(index); // пока как то так !
        }

    }




