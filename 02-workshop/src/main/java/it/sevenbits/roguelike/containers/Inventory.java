package it.sevenbits.roguelike.containers;

import it.sevenbits.roguelike.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory implements Container{
    private List<Item> items;

    public Inventory(){
    items = new ArrayList<Item>();
    }

    public void putItem(Item item) {
        items.add(item);
    }

    public Item getItem(int index) {
        Item currentItem =items.get(index);
        items.remove(index);
        return currentItem;
    }
}
