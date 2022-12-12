package com.qspider.springmvc.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.TransactionException;
import org.springframework.stereotype.Repository;

import com.qspider.springmvc.DTO.StudentDTO;

@Repository
public class StudentDAO implements StudentDAOInterface{

	private static EntityManagerFactory entityManagerFactory ;
	   private static EntityManager entityManager;
	   private static EntityTransaction entityTransaction ;
	   
	   public static void openConnection()
	   {
		 entityManagerFactory=Persistence.createEntityManagerFactory("spring")  ;
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
		    	System.out.println("Transaction alreadyv comitted");
		   }
		   }
	   }

	@Override
	public void addStudent(String name, String email, String userName, String password) {
		
		openConnection();
		
		entityTransaction.begin();
		
		StudentDTO dto=new StudentDTO();
		
		dto.setName(name);
		dto.setEmail(email);
		dto.setUserName(userName);
		dto.setPassword(password);
		
		entityManager.persist(dto);
		
		entityTransaction.commit();
		
	}

	@Override
	public StudentDTO login(String userName, String password) {
		openConnection();

		entityTransaction.begin();

		String jpql = "from StudentDTO where userName = '" + userName + "' and password = '" + password + "'";

		Query query = entityManager.createQuery(jpql);
		try {
			StudentDTO student = (StudentDTO) query.getSingleResult();
			if (student != null) {
				closeConnection();
				return student;
			}
			closeConnection();
		} catch (Exception e) {
			return null;
		}
		return null;
		
	}

	@Override
	public List<StudentDTO> viewAllStudent() {
		openConnection();

		entityTransaction.begin();

		String jpql = "from StudentDTO";

		Query query = entityManager.createQuery(jpql);
		List<StudentDTO> students = query.getResultList();

		closeConnection();
		return students;
	}

	@Override
	public StudentDTO removeStudent(int id) {
		openConnection();
	  entityTransaction.begin();
	  StudentDTO student=entityManager.find(StudentDTO. class,id);
	  entityManager.remove(student);
	  
	  closeConnection();
	  return student;
	  
	}
@Override
	public StudentDTO updateStudent(int id, String name, String email, String userName, String password) {
		openConnection();
		entityTransaction.begin();
		
		StudentDTO student=entityManager.find(StudentDTO.class, id);
		student.setId(id);
		student.setName(name);
		student.setEmail(email);
		student.setUserName(userName);
		student.setPassword(password);
		entityManager.persist(student);
		entityTransaction.commit();
		
		closeConnection();
		return student;
	}

@Override
public StudentDTO searchStudent(int id) {
	openConnection();
	entityTransaction.begin();
	StudentDTO student = entityManager.find(StudentDTO.class, id);
	closeConnection();
	return student;
}
	   
}
