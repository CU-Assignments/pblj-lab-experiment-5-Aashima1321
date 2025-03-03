 import java.io.*; 
import java.util.*; 
class Employee implements Serializable {
  private static final long serialVersionUID = 1L; 
 private int id; 
 private String name; 
 private String designation; 
 private double salary; 
 
 public Employee(int id, String name, String designation, double salary) { 
  this.id = id; 
  this.name = name; 
  this.designation = designation; 
  this.salary = salary; 
 } 
 
 @Override 
 public String toString() { 
  return "Employee ID: " + id + ", Name: " + name + ", Designation: " + designation 
+ ", Salary: " + salary; 
 } 
} 
 
public class EmployeeManagementSystem { 
 private static final String FILE_NAME = "employees.ser"; 
 private static List<Employee> employees = new ArrayList<>(); 
 
 public static void addEmployee() { 
  Scanner scanner = new Scanner(System.in); 
  System.out.print("Enter Employee ID: "); 
  int id = scanner.nextInt(); 
  scanner.nextLine(); 
  System.out.print("Enter Employee Name: "); 
  String name = scanner.nextLine(); 
  System.out.print("Enter Designation: "); 
  String designation = scanner.nextLine(); 
  System.out.print("Enter Salary: "); 
  double salary = scanner.nextDouble(); 
 
  Employee employee = new Employee(id, name, designation, salary); 
  employees.add(employee); 
  saveEmployees(); 
  System.out.println("Employee added successfully!"); 
 } 
 
 public static void displayAllEmployees() { 
  loadEmployees(); 
  if (employees.isEmpty()) { 
   System.out.println("No employees found."); 
  } else { 
   for (Employee employee : employees) { 
    System.out.println(employee); 
   } 
  } 
 } 
private static void saveEmployees() { 
  try (ObjectOutputStream oos = new ObjectOutputStream(new 
FileOutputStream(FILE_NAME))) { 
   oos.writeObject(employees); 
  } catch (IOException e) { 
   System.err.println("Error saving employees: " + e.getMessage()); 
  } 
 } 
 
 @SuppressWarnings("unchecked") 
 private static void loadEmployees() { 
  try (ObjectInputStream ois = new ObjectInputStream(new 
FileInputStream(FILE_NAME))) { 
   employees = (List<Employee>) ois.readObject(); 
  } catch (FileNotFoundException e) { 
   employees = new ArrayList<>(); 
  } catch (IOException | ClassNotFoundException e) { 
   System.err.println("Error loading employees: " + e.getMessage()); 
  } 
 } 
 
 public static void main(String[] args) { 
  Scanner scanner = new Scanner(System.in); 
  while (true) { 
   System.out.println("\nEmployee Management System"); 
   System.out.println("1. Add an Employee"); 
   System.out.println("2. Display All Employees"); 
   System.out.println("3. Exit"); 
   System.out.print("Enter your choice: "); 
   int choice = scanner.nextInt(); 
   scanner.nextLine(); 
 
   switch (choice) { 
   case 1: 
    addEmployee(); 
    break; 
   case 2: 
    displayAllEmployees(); 
    break; 
   case 3: 
    System.out.println("Exiting..."); 
    return; 
   default: 
    System.out.println("Invalid choice! Please try again."); 
   } 
  } 
 } 
}
  
