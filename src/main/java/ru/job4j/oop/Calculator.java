package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int a) {
        return a - x;
    }

    public int divide(int b) {
        return b / x;
    }

    public int sumAllOperations(Calculator calculator, int a) {
        return calculator.divide(a) + calculator.multiply(a) + minus(a) + sum(a);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.divide(5));
        System.out.println(calculator.multiply(5));
        System.out.println(calculator.sumAllOperations(calculator, 5));
        System.out.println(Calculator.sum(5));
    }
}