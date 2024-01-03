/*
    Keywords Used:
    1. this
    2. final
    3. static
*/

public class Employee 
{

    private int employeeID;
    private String employeeName;
    private String employeeDept;
    //Using final Keyword
    private final String companyName = "IIITV, International Campus Diu";

    public Employee(int employeeID, String employeeName, String employeeDept) 
    {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeDept = employeeDept;
    }

    public Employee(int employeeID, String employeeName) 
    {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeDept = "General";
        
    }

    public void display() 
    {
        System.out.println();
        System.out.println("Employee ID: " + this.employeeID);
        System.out.println("Employee Name: " + this.employeeName);
        System.out.println("Employee Department: " + this.employeeDept);
        System.out.println("Employee Company: " + this.companyName);
        System.out.println();
    }

    public static void main(String[] args) 
    {
        // Create an array of objects:
        Employee[] empArray = new Employee[2];

        empArray[0] = new Employee(1024, "Employee 1", "Marketing");
        empArray[1] = new Employee(2048, "Employee 2");

        empArray[0].display();
        empArray[1].display();
    }
}
