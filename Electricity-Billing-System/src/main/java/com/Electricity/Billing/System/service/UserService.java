package com.Electricity.Billing.System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Electricity.Billing.System.dao.UserDao;
import com.Electricity.Billing.System.model.Admin;
import com.Electricity.Billing.System.model.CalculateBill;
import com.Electricity.Billing.System.model.User;

@Service
public class UserService {

	@Autowired
	UserDao dao;

	public List<User> ViewUser() {

		List<User> list = dao.ViewUser();

		return list;
	}

	public String RegistrationForm(User cust) {
		return dao.RegistrationForm(cust);
	}

	public int CalBill(CalculateBill cal) {
		int units=cal.getUnits();
		int bill=0;
		if (units <= 100) {
			bill = 2 * units;
		} else if (units > 100 && units <= 300) 
		{
			bill = 2 * 100 + (units - 100) * 3;

		} else if (units > 300) 
		{
			bill = 2 * 100 + 300 * 200 + (units - 300) * 5;
			bill = (int) (bill + 2.5 * bill / 100); 

		}
		cal.setBill(bill);
		dao.CalBill(cal);
		return bill;
	}

	public List<CalculateBill> BillReport() {
		List<CalculateBill> list = dao.BillReport();
		return list;
	}

	public String PaymentHistory(CalculateBill calbill) {
		return dao.PaymentHistory(calbill);

	}

	public boolean getAdmin(Admin admin) {
		Admin a = dao.getAdmin(admin);
		if (a.getName().equals(admin.getName()) && a.getPassword().equals(admin.getPassword())) {
			return true;
		}
		return false;
	}

	public boolean getUser(User user) {
		User a = dao.getUser(user);
		if (a == null) {
			return false;
		}
		if (a.getUsername().equals(user.getUsername()) && a.getPassword().equals(user.getPassword())) {
			return true;
		}
		return false;
	}
}
