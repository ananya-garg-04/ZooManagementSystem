COMMANDS TO COMPILE AND RUN.
On the terminal go the directory where this folder(A2_2022068) is saved.
Then run the following commands one by one in the given sequence:
    mvn clean
    mvn compile
    mvn package
    mvn exec:java


SOME IMPORTANT POINTS:
    >As soon as the program starts 6 animals, two of each category-Amphibian,Mammal,Reptile,; 3 attractions- Jungle Safari, Botanical Garden, Dinosaur Show; 2 discounts- MINOR10,SENIOR20; and 2 special deals are already present there. However these can modified or removed by the admin.
    >Apart from these admin can add,modify or remove any no. attractions,animals,discounts or deals.
    >For the schedule event option in admin menu, admin can only set the status of the attractions as "OPEN" or "CLOSE".
    >By default, as the program starts and when a new attraction is added, the default status is "CLOSE". Admin will have to explicitly change the status by using schedule event option.
    >All the inputs are case and space sensitive.
    >Admin username: admin
    >Admin password: admin123


SOME ASSUMPTIONS:
    >To visit any attraction, visitor must have any of the memberships. Visitor without membership is not allowed to visit attractions however he can visit animals though.
    >Admin can add any no. of discounts apart from those already present however checks will be performed for MINOR10 and SENIOR20 only. Others will get applied if the visitor uses the discount code without performing any check.
    >Validity check for phone number, name and email does not take place.
    >There are no criteria for password validity.
    >SpecialDeal is defined as discount offered if no. of tickets purchased for an attraction at a time being greater than a certain no.
    >There can be visitors with same name,ph,age,etc.
    >There can be animals/attractions with same name.


CONCEPT:
    >Classes Mammal,Amphibian,Reptile extend abstract class Animal. { Inheritance and Abstract classes }
    >Classes Admin and Visitor implement interface User. { Interfaces and Polymorphism }
    >Class SpecialDeal extends Discount class and calls its parent's class's constructor in its constructor using super(). { Inheritance }
    >Object class's toString() method is overridden in classes Amphibian, Reptile, Mammal, Event, Discount, SpecialDeal. { Object Class }
    >Object class's Object.equals() method is used at various places for checking equality between objects. { Object Class }
    >ArrayList<Object> specialDeals is created in zoo and whenever its element is accessed that element is typecasted to type SpecialDeal. { Object Class }

FLOW OF EXECUTION:
    >Main creates a zoo name ZOOtopia and calls menu function from class Zoo.
    >menu() function has four choices and calls adminMenu() and enterAsVisitor methods from the same class for choice 1 and 2 respectively.
        # adminMenu() method has eight choices and calls methods from the Admin class for the respective choices.
        # enterAsVisitor() has three options- 1.Register, 2. Login, 3.Exit
            * second option calls visitorMenu() method from the same class Zoo.
            * visitorMenu() has ten choices and calls methods from the Visitor class for the respective choices.
            * choice 10 in visitorMenu() takes the user back to enterAsVisitor().
        # choice 3 in enterAsVisitor takes the user back to menu().
        # choice 8 in adminMenu() takes the user back to menu().
    > choice 4 in menu() terminates the ZooBuddies application.