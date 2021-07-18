package it.sevenbits.roguelike.entities;

import it.sevenbits.roguelike.items.Item;

public interface Entity {

    int getHealth();
    void setHealth(int health);

    void putItem(Item item);
    Item getItem(int index);


}
