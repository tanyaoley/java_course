package it.sevenbits.roguelike.items;

public class Coins implements CoinsInerface{
    private int coinsValue;
    private String type;

    public Coins(int value){
        setType("Coins");
        setValue(value);
    }
    public int getValue() {
        return coinsValue;
    }

    public void setValue(int cost) {
        this.coinsValue = cost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
