package com.jspiders.subpack.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.TransactionException;
import org.springframework.stereotype.Repository;

import com.jspiders.subpack.DTOPOJO.StudentDTO;
@Repository
public class StudentRepository {
	private static EntityManagerFactory entityManagerFactory ;
	   private static EntityManager entityManager;
	   private static EntityTransaction entityTransaction ;	
	   
	   public static void openConnection()
	   {
		 entityManagerFactory=Persistence.createEntityManagerFactory("RestAPI");
		 entityManager=entityManagerFactory.createEntityManager();
		 entityTransaction=entityManager.getTransaction();
	   }
	   
	   public static void closeConnection()
	   {
		   if(entityManagerFactory != null)
		   {
			   entityManagerFactory.close();
		   }
		   if(entityManager != null)
		   {
			   entityManager.close();
		   }
		   if(entityTransaction != null)
		   {try {
			   entityTransaction.rollback();
			   }
		    catch(TransactionException e)
		   {
		    	System.out.println("Transaction already comitted");
		   }
		   }
	   }
	public StudentDTO add(StudentDTO student) {
		openConnection();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		return student;
	}

	public StudentDTO search(int id) {
		openConnection();
		entityTransaction.begin();
StudentDTO find = entityManager.find(StudentDTO.class, id);
 entityManager.persist(find);
 entityTransaction.commit();
		return find;
	}

	public StudentDTO update(StudentDTO student) {
		openConnection();
		entityTransaction.begin();
		StudentDTO update=entityManager.find(StudentDTO.class, student.getId());
		update.setName(student.getName());
		update.setEmail(student.getEmail());
		update.setContact(student.getContact());
		update.setUsername(student.getUsername());
		update.setPassword(student.getPassword());
		entityManager.persist(update);
		entityTransaction.commit();
		return update;
	}

	public StudentDTO remove(int id) {
		openConnection();
		entityTransaction.begin();
StudentDTO find = entityManager.find(StudentDTO.class, id);
    entityManager.remove(find);
 entityTransaction.commit();
		return find;
	}


}
