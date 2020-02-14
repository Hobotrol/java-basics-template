package com.epam.izh.rd.online;

public class JavaBasics {
    public static void main(String[] args) {
        int number=26;
        int sum=0;
        boolean primary;
        for (int i=1; i<=number; i++) {
            if (number%i==0) {
                sum++;
            }
        }
        primary= sum <= 2;
       System.out.println(primary);
    }
}
