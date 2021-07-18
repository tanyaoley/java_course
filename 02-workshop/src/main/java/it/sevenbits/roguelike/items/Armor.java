package it.sevenbits.roguelike.items;

public class Armor implements ArmorInterface{
    int armorType;
    private String type;
    public Armor(int armorType){
        setType("Armor");
        setArmor(armorType);
    }
    public void setArmor(int value) {
        armorType = value;
    }

    public int getArmor() {
        return armorType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
