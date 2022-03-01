import java.io.*;

public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String name;
    private final int age;
    private final double salary;
    private final double propertyValue;
    private transient File file;

    public Client(String name, int age, double salary, double propertyValue) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.propertyValue = propertyValue;
    }

    public static Client loadFromFile(File file) {
        FileInputStream fileInputStream = null;
        ObjectInputStream iStream = null;
        Client client;
        try {
            fileInputStream = new FileInputStream(file);
            iStream = new ObjectInputStream(fileInputStream);
            client = (Client) iStream.readObject();
            client.connectToFile(file);
        } catch (Exception e) {
            throw new RuntimeException("Произошла ошибка при выводе: " + e);
        } finally {
            try {
                if (iStream != null) {
                    iStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (Exception e) {
                throw new RuntimeException("При завершении произошла ошибка: " + e);
            }
        }
        return client;
    }

    public void save() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            throw new RuntimeException("Произошла ошибка при сохранении: " + e);
        }
    }

    public void connectToFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", propertyValue=" + propertyValue +
                '}';
    }
}
