package edu.nju.hxh.yummy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

/**
 * @author hxh
 * @date 2019-02-22 10:45
 */
@Entity
@Data
public class ComboItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    private int number;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "combo_id",foreignKey = @ForeignKey(name = "combo_id"))
    private Combo combo;

    public ComboItem() {
    }
}

