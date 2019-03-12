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
    private String rid;
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
    private State state = State.waiting;

    public static enum State {
        /**
         * 等待审批
         */
        waiting,
        /**
         * 审批通过
         */
        normal,
        /**
         * 被拒
         */
        rejected,

    }

    /**
     * 是否正在审批
     */
    private boolean updating;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "rid", foreignKey = @ForeignKey(name = "rid", value = ConstraintMode.CONSTRAINT))
    private Set<Dish> dishes;

    public Restaurant() {

    }


}
