package edu.nju.hxh.yummy.entity;

/**
 * @author hxh
 * @date 2019-02-15 18:24
 */

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * @author hxh
 * @date 2019-02-15 15:28
 */
@Data
@Entity
public class Restaurant {

    @Id
    private String id;
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
    @JoinColumn(name = "restaurantID", foreignKey = @ForeignKey(name = "restaurantID", value = ConstraintMode.CONSTRAINT))
    private Set<Dish> dishes;

    public Restaurant() {

    }
    public void  setInfoUpdate(InfoUpdate infoUpdate){
        this.name = infoUpdate.getNameAfter();
        this.description = infoUpdate.getDescriptionAfter();
        this.city = infoUpdate.getCityAfter();
        this.province = infoUpdate.getProvinceAfter();
        this.district = infoUpdate.getDistrictAfter();
        this.street = infoUpdate.getStreetAfter();
        this.type =infoUpdate.getTypeAfter();
    }


}
