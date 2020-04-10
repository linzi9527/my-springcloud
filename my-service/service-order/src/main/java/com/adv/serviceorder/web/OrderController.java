package com.adv.serviceorder.web;

import com.adv.serviceorder.vo.Order;
import com.adv.serviceorder.vo.User;
import com.summaryday.framework.d.IBaseDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:OrderController
 * @Description:TODO
 * @Author:nano
 * @Date:20-2-17 下午2:08
 * @Version:1.0
 */
@Slf4j
@RestController
public class OrderController {

    @Autowired
    private IBaseDao baseDao;

    private static List<Order> list=new ArrayList<>();

    @RequestMapping("/msg")
    public String test(String s) {
        log.info("\n test后台数据:" + s);
        return "Hi,"+s;
    }

    @RequestMapping("/listInit/{s}")
    public List<Order> setList(@PathVariable String s) {
        list.clear();
        for(int i=0;i<5;i++) {
            Order o = new Order();
            o.setId("o" + System.currentTimeMillis());
            o.setOrdername("订单大餐-"+s);
            o.setOrderdate(LocalDate.now().toString());
            o.setUserid("user-"+i);
            list.add(o);
        }
        log.info("订单数据:" +list.toString());
        return list;
    }


    @PostMapping("/setUser")
    public List<Order> setListByUser(@RequestBody User user) {
        list.clear();
        for(int i=0;i<5;i++) {
            Order o = new Order();
            o.setId("o" + System.currentTimeMillis());
            o.setOrdername("订单大餐-"+user.getName());
            o.setOrderdate(LocalDate.now().toString());
            o.setUserid(user.getId());
            list.add(o);
        }
        log.info("订单数据:" +list.toString());
        return list;
    }

    @RequestMapping("/list")
    public List<Order> getList() {
        log.info("订单数据:" +list.toString());
        return list;
    }

    @RequestMapping("/order/{oid}")
    public Order getUser(@PathVariable String oid) {
        Order order=null;
       if(list!=null&&oid!=null){
        for(Order o:list){
            if(oid.equals(o.getUserid())){
                order=o;
            }
        }
       }
        log.info("数据:" + order);
        return order;
    }

    @PostMapping("/saveOrder")
    public boolean saveOrder(@RequestBody(required = false) Order o) {
        log.info("=========saveOrder(baseDao="+baseDao+")============");
        boolean flag=false;
        try {
            flag=baseDao.save(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @GetMapping("/getOrder/{id}")
    public Order getOrder(@PathVariable String id) {
        log.info("=========getOrder(baseDao="+baseDao+")============");
        try {
            Order o=(Order)baseDao.get(id,Order.class,false);
            return o;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
