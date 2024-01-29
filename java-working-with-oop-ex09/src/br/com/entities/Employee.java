package br.com.entities;

public class Employee {

    private Integer id;
    private Double salary;
    private String name;

    public Employee(Integer id, Double salary, String name) {
        this.id = id;
        this.salary = salary;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void salaryIncrease(double percentage) {
        salary += (salary * percentage / 100.0);
    }

    @Override
    public String toString() {
        String data = "";

        data += id + ", " + name + ", " + "U$ " + salary + "\n";
        return data;
    }

}
