import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static final Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        int[] massive = IntStream.range(0, 1000).map(i -> 100 + new Random().nextInt(100)).toArray();
        System.out.println(Arrays.toString(massive));
        long start = System.currentTimeMillis();

        Thread thread1 = new Thread(() -> IntStream.range(0, massive.length).filter(i -> i != 0 && i % 3 == 0).forEach(i -> {
            synchronized (object) {
                massive[i]++;
            }
        }));
        thread1.start();

        Thread thread2 = new Thread(() -> IntStream.range(0, massive.length).filter(i -> i != 0 && i % 5 == 0).forEach(i -> {
            synchronized (object) {
                massive[i]++;
            }
        }));
        thread2.start();

        Thread thread3 = new Thread(() -> IntStream.range(0, massive.length).filter(i -> i != 0 && i % 7 == 0).forEach(i -> {
            synchronized (object) {
                massive[i]++;
            }
        }));
        thread3.start();

        Thread thread4 = new Thread(() -> IntStream.range(0, massive.length).filter(i -> i != 0 && i % 19 == 0).forEach(i -> {
            synchronized (object) {
                massive[i]++;
            }
        }));
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        long finish = System.currentTimeMillis();
        System.out.println("Прошло времени, мс: " + (finish - start));
        System.out.println(Arrays.toString(massive));
    }
}
