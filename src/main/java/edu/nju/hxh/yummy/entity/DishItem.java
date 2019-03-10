package edu.nju.hxh.yummy.entity;

import edu.nju.hxh.yummy.util.TimeUtil;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author hxh
 * @date 2019-03-10 09:36
 */
@Data
@Entity
public class DishItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * dish id
     */
    private int did;
    /**
     * restaurant ID
     */
    private int rid;
    /**
     * 剩余数量
     */
    private int num;

    private String time = new TimeUtil().toString();

    private String name;

    private String description;

    private String type;

    private double price;

    public DishItem() {
    }

    public DishItem(Dish d){
        this.did = d.getId();
        this.rid = d.getRestaurant().getRid();
        this.num = d.getNumber();
        this.name = d.getName();
        this.type = d.getType();
        this.description = d.getDescription();
        this.price = d.getPrice();
    }
}
