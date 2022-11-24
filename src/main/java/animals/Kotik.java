package main.java.animals;

import java.util.Random;

public class Kotik {
    private static int count = 0;
    private final int METHODS = 6;
    private String name;
    private String voice;
    //Сытость котика будет измеряться от 0 до 1
    private float satiety;
    private float weight;

    public String getName() {
        return name;
    }

    public String getVoice() {
        return voice;
    }

    public float getSatiety() {
        return satiety;
    }

    public float getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public void setSatiety(float satiety) {
        this.normalizeSatiety(satiety);
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public static int getCount() {
        return count;
    }

    //Метод, который нормализует сытость котика, чтобы независимо от ввода она принимала значение от 0 до 1
    //Если значение <0, то приводится к 0; Если значение >1, то приводится к 1; Иначе задаётся как указанное
    private void normalizeSatiety(float satiety){
        if (satiety < 0){
            this.satiety = 0;
        }
        else if (satiety > 1){
            this.satiety = 1;
        }
        else{
            this.satiety = satiety;
        }
    }

    public Kotik(String name, String voice, float satiety, float weight) {
        this.normalizeSatiety(satiety);
        this.name = name;
        this.voice = voice;
        this.weight = weight;

        count++;
    }

    public Kotik() {
        this.name = "Вася";
        this.voice = "Мужланский";
        this.satiety = 0.5f;
        this.weight = 3.5f;
        count++;
    }

    public boolean eat(){
        Random rnd = new Random();
        eat(this.satiety += rnd.nextFloat(), "Whiskas");
        return true;
    }

    public boolean eat(float foodSatiety){
        if (foodSatiety < 0) satiety = 0;
        this.normalizeSatiety(this.satiety + satiety);
        return true;
    }

    public boolean eat(float foodSatiety, String foodName){
        if (foodSatiety < 0) satiety = 0;
        this.normalizeSatiety(this.satiety + satiety);
        return true;
    }

    public boolean play(){
        float satietyCost = 0.2f;
        if (this.satiety < satietyCost){
            return false;
        }
        else{
            this.satiety -= satietyCost;
            return true;
        }
    }

    public boolean sleep(){
        float satietyCost = 0.05f;
        if (this.satiety < satietyCost){
            return false;
        }
        else{
            this.satiety -= satietyCost;
            return true;
        }
    }

    public boolean wash(){
        float satietyCost = 0.1f;
        if (this.satiety < satietyCost){
            return false;
        }
        else{
            this.satiety -= satietyCost;
            return true;
        }
    }

    public boolean walk(){
        float satietyCost = 0.17f;
        if (this.satiety < satietyCost){
            return false;
        }
        else{
            this.satiety -= satietyCost;
            return true;
        }
    }

    //Во время охоты будет вероятность того, что котик поймает добычу, и, соответственно, скушает её
    public boolean hunt(){
        Random rnd = new Random();
        int success;
        float satietyCost = 0.32f;
        if (this.satiety < satietyCost){
            return false;
        }
        else{
            this.satiety -= satietyCost;
            success = rnd.nextInt(2);
            if(success == 1){
                this.normalizeSatiety(this.satiety += rnd.nextFloat());
            }

            return true;
        }
    }

    public String[] liveAnotherDay(){
        String[] method_results = {"Ел", "Играл", "Спал", "Умывался", "Гулял", "Охотился"};
        String[] activities = new String[24];
        Random rnd = new Random();
        int activity;
        
        for (int i = 0; i < 24; i++) {
            activity = rnd.nextInt(METHODS);
            switch (activity){
                case 0:{
                    this.eat();
                    break;
                }
                case 1:{
                    this.play();
                    break;
                }
                case 2:{
                    this.sleep();
                    break;
                }
                case 3:{
                    this.wash();
                    break;
                }
                case 4:{
                    this.walk();
                    break;
                }
                case 5:{
                    this.hunt();
                    break;
                }
            }
            

            activities[i] = i + " - " + method_results[activity];
        }
        return activities;
    }
}
