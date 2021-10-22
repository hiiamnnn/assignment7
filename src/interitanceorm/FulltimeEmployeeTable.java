/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interitanceorm;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author nkotchs
 */
public class FulltimeEmployeeTable {
    public static void insertEmployee(FulltimeEmployee emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InteritanceORMPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(emp);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public static void updateEmployee(FulltimeEmployee emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InteritanceORMPU");
        EntityManager em = emf.createEntityManager();
        FulltimeEmployee fromDb = em.find(FulltimeEmployee.class, emp.getId());
        fromDb.setName(emp.getName());
        fromDb.setSalary(emp.getSalary());
        em.getTransaction().begin();
        try {
            em.persist(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public static FulltimeEmployee findEmployeeById(Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InteritanceORMPU");
        EntityManager em = emf.createEntityManager();
        FulltimeEmployee emp = em.find(FulltimeEmployee.class, id);
        em.close();
        return emp;
    }
    public static List<FulltimeEmployee> findAllEmployee() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InteritanceORMPU");
        EntityManager em = emf.createEntityManager();
        List<FulltimeEmployee> fulltimeEmployeeList = (List<FulltimeEmployee>) em.createNamedQuery("FulltimeEmployee.findAll").getResultList();
        em.close();
        return fulltimeEmployeeList;
    }
    public static List<FulltimeEmployee> findEmployeeByName(String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InteritanceORMPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("FulltimeEmployee.findByName");
        query.setParameter("name", name);
        List<FulltimeEmployee> fulltimeEmployeeList = (List<FulltimeEmployee>) query.getResultList();
        em.close();
        return fulltimeEmployeeList;
    }
    public static void removeEmployee(FulltimeEmployee emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InteritanceORMPU");
        EntityManager em = emf.createEntityManager();
        FulltimeEmployee fromDb = em.find(FulltimeEmployee.class, emp.getId());
        em.getTransaction().begin();
        try {
            em.remove(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
                
    }
}
