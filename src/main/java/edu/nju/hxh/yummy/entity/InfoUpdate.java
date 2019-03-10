package edu.nju.hxh.yummy.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author hxh
 * @date 2019-03-07 16:25
 */
@Data
@Entity
public class InfoUpdate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    /**
     * 餐厅的编号
     */
    private int rid;

    public static enum State{
        /**
         * 等待审批中
         */
        waiting,
        /**
         * 审批通过
         */
        approved,
        /**
         * 审批被拒
         */
        rejected

    }

    private State state = State.waiting;

    private String nameBefore;
    private String nameAfter;

    private String descriptionBefore;
    private String descriptionAfter;

    private String provinceBefore;
    private String provinceAfter;

    private String cityBefore;
    private String cityAfter;

    private String districtBefore;
    private String districtAfter;

    private String streetBefore;
    private String streetAfter;

    private String typeBefore;
    private String typeAfter;

    public InfoUpdate() {
    }
}
