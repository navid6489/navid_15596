package ecommerceOTO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import ecommerceOTO.dao.OrderItemDao;
import ecommerceOTO.dao.ProductDao;
import ecommerceOTO.model.OrderItem;
import ecommerceOTO.model.Product;

public class OrderItemDaoTest {
	
	private OrderItem orderitem;
	private OrderItemDao orderitemdao;
//	private ProductDao productdao;
	private Product product;
	
	@BeforeEach()
	public void beforeEach() {

		//		productdao = new ProductDao();
//		product = productdao.findOne(1);
//		orderitem=new OrderItem(product);
//		orderitemdao=new OrderItemDao();
		orderitem=new OrderItem("tshirt","cotton",123,product);
		orderitemdao=new OrderItemDao();
	}

	@Test
	public void testcreate(){
		Assertions.assertTrue(orderitemdao.create(orderitem));
	}
	
	@Disabled
	@Test
	public void testFindAllNotNull() {
		Assertions.assertNotNull(orderitemdao.findAll());
	}
	
	@Disabled
	@Test
	public void testFindOneNotNull() {
		orderitem=orderitemdao.findOne(1);
		Assertions.assertNotNull(orderitem);
		System.out.println("id=1 |"+orderitem);
	}
	@Disabled
	@Test
	public void testFindOneAndDelete() {
		Assertions.assertTrue(orderitemdao.findOneandDelete(4));
	}
	@Disabled
	@Test
	public void testFindOneAndUpdate() {
		orderitem.setName("shruti");
		Assertions.assertTrue(orderitemdao.findOneandUpdate(1, orderitem));
	}


}
