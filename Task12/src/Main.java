import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactsBook contactsBook = new ContactsBook()
                .add(new Contact("Василий Петрович", "+7-111-1111-111"))
                .add(new Contact("Колян", "+2-222-2222-222"))
                .add(new Contact("Ольга Васильевна", "+43-333-3333-333"))
                .add(new Contact("Бывший", "+7-444-4444-444"))
                .add(new Contact("Отчим", "+43-555-5555-555"))
                .add(new Contact("Мама друга", "+2-666-6666-666"))
                .add(new Contact("Мамуля", "+2-777-7777-777"));

        System.out.println(contactsBook.sortingByName());

        // Прошлое ДЗ
        /*numberSearch(contactsBook);

        deletingNumber(contactsBook);

        System.out.println("Введите имя/часть имени контакта, для поиска:");
        String contactSearch = scanner.nextLine();
        List<Contact> listContactSearch = contactsBook.searchBy(task -> task.getName().contains(contactSearch));
        System.out.println(listContactSearch.isEmpty() ? "Контактов таких нет!" : "Мы нашли такой/ие контакт/ы " + listContactSearch);

        System.out.println("Введите часть имени со *:");
        String partTheName = scanner.nextLine();
        List<Contact> listPartTheName = contactsBook.searchBy(partTheName);
        System.out.println(listPartTheName.isEmpty() ? "Контактов таких нет!" : "Мы нашли такой/ие контакт/ы " + listPartTheName);*/

        System.out.println("У нас имеются номера с кодами стран " + contactsBook.getCountries());
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
