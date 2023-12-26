package org.example;

public class Discount {
    private String code;
    private String category;
    private int percent;
    public Discount(String category,int percent){
        this.category=category;
        this.percent=percent;
        this.code=this.category+this.percent;
    }

    public String getCategory() {
        return category;
    }

    public String getCode(){
        return code;
    }

    public int getPercent() {
        return percent;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public void setCode(String code) {
        this.code = code;
    }
    @Override
    public String toString(){
        return this.category+" ("+this.percent+"% discount) - "+this.code;
    }
}
