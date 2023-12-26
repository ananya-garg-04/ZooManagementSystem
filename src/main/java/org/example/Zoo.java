package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Zoo {
    protected ArrayList<Animal> animals=new ArrayList<>();
    protected ArrayList<Event> attractions=new ArrayList<>();
    protected ArrayList<Visitor> visitors=new ArrayList<>();
    protected ArrayList<Discount> discounts=new ArrayList<>();
    protected ArrayList<Object> specialDeals=new ArrayList<>();
    protected double revenue;
    private final Admin admin=new Admin("admin","admin123",this);
    public Zoo() {
        animals.add(new Amphibian("American Bull Frog","Croaks","The American bullfrog (Lithobates catesbeianus), often simply known as the bullfrog in Canada and " +
                "the United States, is a large true frog native to eastern North America. It typically inhabits large " +
                "permanent water bodies such as swamps, ponds, and lakes. Bullfrogs can also be found in manmade habitats" +
                "such as pools, koi ponds, canals, ditches and culverts. The bullfrog gets its name from the sound the " +
                "male makes during the breeding season, which sounds similar to a bull bellowing."));
        animals.add(new Amphibian("Chinese Giant Salamandor","Whins","The Chinese giant salamander (Andrias davidianus) is one of the largest salamanders and one of the largest " +
                "amphibians in the world.[4] It is fully aquatic, and is endemic to rocky mountain streams and lakes in " +
                "the Yangtze river basin of central China. Either it or a close relative has been introduced to Kyoto " +
                "Prefecture in Japan and to Taiwan.[4][5] It is considered critically endangered in the wild due to habitat " +
                "loss, pollution, and overcollection, as it is considered a delicacy and used in traditional Chinese medicine. " +
                "On farms in central China, it is extensively farmed and sometimes bred, although many of the salamanders on " +
                "the farms are caught in the wild.[6] It has been listed as one of the top-10 \"focal species\" in 2008 by " +
                "the Evolutionarily Distinct and Globally Endangered project." ));
        animals.add(new Mammal("Lion","Roars","In Africa, the range of the lion originally spanned most of the central African rainforest zone and the " +
                "Sahara desert. In the 1960s, it became extinct in North Africa, except in the southern part of Sudan. " +
                "In southern Europe and Asia, the lion once ranged in regions where climatic conditions supported an abundance " +
                "of prey. In Greece, it was common as reported by Herodotus in 480 BC; it was considered rare by 300 BC and " +
                "extirpated by AD 100. It was present in the Caucasus until the 10th century. It lived in Palestine until " +
                "the Middle Ages, and in Southwest Asia until the late 19th century. By the late 19th century, it had been " +
                "extirpated in most of Turkey. The last live lion in Iran was sighted in 1942 about 65 km (40 mi) northwest " +
                "of Dezful, although the corpse of a lioness was found on the banks of the Karun river in Khuzestan province " +
                "in 1944. It once ranged from Sind and Punjab in Pakistan to Bengal and the Narmada River in central India."));
        animals.add(new Mammal("Panda","Squeaks","The giant panda (Ailuropoda melanoleuca), sometimes called a panda bear or simply panda, is a bear species " +
                "endemic to China. It is characterised by its bold black-and-white coat and rotund body. The name " +
                "\"giant panda\" is sometimes used to distinguish it from the red panda, a neighboring musteloid. Though it " +
                "belongs to the order Carnivora, the giant panda is a folivore, with bamboo shoots and leaves making up more " +
                "than 99% of its diet. Giant pandas in the wild occasionally eat other grasses, wild tubers, or even meat in " +
                "the form of birds, rodents, or carrion. In captivity, they may receive honey, eggs, fish, yams, shrub leaves, " +
                "oranges, or bananas along with specially prepared food."));
        animals.add(new Reptile("Monitor Lizard","Hisses","Monitor lizards are lizards in the genus Varanus, the only extant genus in the family Varanidae. They are " +
                "native to Africa, Asia, and Oceania, and one species is also found in the Americas as an invasive species. " +
                "About 80 species are recognized. Monitor lizards have long necks, powerful tails and claws, and " +
                "well-developed limbs. The adult length of extant species ranges from 20 cm (7.9 in) in some species such as " +
                "Varanus sparnus, to over 3 m (10 ft) in the case of the Komodo dragon, though the extinct varanid known as " +
                "megalania (Varanus priscus) may have reached lengths of more than 7 m (23 ft). Most monitor species are " +
                "terrestrial, but arboreal and semiaquatic monitors are also known. While most monitor lizards are carnivorous, " +
                "eating eggs, smaller reptiles, fish, birds, insects, and small mammals, some also eat fruit and vegetation, " +
                "depending on where they live."));
        animals.add(new Reptile("Crocodile","Growls","Crocodiles (family Crocodylidae) or true crocodiles are large semiaquatic reptiles that live throughout the " +
                "tropics in Africa, Asia, the Americas and Australia. The term crocodile is sometimes used even more loosely " +
                "to include all extant members of the order Crocodilia, which includes the alligators and caimans (family " +
                "Alligatoridae), the gharial and false gharial (family Gavialidae) among other extinct taxa."));
        attractions.add(new Event("Jungle Safari",10,"ZOOtopia offers an adventure ride to the Jungle Safari that allows you to explore unexplored trails. Buy your ticket now!"));
        attractions.add(new Event("Botanical Garden",15,"ZOOtopia offers an adventure ride to the Botanical Garden that allows you to explore unexplored trails. Buy your ticket now!"));
        attractions.add(new Event("Dinosaur Show",12,"ZOOtopia offers an adventure ride to the Dinosaur show that allows you to explore unexplored trails. Buy your ticket now!"));
        discounts.add(new Discount("MINOR",10));
        discounts.add(new Discount("SENIOR",20));
        specialDeals.add(new SpecialDeal(2,15));
        specialDeals.add(new SpecialDeal(3,30));
    }
    public void updateEventIds(){
        for(Event a:attractions){
            a.setId(attractions.indexOf(a)+1);
        }
    }
    public void adminMenu(Admin a) throws InputMismatchException {
        Scanner sc=new Scanner(System.in);
        while(true){
            try {
                System.out.println("\nAdmin Menu:\n1. Manage Attractions\n2. Manage Animals\n3. Schedule Events\n4. Set Discounts\n5. Set Special Deal\n6. View Visitor Stats\n7. View Feedback\n8. Exit\n");
                System.out.print("Enter your choice: ");
                int ch = sc.nextInt();
                sc.nextLine();
                if (ch == 1) {
                    a.manageAttraction();
                } else if (ch == 2) {
                    a.manageAnimals();
                } else if (ch == 3) {
                    a.scheduleEvent();
                } else if (ch == 4) {
                    a.setDiscounts();
                } else if (ch == 5) {
                    a.setSpecialDeals();
                } else if (ch == 6) {
                    a.viewVisitorStats();
                } else if (ch == 7) {
                    a.viewFeedback();
                } else if (ch == 8) {
                    System.out.println("\nLogged Out");
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
    public void visitorMenu(Visitor v) throws InputMismatchException{
        Scanner sc=new Scanner(System.in);
        while(true){
            try {
                System.out.println("\nVisitor Menu:\n1. Explore the Zoo\n2. Buy Membership\n3. Buy Tickets\n4. View Discounts\n5. View Special Deals\n6. Visit Animals\n7. Visit Attractions\n8. Leave Feedback\n9. Top-up Balance\n10.Log Out\n");
                System.out.print("Enter your choice: ");
                int ch = sc.nextInt();
                sc.nextLine();
                if (ch == 1) {
                    v.exploreZoo();
                } else if (ch == 2) {
                    v.buyMembership();
                } else if (ch == 3) {
                    v.buyTickets();
                } else if (ch == 4) {
                    v.viewDiscounts();
                } else if (ch == 5) {
                    v.viewSpecialDeals();
                } else if (ch == 6) {
                    v.visitAnimals();
                } else if (ch == 7) {
                    v.visitAttraction();
                } else if (ch == 8) {
                    v.leaveFeedback();
                } else if (ch == 9) {
                    System.out.print("\nEnter the amount you want to add to your balance: Rs.");
                    Scanner scan = new Scanner(System.in);
                    int amt = scan.nextInt();
                    v.setBalance(v.getBalance() + (double)amt);
                    System.out.println("Amount added successfully.");
                    scan.nextLine();
                } else if (ch == 10) {
                    System.out.println("\nLogged Out");
                    break;
                } else {
                    System.out.println("\nInvalid input");
                }
            }
            catch(Exception e){
                System.out.println("\nInvalid Input");
                sc.nextLine();
            }
        }
    }
    public void enterAsVisitor() throws InputMismatchException{
        Scanner sc=new Scanner(System.in);
        while(true) {
            try {
                System.out.println("\n1. Register\n2. Login\n3. Back\n");
                System.out.print("Enter your choice: ");
                int ch = sc.nextInt();
                sc.nextLine();
                if (ch == 1) {
                    System.out.print("\nEnter Visitor Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Visitor Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Visitor Phone Number: ");
                    long ph = sc.nextLong();
                    sc.nextLine();
                    System.out.print("Enter Visitor Balance: ");
                    int balance = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Visitor Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Visitor Password: ");
                    String password = sc.nextLine();
                    this.visitors.add(new Visitor(name, age, ph, balance, email, password, this));
                    System.out.println("\nRegistration Successful.");
                } else if (ch == 2) {
                    System.out.print("\nEnter Visitor Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter password: ");
                    String password = sc.nextLine();
                    int flag = 0;
                    for (Visitor v : visitors) {
                        if (Objects.equals(v.getEmail(), email) && Objects.equals(v.getPassword(), password)) {
                            flag = 1;
                            System.out.println("\nLogin Successful.");
                            this.visitorMenu(v);
                        }
                    }
                    if (flag == 0) {
                        System.out.println("\nIncorrect email or password");
                    }
                } else if (ch == 3) {
                    System.out.println("...");
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
    public void menu() throws InputMismatchException{
        Scanner sc=new Scanner(System.in);
        this.updateEventIds();
        while(true){
            try {
                System.out.println("\n1. Enter As Admin\n2. Enter As Visitor\n3. View Special Deals\n4. Terminate Application\n");
                System.out.print("Enter your choice: ");
                int ch = sc.nextInt();
                sc.nextLine();
                if (ch == 1) {
                    System.out.print("\nEnter admin username: ");
                    String username = sc.nextLine();
                    System.out.print("Enter admin password: ");
                    String password = sc.nextLine();
                    if (Objects.equals(username, admin.getUsername()) && Objects.equals(password, admin.getPassword())) {
                        System.out.println("\nLogged in as Admin.");
                        this.adminMenu(admin);
                    } else {
                        System.out.println("\nIncorrect username or password");
                    }
                } else if (ch == 2) {
                    this.enterAsVisitor();
                } else if (ch == 3) {
                    System.out.println("\n");
                    for (Object sd : specialDeals) {
                        int id = specialDeals.indexOf(sd) + 1;
                        System.out.print(id);
                        System.out.println(". " + (SpecialDeal)sd);
                    }
                } else if (ch == 4) {
                    System.out.println("\nZooBuddies Terminated!!!");
                    System.exit(1);
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
}
