package it.sevenbits.roguelike.entities;

import it.sevenbits.roguelike.containers.Inventory;
import it.sevenbits.roguelike.items.Item;

public class Player implements PlayerInterface{
    private int health;
    private Inventory inventory;

    public Player(){
        inventory = new Inventory();
        setHealth(10);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void putItem(Item item) {
        inventory.putItem(item);
    }

    public Item getItem(int index) {
        return inventory.getItem(index);
    }
}