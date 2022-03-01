package Task;

public class Picker<T extends Number> {
    private T first;
    private T second;
    private double firstProb;

    public Picker(T first, T second, double firstProb) {
        this.first = first;
        this.second = second;
        this.firstProb = firstProb;
    }

    public T pick() {
        if (Math.random() <= firstProb) {
            return first;
        } else {
            return second;
        }
    }
}
