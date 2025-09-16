package com.magasin;
import  com.magasin.Magasin;
import   com.magasin.Item;

public class Main {
    public static void main(String[] args) {

        System.out.println("Golden Master");
        Item[] items = {
                new Item("Normal", 10, 20),
                new Item("Normal", 1, 20),
                new Item("Normal", 0, 20),
                new Item("Normal", -1, 20),

                // Comté
                new Item("Comté", 2, 49),
                new Item("Comté", 0, 48),

                // Pass VIP Concert
                new Item("Pass VIP Concert", 15,20),
                new Item("Pass VIP Concert", 11,49),
                new Item("Pass VIP Concert", 10,49),
                new Item("Pass VIP Concert", 0,20),

                // Kryptonite
                new Item("Kryptonite", 0,80),



        };

        Magasin magasin = new Magasin(items);

        int days = 5;
        for (int day = 0; day < days; day++) {
            System.out.println("----- jour " + day + "-----");

            magasin.updateQuality();


            for (Item item : items) {
                System.out.println(item);

            }


        }

    }
}
