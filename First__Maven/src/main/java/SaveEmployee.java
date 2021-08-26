import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveEmployee {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure().addAnnotatedClass(Employee_Hb.class);
		
		SessionFactory sessionFactory=  cfg.buildSessionFactory();
		
	  Session session=	sessionFactory.openSession();
	   Transaction transaction=  session.beginTransaction();
	  
	  //Employee_Hb employee_Hb=new Employee_Hb("jbk", 123456);
	 Employee_Hb employee_Hb= session.get(Employee_Hb.class, 1);
	 System.out.println(employee_Hb);
	  
	 // session.save(employee_Hb);
	  //transaction.commit();
		
	}

}
