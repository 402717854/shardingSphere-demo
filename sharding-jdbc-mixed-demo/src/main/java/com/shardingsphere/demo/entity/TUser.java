package com.shardingsphere.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class TUser implements Serializable {
    private Long id;

    private Long orderId;

    private String name;

    private Date createTime;

    private static final long serialVersionUID = 1L;

}