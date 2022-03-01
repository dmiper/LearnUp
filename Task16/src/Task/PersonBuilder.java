package Task;

public class PersonBuilder {
    private String name;
    private int age = -1;

    public PersonBuilder() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Imia ne mojet bit NULL!");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Vozrast ne mojet bit menshe 0!" + age);
        }
        this.age = age;
    }

    public Person build() {
        if (name == null) {
            throw new IllegalStateException("Imia doljno bit zapolneno!");
        }
        if (age == -1) {
            throw new IllegalStateException("Vozrast doljno bit zapolneno!");
        }
        return new Person(name, age);
    }
}
