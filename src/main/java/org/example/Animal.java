package org.example;

public abstract class Animal {
    private final String name;
    private final String category;
    private final String voice;
    private String info;
    public Animal(String name,String category,String voice,String info){
        this.name=name;
        this.category=category;
        this.voice=voice;
        this.info=info;
    }
    public String getName(){
        return this.name;
    }

    public String getCategory() {
        return this.category;
    }

    public String getVoice() {
        return this.voice;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public abstract void makeNoise();
    public abstract void info();
    public void feed(){
        this.makeNoise();
    }
    public void read(){
        this.info();
    }
}
