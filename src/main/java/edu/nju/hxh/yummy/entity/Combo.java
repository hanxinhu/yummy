package edu.nju.hxh.yummy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author hxh
 * @date 2019-03-13 08:23
 */
@Data
@Entity
public class Combo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    /**
     * 存dish的ID
     */
    @ElementCollection
    List<Integer> dishes;

    private String name;
    /**
     * 优惠金额
     */
    private double privilege;

    private String start;

    private String end;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurantID", foreignKey = @ForeignKey(name = "restaurantID"))
    private Restaurant restaurant;
    public Combo() {
    }
}
