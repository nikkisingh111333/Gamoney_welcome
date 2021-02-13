package Phase1.Users;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaUpdate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class Star_WalletOperations {
	protected final Configuration con=new Configuration().configure();
	protected final SessionFactory s=con.buildSessionFactory(); 
	@Async
	public void CreateWalletORUpdate(star_wallet sw) { //FOR STAR WALLET
		 
	     con.addAnnotatedClass(Phase1.Users.star_wallet.class);
	    
	     Session sess=s.getCurrentSession();
	     Transaction tx=sess.beginTransaction();
	     sess.saveOrUpdate(sw);
	     
	     sess.flush();
//	     sess.clear();
	    // tx.rollback();
	     
	     tx.commit();
	     
	     sess.close();
	    
	     
	     
	 }
	 public <E> int updateStars(String username,int stars) {
		 con.addAnnotatedClass(Phase1.Users.star_wallet.class);
		
		 Session sess=s.getCurrentSession();
		 Transaction tx=sess.beginTransaction();
		 Query query=sess.createQuery("UPDATE star_wallet set totatstars="+stars+" where username='"+username+"'");
//		 query.setParameter("?1", stars);
//		 query.setParameter("?2", username);
		 int update_status=query.executeUpdate();
		 System.out.println(update_status);
		 sess.flush();
		// tx.rollback();
		 tx.commit();
		 
		 sess.close();
		 
		 return update_status;
	 }
	 public star_wallet getStars(String name) {
		 con.addAnnotatedClass(Phase1.Users.star_wallet.class);
		 
		 Session sess=s.getCurrentSession();
		 Transaction tx=sess.beginTransaction();
		 List<star_wallet> l=sess.createQuery("from star_wallet where username='"+name+"'").getResultList();
		 sess.flush();
		// tx.rollback();
		 tx.commit();
		
		 sess.close(); //ALWAYS COMMIT CURRENT TRANSACTION AND CLOSE THE SESSION AFTER USING THE CONNECTION OTHERWISE HIBERNATE WONT WORK PROPERLY
		 for(star_wallet sw:l) {
			 if(sw!=null) {
				 return sw;
			 }
			 else {
				 return null;
			 }
		 }
		return null;
	 }
	
//	public static void main(String[] m) {
//		star_wallet o=new star_wallet();
//		
//		o.setUsername("london");
//		o.setAddedInAndAt(new Date().toString().trim());
//		o.setTotalMoney(6666);
//		try {
//			new WalletOperations().CreateWalletORUpdate(o);
//		new WalletOperations().updateStars("london",545454545);
//	        System.out.println("data is__"	+new Star_WalletOperations().getStars("lond"));
//		}
//		catch(Exception e) {
//			System.out.println("exception:"+e.getMessage());
//		}
//	}
}
