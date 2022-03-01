package Task;

public class MoveByTagCriteria implements MoveCriteria{
    private final String tag;

    public MoveByTagCriteria(String tag) {
        this.tag = tag;
    }

    @Override
    public boolean shouldMove(String task) {
        /*if (task.contains("#" + tag)) {
            return true;
        } else {
            return false;
        }*/
        return task.contains("#" + tag);
    }
}
