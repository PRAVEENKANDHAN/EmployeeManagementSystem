import java.util.Scanner;

import com.ideas2it.employee.view.EmployeeView;
import com.ideas2it.project.view.ProjectView;

/**
 * EmployeeManagementSystem class initiates the employee operations
 * @version 09/03/2021
 * @author PRAVEEN KANDHAN 
 */
public class EmployeeManagementSystem {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String option = "\n1-->Project Management\n2-->EmployeeManagement\n"
                + "3-->Exit\nPlease Enter your choice";		
        int choice = 0;
        while(3 != choice) {
            System.out.println(option);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    ProjectView projectView =new ProjectView();
                    projectView.projectOperations();
                    break;
                case 2:
                    EmployeeView employeeView = new EmployeeView();     
                    employeeView.employeeOperations();
                    break;
                case 3:
                    System.out.println("Thank you");
                    break;				
                default:
                    System.out.print("Please Enter right choice");
                    choice = 3;
                    break;
            }				
        }			
    }
}    
