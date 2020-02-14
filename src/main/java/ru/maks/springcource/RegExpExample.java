package ru.maks.springcource;

public class RegExpExample {
    public void doWork() {
        String str1 = "-123";
        System.out.println(str1.matches("(a|c|-)?\\d*"));
        String str2 = "g123";
        System.out.println(str2.matches("[a-z]+\\d+"));
    }
}
