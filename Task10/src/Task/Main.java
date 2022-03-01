package Task;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*List<Person> people = new ArrayList<>();
        people.add(new Person("Olya", 15));
        people.add(new Person("Otya", 17));
        people.add(new Person("Kolya", 11));

        System.out.println(people);
        Collections.sort(people, new PersonNameLengthComparator());
        System.out.println(people);

        *//*
        // Сортировка
        List<String> names = new ArrayList<>();
        names.add("Olya");
        names.add("Petya");
        names.add("Sveta");
        names.add("Kostya");
        System.out.println(names);

        Collections.sort(names);
        System.out.println(names);*/
        /*String[] arr = new String[5];

        Map<String, Person> map = new HashMap<>();
        map.put("eke", new Person("Gosha", 45));
        map.put("lol", new Person("Lolita", 78));
        map.put("tyt", new Person("Grisha", 17));
        map.put("kee", new Person("Anastasia", 23));

        Person p = map.get("lol");
        System.out.println(p);*/
        /*String text = "hello go my to friends to hello";
        Map<String, Integer> fregs = new TreeMap<>();
        //Map<String, Integer> fregs = new HashMap<>();
        for (String word : text.split(" ")) {
            if (fregs.containsKey(word)) {
                fregs.put(word, fregs.get(word) + 1);
            } else {
                fregs.put(word, 1);
            }
        }
        //System.out.println(fregs);

        for (String wors : fregs.keySet()) {
            int freg = fregs.get(wors);
            System.out.println("Slovo " + wors + " vstretilos " + freg + " raz");
        }
        System.out.println("sdfoiuyhj".hashCode());*/
        Set<String> names = new HashSet<>();
        names.add("Tolya");
        names.add("Zjenya");
        names.add("Petya");
        names.add("Wilyams");

        if (names.contains("Petya")) {
            System.out.println("Nashli doljznika!");
        }
    }
}
