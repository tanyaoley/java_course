package it.sevenbits.roguelike.entities;

import it.sevenbits.roguelike.containers.Inventory;
import it.sevenbits.roguelike.items.Item;

public class Monster implements MonsterInterface{
    private int health;
    private Inventory inventory;

    public Monster(){
        inventory = new Inventory();
        setHealth(5);
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
