package edu.nju.hxh.yummy.entity;

import edu.nju.hxh.yummy.util.TimeUtil;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author hxh
 * @date 2019-03-09 18:08
 */
@Entity
@Data
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "restaurant")
    private String rid;

    private int uid;
    private String createTime = TimeUtil.getTime();
    private String payTime;
    private String receiveTime;
    /**
     * 预期送达时间
     */
    private String expectedTime;

    public enum State {
        /**
         * 未支付
         */
        unpaid,
        /**
         * 已支付
         */
        paid,
        /**
         * 确认收货
         */
        received,
        /**
         * 订单取消
         */
        canceled,
    }

    /**
     * 省份
     */
    private String province;
    /**
     * 城市
     */
    private String city;
    /**
     * 区
     */
    private String district;
    /**
     * 街道
     */
    private String street;
    private String name;
    private String phone;
    private State state = State.unpaid;
    private boolean settled = false;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "bid", foreignKey = @ForeignKey(name = "bid", value = ConstraintMode.CONSTRAINT))
    private List<BillItem> items;
    /**
     * 套餐的优惠价格
     */
    private double privilege;

    /**
     * 假设是会员折扣  0级开始 每一级多折扣百分之一 最多折扣百分之十
     */
    private double discount;
    /**
     * 为所有item的价格总和
     */
    private double sum;
    /**
     * 实际付款
     */
    private double moneyToPay;

    public Bill() {
    }

}
