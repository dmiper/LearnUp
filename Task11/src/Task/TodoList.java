package Task;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TodoList {
    private List<String> primary = new ArrayList<>();
    private List<String> secondary = new ArrayList<>();

    public void moveToSecondaryByCriteria(Predicate<String> criteria) {
        List<String> list = new ArrayList<>();
        for (String task : primary) {
            if (criteria.test(task)) {
                list.add(task);
            }
        }
        primary.removeAll(list);
        secondary.addAll(list);
    }

    /*public void moveSecondaryByTag(String tag) {
        // тот же код только с использованием предикатов
        List<String> list = primary
        .stream()
        .filter(task -> task.contains("#" + tag))
        .collect(Collectors.toList());

        List<String> list = new ArrayList<>();
        for (String task : primary) {
            if (task.contains("#" + tag)) {
                list.add(task);
            }
        }
        primary.removeAll(list);
        secondary.addAll(list);
    }*/

    public TodoList addPrimary(String task) {
        primary.add(task);
        return this;
    }

    public TodoList addSecondary(String task) {
        secondary.add(task);
        return this;
    }

    public List<String> listAllTasks() {
        List<String> all = new ArrayList<>();
        all.addAll(primary);
        all.addAll(secondary);
        return all;
    }
}
