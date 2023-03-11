package me.see1.ru;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Toy> toys = new ArrayList<>();
        Toy.addNewToy(toys, 1, "Doll", 10, 50);
        Toy.addNewToy(toys, 2, "Car", 20, 30);
        Toy.addNewToy(toys, 3, "Teddy bear", 15, 20);

        Toy.changeToyWeight(toys, 1, 60);

        Toy prizeToy = Toy.selectAndRemovePrizeToy(toys);
        if (prizeToy != null) {
            Toy.writePrizeToyToFile(prizeToy, "prize_toys.txt");
        }

    }
}