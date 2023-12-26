package org.example;

public class Mammal extends Animal{
    public Mammal(String name,String voice,String info){
        super(name,"Mammal",voice,info);
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
        return "Mammal: "+this.getName();
    }
}
