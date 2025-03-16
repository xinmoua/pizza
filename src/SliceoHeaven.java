import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class SliceoHeaven {
    public String storeName;
    public String storeAddress;
    public String storeEmail;
    public long storePhone;
    public String storeMenu;

    private String pizzaIngredients;
    private double pizzaPrice = 12.00;
    private String sides;
    private String drinks;

    private String orderID;
    private double orderTotal;

    private long cardNumber;
    private String expiryDate;
    private int cvv;
    
    private String ing1;
    private String ing2;
    private String ing3;

    private int ingChoice1;
    private int ingChoice2;
    private int ingChoice3;
    private int sizeChoice;
    private int sideDishChoice;
    private int drinkChoice;

    private String pizzaSize;
    private String extraCheese;
    private String sideDish;
    private String birthdate;
    private Long blacklistedNumber = 24745321139078L;
    private String cardNumberToDisplay;
    private int birthture;

    private double totalOrderPrice = 0;
    
    private String[] pizzasOrdered = new String[10];
    private String[] pizzaSizesOrdered = new String[10];
    private String[] sideDishesOrdered = new String[10];
    private String[] drinksOrdered = new String[20];

    private static final String DEF_ORDER_ID = "DEF-SOH-099";
    private static final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    private static final double DEF_ORDER_TOTAL = 15.00;
    private static final double PIZZA_BASE_PRICE = 10.00;

    public SliceoHeaven() {
        this.orderID = DEF_ORDER_ID;
        this.pizzaIngredients = DEF_PIZZA_INGREDIENTS;
        this.orderTotal = DEF_ORDER_TOTAL;
    }

    public String getpizzaIngredients() {
        return pizzaIngredients;
    }

    public void setpizzaIngredients(String pizzaIngredients) {
        this.pizzaIngredients = pizzaIngredients;
    }

    public double getPizzaPrice() {
        return pizzaPrice;
    }

    public void setPizzaPrice(double pizzaPrice) {
        this.pizzaPrice = pizzaPrice;
    }

    public String getSides() {
        return sides;
    }

    public void setSides(String sides) {
        this.sides = sides;
    }

    public String getDrinks() {
        return drinks;
    }

    public void setDrinks(String drinks) {
        this.drinks = drinks;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    enum PizzaSelection{
        PEPPERONI("Pepperoni", "Lots of pepperoni and extra cheese", 18),
        HAWAIIAN("Hawaiian", "Pineapple, ham, and extra cheese", 22),
        VEGGIE("Veggie", "Green pepper, onion, tomatoes, mushroom, and black olives", 25),
        BBQ_CHICKEN("BBQ Chicken", "Chicken in BBQ sauce, bacon, onion, green pepper,and cheddar cheese", 35),
        EXTRAVAGANZA("Extravaganza", "Pepperoni, ham, Italian sausage, beef, onions,green pepper, mushrooms, black olives, and extra cheese", 45);
        String pizzaName;
        String pizzaToppings;
        double price;
        private PizzaSelection(String pizzaName,String pizzaToppings,int price){
            this.pizzaName = pizzaName;
            this.pizzaToppings = pizzaToppings;
            this.price = price;
        }
        public String getPizzaName(){
            return this.pizzaName;
        }
        public String getPizzaToppings(){
        return this.pizzaToppings;
        }
        public double getPrice(){
            return this.price;
        }
        public String toString(){
            return this.pizzaName + " with " + this.pizzaToppings + ":€" + this.price;
        }
    }
    enum PizzaToppings{
        HAM("Ham", 2), 
        PEPPERONI("Pepperoni", 2),
        BEEF("Beef", 2),
        CHICKEN("Chicken", 2), 
        SAUSAGE("Sausage", 2),
        PINEAPPLE("Pineapple", 1),
        ONION("Onion", 0.5), 
        TOMATOES("Tomatoes", 0.4), 
        GREEN_PEPPER("Green Pepper", 0.5), 
        BLACK_OLIVES("Black Olives", 0.5), 
        SPINACH("Spinach", 0.5), 
        CHEDDAR_CHEESE("Cheddar Cheese", 0.8), 
        MOZZARELLA_CHEESE("Mozzarella Cheese", 0.8), 
        FETA_CHEESE("Feta Cheese", 1), 
        PARMESAN_CHEESE("Parmesan Cheese", 1);
        String topping;
        double toppingPrice;
        private PizzaToppings(String topping,double toppingPrice){
            this.topping = topping;
            this.toppingPrice = toppingPrice;
        }
        public String getTopping(){
            return this.topping;
        }
        public double getToppingPrice(){
            return this.toppingPrice;
        }
        public String toString(){
            return this.topping  + ":€" +this.toppingPrice;
        }
    }
    enum PizzaSize{
        LARGE("Large", 10), 
        MEDIUM("Medium", 5),
        SMALL("Small", 0);
        String pizzaSize;
        double addToPizzaPrice;
        private PizzaSize(String pizzaSize,int addToPizzaPrice){
            this.pizzaSize = pizzaSize;
            this.addToPizzaPrice = addToPizzaPrice;
        }
        public String getPizzaSize(){
            return this.pizzaSize;
        }
        public double getAddToPizzaPrice(){
            return this.addToPizzaPrice;
        }
        public String toString(){
            return this.pizzaSize + ":€" + this.addToPizzaPrice;
        }
    }
    enum SideDish{
        CALZONE("Calzone", 15), 
        CHICKEN_PUFF("Chicken Puff", 20),
        MUFFIN("Muffin", 12),
        NOTHING("No side dish", 0);
        String sideDishName;
        double addToPizzaPrice;
        private SideDish(String sideDishName,int addToPizzaPrice){
            this.sideDishName = sideDishName;
            this.addToPizzaPrice = addToPizzaPrice;
        }
        public String getSideDishName(){
            return this.sideDishName;
        }
        public double getAddToPizzaPrice(){
            return this.addToPizzaPrice;
        }
        public String toString(){
            return this.sideDishName + ":€" + this.addToPizzaPrice;
        }
    }
    enum Drinks{
        COCA_COLA("Coca Cola", 8), 
        COCOA_DRINK("Cocoa Drink", 10),
        NOTHING("No drinks", 0);
        String  drinkName;
        double addToPizzaPrice;
        private Drinks(String drinkName,int addToPizzaPrice){
            this.drinkName = drinkName;
            this.addToPizzaPrice = addToPizzaPrice;
        }
        public String getDrinkName(){
            return this.drinkName;
        }
        public double getAddToPizzaPrice(){
            return this.addToPizzaPrice;
        }
        public String toString(){
            return this.drinkName +  ":€" + this.addToPizzaPrice;
        }
    }
    static Scanner scan = new Scanner(System.in);
    private int number = 0;
    public void takeOrder() {
        int right = 0;
        while(right == 0){
        {int a = 1;
        for(PizzaSelection pizzaSelection : PizzaSelection.values()){
            System.out.print(a + ".");
            System.out.println(pizzaSelection.toString());
            a++;
        }}
        System.out.println("6. Custom Pizza with a maximum of 10 toppings that you choose");
        System.out.println("Please enter your choice (1 - 6):");
        String str = ""; 
        {int aa = 0;
            while( aa == 0){
        if (scan.hasNextLine()){
            str = scan.nextLine();
        }
        switch(str){
            case "1":
            PizzaSelection p1 = PizzaSelection.PEPPERONI;
            this.pizzasOrdered[number] = p1.toString();
            this.totalOrderPrice += p1.price;
            aa = 1;
            break;
            case "2":
            PizzaSelection p2 = PizzaSelection.HAWAIIAN;
            this.pizzasOrdered[number] = p2.toString();
            this.totalOrderPrice += p2.price;
            aa = 1;
            break;
            case "3":
            PizzaSelection p3 = PizzaSelection.VEGGIE;
            this.pizzasOrdered[number] = p3.toString();
            this.totalOrderPrice += p3.price;
            aa = 1;
            break;
            case "4":
            PizzaSelection p4 = PizzaSelection.BBQ_CHICKEN;
            this.pizzasOrdered[number] = p4.toString();
            this.totalOrderPrice += p4.price;
            aa = 1;
            break;
            case "5":
            PizzaSelection p5 = PizzaSelection.EXTRAVAGANZA;
            this.pizzasOrdered[number] = p5.toString();
            this.totalOrderPrice += p5.price;
            aa = 1;
            break;
            case "6":
            {int a = 1;
            for(PizzaToppings pizzaToppings : PizzaToppings.values()){
                System.out.print(a + ".");
                System.out.println(pizzaToppings.toString() + " ");
                a++;
            }}
            System.out.println("enter a maximum of 10 choices(Separate with spaces)(Enter only the numbers)");
            if (scan.hasNextLine()) {
                str = scan.nextLine();
            }
            String[] str1 = str.split(" ",0);
            int length = str1.length;
            double oneprice = 0;
            String pizzasOrdereds1 = null;
            String pizzasOrdereds2 = null;
            String pizzasOrdereds3 = null;
            PizzaToppings[] pizzaToppings = PizzaToppings.values();
            for(int a = 0;a < length;a++){
                int b = Integer.parseInt(str1[a]);
                pizzasOrdereds1 = pizzaToppings[b - 1].topping + ",";
                pizzasOrdereds2 = pizzasOrdereds3; 
                pizzasOrdereds3 = pizzasOrdereds2 + pizzasOrdereds1;
                oneprice += pizzaToppings[b - 1].toppingPrice;
            }
            this.totalOrderPrice += PIZZA_BASE_PRICE + oneprice;
            this.pizzasOrdered[number] = "Custom Pizza with " + pizzasOrdereds3 + ":€" + (PIZZA_BASE_PRICE + oneprice);
            aa = 1;
            break;
            default:
            System.out.println("Please enter valid content");
            break;
        }
    }}

        System.out.println("What size should your pizza be?");
        {int a = 1;
        for(PizzaSize PizzaSize : PizzaSize.values()){
            System.out.print(a + ".");
            System.out.println(PizzaSize.toString());
            a++;
        }}
        System.out.println("Enter only one choice (1, 2, or 3):");
        {int a = 0;
            PizzaSize[] pizzaSize = PizzaSize.values();
        while(a == 0){
            if (scan.hasNextLine()) {
            str = scan.nextLine();
         }
         switch(str){
            case "1":
            this.totalOrderPrice += pizzaSize[0].addToPizzaPrice; 
            this.pizzaSizesOrdered[number] = pizzaSize[0].toString();
            a = 1;
            break;
            case "2":
            this.totalOrderPrice += pizzaSize[1].addToPizzaPrice; 
            this.pizzaSizesOrdered[number] = pizzaSize[1].toString();
            a = 1;
            break;
            case "3":
            this.totalOrderPrice += pizzaSize[2].addToPizzaPrice; 
            this.pizzaSizesOrdered[number] = pizzaSize[2].toString();
            a = 1;
            break;
            default:
            System.out.println("Invalid choice(s). Please pick only from the given list:");
            break;
         }
    }}

        System.out.println("Do you want extra cheese (Y/N):");
        if (scan.hasNextLine()) {
            str = scan.nextLine();
         }
        this.extraCheese = str;
        
        System.out.println("Following are the side dish that go well with your pizza:");
        {int a = 1;
        for(SideDish sideDish : SideDish.values()){
            System.out.print(a + ".");
            System.out.println(sideDish.toString());
            a++;
        }}
        System.out.println("Enter only one choice (1, 2, 3, or 4):");
        {int a = 0;
            SideDish[] sideDish = SideDish.values();
        while(a == 0){
            if (scan.hasNextLine()) {
            str = scan.nextLine();
         }
         switch(str){
            case "1":
            this.totalOrderPrice += sideDish[0].addToPizzaPrice; 
            this.sideDishesOrdered[number] = sideDish[0].toString();
            a = 1;
            break;
            case "2":
            this.totalOrderPrice += sideDish[1].addToPizzaPrice; 
            this.sideDishesOrdered[number] = sideDish[1].toString();
            a = 1;
            break;
            case "3":
            this.totalOrderPrice += sideDish[2].addToPizzaPrice; 
            this.sideDishesOrdered[number] = sideDish[2].toString();
            a = 1;
            break;
            case "4":
            this.totalOrderPrice += sideDish[3].addToPizzaPrice; 
            this.sideDishesOrdered[number] = sideDish[3].toString();
            a = 1;
            break;
            default:
            System.out.println("Invalid choice(s). Please pick only from the given list:");
            break;
         }
    }}


        System.out.println("Choose from one of the drinks below. We recommend Coca Cola:");
        {int a = 1;
        for(Drinks drinks : Drinks.values()){
            System.out.print(a + ".");
            System.out.println(drinks.toString());
            a++;
        }}
        System.out.println("Enter only one choice (1, 2, or 3):");
        {int a = 0;
            Drinks[] drinks = Drinks.values();
        while(a == 0){
            if (scan.hasNextLine()) {
            str = scan.nextLine();
         }
         switch(str){
            case "1":
            this.totalOrderPrice += drinks[0].addToPizzaPrice; 
            this.drinksOrdered[number] = drinks[0].toString();
            a = 1;
            break;
            case "2":
            this.totalOrderPrice += drinks[1].addToPizzaPrice; 
            this.drinksOrdered[number] = drinks[1].toString();
            a = 1;
            break;
            case "3":
            this.totalOrderPrice += drinks[2].addToPizzaPrice; 
            this.drinksOrdered[number] = drinks[2].toString();
            a = 1;
            break;
            default:
            System.out.println("Invalid choice(s). Please pick only from the given list:");
            break;
         }
    }}
    System.out.println("Do you want to order another one ? (Y/N)");
    if (scan.hasNextLine()) {
        str = scan.nextLine();
     }
    if(str.equals("Y") || str.equals("y")){
        System.out.println("OK!");
        number++;
    }else{
        right = 1;
    }
}
        this.orderTotal = this.totalOrderPrice;
        String str = "";
        System.out.println("Would you like the chance to pay only half for your order? (Y/N):");
        if (scan.hasNextLine()) {
            str = scan.nextLine();
         }
        if(str.equals("Y") || str.equals("y")){
            isItYourBirthday();
        }

        makeCardPayment();
        processCardPayment();
        scan.close();
        
        System.out.println("Order accepted!");
        System.out.println("Order is being prepared");

        try {
            Thread.sleep(5000);
            makePizza();
        } catch (InterruptedException e) {
            System.out.println("Order is ready for pickup!");
        }

        System.out.println("Your order is ready!");
    }

    public void isItYourBirthday(){
        System.out.println("What is the day of your birth?(use spaces to '-')\n(Enter in the order of year, month, and day)");
        String str = "";
        int a = 0;
        int age = 0;
        int month1 = 0;
        int day1 = 0;
        int date2 = 0;
        int date3 = 0;
        while(a == 0){
        if (scan.hasNextLine()) {
            str = scan.nextLine();
         }
         this.birthdate = str;
         String[] str9 = str.split("-");
         int date1 = Integer.parseInt(str9[0]);
         date2 = Integer.parseInt(str9[1]);
         date3 = Integer.parseInt(str9[2]);

         LocalDate today = LocalDate.now();
         LocalDate someDay = LocalDate.of(date1,date2,date3);
         Period diff = Period.between(someDay, today);
         age = diff.getYears();
         month1 =  today.getMonthValue();
         day1 = today.getDayOfMonth();
         if(age <= 5 || age >= 120){
            System.out.println("Invalid date. You are either too young or too dead to order.");
            System.out.println("Please enter a valid date:");
         }else{
            a = 1;
         }
        }
         this.birthture = 10000*(date2 - month1) + (date3 - day1);
         //System.out.println(age +" "+ month1 +" " + day1 + " " +date2 +" " + date3 +" " +birthture);
         if(age > 5 && age < 18 && birthture == 0){
            System.out.println("Congratulations! You pay only half the price for your order");
            this.orderTotal = DEF_ORDER_TOTAL/2;
         }else{
            System.out.println("Too bad! You do not meet the conditions to get our 50% discount");
         }
    }

    public void makeCardPayment(){
        System.out.println("Please enter your card number:");
        String str = "";
        if (scan.hasNextLine()) {
            str = scan.nextLine();
         }
        this.cardNumber = Long.parseLong(str);

        System.out.println("Please enter your card’s expiry date:\n(use spaces to '-')(Enter in the order of year, month,day)");
        int a = 0;
        while(a == 0){
        if (scan.hasNextLine()) {
            str = scan.nextLine();
         }
         String[] str2 = str.split("-");
         int date1 = Integer.parseInt(str2[0]);
         int date2 = Integer.parseInt(str2[1]);
         int date3 = Integer.parseInt(str2[2]);
         LocalDate today = LocalDate.now();
         LocalDate someDay = LocalDate.of(date1,date2,date3);
         Long days = ChronoUnit.DAYS.between(today, someDay);
         if(days <= 0){
            System.out.println("Please enter the correct date!");
         }else{
            a = 1;
         }
         this.expiryDate = str;
        }
         System.out.println("Please enter your card’s cvv number:(three digits long)");
        if (scan.hasNextLine()) {
            str = scan.nextLine();
         }
         String cv = str.substring(0,3);
         this.cvv = Integer.parseInt(cv);
    }

    private void makePizza() {
        
    }


    public void processCardPayment(){
        int a = 0;
        String str = "";
        while(a == 0){
        String number = Long.toString(cardNumber);
        String blackCard = Long.toString(blacklistedNumber);
        if(number.length() != 14){
            System.out.println("Invalid card");
            System.out.println("Please enter right card number:");
            if (scan.hasNextLine()) {
                str = scan.nextLine();
            }
            this.cardNumber = Long.parseLong(str);
        }else{
            if(number.equals(blackCard)){
                System.out.println("Card is blacklisted. Please use another card");
                System.out.println("Please enter right card number:");
                if (scan.hasNextLine()) {
                    str = scan.nextLine();
                }
                this.cardNumber = Long.parseLong(str);
            }else{
            System.out.println("Card accepted");
            char[] cardarray = number.toCharArray();
            int firstCardDigit = cardarray[0] - '0';
            String bString = number.substring(10);
            int lastFourDigits = Integer.parseInt(bString);
            this.cardNumberToDisplay = cardarray[0] + "*********" + bString;
            a = 1;
            }
        }
    }
    }
    public void specialOfTheDay(StringBuffer pizzaOfTheDay,StringBuffer sideOfTheDay,String specialPrice){
        System.out.println(pizzaOfTheDay);
        System.out.println(sideOfTheDay);
        System.out.println(specialPrice);
    }

    public final String toString(){
        String string1 = null;
        String string2 = null;
        String string3 = null;
        for(int a = 0;a <= number;a++){
            string1 = (a + 1) + "." + pizzasOrdered[a] + "\n" +
            pizzaSizesOrdered[a] + "\n" +
            sideDishesOrdered[a] + "\n" +
            drinksOrdered[a];
            string2 = string3;
            string3 = string2 + "\n" + string1;
        }
        return "********RECEIPT********" + "\n" +
        "cardNumber :" + cardNumberToDisplay + "\n" +
        "cvvNumber :" + cvv + "\n" +
        "Order ID: " + orderID + string3 +
        "Thank you for dining with Slice-o-Heaven Pizzeria. Your order details are as follows:" + "\n" +
        "ORDER TOTAL:€" + orderTotal;
    }
}