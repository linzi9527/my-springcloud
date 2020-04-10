package com.adv.producer.vo;

import com.summaryday.framework.a.Colum;
import com.summaryday.framework.a.Key;
import com.summaryday.framework.a.Table;
import lombok.Data;

/**
 * @ClassName:User
 * @Description:TODO
 * @Author:nano
 * @Date:20-2-17 上午11:09
 * @Version:1.0
 */
@Data
@Table(name = "tbl_user",type = Table.policy.VO)
public class User {

    @Key(isPrimary = true)
    @Colum(columName = "id", isNUll = false, type = Colum.ObjTypes.VARCHAR)
    private String id;

    @Colum(columName = "username", isNUll = false, type = Colum.ObjTypes.VARCHAR)
    private String username;

    @Colum(columName = "age", isNUll = false, type = Colum.ObjTypes.INT)
    private int age;

    @Colum(columName = "addr", isNUll = false, type = Colum.ObjTypes.VARCHAR)
    private String addr;

}
