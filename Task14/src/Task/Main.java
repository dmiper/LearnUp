package Task;

class Main {
    /*public static volatile long count = 0;
    public static final Object object = new Object();

    public static void main(String[] args) throws Exception{

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 2_140_000_000; i++) {
                if (i % 500 == 0) {
                    System.out.println("I = " + i);
                    synchronized (object) {
                        count++;
                    }
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 2_140_000_000; i++) {
                if (i % 500 == 0) {
                    System.out.println("II = " + i);
                    synchronized (object) {
                        count--;
                    }
                }
            }
        });
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(count);
    }*/

    public static void f() {
        synchronized (Main.class) {

        }
    }

    public static Integer x = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (x) {
                System.out.println("Hi 1");
                x++;
                System.out.println("Bye 1");
            }
        }).start();

        new Thread(() -> {
            synchronized (x) {
                System.out.println("Hi 2");
                x++;
                System.out.println("Bye 2");
            }
        }).start();
    }
}
