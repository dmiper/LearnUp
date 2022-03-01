import java.util.List;

public class Main {
    public static void main(String[] args) {
        ChartBuilder chartBuilder = new ChartBuilder();
        chartBuilder.setSize(15);
        chartBuilder.wordDay();
        chartBuilder.dayOffs(3);
        chartBuilder.workDays(5);
        chartBuilder.dayOff();
        chartBuilder.workDays(5);
        chartBuilder.setSize(20);
        chartBuilder.wordDay();
        println(chartBuilder.build());
        chartBuilder.setSize(10);
        println(chartBuilder.build());
    }

    public static void println(List<Boolean> employeeSchedule) {
        for (boolean x : employeeSchedule) System.out.println(x ? "Rabochiy den" : "Vihodnoiy");
        System.out.println("========");
    }
}
