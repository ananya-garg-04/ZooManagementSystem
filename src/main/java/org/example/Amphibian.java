package org.example;

public class Amphibian extends Animal{
    public Amphibian(String name,String voice,String info){
        super(name,"Amphibian",voice,info);
    }
    @Override
    public void makeNoise(){
        System.out.println(this.getName()+" "+this.getVoice()+"!");
    }
    @Override
    public void info(){
        System.out.println(this.getName()+": ");
        System.out.println(this.getInfo());
    }
    @Override
    public String toString(){
        return "Amphibian: "+this.getName();
    }
}

