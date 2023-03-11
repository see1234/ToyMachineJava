package me.see1.ru;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Toy {
    private int id;
    private String name;
    private int quantity;
    private double weight;

    public Toy(int id, String name, int quantity, double weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getWeight() {
        return weight;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public static void addNewToy(List<Toy> toys, int id, String name, int quantity, double weight) {
        toys.add(new Toy(id, name, quantity, weight));
    }

    public static void changeToyWeight(List<Toy> toys, int id, double weight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(weight);
                break;
            }
        }
    }
    //С помощью метода выбора призовой игрушки – мы получаем эту призовую игрушку и записываем в список\массив.
    //Это список призовых игрушек, которые ожидают выдачи.
    public static Toy selectPrizeToy(List<Toy> toys) {
        double totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }
        double random = new Random().nextDouble() * totalWeight;
        double weightSum = 0;
        for (Toy toy : toys) {
            weightSum += toy.getWeight();
            if (weightSum >= random) {
                toy.setQuantity(toy.getQuantity() - 1);
                toys.remove(toy);
                return toy;
            }
        }
        return null;
    }
    //Еще у нас должен быть метод – получения призовой игрушки.
    //После его вызова – мы удаляем из списка\массива первую игрушку и сдвигаем массив. А эту игрушку записываем в текстовый файл.

    //короч тут я не понял, но удалил после получения её
    public static Toy selectAndRemovePrizeToy(List<Toy> toys) {
        double totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }
        double random = new Random().nextDouble() * totalWeight;
        double weightSum = 0;
        for (Toy toy : toys) {
            weightSum += toy.getWeight();
            if (weightSum >= random) {
                toy.setQuantity(toy.getQuantity() - 1);
                return toy;
            }
        }
        return null;
    }

    public static void writePrizeToyToFile(Toy toy, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(toy.getName() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}