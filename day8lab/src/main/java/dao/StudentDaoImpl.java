package dao;

import static utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;

import pojos.Course;
import pojos.Student;
public class StudentDaoImpl implements StudentDao {

	@Override
	public String addStudent(Student s1) {
		String msg="insert Student details failed..";
		
		Session session =getFactory().openSession();
		Transaction tx=session.beginTransaction();
		try {
			session.save(s1);
		}catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
		}
		finally {
			if(session!=null)
				session.close();
		}
		return msg;
	}

	@Override
	public String loginStudent(String email, String password) {
		String msg="Login unsucessfull....";
		String jpql="select s from Student s where s.email=:em and s.password=:pass";
		Student stud=null;
		
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			stud=session.createQuery(jpql,Student.class).setParameter("em", email).setParameter("pass", password).getSingleResult();
			
			tx.commit();
			msg="Student Login SucessFully..";
		}catch (RuntimeException e) {
		if(tx!=null)
			tx.rollback();
			throw e;
			
		}
		return msg;
	}

	@Override
	public List<Student> getnameCourse(Course type) {
		String jpql="select s from Student s where s.type=:course";
		String msg="Course not valid...";
		List<Student> studentList=null;
		Session session =getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			studentList=session.createQuery(jpql,Student.class).setParameter("course",type ).getResultList();
			tx.commit();
			
		}catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
			
		}
		return studentList;
	}

	@Override
	public String updateCourse(Integer studentId, Course course) {
		String msg="Update Course failed....";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			Student student=null;
			student=session.get(Student.class,studentId);
			if(student!=null) {
	             student.setType(course);
			System.out.println("Course Updated Sucessfully"+student.getSid()+" "+student.getType());
			}
			else {
				msg="Curse not updated";
			}
			
			
		tx.commit();	
		}catch (RuntimeException e) {
		if(tx!=null)
			tx.rollback();
		throw e;
		}
		return null;
	}

@Override
	public List<Student> getStudentBy(LocalDate date) {
		
		List<Student> studentList = new ArrayList<>();
		Session SS = getFactory().getCurrentSession();
		Transaction TX = SS.beginTransaction();
		String JPQL = "select s from Student s where s.dob < :DOB";
		
		try{
			
			studentList = SS.createQuery(JPQL, Student.class).setParameter("DOB", date).getResultList();
			
			TX.commit();	
			System.out.println("  ");
			System.out.println(" -: This Is The List Of Students As Per Given Date :- ");
		}
		catch(RuntimeException e){
		
			if(TX != null)
				TX.rollback();	
			throw e;				
		}
		
		return studentList;
	}
		
	

}
