package com.epam.izh.rd.online.service;

public class SimpleMathService implements MathService {

    /**
     * Метод возвращает 0, если value1 = value2.
     * Метод возвращает -1, если value1 < value2.
     * Метод возвращает 1, если value1 > value2.
     *
     * Например для (-1, -1) метод должен вернуть 0;
     * Например для (-3, -1) метод должен вернуть -1;
     * Например для (3, 1) метод должен вернуть 1;
     */
    @Override
    public int compare(int value1, int value2) {
        if (value1 != value2) {
            return value1 > value2 ? 1 : -1;
        }
        else {
            return 0;
        }
    }

    /**
     * Метод возвращает максимальное число из пары.
     * Например для списка (-1, 2) метод должен вернуть 2
     */
    @Override
    public int maxFrom(int value1, int value2) {
        return value1>value2 ? value1:value2;
    }

    /**
     * Метод возвращает максимальное число из переданного массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 22
     */
    @Override
    public int maxFrom(int[] values) {
        int max=0;
        for (int value : values) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    /**
     * Метод возвращает сумму чисел массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 30
     */
    @Override
    public int sum(int[] values) {
        int sum=0;
        for (int value : values) {
            sum = sum + value;
        }
        return sum;
    }

    /**
     * Метод фильтрует массив, оставляя только четные числа.
     * Например для списка {-1, -3, 4, 8, 5, 22, 17} метод должен вернуть {4, 8, 22}
     */
    @Override
    public int[] getEvenDigits(int[] values) {
        int n=0;
        for (int item : values)
            if (item % 2 == 0) {
                n++;
            }
        int[] arr= new int [n];
            int k = 0;
        for (int value : values) {
            if (value % 2 == 0) {
                arr[k] = value;
                k++;
            }
        }
        return arr;
    }

    /**
     * Метод считает факториал из заданного числа.
     * Например для числа 5 метод должен вернуть 120.
     * Факториал 0 должен быть равен 1.
     */
    @Override
    public long calcFactorial(int initialVal) {
        int factor =1;
        for (int i=1; i<=initialVal; i++) {
            factor =factor*i;
        }
        return factor;
    }

    /**
     * Метод возвращает число, которе находится на заданной позиции (счет начинается с нуля) в ряду фибоначчи.
     *
     * Ряд фибоначчи - ряд, следующие элементы которого состоят из суммы двух предыдущих.
     * Ряд начинается 0 и 1.
     * Пример 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ...
     *
     * Для числа 9 метод должен вернуть 34
     * Для числа 0 метод должен вернуть 0
     */
    @Override
    public long calcFibonacci(int number) {
        int [] fib = new int[number+1];
        if (number==0) {
            fib [0]=0;
        }
        else {
            fib [0]=0;
            fib [1]=1;
            for (int i=2; i<=number; i++) {
                fib[i]=fib[i-1]+fib[i-2];
            }
        }
        return fib[number];
    }

    /**
     * Метод возвращает отсортированный по возрастанию массив.
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть {-5, -3, -1, 4, 5, 8, 22}
     */
    @Override
    public int[] sort(int[] values) {
        for (int i=values.length-1; i>0; i--) {
            for (int j=0; j<i; j++) {
                if (values [j]>values[j+1]) {
                    int max=values [j];
                    values [j]=values[j+1];
                    values [j+1]=max;
                }
            }
        }
        return values;
    }

    /**
     * Метод определяет, является ли заданное число простым.
     * Простое число - число, которое делится только на 1 и на само себя.
     *
     * Например для числа 22 вернется false, а для числа 23 true.
     */
    @Override
    public boolean isPrimary(int number) {
        int sum=0;
        boolean primary;
        for (int i=1; i<=number; i++) {
            if (number%i==0) {
                sum++;
            }
        }
        primary= sum <= 2;
        return primary;
    }

    /**
     * Метод возвращает массив, в котором элементы расположены в обратном порядке.
     *
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод вернет {-5, 22, 5, 8, 4, -3, -1}
     */
    @Override
    public int[] reverseArray(int[] values) {
        int n = values.length;
        int[] rearr = new int[n];
        for (int i=0; i<values.length; i++) {
            rearr [i]= values [n-1];
            n--;
        }
        return rearr;
    }
}
