package ru.maks.springcource;

public class MyMath {
    public static double divide(int val1, int val2) {
        if (val1 == 0)
            throw new ArithmeticException();
        return val1 / val2;
    }
}
