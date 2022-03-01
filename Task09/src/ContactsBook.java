import java.util.ArrayList;

public class ContactsBook {
    private final ArrayList<Contact> contacts = new ArrayList<>();

    public void removeByPhone(String phone) {
        Contact contactRemove = null;
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(phone)) {
                contactRemove = contact;
                break;
            }
        }
        if (contactRemove == null) {
            throw new RuntimeException("Контакта с таким номером у нас нет!");
        }
        System.out.println("Клиент с номером " + phone + " удален.");
        contacts.remove(contactRemove);
    }

    public void add(Contact contact) {
        contacts.add(contact);
    }

    public Contact getByPhone(String phone) {
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(phone)) {
                return contact;
            }
        }
        return null;
    }
}
