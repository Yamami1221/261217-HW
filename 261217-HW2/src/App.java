public class App {
    public static void main(String[] args) throws Exception {
        AdvanceDynamicArray test = new AdvanceDynamicArray(5);
        test.pushBack(1);
        test.pushBack(2);
        test.pushBack(3);
        System.out.println(test.get(0));
        System.out.println(test.popBack());
        test.printStructure();
    }
}
