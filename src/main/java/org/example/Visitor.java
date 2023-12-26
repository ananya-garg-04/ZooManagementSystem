package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
public class Visitor implements User{
    private final String name;
    private String feedback,membership;
    private final String email;
    private final String password;
    private final long ph;
    private final int age;
    private double balance;
    private final Zoo zoo;
    private ArrayList<String> ticketsfor=new ArrayList<>();

    public Visitor(String name, int age, long ph, int balance, String email, String password, Zoo zoo) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.ph = ph;
        this.age = age;
        this.balance = balance;
        this.zoo = zoo;
    }
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return age;
    }
    public double getBalance() {
        return balance;
    }
    public String getEmail() {
        return email;
    }
    @Override
    public String getPassword() {
        return password;
    }
    public String getFeedback() {
        return feedback;
    }
    public String getMembership(){
        return membership;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    public void setMembership(String membership) {
        this.membership = membership;
    }
    public void exploreZoo() throws InputMismatchException {
        Scanner sc=new Scanner(System.in);
        while(true){
            try {
                System.out.println("\nExplore the Zoo:");
                System.out.println("1. View Attractions");
                System.out.println("2. View Animals");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int ch = sc.nextInt();
                sc.nextLine();
                if (ch == 1) {
                    System.out.println("\n");
                    for (Event a : zoo.attractions) {
                        System.out.println(a);
                    }
                } else if (ch == 2) {
                    System.out.println("\n");
                    for (Animal a : zoo.animals) {
                        System.out.println(a);
                    }
                } else if (ch == 3) {
                    System.out.println("\n...");
                    break;
                } else {
                    System.out.println("\nInvalid Input");
                }
            }
            catch(Exception e){
                System.out.println("\nInvalid Input");
                sc.nextLine();
            }
        }
    }
    public void buyMembership() throws InputMismatchException{
        if(Objects.equals(this.getMembership(), "PREMIUM")){
            System.out.println("\nYou are already a premium member. You need not buy any membership again.");
            return;
        }
        try {
            System.out.println("\nBuy Membership:\n1. Basic Membership(Rs.20)\n2. Premium Membership(Rs.50)\nEnter your choice:");
            Scanner sc = new Scanner(System.in);
            int ch = sc.nextInt();
            sc.nextLine();
            System.out.print("Apply Discount code: ");
            String code = sc.nextLine();
            int off = 100;
            for (Discount d : zoo.discounts) {
                if (Objects.equals(d.getCode(), code)) {
                    if (Objects.equals(d.getCode(), "MINOR10")) {
                        if (this.getAge() < 18) {
                            off = off - d.getPercent();
                        } else {
                            System.out.println("Discount not applicable.");
                        }
                    } else if (Objects.equals(d.getCode(), "SENIOR20")) {
                        if (this.getAge() > 60) {
                            off = off - d.getPercent();
                        } else {
                            System.out.println("Discount not applicable");
                        }
                    } else {
                        off = off - d.getPercent();
                    }
                }
            }
            if (ch == 1) {
                if (Objects.equals(this.getMembership(), "BASIC")) {
                    System.out.println("You already have basic membership. You need not buy it again. However you can upgrade to premium membership.");
                    return;
                }
                if (this.balance < (double)20 * off / 100) {
                    System.out.println("Insufficient balance");
                } else {
                    this.setBalance(this.getBalance() - (double)20 * off / 100);
                    zoo.revenue += (double)20 * off / 100;
                    this.setMembership("BASIC");
                    System.out.println("Basic Membership purchased successfully. Your balance is now Rs." + this.getBalance());
                }
            } else if (ch == 2) {
                if (this.balance < (double)50 * off / 100) {
                    System.out.println("Insufficient balance");
                } else {
                    this.setBalance(this.getBalance() - (double)50 * off / 100);
                    zoo.revenue += (double)50 * off / 100;
                    this.setMembership("PREMIUM");
                    System.out.println("Premium Membership purchased successfully. Your balance is now Rs." + this.getBalance());
                }
            } else {
                System.out.println("\nInvalid Input");
            }
        }
        catch(Exception e){
            System.out.println("\nInvalid Input");
        }
    }
    public void buyTickets() throws InputMismatchException{
        if(Objects.equals(this.getMembership(), "PREMIUM")){
            System.out.println("\nSince you are a premium member, you don't need to buy tickets to visit any of the attractions.");
            return;
        }
        try {
            System.out.println("\nSelect an Attraction to buy ticket: ");
            for (Event a : zoo.attractions) {
                System.out.println(a.getId() + "." + a.getName() + "(Rs." + a.getPrice() + ")");
            }
            System.out.print("\nEnter your choice: ");
            Scanner sc = new Scanner(System.in);
            int ch = sc.nextInt();
            sc.nextLine();
            if (ch > zoo.attractions.size()) {
                System.out.println("\nInvalid Input");
                return;
            }
            System.out.print("\nEnter the number of tickets: ");
            int no = sc.nextInt();
            sc.nextLine();
            System.out.print("Apply Discount Code: ");
            String code = sc.nextLine();
            double p = zoo.attractions.get(ch - 1).getPrice();
            //apply discount
            for (Discount d : zoo.discounts) {
                if (Objects.equals(d.getCode(), code)) {
                    if (Objects.equals(d.getCode(), "MINOR10")) {
                        if (this.getAge() < 18) {
                            p = p - p * d.getPercent() / 100;
                        } else {
                            System.out.println("Discount not applicable.");
                        }
                    } else if (Objects.equals(d.getCode(), "SENIOR20")) {
                        if (this.getAge() > 60) {
                            p = p - p * d.getPercent() / 100;
                        } else {
                            System.out.println("Discount not applicable.");
                        }
                    } else {
                        p = p - p * d.getPercent() / 100;
                    }
                }
            }
            //Apply special deal
            int deal = 0;
            for (Object sd : zoo.specialDeals) {
                if (no - 1 == ((SpecialDeal)sd).getUppercap()) {
                    deal = ((SpecialDeal)sd).getPercent();
                }
            }
            p = p - p * deal / 100;
            if (this.getBalance() >= p * no) {
                //zoo.revenue += p * no;
                for (int k = 0; k < no; k++) {
                    this.setBalance(this.getBalance() - p);
                    zoo.revenue+=p;
                    zoo.attractions.get((ch - 1)).setCount(zoo.attractions.get(ch - 1).getCount() + 1);
                    this.ticketsfor.add(zoo.attractions.get(ch - 1).getName());
                }
                System.out.println("\nThe ticket(s) for " + zoo.attractions.get(ch - 1).getName() + " was purchased successfully. Your balance is now " + this.getBalance() + ".");
            } else {
                System.out.println("\nInsufficient Balance");
            }
        }
        catch(Exception e){
            System.out.println("\nInvalid Input");
        }
    }
    public void visitAttraction() throws InputMismatchException{
        if(this.getMembership()==null){
            System.out.println("\nBuy a membership first to visit zoo attractions.");
            return;
        }
        try {
            System.out.println("\nSelect an attraction to visit: ");
            for (Event a : zoo.attractions) {
                System.out.println(a.getId() + "." + a.getName());
            }
            System.out.print("Enter your choice:");
            Scanner sc = new Scanner(System.in);
            int ch = sc.nextInt();
            sc.nextLine();
            if (Objects.equals(zoo.attractions.get(ch - 1).getStatus(), "CLOSE")) {
                System.out.println("\nYou cannot visit this attraction at the moment as it is closed as per the schedule.");
                return;
            }
            if (Objects.equals(this.getMembership(), "BASIC")) {
                if (this.ticketsfor.contains(zoo.attractions.get(ch - 1).getName())) {
                    this.ticketsfor.remove(zoo.attractions.get(ch - 1).getName());
                    System.out.println("\n1 Ticket used.\nThank you for visiting " + zoo.attractions.get(ch - 1).getName() + ". Hope you enjoyed the attraction.");
                    zoo.attractions.get(ch - 1).setCount(zoo.attractions.get(ch - 1).getCount() + 1);
                    zoo.attractions.get(ch-1).setVisitors(zoo.attractions.get(ch-1).getVisitors()+1);
                } else {
                    System.out.println("Ticket not available. Basic Members need to buy separate tickets for the attractions.");
                }
            } else if (Objects.equals(this.getMembership(), "PREMIUM")) {
                zoo.attractions.get(ch - 1).setVisitors(zoo.attractions.get(ch - 1).getVisitors() + 1);
                System.out.println("\nThank you for visiting " + zoo.attractions.get(ch - 1).getName() + ". Hope you enjoyed the attraction.");
            }
        }
        catch(Exception e){
            System.out.println("\nInvalid Input");
        }
    }
    public void visitAnimals() throws InputMismatchException{
        try {
            System.out.println("\nSelect an animal to visit");
            for (Animal a : zoo.animals) {
                System.out.println(zoo.animals.indexOf(a) + 1 + ". " + a);
            }
            System.out.print("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            int ch = sc.nextInt();
            sc.nextLine();
            if (ch > zoo.animals.size()) {
                System.out.println("\nInvalid input");
                return;
            }
            System.out.println("\nFeed or Read: ");
            System.out.println("1. Feed\n2. Read");
            System.out.print("Enter your choice: ");
            int ch1 = sc.nextInt();
            sc.nextLine();
            if (ch1 == 1) {
                zoo.animals.get(ch - 1).feed();
            } else if (ch1 == 2) {
                zoo.animals.get(ch - 1).read();
            } else {
                System.out.println("\nInvalid input");
            }
        }
        catch(Exception e){
            System.out.println("\nInvalid Input");
        }
    }
    public void leaveFeedback(){
        System.out.print("\nLeave Feedback:\nEnter your feedback: ");
        Scanner sc=new Scanner(System.in);
        String feedback=sc.nextLine();
        this.setFeedback(feedback);
        System.out.println("Thank you for your feedback.");
    }
    public void viewDiscounts(){
        System.out.println("\n");
        for(Discount d:zoo.discounts){
            int id=zoo.discounts.indexOf(d)+1;
            System.out.print(id);
            System.out.println(". "+d);
        }
    }
    public void viewSpecialDeals(){
        System.out.println("\n");
        for(Object sd: zoo.specialDeals){
            int id=zoo.specialDeals.indexOf(sd)+1;
            System.out.print(id);
            System.out.println(". "+(SpecialDeal)sd);
        }
    }
}
