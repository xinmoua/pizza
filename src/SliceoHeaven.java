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
        System.out.println("Please pick any three of the following ingredients:");
        System.out.println("1. Mushroom");
        System.out.println("2. Paprika");
        System.out.println("3. Sun-dried tomatoes");
        System.out.println("4. Chicken");
        System.out.println("5. Pineapple");
        System.out.println("Enter any three choices (1, 2, 3,…) separated by spaces:");
        String str = "";
        int a = 0;
        while(a == 0){
        if (scan.hasNextLine()) {
           str = scan.nextLine();
        }
        String[] str2 = str.split(" ");
        for(int b = 0;b < 3;b++){
            int c = 0;
            switch (str2[b]) {
                case "1":
                break;
                case "2":
                break;
                case "3":
                break;
                case "4":
                break;
                case "5":
                break;
                default:
                System.out.println("Invalid choice(s). Please pick only from the given list:");
                c = 1;
                break;
            }
            if(c == 1){
                break;
            }
            if(b == 2){
                a = 1;
            }

        }
        this.ingChoice1 = Integer.parseInt(str2[0]);
        this.ingChoice2 = Integer.parseInt(str2[1]);
        this.ingChoice3 = Integer.parseInt(str2[2]);
        this.ing1 = switch(str2[0]){
            case "1" -> "Mushroom";
            case "2" -> "Paprika";
            case "3" -> "Sun-dried tomatoes";
            case "4" -> "Chicken";
            case "5" -> "Pineapple";
            default -> "";
        };
        this.ing2 = switch(str2[1]){
            case "1" -> "Mushroom";
            case "2" -> "Paprika";
            case "3" -> "Sun-dried tomatoes";
            case "4" -> "Chicken";
            case "5" -> "Pineapple";
            default -> "";
        };
        this.ing3 = switch(str2[2]){
            case "1" -> "Mushroom";
            case "2" -> "Paprika";
            case "3" -> "Sun-dried tomatoes";
            case "4" -> "Chicken";
            case "5" -> "Pineapple";
            default -> "";
        };
    }

        System.out.println("What size should your pizza be?");
        System.out.println("1. Large");
        System.out.println("2. Medium");
        System.out.println("3. Small");
        System.out.println("Enter only one choice (1, 2, or 3):");;
        int a2 = 0;
        while(a2 == 0){
            if (scan.hasNextLine()) {
            str = scan.nextLine();
         }
         switch(str){
            case "1":
            a2 = 1;
            break;
            case "2":
            a2 = 1;
            break;
            case "3":
            a2 = 1;
            break;
            default:
            System.out.println("Invalid choice(s). Please pick only from the given list:");
            break;
         }
         this.sizeChoice = Integer.parseInt(str);
         this.pizzaSize = switch(str){
            case "1" -> "Large";
            case "2" -> "Medium";
            case "3" -> "Small";
            default -> "";
        };
    }

        System.out.println("Do you want extra cheese (Y/N):");
        if (scan.hasNextLine()) {
            str = scan.nextLine();
         }
        this.extraCheese = str;
        
        System.out.println("Following are the side dish that go well with your pizza:");
        System.out.println("1. Calzone");
        System.out.println("2. Garlic bread");
        System.out.println("3. Chicken puff");
        System.out.println("4. Muffin");
        System.out.println("5. Nothing for me");
        System.out.println("What would you like? Pick one (1, 2, 3,…):");
        int a3 = 0;
        while(a3 == 0){
            if (scan.hasNextLine()) {
            str = scan.nextLine();
         }
         switch(str){
            case "1":
            a3 = 1;
            break;
            case "2":
            a3 = 1;
            break;
            case "3":
            a3 = 1;
            break;
            case "4":
            a3 = 1;
            break;
            case "5":
            a3 = 1;
            break;
            default:
            System.out.println("Invalid choice(s). Please pick only from the given list:");
            break;
         }
         this.sideDishChoice = Integer.parseInt(str);
         this.sideDish = switch(str){
            case "1" -> "Calzone";
            case "2" -> "Garlic bread";
            case "3" -> "Chicken puff";
            case "4" -> "Muffin";
            case "5" -> "Nothing for me";
            default -> "";
        };
    }

        System.out.println("Choose from one of the drinks below. We recommend Coca Cola:");
        System.out.println("1. Coca Cola");
        System.out.println("2. Cold coffee");
        System.out.println("3. Cocoa Drink");
        System.out.println("4. No drinks for me");
        System.out.println("Enter your choice:");
        int a4 = 0;
        while(a4 == 0){
            if (scan.hasNextLine()) {
            str = scan.nextLine();
         }
         switch(str){
            case "1":
            a4 = 1;
            break;
            case "2":
            a4 = 1;
            break;
            case "3":
            a4 = 1;
            break;
            case "4":
            a4 = 1;
            break;
            default:
            System.out.println("Invalid choice(s). Please pick only from the given list:");
            break;
         }
         this.drinkChoice = Integer.parseInt(str);
         this.drinks = switch(str){
            case "1" -> "Coca Cola";
            case "2" -> "Cold coffee";
            case "3" -> "Cocoa Drink";
            case "4" -> "No drinks for me";
            default -> "";
        };
    }
        

        System.out.println("Would you like the chance to pay only half for your order? (Y/N)：");
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
         Period diff = Period.between(today,someDay);
         int year = diff.getYears();
         int month = diff.getMonths();
         int day = diff.getDays();
         if(year > 0){
            a = 1;
         }else{
            if(year == 0){
                if(month > 0){
                    a = 1;
                }else{
                    if(month == 0){
                        if(day > 0){
                            a = 1;
                        }else{
                            System.out.println("Please enter the correct date!");
                        }
                    }else{
                        System.out.println("Please enter the correct date!");
                    }
                }
            }else{
                System.out.println("Please enter the correct date!");
            }
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
        return "********RECEIPT********" + "\n" +
        "cardNumber :" + cardNumberToDisplay + "\n" +
        "cvvNumber :" + cvv + "\n" +
        "Order ID: " + orderID + "\n" +
        "Order pizzaIngredients: " + ing1 + " " + ing2 + " " + ing3 +" " + pizzaIngredients + "\n" +
        "Order size of pizza:" + pizzaSize + "\n" +
        "Order extra cheese(Y/N):" + extraCheese + "\n" +
        "Order sides: " + sideDish + "\n" +
        "Order drinks: " + drinks + "\n" +
        "Order pizzaPrice: " + pizzaPrice + "\n" +
        "Order Total: " + orderTotal + "\n";
    }
}