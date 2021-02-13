package Phase1.Users;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
@Component
public class HibernateDataHandler implements Serializable {
	private final Configuration c=new Configuration().configure();
    
	protected final SessionFactory s=c.buildSessionFactory(); 
    public String man;
	 public HibernateDataHandler() {
		 System.out.println("i m ironDataBase");
	 }
	 public List getALL(String entityName) {
		  
			
		     
		     Session sess=s.openSession();
		     Transaction t=sess.beginTransaction();
		     Query q=sess.createQuery("from "+entityName);
		    // sess.refresh(u);
		     List ALL=q.getResultList();
		     sess.clear();
		     t.commit();
		     sess.close();
		     return ALL;
	 }
 @Async("taskExecutor")
 public <T>void SaveUser(T u) { 
     System.out.println("USER-DATA-THREAD:-"+Thread.currentThread().getName());
     Session sess=s.openSession();
     Transaction t=sess.beginTransaction();
    // sess.refresh(u);
     sess.persist(u);
     sess.clear();
     sess.flush();
     t.commit();
     sess.close();
     
     
 }
 
 public List getUser() {       //for multiple users
     Session sess=s.openSession();
     Transaction t=sess.beginTransaction();
	 Query q=sess.createQuery("from user");
	 System.out.println(t.getRollbackOnly());
	 sess.clear();
	 t.commit();
	 return q.getResultList(); 
 }
 @Cacheable(value="userCache" ,key="#name")  //THE KEY ATTRIBUTE WILL TAKE ANY VALUE PASS ON NAME PARAM AS ITS CACHE KEY IN CACHE-CONCURRENT-HASHMAP (SPEL)
 public UserInterface fetchOneUser(String name,Class entity){
		 c.addAnnotatedClass(entity);
	     Session sess=s.openSession();
	     Transaction t=sess.beginTransaction();
	     System.out.println("User Logged In By Using:-"+entity.getName());
		 Query q=sess.createQuery("from "+entity.getName()+" u where u.username='"+name+"'");
		 System.out.println("i m invoked");
		 try {
	     UserInterface user=(UserInterface) q.getResultList().get(0);           
		 if(user!=null) {
			 return user;
		 }
		 else {
			 return null;
		 }
		 }
		 catch(Exception e) {
			 System.out.println("Exception:"+e.getMessage());
			 return null;
		 }
		  
 }
 public<T> Integer updateUserInfo(Class entity,String phone,String name) {
	 c.addAnnotatedClass(entity);
     Session sess=s.openSession();
     Transaction t=sess.beginTransaction();
     int x=0;
     try {
     Query q=sess.createQuery("update "+entity.getName()+" set phone='"+phone+"' where username='"+name+"'");
     x=q.executeUpdate();
    // sess.refresh(u);
     sess.clear();
     t.commit();
     sess.close();
     return x;
     }
     catch(Exception e) {
    	 System.out.println("Exception:"+e.getMessage());

         sess.clear();
         t.commit();
         sess.close();
    	 return x;
     }
	 
 }
}
