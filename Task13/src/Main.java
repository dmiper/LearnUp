import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) throws Exception {
        /*String line = "";
        person = parser.parse(line, Person.class);*/
        //Person person = new Person();
        //System.out.println(person);

        // V1
        //Class<Person> clazz = Person.class;

        // V2
        //Class<Person> clazz = (Class<Person>) forName("Person");
        Class<Person> clazz = Person.class;
        Constructor<Person> constructor = clazz.getConstructor(String.class, int.class);
        Person person1 = constructor.newInstance("Petya", 14);
        System.out.println(person1);

        Field ageField = clazz.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(person1, 20);
        System.out.println(person1);
        int ans = max(11, 5, 3, 15, 95);
    }

    public static int max(int ... values) {
        int max = values[0];
        for (int value : values) {
            if (max < value) {
                max = value;
            }
        }
        return max;
    }
}
