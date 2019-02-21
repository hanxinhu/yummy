package edu.nju.hxh.yummy.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author hxh
 * @date 2019-02-15 18:23
 */
@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int aid;
    /**
     * 省份
     */
    private String province;
    /**
     * 城市
     */
    private String city;
    /**
     * 区
     */
    private String district;
    /**
     * 街道
     */
    private String street;
    private String name;
    private String phone;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;

    public Address(){

    }

    public Address(String province, String city, String district, String street, String name, String phone) {
        this.province = province;
        this.city = city;
        this.district = district;
        this.street = street;
        this.name = name;
        this.phone = phone;

    }
}
