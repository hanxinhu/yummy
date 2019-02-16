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
        DELETED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer uid;
    private String mail;
    private String name;
    private String password;
    private String phone;
    private State state;
    private int level;
    private double balance;
    /**
     * 保存uuid 激活用
     */
    private String token;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Address> addresses;
    /**
     * 积分 用于确定用户等级
     */
    private int score;

    public User(String mail, String name, String password, String phone) {
        this.mail = mail;
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
}
