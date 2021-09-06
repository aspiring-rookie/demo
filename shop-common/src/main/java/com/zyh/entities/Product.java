package com.zyh.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    /**
     * 主键
     */
    private Integer pid;
    /**
     * 商品名称
     */
    private String pname;
    /**
     * 商品价格
     */
    private Double pprice;
    /**
     * 库存
     */
    private Integer stook;
}
