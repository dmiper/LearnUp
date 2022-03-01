import java.io.File;

public class Main {
    private static final String FILE_NAME = "client.ser";

    public static void main(String[] args) {
        Client client = new Client(
                "Я",
                25,
                29345.45,
                3248624.41);
        client.connectToFile(new File(FILE_NAME));
        client.save();
        System.out.println(Client.loadFromFile(new File(FILE_NAME)));

        client = Client.loadFromFile(new File(FILE_NAME));
        System.out.println(client);
        client.save();
    }
}
