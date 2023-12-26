package org.example;

public class Reptile extends Animal{
    public Reptile(String name,String voice,String info){
        super(name,"Reptile",voice,info);
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
        return "Reptile: "+this.getName();
    }
}
