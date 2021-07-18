package it.sevenbits.roguelike.items;

public class Weapon implements WeaponInterface{
    private int damage;
    private String type;

    public Weapon(int damage){
        setType("Weapon");
        setWeaponDamage(damage);
    }

    public void setWeaponDamage(int damage) {
        this.damage = damage;
    }

    public int getWeaponDamage() {
        return damage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
