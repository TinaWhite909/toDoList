package com.devcolibri.logpack;

public class Main {
    private static OrderLogic logic;

    public static void main(String[] args) {
        logic = new OrderLogic();
        logic.doOrder();
    }
}
