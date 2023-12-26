package org.example;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Admin implements User{
    private final String username;
    private final String password;
    private final Zoo zoo; //zoo to which this admin belongs
    public Admin(String username,String password,Zoo zoo){
        this.password=password;
        this.username=username;
        this.zoo=zoo;
    }
    public String getUsername(){
        return this.username;
    }
    @Override
    public String getPassword() {
        return this.password;
    }
    public void manageAttraction() throws InputMismatchException{
        Scanner sc=new Scanner(System.in);
        while(true) {
            try {
                System.out.println("\nManage Attractions: ");
                System.out.println("1. Add Attraction");
                System.out.println("2. View Attractions");
                System.out.println("3. Modify Attraction");
                System.out.println("4. Remove Attraction");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int ch = sc.nextInt();
                sc.nextLine();
                if (ch == 1) {
                    System.out.print("Enter attraction name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter ticket price for attraction: ");
                    int price = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter attraction description: ");
                    String descp = sc.nextLine();
                    zoo.attractions.add(new Event(name, (double)price, descp));
                    zoo.updateEventIds();
                } else if (ch == 2) {
                    for (Event a : zoo.attractions) {
                        System.out.println(a);
                    }
                } else if (ch == 3) {
                    System.out.print("Enter the name of attraction you want to modify:");
                    String n = sc.nextLine();
                    System.out.println("\nModify Attraction: ");
                    System.out.println("1. Change name");
                    System.out.println("2. Update ticket price");
                    System.out.println("3. Update Descp\n");
                    System.out.print("Enter your choice: ");
                    int ch1 = sc.nextInt();
                    sc.nextLine();
                    if (ch1 == 1) {
                        System.out.print("\nEnter new name: ");
                        String name = sc.nextLine();
                        for (Event a : zoo.attractions) {
                            if (Objects.equals(a.getName(), n)) {
                                a.setName(name);
                                System.out.println("Name updated successfully.");
                            }
                        }
                    } else if (ch1 == 2) {
                        System.out.print("\nEnter updated price: Rs.");
                        int price = sc.nextInt();
                        sc.nextLine();
                        for (Event a : zoo.attractions) {
                            if (Objects.equals(a.getName(), n)) {
                                a.setPrice((double)price);
                                System.out.println("Price updated successfully.");
                            }
                        }
                    } else if (ch1 == 3) {
                        System.out.print("\nEnter updated description: ");
                        String descp = sc.nextLine();
                        for (Event a : zoo.attractions) {
                            if (Objects.equals(a.getName(), n)) {
                                a.setDescp(descp);
                                System.out.println("Description updated successfully.");
                            }
                        }
                    } else {
                        System.out.println("\nInvalid input");
                    }
                } else if (ch == 4) {
                    System.out.print("\nEnter the name of attraction you want to remove:");
                    String name = sc.nextLine();
                    zoo.attractions.removeIf(a -> Objects.equals(a.getName(), name));
                    zoo.updateEventIds();
                } else if (ch == 5) {
                    //nothing to be done
                    System.out.println("\n...");
                    break;
                } else {
                    System.out.println("\nInvalid Input");
                }
            }
            catch (Exception e){
                System.out.println("\nInvalid Input");
                sc.nextLine();
            }
        }
    }
    public void manageAnimals() throws InputMismatchException{
        Scanner sc=new Scanner(System.in);
        while(true) {
            try {
                System.out.println("\nManage Animals: ");
                System.out.println("1. Add Animal");
                System.out.println("2. Update animal details");
                System.out.println("3. Remove animal");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int ch = sc.nextInt();
                sc.nextLine();
                if (ch == 1) {
                    String name, voice, info, category;
                    System.out.print("\nEnter name: ");
                    name = sc.nextLine();
                    System.out.print("Enter category: ");
                    category = sc.nextLine();
                    System.out.print("Enter sound animal makes: ");
                    voice = sc.nextLine();
                    System.out.print("Enter animal description: ");
                    info = sc.nextLine();
                    if (Objects.equals(category, "Mammal")) {
                        zoo.animals.add(new Mammal(name, voice, info));
                    } else if (Objects.equals(category, "Amphibian")) {
                        zoo.animals.add(new Amphibian(name, voice, info));
                    } else if (Objects.equals(category, "Reptile")) {
                        zoo.animals.add(new Reptile(name, voice, info));
                    }
                } else if (ch == 2) {
                    String name, info;
                    System.out.print("\nWhich animal's description do you want to update?: ");
                    name = sc.nextLine();
                    for (Animal a : zoo.animals) {
                        if (Objects.equals(a.getName(), name)) {
                            System.out.print("Enter updated description: ");
                            info = sc.nextLine();
                            a.setInfo(info);
                        }
                    }
                } else if (ch == 3) {
                    String name;
                    System.out.print("\nWhich animal do you want to remove? :");
                    name = sc.nextLine();
                    zoo.animals.removeIf(a -> Objects.equals(a.getName(), name));
                } else if (ch == 4) {
                    System.out.println("\n...");
                    break;
                } else {
                    System.out.println("\nInvalid input");
                }
            }
            catch (Exception e){
                System.out.println("\nInvalid Input");
                sc.nextLine();
            }
        }
    }
    public void scheduleEvent() throws InputMismatchException{
        System.out.println("\n");
        for(Event a:zoo.attractions){
            System.out.println(a);
        }
        try {
            System.out.print("Which event do you want to schedule?(Enter id): ");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Status(OPEN/CLOSE): ");
            String status = sc.nextLine();
            for (Event a : zoo.attractions) {
                if (a.getId() == id) {
                    a.setStatus(status);
                    System.out.println("Event scheduled successfully.");
                }
            }
        }
        catch (Exception e){
            System.out.println("\nInvalid Input");
        }
    }
    public void viewFeedback(){
        System.out.println("\n");
        for(Visitor v:zoo.visitors){
            System.out.println(v.getName()+": "+v.getFeedback());
        }
    }
    public void viewVisitorStats(){
        int total=0,max=0;
        for(Event a:zoo.attractions){
            total+=a.getVisitors();
            if(a.getVisitors()>max){
                max=a.getVisitors();
            }
        }
        System.out.println("\nTotal visitors: "+total);
        System.out.println("Revenue: Rs."+zoo.revenue);
        System.out.println("Most popular attraction(s):");
        for(Event a:zoo.attractions){
            if(a.getVisitors()==max){
                System.out.println(a.getName());
            }
        }
    }
    public void setDiscounts() throws InputMismatchException{
        Scanner sc=new Scanner(System.in);
        while(true){
            try {
                System.out.println("\nSet Discounts:\n1. Add Discount\n2. Modify Discount\n3. Remove Discount\n4. Exit");
                System.out.print("\nEnter your choice: ");
                int ch = sc.nextInt();
                sc.nextLine();
                if (ch == 1) {
                    System.out.print("\nEnter Discount category(in capital letters): ");
                    String category = sc.nextLine();
                    System.out.print("Enter discount percentage(eg. 20 for 20%): ");
                    int percent = sc.nextInt();
                    zoo.discounts.add(new Discount(category, percent));
                    System.out.println("Discount added successfully.");
                } else if (ch == 2) {
                    System.out.println("\n");
                    for (Discount d : zoo.discounts) {
                        int id = zoo.discounts.indexOf(d) + 1;
                        System.out.print(id);
                        System.out.println(". " + d);
                    }
                    System.out.print("\nEnter your choice: ");
                    int ch1 = sc.nextInt();
                    sc.nextLine();
                    for (Discount d : zoo.discounts) {
                        if (ch1 == zoo.discounts.indexOf(d) + 1) {
                            System.out.print("\nEnter updated discount percentage: ");
                            int percent = sc.nextInt();
                            sc.nextLine();
                            d.setPercent(percent);
                            d.setCode(d.getCategory() + d.getPercent());
                            System.out.println("Discount modified successfully.");
                        }
                    }
                } else if (ch == 3) {
                    System.out.println("\n");
                    for (Discount d : zoo.discounts) {
                        int id = zoo.discounts.indexOf(d) + 1;
                        System.out.print(id);
                        System.out.println(". " + d);
                    }
                    System.out.print("\nEnter your choice: ");
                    int ch1 = sc.nextInt();
                    sc.nextLine();
                    try {
                        zoo.discounts.remove(ch1 - 1);
                        System.out.println("\nDiscount removed successfully.");
                    } catch (Exception e) {
                        System.out.println("\nInvalid input");
                    }
                } else if (ch == 4) {
                    break;
                } else {
                    System.out.println("\nInvalid input");
                }
            }
            catch (Exception e){
                System.out.println("\nInvalid Input");
                sc.nextLine();
            }
        }
    }
    public void setSpecialDeals(){
        Scanner sc=new Scanner(System.in);
        while(true){
            try {
                System.out.println("\nSet Special Deals:\n1. Add special deal\n2. Remove special deal\n3. Exit");
                System.out.print("Enter your choice: ");
                int ch = sc.nextInt();
                sc.nextLine();
                if (ch == 1) {
                    System.out.print("\nEnter upper cap of tickets for deal: ");
                    int uppercap = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter deal percentage(eg. 10 for 10%): ");
                    int percent = sc.nextInt();
                    sc.nextLine();
                    zoo.specialDeals.add(new SpecialDeal(uppercap, percent));
                    System.out.println("Deal added successfully.");
                } else if (ch == 2) {
                    System.out.println("\n");
                    for (Object sd : zoo.specialDeals) {
                        int id = zoo.specialDeals.indexOf(sd) + 1;
                        System.out.print(id);
                        System.out.println(". " + (SpecialDeal)sd);
                    }
                    System.out.print("\nEnter your choice: ");
                    int ch1 = sc.nextInt();
                    sc.nextLine();
                    try {
                        zoo.specialDeals.remove(ch1 - 1);
                        System.out.println("\nDeal removed successfully.");
                    } catch (Exception e) {
                        System.out.println("\nInvalid input");
                    }
                } else if (ch == 3) {
                    break;
                } else {
                    System.out.println("\nInvalid Input");
                }
            }
            catch (Exception e){
                System.out.println("\nInvalid Input");
                sc.nextLine();
            }
        }
    }
}
