package com.belajar;

//menggunakan operator pembanding
public class Latihan3 {
    public static void main(String[] args) {
        int A = 70;
        int B = 80;
        int C = 90;
        boolean a = A > B && B < C || C < B;
        boolean b = A < B || B < C && C < B;

        System.out.println(a);
        System.out.println(b);
    }
}
