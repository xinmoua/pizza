import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
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
    private String pizzaSize;
    private String extraCheese;
    private String sideDish;
    private String birthdate;
    private Long blacklistedNumber = 24745321139078L;
    private String cardNumberToDisplay;
    private int birthture;

    private static final String DEF_ORDER_ID = "DEF-SOH-099";
    private static final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    private static final double DEF_ORDER_TOTAL = 15.00;

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

    static Scanner scan = new Scanner(System.in);
    public void takeOrder() {
        System.out.println("Enter three ingredients for your pizza (use spaces to separate ingredients):");
        String str1 = "";
        if (scan.hasNextLine()) {
           str1 = scan.nextLine();
        }
        String[] str2 = str1.split(" ");
        this.ing1 = str2[0];
        this.ing2 = str2[1];
        this.ing3 = str2[2];

        System.out.println("Enter size of pizza (Small, Medium, Large):");
        String str3 = "";
        if (scan.hasNextLine()) {
            str3 = scan.nextLine();
         }
        this.pizzaSize = str3;
        
        System.out.println("Do you want extra cheese (Y/N):");
        String str4 = "";
        if (scan.hasNextLine()) {
            str4 = scan.nextLine();
         }
        this.extraCheese = str4;
        
        System.out.println("Enter one side dish (Calzone, Garlic bread, None):");
        String str5 = "";
        if (scan.hasNextLine()) {
            str5 = scan.nextLine();
         }
        this.sideDish = str5;
      
        System.out.println("Enter drinks(Cold Coffee, Cocoa drink, Coke, None):");
        String str6 = "";
        if (scan.hasNextLine()) {
            str6 = scan.nextLine();
         }
        this.drinks = str6;

        System.out.println("Would you like the chance to pay only half for your order? (Y/N)：");
        String str7 = "";
        if (scan.hasNextLine()) {
            str7 = scan.nextLine();
         }
        if(str7.equals("Y") || str7.equals("y")){
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
        printReceipt();
    }

    public void isItYourBirthday(){
        System.out.println("What is the day of your birth?(use spaces to '-')\n(Enter in the order of year, month, and day)");
        String str8 = "";
        if (scan.hasNextLine()) {
            str8 = scan.nextLine();
         }
         this.birthdate = str8;
         String[] str9 = str8.split("-");
         String d1 = str9[0];
         String d2 = str9[1];
         String d3 = str9[2];
         int date1 = Integer.parseInt(str9[0]);
         int date2 = Integer.parseInt(str9[1]);
         int date3 = Integer.parseInt(str9[2]);

         LocalDate today = LocalDate.now();
         LocalDate someDay = LocalDate.of(date1,date2,date3);
         Period diff = Period.between(someDay, today);
         int age = diff.getYears();
         int month1 =  today.getMonthValue();
         int day1 = today.getDayOfMonth();
         this.birthture = 10000*(date2 - month1) + (date3 - day1);
         System.out.println(age +" "+ month1 +" " + day1 + " " +date2 +" " + date3 +" " +birthture);
         if(age < 18 && birthture == 0){
            System.out.println("Congratulations! You pay only half the price for your order");
         }else{
            System.out.println("Too bad! You do not meet the conditions to get our 50% discount");
         }
    }

    public void makeCardPayment(){
        System.out.println("Please enter your card number:");
        String str1 = "";
        if (scan.hasNextLine()) {
            str1 = scan.nextLine();
         }
        this.cardNumber = Long.parseLong(str1);

        System.out.println("Please enter your card’s expiry date:\n(use spaces to '-')(Enter in the order of year, month)");
        String str2 = "";
        if (scan.hasNextLine()) {
            str2 = scan.nextLine();
         }
         this.expiryDate = str2;
         System.out.println("Please enter your card’s cvv number:(three digits long)");
         String str3 = "";
        if (scan.hasNextLine()) {
            str3 = scan.nextLine();
         }
         String cv = str3.substring(0,3);
         this.cvv = Integer.parseInt(cv);
    }

    private void makePizza() {
        
    }


    public void processCardPayment(){
        String number = Long.toString(cardNumber);
        String blackCard = Long.toString(blacklistedNumber);
        if(number.length() != 14){
            System.out.println("Invalid card");
        }else{
            if(number.equals(blackCard)){
                System.out.println("Card is blacklisted. Please use another card");
            }else{
            System.out.println("Card accepted");
            char[] cardarray = number.toCharArray();
            int firstCardDigit = cardarray[0] - '0';
            String bString = number.substring(10);
            int lastFourDigits = Integer.parseInt(bString);
            this.cardNumberToDisplay = cardarray[0] + "*********" + bString;
            }
        }
    }
    public void specialOfTheDay(StringBuffer pizzaOfTheDay,StringBuffer sideOfTheDay,String specialPrice){
        System.out.println(pizzaOfTheDay);
        System.out.println(sideOfTheDay);
        System.out.println(specialPrice);
    }

    private void printReceipt() {
        System.out.println("********RECEIPT********");
        System.out.println("cardNumber :" + cardNumberToDisplay);
        System.out.println("cvvNumber :" + cvv);
        System.out.println("Order ID: " + orderID);
        System.out.println("Order pizzaIngredients: " + ing1 + " " + ing2 + " " + ing3 +" " + pizzaIngredients);
        System.out.println("Order size of pizza:" + pizzaSize);
        System.out.println("Order extra cheese(Y/N):" + extraCheese);
        System.out.println("Order sides: " + sideDish );
        System.out.println("Order drinks: " + drinks);
        System.out.println("Order pizzaPrice: " + pizzaPrice);
        if(birthture == 0){
            System.out.println("Order Total: " + orderTotal/2);
        }else{
            System.out.println("Order Total: " + orderTotal);
        }
    }
}