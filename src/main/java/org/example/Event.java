package org.example;

public class Event {
    private int id;
    private String name,descp;
    private double price; //ticket price for basic members
    private int count=0; //count of ticketed visitors
    private int visitors; // no.of visitors who visited attraction (ticketed and non-ticketed both included)
    private String status;
    public Event(String name,double price,String descp){
        this.name=name;
        this.price=price;
        this.descp=descp;
        this.status="CLOSE";

    }
    public int getId(){
        return this.id;
    }

    public int getCount() {
        return this.count;
    }
    public double getPrice(){
        return this.price;
    }
    public String getName(){
        return this.name;
    }
    public String getDescp(){
        return this.descp;
    }

    public String getStatus() {
        return status;
    }

    public int getVisitors() {
        return visitors;
    }

    public void setVisitors(int visitors) {
        this.visitors = visitors;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCount(int count) {
        this.count = count;
    }
    @Override
    public String toString(){
        return this.getId()+". "+this.getName()+"(Rs."+this.getPrice()+")"+": "+this.getDescp();
    }
}
