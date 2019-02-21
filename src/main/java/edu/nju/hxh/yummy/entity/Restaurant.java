package edu.nju.hxh.yummy.entity;

/**
 * @author hxh
 * @date 2019-02-15 18:24
 */
import lombok.Data;

import javax.persistence.*;

/**
 * @author hxh
 * @date 2019-02-15 15:28
 */
@Data
@Entity
@Table(name = "Restaurant")
public class Restaurant {
    public static enum Type{
        /**
         * 低级
         */
        LOW,
        /**
         * 中级
         */
        MIDDLE,
        /**
         * 高级
         */
        HIGH
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 7)
    private int rid;
    private String name;
    private String password;
    private String description;
    private Type type;
    private double balance;
    private String email;

    private String province;
    private String city;
    private String district;
    private String street;

    public Restaurant() {
    }



}
