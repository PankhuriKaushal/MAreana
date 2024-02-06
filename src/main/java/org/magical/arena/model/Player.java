package org.magical.arena.model;

public class Player {
    private int health;
    private int finalHealth;
    private int strength;
    private int attack;

    public Player() {
    }

    public Player(int health, int strength, int attack) {
        this.health = health;
        this.strength = strength;
        this.finalHealth = health;
        this.attack = attack;
    }

    public int getFinalHealth() {
        return finalHealth;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

}
