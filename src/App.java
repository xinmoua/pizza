public class App {
    public static void main(String[] args) throws Exception {
        SliceoHeaven sliceoheaven = new SliceoHeaven();
        sliceoheaven.takeOrder();
        System.out.println(sliceoheaven);
        sliceoheaven.specialOfTheDay(null, null, null);
    }
}
