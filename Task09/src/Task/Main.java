package Task;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*
        //1 пример
        Task.Picker<String> picker = new Task.Picker<String>("Привет", "Мир", 0.1);
        String picked = picker.pick();
        System.out.println(picked);

        //Task.Picker<Task.Person> p = new Task.Picker<Task.Person>(null, null, 0.5);

        String s = pick("Hello", "World", 0.1);
    }

    public static <T> T pick(T first, T second, double firstProb) {
        if (Math.random() <= firstProb) {
            return first;
        } else {
            return second;
        }*/

        //String[] arr = new String[5];

        ArrayList<String> list = new ArrayList<String>();
        list.add("Kolya");
        list.add("Olya");
        list.set(1, "Tolya");
        System.out.println(list);
    }
}
