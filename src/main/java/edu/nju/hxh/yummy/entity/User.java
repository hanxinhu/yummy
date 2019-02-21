package edu.nju.hxh.yummy.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author hxh
 * @date 2019-02-15 18:21
 */
@Entity

@Data
public class User {
    public static enum State {
        /**
         * 未验证
         */
        UNAUTHORIZED,
        /**
         * 正常
         */
        NORMAL,
        /**
         * 已注销
         */
        CANCELED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer uid;
    private String email;
    private String name;
    private String password;
    private String phone;

    private State state = State.UNAUTHORIZED;
    private int level = 0;
    private double balance = 0;
    /**
     * 保存uuid 激活用
     */
    private String token;

    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",foreignKey = @ForeignKey(name = "user_id",value = ConstraintMode.CONSTRAINT))
    private List<Address> addresses;
    /**
     * 积分 用于确定用户等级
     */
    private int score;

    public User(String email, String name, String password, String phone) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

    public User() {
    }

    public void addAddress(Address address) {
        address.setUser(this);
        if (this.addresses == null) {
            addresses = new ArrayList<>();
        }
        addresses.add(address);
    }
    public void putKeyInAddress(){
        if(this.getAddresses()!=null){
            for(Address address : this.getAddresses()){
                address.setUser(this);
            }
        }
    }
}
