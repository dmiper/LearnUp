package Task;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        TodoList todoList = new TodoList()
                .addPrimary("Pobegat #errords #sport")
                .addPrimary("Porabotat #job")
                .addSecondary("Shodit v magaz #errords")
                .addPrimary("Provesti vebinar #job")
                .addSecondary("Shodit poplavat #sport");

        //todoList.moveSecondaryByTag("sport");
        //todoList.moveToSecondaryByCriteria(new MoveByTagCriteria("sport"));

        /*MoveCriteria criteria = new MoveCriteria() {
            @Override
            public boolean shouldMove(String task) {
                return task.contains("#sport");
            }
        };*/
        //MoveCriteria criteria = task -> task.contains("#sport");
        todoList.moveToSecondaryByCriteria(task -> task.contains("#spo"));


        System.out.println(todoList.listAllTasks());
    }


}
