package Tester;

import static HUtils.HUtilities.getFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import DAO.StudentDAOImpl;
import POJOs.Student;

public class StudentsByDate {

	public static void main(String[] args) {
		
		try(SessionFactory SF = getFactory(); Scanner sc = new Scanner(System.in);){
			
			StudentDAOImpl StudentDAOInstance = new StudentDAOImpl();
			
			List<Student> studentList = StudentDAOInstance.getStudentBy(LocalDate.parse(sc.next()));
						
			studentList.forEach(System.out :: println);
			
		}catch(RuntimeException e) {
			
			e.printStackTrace();			
		}

	}

}
