package com.example.lutemon;

import java.io.Serializable;

public abstract class Lutemon implements Serializable {
    protected String name;
    protected String color;
    protected int attack;
    protected int defence;
    protected int experience;
    protected int health;
    protected int max_health;
    protected String id;
    private int idCounter;
    protected int wins;
    protected int losses;
    protected int trainingDays;

    protected int level;
    protected int image;

    public Lutemon(){
        this.name = "Lutemon";
        this.color = "Type";
        this.attack = 100;
        this.defence = 100;
        this.experience = 0;
        this.health = 100;
        this.max_health = 100;


    }

    public Lutemon(String name, String color, int attack, int defence, int experience, int max_health, int id, int idCounter) {
        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defence = defence;
        this.experience = experience;
        this.health = max_health;
        this.max_health = max_health;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setMax_health(int max_health) {
        this.max_health = max_health;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIdCounter(int idCounter) {
        this.idCounter = idCounter;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth() {
        return health;
    }

    public int getMax_health() {
        return max_health;
    }

    public String getId() {
        return id;
    }

    public int getIdCounter() {
        return idCounter;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getTrainingDays() {
        return trainingDays;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public void setTrainingDays(int trainingDays) {
        this.trainingDays = trainingDays;
    }

    public String listOfStats(){ //Lists stats
        String stats;
        stats = color + "(" + name + ")" + " att: " + attack + "; def: " + defence + "; exp: " + experience + ";" +
                "; health: " + health + "/" + max_health;


        return stats;
    }

    public void checkIncrease() { // This checks if the lutemon has enough experience to move to the next level
        if (experience > 10 && level == 1) {
            max_health = max_health + 2;
            health = max_health;
            attack = attack + 2;
            experience = 0;
            level = 2;
        }
        if (experience > 20 && level == 2) {
            max_health = max_health + 2;
            health = max_health;
            attack = attack + 2;
            experience = 0;
            level = 3;

        }
        if (experience > 30 && level == 3) {
            max_health = max_health + 2;
            health = max_health;
            attack = attack + 2;
            experience = 0;
            level = 4;

        }
        if (experience > 40 && level == 4) {
            max_health = max_health + 2;
            health = max_health;
            attack = attack + 2;
            experience = 0;
            level = 5;

        }
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
