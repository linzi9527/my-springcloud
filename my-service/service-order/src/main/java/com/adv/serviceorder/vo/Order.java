package com.adv.serviceorder.vo;

import com.summaryday.framework.a.Colum;
import com.summaryday.framework.a.Key;
import com.summaryday.framework.a.Table;
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
@Table(name = "tbl_order",type = Table.policy.VO)
public class Order {

    @Key(isPrimary = true)
    @Colum(columName = "id", isNUll = false, type = Colum.ObjTypes.VARCHAR)
    private String id;

    @Colum(columName = "ordername", isNUll = false, type = Colum.ObjTypes.VARCHAR)
    private String ordername;

    @Colum(columName = "orderdate", isNUll = false, type = Colum.ObjTypes.VARCHAR)
    private String orderdate;

    @Colum(columName = "userid", isNUll = false, type = Colum.ObjTypes.VARCHAR)
    private String userid;
}
