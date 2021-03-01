package com.company;

public class Main {

    public static void main(String[] args) {
        Randoms r = new Randoms(10, 80);
        for (int value : r) {
            System.out.println(value);
            if (value == 78) {
                System.out.println("Enough");
                break;
            }
        }
    }
}
