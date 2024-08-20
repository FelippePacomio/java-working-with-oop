package br.com.entities;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private String name;
    protected Integer hours;
    protected Double valuePerHour;
    private List<Employee> employeeList;

    public Employee() {
    }

    public Employee(String name, Integer hours, Double valuePerHour) {
        this.name = name;
        this.hours = hours;
        this.valuePerHour = valuePerHour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(Double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public double payment() {
        return valuePerHour *= hours;
    }

    public void readList(List<Employee> employeeList) {
        StringBuilder sb = new StringBuilder();
        for (Employee i : employeeList) {
            sb.append("\nEmployee: ");
            sb.append(i.getName());
            sb.append(" - $");
            sb.append(i.payment());
            sb.append("\n\n");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("|----- Payments -----|\n\n");

        readList(employeeList);

        return sb.toString();
    }
}
