package org.example;

public class SpecialDeal extends Discount{
    private final int uppercap;
    public SpecialDeal(int uppercap,int percent){
        super("MORETHAN"+uppercap,percent);
        this.uppercap=uppercap;
    }

    public int getUppercap() {
        return uppercap;
    }
    @Override
    public String toString(){
        return "Special discount of "+this.getPercent()+"% on buying more than "+this.uppercap+" attraction tickets";
    }
}
