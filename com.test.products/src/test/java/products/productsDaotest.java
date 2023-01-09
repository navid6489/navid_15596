package products;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.test.products.dao.productsDao;
import com.test.products.model.products;


public class productsDaotest {

	private products product;
	private productsDao productsdao;
	
	@BeforeEach()
	public void beforeEach() {
		product=new products("vinit");
		productsdao=new productsDao();
	}
	@Disabled
	@Test
	public void testcreateproduct(){
		Assertions.assertTrue(productsdao.createproduct(product));
	}
	
	@Test
	public void testFindAllNotNull() {
		Assertions.assertNotNull(productsdao.findAll());
	}
	
	@Test
	public void testFindOneNotNull() {
		product=productsdao.findOne(1);
		Assertions.assertNotNull(product);
		System.out.println("id=1 |"+product);
	}
	
	@Test
	public void testFindOneAndDelete() {
		Assertions.assertTrue(productsdao.findOneandDelete(4));
	}
	
	@Test
	public void testFindOneAndUpdate() {
		product.setName("shruti");
		Assertions.assertTrue(productsdao.findOneandUpdate(2, product));
	}

	
}
