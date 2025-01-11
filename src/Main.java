import java.util.ArrayList;

abstract class Employee{
    private String name;
    private int id;

    public Employee(String name ,int id){
        this.name = name;
        this.id = id;
    }

    // Getter
    public String getName(){
        return name;
    }

    // Getter
    public int getId(){
        return id;
    }

    public abstract double calculateSalary();

    @Override // because toString() is inbuilt method and we use it for another
    public String toString(){
        return ("Employee [name="+name+", id="+id+", salary="+calculateSalary()+"]");
    }
}


class FullTimeEmployee extends Employee{
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary){
        super(name,id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary(){
       return monthlySalary;
    }
}


class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlySalary;

    public PartTimeEmployee(String name,int id,int hoursWorked,double hourlySalary){
        super(name,id);
        this.hoursWorked = hoursWorked;
        this.hourlySalary = hourlySalary;
    }

    @Override
    public double calculateSalary(){
        return (hoursWorked * hourlySalary);
    }
}



class PayrollSystem{
    private ArrayList<Employee> employeeList;

    public PayrollSystem(){
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        //Employee employeeToRemove = null;
        for(Employee empolyee : employeeList){
            if(empolyee.getId()==id){
               // employeeToRemove = empolyee;
                employeeList.remove(empolyee);
                break;
            }
        }
        // if(employeeToRemove != null){
        //     employeeList.remove(employeeToRemove);
        // }
    }

    public void displayEmployee(){
        for(Employee employee : employeeList){
            System.out.println(employee); // By default toString() method print thase 
        }
    }
} 



public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("Prince", 25,500000000);
        PartTimeEmployee emp2 = new PartTimeEmployee("Vipra",1, 175, 100000);
        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        System.out.println("Initial Employee Details : ");
        payrollSystem.displayEmployee();
        System.out.println("Removing Employee : ");
        payrollSystem.removeEmployee(25);
        System.out.println("Remaining Employee Details : ");
        payrollSystem.displayEmployee();
    }
}
