package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Player;
public class PlayerDaoImpl implements PlayerDao {

	@Override
	public String addPlayer(Player player) {
		String msg="Palyer Added Sucessfully..";
		Session session =getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		try {
			session.persist(player);
			tx.commit();
		}catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
		}
		return null;
	}

}
