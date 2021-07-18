package it.sevenbits.roguelike;

import it.sevenbits.roguelike.containers.Chest;
import it.sevenbits.roguelike.entities.Player;
import it.sevenbits.roguelike.items.Armor;
import it.sevenbits.roguelike.items.Coins;
import it.sevenbits.roguelike.items.Weapon;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        Chest chest = new Chest();

        Weapon weapon = new Weapon(1);
        chest.putItem(weapon);

        Armor armor = new Armor(1);
        Coins coins = new Coins(1000);
        player.putItem(armor);
        player.putItem(coins);

        System.out.println(player.getItem(0).getType());

        chest.putItem(player.getItem(0));
        System.out.println(chest.getItem(1).getType());
        System.out.println(chest.getItem(0).getType());


    }
}
