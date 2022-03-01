import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Integer> numbers = List.of(3, 5, 7, 9, 11);
        int[] massive = IntStream.range(0, 1000).map(i -> 100 + new Random().nextInt(100)).toArray();

        ExecutorService service = Executors.newFixedThreadPool(5);
        List<Future<Integer>> futures = new ArrayList<>();
        for (int x : numbers) {
            Future<Integer> future = service.submit(() -> Arrays.stream(massive).filter(i -> i % x == 0).sum());
            futures.add(future);
        }

        int max = Integer.MIN_VALUE;
        int index = 0;
        for (Future<Integer> future : futures) {
            int i = future.get();
            if (i > max) {
                max = i;
                index = numbers.get(futures.indexOf(future));
            }
        }
        service.shutdown();
        System.out.println("Сумма чисел делящихся на " + index + " максимальная и равна " + max);
    }
}
