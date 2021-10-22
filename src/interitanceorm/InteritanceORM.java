/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interitanceorm;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author nkotchs
 */
public class InteritanceORM {

    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int i;
       
      /* 
       FulltimeEmployee emp1 = new FulltimeEmployee();
       emp1.setName("John");
       emp1.setSalary(5000);
       ParttimeEmployee emp2 = new ParttimeEmployee();
       emp2.setName("Jane");
       emp2.setHoursWork(4);
       persist(emp1);
       persist(emp2);
     */
      do{
        System.out.println("-----Employee Management Menu-----");
        System.out.print("Enter 1 to insert Employee");
        System.out.print("\nEnter 2 to update Employee");
        System.out.print("\nEnter 3 to delete Employee");
        System.out.print("\nEnter 0 to exit Program");
        System.out.print("\nEnter:"); i = sc.nextInt();
        switch(i){
            case 1: insertMenu();
            break;
            case 2: updateMenu();
            break;
            case 3: deleteMenu();
            break;
            case 4: break;
        } 
      }while(i==1 || i==2 || i==3);
    }

   /* public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InteritanceORMPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
   */

    private static void insertMenu() {
        System.out.print("Enter 1 to insert Full-time Employee");
        System.out.print("\nEnter 2 to insert Part-time Employee");
        System.out.print("\nEnter:"); int i = sc.nextInt();
        if(i==1){
            FulltimeEmployee emp = new FulltimeEmployee();
            //System.out.print("Enter Full-time Employee's ID: "); long id = sc.nextLong();
            System.out.print("Enter Full-time Employee's Name: "); String n = sc.next();
            sc.nextLine();
            System.out.print("Enter Full-time Employee's Salary: "); int s = sc.nextInt();
            emp.setName(n);
            emp.setSalary(s);
            FulltimeEmployeeTable.insertEmployee(emp);
            //persist(emp);
        }
        else if(i==2){
            ParttimeEmployee emp = new ParttimeEmployee();
            System.out.print("Enter Part-time Employee's Name: "); String n = sc.next();
            sc.nextLine();
            System.out.print("Enter Part-time Employee's Hours work: "); int h = sc.nextInt();
            emp.setName(n);
            emp.setHoursWork(h);
            ParttimeEmployeeTable.insertEmployee(emp);
            //persist(emp);
        }
    }

    private static void updateMenu() {
        System.out.print("Enter 1 to update Full-time Employee");
        System.out.print("\nEnter 2 to update Part-time Employee");
        System.out.print("\nEnter:"); int i = sc.nextInt();
        if(i==1){
            FulltimeEmployee emp;
            System.out.print("Enter Full-time Employee's ID: "); long id = sc.nextLong();
            emp = FulltimeEmployeeTable.findEmployeeById(id);
            if(emp != null){
                System.out.print("Enter Full-time Employee's Name: "); String n = sc.next();
                sc.nextLine();
                System.out.print("Enter Full-time Employee's Salary: "); int s = sc.nextInt();
                emp.setName(n);
                emp.setSalary(s);
                FulltimeEmployeeTable.updateEmployee(emp);
            }
        }
        else if(i==2){
            ParttimeEmployee emp;
            System.out.print("Enter Part-time Employee's ID: "); long id = sc.nextLong();
            emp = ParttimeEmployeeTable.findEmployeeById(id);
            if(emp != null){
                System.out.print("Enter Part-time Employee's Name: "); String n = sc.next();
                sc.nextLine();
                System.out.print("Enter Part-time Employee's Hours work: "); int h = sc.nextInt();
                emp.setName(n);
                emp.setHoursWork(h);
                ParttimeEmployeeTable.updateEmployee(emp);
            }
        }
    }

    private static void deleteMenu() {
        System.out.print("Enter 1 to delete Full-time Employee");
        System.out.print("\nEnter 2 to delete Part-time Employee");
        System.out.print("\nEnter:"); int i = sc.nextInt();
        if(i==1){
            FulltimeEmployee emp;
            System.out.print("Enter Full-time Employee's ID: "); long id = sc.nextLong();
            emp = FulltimeEmployeeTable.findEmployeeById(id);
            FulltimeEmployeeTable.removeEmployee(emp);
        }
        else if(i==2){
            ParttimeEmployee emp;
            System.out.print("Enter Part-time Employee's ID: "); long id = sc.nextLong();
            emp = ParttimeEmployeeTable.findEmployeeById(id);
            ParttimeEmployeeTable.removeEmployee(emp);
        }
    }
    
}
