import java.util.*;

public class ContactsBook {
    private final HashMap<String, Contact> contacts = new HashMap<>();

    public void removeByPhone(String phone) {
        if (contacts.containsKey(phone)) {
            contacts.remove(phone);
            System.out.println("Контакта с номером " + phone + " удален.");
        } else {
            throw new RuntimeException("Контакта с таким номером у нас нет!");
        }
    }

    public ContactsBook add(Contact contact) {
        contacts.put(contact.getPhoneNumber(), contact);
        return this;
    }

    public Contact getByPhone(String phone) {
        return contacts.get(phone);
    }

    public Collection<Contact> sortingByName() {
        List<Contact> list = new ArrayList<>(contacts.values());
        Collections.sort(list);
        return list;
    }
}
