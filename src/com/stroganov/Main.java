package com.stroganov;


/*

Задание. Ввести n чисел с консоли.

1.     Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
2.     Вывести числа в порядке возрастания (убывания) значений их длины.
3.     Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.
4.     Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.
5.     Найти количество чисел, содержащих только четные цифры, а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.
6.     Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.
7.     Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
	// write your code here

        ArrayList<Integer> array = new ArrayList<>();



        System.out.println("Введите 10 чисел");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        try {

            for (int i=0; i<10; i++){

                array.add(Integer.parseInt(reader.readLine()));
            }

        } catch (NumberFormatException f ) {
            System.err.println("Неправильный формат: " + f + "\n");
        } catch (IOException e){

            System.out.println("Ошибка чтения с консоли: " + e + "\n");
        }


        if (!array.isEmpty()) {

            NumberSort numberSort = new NumberSort(array);

            // 1
            System.out.println("Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.");
            numberSort.minmaxprint();

            // 2

            System.out.println("Вывести числа в порядке возрастания (убывания) значений их длины.");
            numberSort.sortByLength();

            // 3

            System.out.println("Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.");
            numberSort.printLessMediumLength();

            // 4

            System.out.println("Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.");
            int s = numberSort.findMinDifferentNumbers();
            System.out.println("Первое число, в котором количество различных цифр минимально: " + s);

        }


    }
}
