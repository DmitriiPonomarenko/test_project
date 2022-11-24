package main.java;

import main.java.animals.Kotik;

public class Main {
    public static void main(String[] args) {
        Kotik vasya = new Kotik();
        Kotik pushok = new Kotik("Пушок", "Нежный", 1, 2.52f);


        boolean comparison = vasya.getName().equals(pushok.getName());
        System.out.println(comparison);

        for (String val :
                pushok.liveAnotherDay()) {
            System.out.println(val);
        }
    }
}