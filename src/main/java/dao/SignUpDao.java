package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Employee;

public class SignUpDao {

	public boolean saveDetails(Employee e) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(e);
		et.commit();

		return true;

	}

	public Employee findByEmail(String email) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Query query = em.createQuery("select f from Employee f where f.email like?1");
		query.setParameter(1, email);
		Employee e = (Employee) query.getSingleResult();
		return e;
	}

	public boolean deleteByEmail(String mail) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Query query = em.createQuery("select f from Employee f where f.email like?1");
		query.setParameter(1, mail);
		Employee e = (Employee) query.getSingleResult();

		et.begin();
		em.remove(e);
		et.commit();

		return true;
	}
	
	public List<Employee> getAllDetails(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("select e from Employee e");
		return query.getResultList();
		
		
	}
}
