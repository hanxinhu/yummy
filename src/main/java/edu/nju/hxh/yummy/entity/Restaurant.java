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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rid;
    private String name;
    private Type type;
    private double balance;

    private String province;
    private String city;
    private String district;
    private String street;

    public Restaurant() {
    }

    public Restaurant(String name,  Type type, String province, String city, String district, String street) {
        this.name = name;
        this.type = type;
        this.province = province;
        this.city = city;
        this.district = district;
        this.street = street;
        this.balance = 0;
    }

}
