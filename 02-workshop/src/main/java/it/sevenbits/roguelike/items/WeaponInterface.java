package it.sevenbits.roguelike.items;

public interface WeaponInterface extends Item {
    void setWeaponDamage(int damage);
    int getWeaponDamage();
}
