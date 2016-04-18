package com.ordermanagement;

import com.ordermanagement.controller.OrderController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class OrdermanagementApplicationTests {
	private OrderController orderController;
	@Before
	public void createController()
	{
		orderController = new OrderController();
	}


	@Test
	public void contextLoads() {

	}

	@Test
	public void createFirstOrderReturnsOrderId()
	{
		Map<String,Object> map = new HashMap<>();
		map.put("customerId",1);
		Assert.assertEquals("First customer created must return 1",1,orderController.createOrder(map, new MockHttpServletResponse()));

	}

/*	@Test
	public void movieAddedToFirstOrderReturnsStatusCodeOk()
	{
		Map<String,Object> map = new HashMap<>();
		map.put("orderId",1);
		map.put("movieId",1);
		Assert.assertEquals("Movie added to first order returns statuscode ok",HttpServletResponse.SC_OK,orderController.addMovie(map,new MockHttpServletResponse()));


	}
*/
	/*@Test		so sollten die void methoden getestet werden i man wtf
	public void testCollectionAdd() {
		Collection collection = new ArrayList();
		assertEquals(0, collection.size());
		collection.add("itemA");
		assertEquals(1, collection.size());
		collection.add("itemB");
		assertEquals(2, collection.size());
	}*/

	/*
	@Test
	public void deleteMovieReturnsStatusCodeOk()
	{
		Map<String,Object> map = new HashMap<>();
		map.put("orderId",1);
		map.put("movieId",1);
		Assert.assertEquals("Movie with id 1 deleted from order 1 returns statuscode ok",HttpServletResponse.SC_OK,orderController.deleteMovie(map,new MockHttpServletResponse()));
	}*/

	@Test
	public void readOrderFromLeftShoppingCartWithStatusflagOpen()
	{
		Map<String,Object> map = new HashMap<>();
		map.put("orderId",1);
		//Assert.assertEquals("Make sure that it is returned order id 1 with the given order which's is is also 1 ",1,orderController.readOrder(map,new MockHttpServletResponse()));

	}

	public static void main(String[] args) {

	}

}
