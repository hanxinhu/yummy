package edu.nju.hxh.yummy.entity;

/**
 * @author hxh
 * @date 2019-02-15 18:24
 */

import lombok.Data;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author hxh
 * @date 2019-02-15 15:28
 */
@Data
@Entity
@Table(name = "Restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 7)
    private int rid;
    private String name;
    private String password;
    private String description;
    private String type;
    private double balance;
    private String email;

    private String province;
    private String city;
    private String district;
    private String street;

    private String createTime;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "rid", foreignKey = @ForeignKey(name = "rid", value = ConstraintMode.CONSTRAINT))
    private Set<Dish> dishes;

    public Restaurant() {

    }

    public List<DishItem> getDishItems(){
        List<DishItem> dishItems = new LinkedList<>();
        for(Dish d : dishes){
            DishItem item = new DishItem(d);
            dishItems.add(item);
        }
        return dishItems;
    }

}
