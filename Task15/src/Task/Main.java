package Task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    /* V1
    private static final Object object = new Object();
    private static volatile int x = -1;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                for (int i = 0; i < 100_000_000; i++) {
                    if (i % 77_732 == 0) {
                        //while (x == -1);
                        synchronized (object) {
                            object.wait();
                            System.out.println(i * x);
                        }
                    }
                }
            } catch (InterruptedException ignored) {
            }
        }).start();

        new Thread(() -> {
            for (int i = 100_000_000; i < 200_000_000; i++) {
                if (i % 83_449 == 0) {
                    x = i;
                    synchronized (object) {
                        object.notify();
                        System.out.println("ya poschital");
                    }
                }
            }
        }).start();
    }*/
    public static void main(String[] args) {
        List<Integer> numbers = List.of(14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24);
        int start = 111;
        int end = 555;

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()); // узнать количество ядер процессора

        List<Future<Integer>> futures = new ArrayList<>();
        for (int x : numbers) {
            Future<Integer> future = service.submit(() -> {
                for (int i = start; i < end; i++) {
                    if (i % x == 0) {
                        return i;
                    }
                }
                return Integer.MAX_VALUE;
            });
            futures.add(future);
        }

        int min = Integer.MAX_VALUE;

        for (Future<Integer> future : futures) {
            try {
                int x = future.get();
                if (x < min) {
                    min = x;
                }
            } catch (Exception ignored) {
            }
        }

        System.out.println(min);

        /* V2
        List<Thread> threads = new ArrayList<Thread>();

        for (int x : numbers) {
            Thread thread = new Thread(() -> {
                for (int i = start; i < end; i++) {
                    if (i % x == 0) {
                        synchronized (threads) {
                            min = Math.min(min, i);
                        }
                    }
                }

            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(min);*/
    }
}
