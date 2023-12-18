package hibernate_student.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_student.dto.Student;

public class StudentDao {
	Student student = new Student();
	// StudentDao dao=new StudentDao();

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Priti");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		return entityManager;
	}

	public void saveStudent(Student student) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		entityManager.persist(student);

		entityTransaction.commit();
		System.out.println(" save Successfully");

	}

	public void getStudent(int id) {
		EntityManager entityManager = getEntityManager();
		Student student = entityManager.find(Student.class, id);
		if (student != null) {
			System.out.println(student);
		} else {
			System.out.println("Employee with given id not found");
		}
	}

	public void updateStudent(Student student) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		entityManager.merge(student);

		entityTransaction.commit();
		System.out.println(" update Successfully");
	}

	public void deleteStudent(int id) {
		// EntityManagerFactory
		// entityManagerFactory=Persistence.createEntityManagerFactory("Priti");
		// EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityManager entityManager = getEntityManager();
		Student student = entityManager.find(Student.class, id);

		if (student != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(student);

			entityTransaction.commit();
			System.out.println("student deleted successfully");
		} else {
			System.out.println("student not found with this id");
		}
	}

	public void getAllStudent() {
		EntityManager entityManager = getEntityManager();

		Query query = entityManager.createQuery("select s from Student s");
		List<Student> list = query.getResultList();
		System.out.println(list);

	}

	public void getStudent(long phone) {
		EntityManager entityManager = getEntityManager();
		// Student s=entityManager.find(Student.class, phone);

		Query query = entityManager.createQuery("select s from Student s where s.phone=?1");
		query.setParameter(1, phone);
		try {
			Student student = (Student) query.getSingleResult();

			System.out.println(student);
			System.out.println("student found");
		} catch (Exception e) {
			System.out.println(" Student with phone" + phone + " Not found");
		}

	}

	public void getStudent(String email) {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select s from Student s where s.email=?1");
		query.setParameter(1, email);
		try {
			Student student = (Student) query.getSingleResult();
			System.out.println(student);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Student with email " + email + " Not found");
		}

	}
}
