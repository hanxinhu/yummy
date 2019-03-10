package edu.nju.hxh.yummy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

/**
 * @author hxh
 * @date 2019-03-09 18:18
 */
@Entity
@Data
public class BillItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private int did;
    private double price;
    private int num;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bid",foreignKey = @ForeignKey(name = "bid"))
    private Bill bill;

    public BillItem() {

    }
}
