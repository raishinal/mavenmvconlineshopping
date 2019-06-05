/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Raishin
 */
@Entity
public class Cart {
     @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String username;
    private int productid;
    private String productname;
    private String orderdate;

    public Cart() {
    }

    public Cart(String username, int productid, String productname, String orderdate) {
        this.username = username;
        this.productid = productid;
        this.productname = productname;
        this.orderdate = orderdate;
    }

    public Cart(int id, String username, int productid, String productname, String orderdate) {
        this.id = id;
        this.username = username;
        this.productid = productid;
        this.productname = productname;
        this.orderdate = orderdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

   
            
}
