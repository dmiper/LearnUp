package Task;

@FunctionalInterface
public interface MoveCriteria {
    boolean shouldMove(String task);
}
