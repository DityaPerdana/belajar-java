package com.belajar;
import java.util.Scanner;

public class pajar {
    public static void main(String[] args) {
        int index;

        Scanner Input = new Scanner(System.in);

        System.out.println("masukkan id");
        index = Input.nextInt();

        switch(index){
            case 1:
                System.out.println("Beras");
                break;
            case 2:
                System.out.println("Minyak Goreng");
                break;
        }
    }
}
