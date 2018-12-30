package Map61B;

public class IterationDemo {
    public static void main(String[] args) {
        ArrayMap<String, Integer> m = new ArrayMap<String, Integer>();
        m.put("apple", 1);
        m.put("orange", 2);

        for (String s : m) {
            System.out.println(s);
        }
    }
}
