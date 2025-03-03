public class SliceoHeaven {
    public String storeName;
    public String storeAddress;
    public String storeEmail;
    public long storePhone;
    public String storeMenu;

    private String pizzaIngredients;
    private double pizzaPrice;
    private String sides;
    private String drinks;

    private String orderID;
    private double orderTotal;

    private String cardNumber;
    private String expiryDate;
    private int cvv;


    private static final String DEF_ORDER_ID = "DEF-SOH-099";
    private static final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    private static final double DEF_ORDER_TOTAL = 15.00;
    public static final String BLACKLISTED_CARD = "24745321139078";

    public SliceoHeaven() {
        this.orderID = DEF_ORDER_ID;
        this.pizzaIngredients = DEF_PIZZA_INGREDIENTS;
        this.orderTotal = DEF_ORDER_TOTAL;
        this.sides = "";
        this.drinks = "";
    }

    public SliceoHeaven(String orderID, String pizzaIngredients, double orderTotal) {
        this.orderID = orderID;
        this.pizzaIngredients = pizzaIngredients;
        this.orderTotal = orderTotal;
        this.sides = "";
        this.drinks = "";
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

    public void takeOrder(String id, String piin, double total, String side, String drink, double pPrice) {
        pizzaIngredients = piin;
        orderID = id;
        orderTotal = total;
        sides = side;
        drinks = drink;
        pizzaPrice = pPrice;
        
        System.out.println("Order accepted!");
        System.out.println("Order is being prepared");

        try {
            Thread.sleep(5000);
            makePizza(piin);
        } catch (InterruptedException e) {
            System.out.println("Order is ready for pickup!");
        }

        System.out.println("Your order is ready!");
        printReceipt();
    }

    private void makePizza(String piin) {
        pizzaIngredients = piin;
    }
    public void processCardPayment(String cardNumber,String expiryDate,int cvv){
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        if(cardNumber.length() != 14){
            System.out.println("Invalid card");
        }else{
            if(cardNumber.equals(BLACKLISTED_CARD)){
                System.out.println("Card is blacklisted. Please use another card");
            }else{
            System.out.println("Card accepted");
            char[] cardarray = cardNumber.toCharArray();
            int firstCardDigit = cardarray[0] - '0';
            String bString = cardNumber.substring(10);
            int lastFourDigits = Integer.parseInt(bString);
            String cardNumberToDisplay = cardarray[0] + "*********" + bString;
            System.out.println(cardNumberToDisplay);
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
        System.out.println("Order ID: " + orderID);
        System.out.println("Order pizzaIngredients: " + pizzaIngredients);
        System.out.println("Order sides: " + sides);
        System.out.println("Order drinks: " + drinks);
        System.out.println("Order pizzaPrice: " + pizzaPrice);
        System.out.println("Order Total: " + orderTotal);
    }
}