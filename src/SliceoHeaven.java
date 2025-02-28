public class SliceoHeaven {
    public String storeName;
    public String storeAddress;
    public String storeEmail;
    public long storePhone;
    private String storeMenu;

    public String pizzaIngredients;
    private double pizzaPrice;
    private String sides;
    private String drinks;

    private String orderID;
    private double orderTotal;

    private static final String DEF_ORDER_ID = "DEF-SOH-099";
    private static final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    private static final double DEF_ORDER_TOTAL = 15.00;

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

    public String getStoreMenu() {
        return storeMenu;
    }

    public void setStoreMenu(String storeMenu) {
        this.storeMenu = storeMenu;
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