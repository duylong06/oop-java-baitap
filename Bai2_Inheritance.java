/*
 * BAI 2 - INHERITANCE + POLYMORPHISM (Ke thua + Da hinh)
 * He thong tinh luong nhan su
 *
 * Y tuong: gom phan CHUNG len class cha, phan RIENG de o class con.
 * Mot vong for-each duy nhat -> moi object tu tinh luong theo cach cua no
 * (Dynamic Method Dispatch).
 */

import java.util.*;

class Employee {
    // protected = "tu do gia dinh": cha va cac class con deu dung duoc
    protected String id;
    protected String name;
    protected double baseSalary;

    public Employee(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Cach tinh mac dinh
    public double calculateSalary() {
        return baseSalary;
    }

    // Chi viet MOT LAN o cha, nhung goi calculateSalary() cua object that
    public void displayInfo() {
        System.out.println("ID: " + id + " | Ten: " + name
                         + " | Luong: " + calculateSalary());
    }
}

class FullTimeEmployee extends Employee {
    private double bonus;

    public FullTimeEmployee(String id, String name, double baseSalary, double bonus) {
        super(id, name, baseSalary);   // goi constructor cha TRUOC (dong dau tien)
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }
}

class PartTimeEmployee extends Employee {
    private int workingHours;
    private double hourlyRate;

    public PartTimeEmployee(String id, String name, double baseSalary,
                            int workingHours, double hourlyRate) {
        super(id, name, baseSalary);
        this.workingHours = workingHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return workingHours * hourlyRate;
    }
}

public class Bai2_Inheritance {
    public static void main(String[] args) {

        // List<Employee> chua duoc ca 2 loai, vi ca 2 deu "LA MOT LOAI" Employee
        List<Employee> employees = new ArrayList<>();

        employees.add(new FullTimeEmployee("E01", "An", 10000, 2000));
        employees.add(new PartTimeEmployee("P01", "Binh", 0, 80, 50));
        employees.add(new PartTimeEmployee("P02", "Chi", 0, 60, 45.5));

        // MOT vong for-each duy nhat, khong co if-else phan loai
        for (Employee employee : employees) {
            employee.displayInfo();
        }
    }
}
