import java.util.ArrayList;
import java.util.List;

public class ChartBuilder {
    private List<Boolean> employeeSchedule = null;

    public ChartBuilder() {

    }

    public void setSize(int size) {
        if (employeeSchedule != null) {
            int sizeEmployeeSchedule = employeeSchedule.size();
            if (size > sizeEmployeeSchedule) {
                for (int i = employeeSchedule.size(); i < size; i++) {
                    employeeSchedule.add(false);
                }
            } else if (size < sizeEmployeeSchedule) {
                employeeSchedule.subList(size, sizeEmployeeSchedule).clear();
            }
        } else {
            employeeSchedule = new ArrayList<>(size);
        }
    }

    public void dayOff() {
        employeeSchedule.add(false);
    }

    public void dayOffs(int count) {
        for (int i = 0; i < count; i++) employeeSchedule.add(false);
    }

    public void wordDay() {
        employeeSchedule.add(true);
    }

    public void workDays(int count) {
        for (int i = 0; i < count; i++) employeeSchedule.add(true);
    }

    public Chart build() {
        if (employeeSchedule == null) {
            throw new IllegalStateException("Grafik ne mojet bit pestoiy!");
        }
        Boolean[] schedule = new Boolean[employeeSchedule.size()];
        for (int i = 0; i < employeeSchedule.size(); i++) {
            schedule[i] = employeeSchedule.get(i);
        }
        return new Chart(schedule);
    }
}
