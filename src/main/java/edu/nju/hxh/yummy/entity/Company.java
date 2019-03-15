package edu.nju.hxh.yummy.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author hxh
 * @date 2019-03-09 19:13
 */
@Data
@Entity
public class Company {
    @Id
    private String id = "admin";
    private double balance;

    public Company() {
    }
}
