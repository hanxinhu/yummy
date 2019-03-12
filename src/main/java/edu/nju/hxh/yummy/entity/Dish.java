package edu.nju.hxh.yummy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

/**
 * @author hxh
 * @date 2019-02-21 23:01
 */
@Data
@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    private double price;
    private String start;
    private String end;
    /**
     * 菜所属于的类型
     */
    private String type;


    /**
     * 库存
     */
    private int number;
    /**
     * 已经售出的量
     */
    private int sales;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rid", foreignKey = @ForeignKey(name = "rid"))
    private Restaurant restaurant;

    public Dish() {

    }


}
