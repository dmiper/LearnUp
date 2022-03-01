import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ContactsBook contactsBook = new ContactsBook();
        contactsBook.add(new Contact("Василий Петрович", "2-111-111"));
        contactsBook.add(new Contact("Колян", "2-222-222"));
        contactsBook.add(new Contact("Ольга Васильевна", "2-333-333"));
        contactsBook.add(new Contact("Бывший", "2-444-444"));
        contactsBook.add(new Contact("Отчим", "2-555-555"));
        contactsBook.add(new Contact("Мама друга", "2-666-666"));
        contactsBook.add(new Contact("Мамуля", "2-777-777"));

        numberSearch(contactsBook);

        deletingNumber(contactsBook);
    }

    public static void numberSearch(ContactsBook contactsBook) {
        String phoneNumber = scanner();
        Contact contact = contactsBook.getByPhone(phoneNumber);
        if (contact != null) {
            System.out.println("Имя контакта: " + contact.getName() + " с номером: " + contact.getPhoneNumber());
        } else {
            System.err.println("Контакта с таким номером у нас нет!");
        }
    }

    public static void deletingNumber(ContactsBook contactsBook) {
        String phoneNumber = scanner();
        contactsBook.removeByPhone(phoneNumber);
    }

    private static String scanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер контакта:");
        return scanner.nextLine();
    }
}
