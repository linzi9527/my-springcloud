package com.adv.serviceuser.vo;

import lombok.Data;

import java.time.LocalDate;

/**
 * @ClassName:Order
 * @Description:TODO
 * @Author:nano
 * @Date:20-2-17 下午2:08
 * @Version:1.0
 */
@Data
public class Order {
    private String id;
    private String orderName;
    private LocalDate orderDate;
    private String userId;
}
