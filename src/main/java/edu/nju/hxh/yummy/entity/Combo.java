package edu.nju.hxh.yummy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * 套餐
 * @author hxh
 * @date 2019-02-21 23:00
 */
@Entity
@Data
public class Combo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    private int number;
    private double price;
    private String start;
    private String end;
    /**
     * 套餐所属于的类型
     */
    private String type;

    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "combo_id",foreignKey = @ForeignKey(name = "combo_id",value = ConstraintMode.CONSTRAINT))
    private Set<Combo> items;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rid",foreignKey = @ForeignKey(name = "rid"))
    private Restaurant restaurant;

    public Combo() {
    }
}
