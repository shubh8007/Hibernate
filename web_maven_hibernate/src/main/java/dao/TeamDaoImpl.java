package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Team;
public class TeamDaoImpl implements Teamdao
{

	@Override
	public String addnewTeam(Team team) {
		String msg="team added Sucessful";
		
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		try {
			session.persist(team);
			tx.commit();
		}catch (RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
			}
		}
		
		
		
		
		return msg;
	}

	
	
	
}
