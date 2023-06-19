package tester;
import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.TeamDaoImpl;
import pojos.Team;
public class TeamTester {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory();
				Scanner sc=new Scanner(System.in);){
			TeamDaoImpl dao=new TeamDaoImpl();
			System.out.println("  sname,  sabbrevation,  sowner,  maxAge,  battingAvg, wicketsTaken");
			System.out.println(dao.addnewTeam(new Team(sc.next(),sc.next(),sc.next(),sc.nextInt(),sc.nextDouble(),sc.nextInt())));
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
