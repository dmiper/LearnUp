import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactsBook contactsBook = new ContactsBook()
                .add(new Contact("Василий Петрович", "2-111-111"))
                .add(new Contact("Колян", "2-222-222"))
                .add(new Contact("Ольга Васильевна", "2-333-333"))
                .add(new Contact("Бывший", "2-444-444"))
                .add(new Contact("Отчим", "2-555-555"))
                .add(new Contact("Мама друга", "2-666-666"))
                .add(new Contact("Мамуля", "2-777-777"));

        System.out.println(contactsBook.sortingByName());

        // Прошлое ДЗ
        /*numberSearch(contactsBook);

        deletingNumber(contactsBook);*/

        System.out.println("Введите имя/часть имени контакта, для поиска:");
        String contactSearch = scanner.nextLine();
        List<Contact> listContactSearch = contactsBook.searchBy(task -> task.getName().contains(contactSearch));
        System.out.println(listContactSearch.isEmpty() ? "Контактов таких нет!" : "Мы нашли такой/ие контакт/ы " + listContactSearch);

        System.out.println("Введите часть имени со *:");
        String partTheName = scanner.nextLine();
        List<Contact> listPartTheName = contactsBook.searchBy(partTheName);
        System.out.println(listPartTheName.isEmpty() ? "Контактов таких нет!" : "Мы нашли такой/ие контакт/ы " + listPartTheName);
    }

    public static void numberSearch(ContactsBook contactsBook) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер контакта который хотите найти:");
        Contact contact = contactsBook.getByPhone(scanner.nextLine());
        System.out.println(contact == null ? "Контакта с таким номером у нас нет!" : "Имя контакта: " + contact.getName() + " с номером: " + contact.getPhoneNumber());
    }

    public static void deletingNumber(ContactsBook contactsBook) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер контакта который хотите удалить:");
        contactsBook.removeByPhone(scanner.nextLine());
    }
}
