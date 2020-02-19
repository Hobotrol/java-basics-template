package com.epam.izh.rd.online;

public class JavaBasics {
    public static void main(String[] args) {
        int [] values= {4,4,5,5,2,6};
        int n = values.length;
        int[] rearr = new int[n];
        for (int i=0; i<values.length; i++) {
            rearr [i]= values [n-1];
            System.out.println(rearr[i]);
            n--;
        }
    }
}
