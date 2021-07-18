package it.sevenbits.roguelike.containers;

import it.sevenbits.roguelike.items.Item;

public interface Container {
    void putItem(Item item);
    Item getItem(int index);
}
