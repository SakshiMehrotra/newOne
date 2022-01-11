package shop.buyAndSell.quickr.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import shop.buyAndSell.quickr.models.Order;
import shop.buyAndSell.quickr.responses.ResponseData;
import shop.buyAndSell.quickr.services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ProductOrder")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:3000" })
public class OrderController {

    Date date=new Date();
    SimpleDateFormat formatter=new SimpleDateFormat("dd/mm/yyyy");
    String currentDate=formatter.format(date);

    @Autowired
    private OrderService orderService;
    @PostMapping("/addOrder")
    public ResponseData addOrder(@RequestBody Order order) {
        order.setOrderId(UUID.randomUUID().toString());
        order.setOrderDate(currentDate);
        Order data = orderService.addOrder(order);
        if (data != null) {

            return new ResponseData(200, data, "order placed successfully");
        }
        return new ResponseData(400, null, "order is not placed");
    }

    @GetMapping("/getOrderDetails")
    public ResponseData getOrders() {

        List<Order> orderList = orderService.getOrders();
        if (orderList.size() > 0) {
            return new ResponseData(200, orderList, "success");
        }
        return new ResponseData(400, null, "order details not found");
    }

    @PutMapping("/updateOrder")
    public ResponseData updateOrder(@RequestBody Order order){
        Order data = orderService.validateId(order.getOrderId());
        if (data == null) {
            return new ResponseData(800, null, "give proper order id");
        }
        data=new Order();
        data=orderService.updateOrder(order);
        if(data==null){
            return new ResponseData(400, order, "order could not be updated");
        }else{
            return new ResponseData(200, data, "order is successfully updated");
        }
    }

}
