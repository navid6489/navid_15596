package ecommerceOTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import ecommerceOTO.dao.ProductDao;
import ecommerceOTO.model.Product;


public class ProductDaoTest {
	
	private Product product;
	private ProductDao productsdao;
	
	@BeforeEach()
	public void beforeEach() {
		product=new Product("naruto",1234);
		productsdao=new ProductDao();
	}

	@Test
	public void testcreate(){
		Assertions.assertTrue(productsdao.create(product));
	}
	@Disabled
	@Test
	public void testFindAllNotNull() {
		Assertions.assertNotNull(productsdao.findAll());
	}

	@Disabled
	@Test
	public void testFindOneNotNull() {
		product=productsdao.findOne(1);
		Assertions.assertNotNull(product);
		System.out.println("id=1 |"+product);
	}
	@Disabled
	@Test
	public void testFindOneAndDelete() {
		Assertions.assertTrue(productsdao.findOneandDelete(4));
	}
	@Disabled
	@Test
	public void testFindOneAndUpdate() {
		product.setPname("Tshirt");
		Assertions.assertTrue(productsdao.findOneandUpdate(2, product));
	}

}
