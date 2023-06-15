package com.Electricity.Billing.System.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Electricity.Billing.System.model.Admin;
import com.Electricity.Billing.System.model.CalculateBill;
import com.Electricity.Billing.System.model.User;

@Repository
public class UserDao {

	@Autowired
	SessionFactory sf;

	public List<User> ViewUser() {

		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(User.class);
		List<User> list = cr.list();
		return list;
	}

	public String RegistrationForm(User cust) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.save(cust);
		tr.commit();
		return "Registered";
	}

	public String CalBill(CalculateBill cal) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.save(cal);
		tr.commit();
		return "Bill Calculated";
	}

	public List<CalculateBill> BillReport() {

		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(CalculateBill.class);
		List<CalculateBill> list = cr.list();
		return list;

	}

	public String PaymentHistory(CalculateBill calbill) {
		// TODO Auto-generated method stub
		return null;
	}

	public Admin getAdmin(Admin admin) {
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Admin.class);
		cr.add(Restrictions.eq("name", admin.getName()));
		return (Admin) cr.list().get(0);
	}

	public User getUser(User user) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.eq("username", user.getUsername()));
		if (cr.list().isEmpty())
			return null;
		return (User) cr.list().get(0);
	}

}
