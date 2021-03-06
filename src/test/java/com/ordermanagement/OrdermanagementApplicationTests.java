package com.ordermanagement;
import com.ordermanagement.repository.entity.Movie;
import com.ordermanagement.repository.entity.OrderNew;
import com.ordermanagement.service.OrderService;
import net.minidev.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
        import org.springframework.test.web.servlet.MvcResult;
        import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
        import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.http.ResponseEntity.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
        import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@ActiveProfiles("dev")
public class OrdermanagementApplicationTests {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Autowired
    private OrderService orderService;



    @Before
    public void setup()
    {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }


    @Test
    public void createFirstOrderReturnsOrderId1() throws Exception {


        mockMvc.perform(post("/cart")).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$orderId").exists())
                .andExpect(jsonPath("$description").exists())
                .andExpect(jsonPath("$statusFlag", is("open")));
    }


    @Test
    public void testGetOrderWhichExists() throws Exception {
        this.mockMvc.perform(get("/cart")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.orderId").exists())
                .andExpect(jsonPath("$.description").exists())
                .andExpect(jsonPath("$.statusFlag").exists());
    }


	@Test
    public void testPutMovieWithCorrectOrder() throws Exception {
        OrderNew order =createTestOrder();
        order.setOrderID(1L);
	    Movie m = new Movie();
        m.setMovieId(1L);
        m.setName("Avengers");
        JSONObject json = createJsonWithOrder(order);
        String obj = json.toJSONString();
        MvcResult result = this.mockMvc.perform(put("/cart").contentType(MediaType.APPLICATION_JSON_UTF8)
        .content(obj))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andReturn();
        Assert.assertThat(result.getResponse().getContentAsString(),equalTo("1"));

     // MvcResult result =   this.mockMvc.perform(put("/cart").contentType(MediaType.APPLICATION_JSON_UTF8).content())

	}

    private JSONObject createJsonWithOrder(OrderNew order) {
        JSONObject obj = new JSONObject();
        obj.put("orderId",order.getOrderID());
        obj.put("description",order.getDescription());
        obj.put("statusFlag",order.getStatusFlag());
        return obj;
    }



    public OrderNew createTestOrder()
    {
        OrderNew order = new OrderNew();
        order.setDescription("order1");
        order.setStatusFlagOpen();
        return order;
    }



    public static void main(String[] args) {

        OrdermanagementApplicationTests test = new OrdermanagementApplicationTests();
        try {
            test.createFirstOrderReturnsOrderId1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
