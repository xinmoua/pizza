public class App {
    public static void main(String[] args) throws Exception {
        SliceoHeaven sliceoheaven = new SliceoHeaven();
        sliceoheaven.processCardPayment("23141255731275", null, 0);
        sliceoheaven.takeOrder("56","Mozzarella Cheese",140.00,"salad","coke",120);
        sliceoheaven.specialOfTheDay(null, null, null);
    }
}
