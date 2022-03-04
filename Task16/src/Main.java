import java.util.Arrays;

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
        Chart chart = chartBuilder.build();
        System.out.println(Arrays.toString(chart.getSchedule()));
        chartBuilder.setSize(10);
        chart = chartBuilder.build();
        System.out.println(Arrays.toString(chart.getSchedule()));
    }
}
