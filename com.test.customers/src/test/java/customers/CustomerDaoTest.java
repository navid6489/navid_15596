package customers;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.test.customers.dao.customerDao;
import com.test.customers.model.customer;

public class CustomerDaoTest {
	
	private customer customers;
	private customerDao CustomerDao;
	
	@BeforeEach()
	public void beforeEach() {
		customers=new customer("11road","1234321234","vinit");
		CustomerDao=new customerDao();
	}
	
	
	@Test
	public void testcreatecustomer() {
		Assertions.assertTrue(CustomerDao.createcustomer(customers));
	}
	@Disabled
	@Test
	public void testFindAllNotNull() {
		Assertions.assertNotNull(CustomerDao.findAll());
	}
	@Disabled
	@Test
	public void testFindOneNotNull() {
		customers=CustomerDao.findOne(1);
		Assertions.assertNotNull(customers);
		System.out.println("id=1 |"+customers);
	}
	
	@Disabled
	@Test
	public void testFindOneAndDelete() {
		Assertions.assertTrue(CustomerDao.findOneandDelete(4));
	}
	@Disabled
	@Test
	public void testFindOneAndUpdate() {
		customers.setName("naruto");
		Assertions.assertTrue(CustomerDao.findOneandUpdate(7, customers));
	}

}
