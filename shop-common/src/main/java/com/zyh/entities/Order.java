package com.zyh.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    /**
     * 订单id
     */
    private Long oid;
    //用户
    /**
     * 用户id
     */
    private Integer uid;
    /**
     * 用户名
     */
    private String uname;
    //商品
    /**
     * 商品id
     */
    private Integer pid;
    /**
     * 商品名称
     */
    private String pname;
    /**
     * 商品单价
     */
    private Double pprice;
    //数量
    /**
     * 购买数量
     */
    private Integer num;

}
