package Task;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Task.PersonBuilder builder = new Task.PersonBuilder();
        builder.setName("Pertya");
        builder.setAge(20);
        Task.Person person = builder.build();

    }
}
