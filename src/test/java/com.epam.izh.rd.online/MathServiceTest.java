package com.epam.izh.rd.online;

import com.epam.izh.rd.online.service.MathService;
import com.epam.izh.rd.online.service.SimpleMathService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MathServiceTest {

    private static MathService mathService;

    @BeforeAll
    static void setup() {
        mathService = new SimpleMathService();
    }

    @ParameterizedTest
    @MethodSource("com.epam.izh.rd.online.Providers#testCompare")
    @DisplayName("Тест метода MathService.compare(int value1, int value2)")
    public int compare(int value1,int value2) {
        if (value1 != value2) {
            return value1 > value2 ? 1 : -1;
        }
        else {
            return 0;
        }
    }
    void testCompare(int value1, int value2, int expected) {
        assertEquals(expected, mathService.compare(value1, value2), "Для входных параметров: " + value1 + " " + value2);

    }
    @Test
    @DisplayName("Тест метода MathService.maxFrom(int value1, int value2)")
    public int maxFrom (int value1, int value2) {
        return value1>value2 ? value1:value2;
    }
    void testMaxFrom() {
        assertEquals(2, mathService.maxFrom(-10, 2), "Для входных параметров: " + -10 + " " + 2);
    }

    @Test
    @DisplayName("Тест метода MathService.maxFrom(int[] values)")
    public int maxFromArray (int [] values) {
        int max=0;
        for (int value : values) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
    void testMaxFromArray() {
        int[] param = {1, 3, 5, 7, 8};
        assertEquals(8, mathService.maxFrom(param), "Для входных параметров: " + Arrays.toString(param));
    }

    @ParameterizedTest
    @MethodSource("com.epam.izh.rd.online.Providers#testSumProvider")
    @DisplayName("Тест метода MathService.sum(int[] values)")
    public int sum (int[] values) {
    int sum=0;
        for (int value : values) {
            sum = sum + value;
        }
    return sum;
    }
    void testSum(int[] param, int expected) {
        assertEquals(expected, mathService.sum(param), "Для входных параметров: " + Arrays.toString(param));
    }

    @ParameterizedTest
    @MethodSource("com.epam.izh.rd.online.Providers#testGetEvenDigitsProvider")
    @DisplayName("Тест метода MathService.getEvenDigits(int[] values)")
    public int [] getEvenDigits (int[]values) {
        int n=0;
        for (int item : values)
            if (item % 2 == 0) {
                n++;
            }
    int[] arr= new int [n];
        for (int value : values) {
            int k = 0;
            if (value % 2 == 0) {
                arr[k++] = value;
            }
        }
       return arr;
    }
    void testGetEvenDigits(int[] param, int[] expected) {
        assertArrayEquals(expected, mathService.getEvenDigits(param), "Для входных параметров: " + Arrays.toString(param));
    }

    @ParameterizedTest
    @MethodSource("com.epam.izh.rd.online.Providers#testCalcFactorialProvider")
    @DisplayName("Тест метода MathService.calcFactorial(int initialVal)")
    public int calcFactorial (int initialVal) {
        int factor =1;
        for (int i=1; i<=initialVal; i++) {
            factor =factor*i;
        }
        return factor;
    }
    void testCalcFactorial(int param, int expected) {
        assertEquals(expected, mathService.calcFactorial(param), "Для входого параметра: " + param);
    }

    @ParameterizedTest
    @MethodSource("com.epam.izh.rd.online.Providers#testCalcFibonacciProvider")
    @DisplayName("Тест метода MathService.calcFibonacci(int number)")
    public int CalcFibonacci (int param){
        int [] fib = new int[param+1];
        if (param==0) {
            fib [0]=0;
        }
        else {
            fib [0]=0;
            fib [1]=1;
            for (int i=2; i<=param; i++) {
                fib[i]=fib[i-1]+fib[i-2];
            }
        }
        return fib[param];
    }
    void testCalcFibonacci(int param, int expected) {
        assertEquals(expected, mathService.calcFibonacci(param), "Для входого параметра: " + param);
    }

    @ParameterizedTest
    @MethodSource("com.epam.izh.rd.online.Providers#testSortProvider")
    @DisplayName("Тест метода MathService.sort(int[] arr)")
    public  int[] sort (int[]arr) {
        for (int i=arr.length-1; i>0; i--) {
            for (int j=0; j<i; j++) {
                if (arr [j]>arr[j+1]) {
                    int max=arr [j];
                    arr [j]=arr[j+1];
                    arr [j+1]=max;
                }
            }
        }
        return arr;
    }
    void testSort(int[] param, int[] expected) {
        assertArrayEquals(expected, mathService.sort(param), "Для входных параметров: " + Arrays.toString(param));
    }

    @ParameterizedTest
    @MethodSource("com.epam.izh.rd.online.Providers#testIsPrimaryProvider")
    @DisplayName("Тест метода MathService.isPrimary(int number)")
    public boolean isPrimary (int number) {
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
    void testIsPrimary(int param, boolean expected) {
        assertEquals(expected, mathService.isPrimary(param), "Для входого параметра: " + param);
    }

    @ParameterizedTest
    @MethodSource("com.epam.izh.rd.online.Providers#testReverseArrayProvider")
    @DisplayName("Тест метода MathService.reverseArray(int[] arr)")
    public int[] reverseArray (int [] arr) {
        int n = arr.length;
        int[] rearr = new int[n];
        for (int i=0; i<n; i++) {
            rearr [i]= arr [n-1];
            n--;
        }
        return rearr;
    }
    void testIsPrimary(int[] param, int[] expected) {
        assertArrayEquals(expected, mathService.reverseArray(param), "Для входных параметров: " + Arrays.toString(param));
    }
}
