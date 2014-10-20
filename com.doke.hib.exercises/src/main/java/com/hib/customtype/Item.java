package com.hib.customtype;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    protected Long id;

    
    protected String name;

    
    @org.hibernate.annotations.Type(
    		type = "com.hib.customtype.MonetaryAmountType"
    		)
    @Column(name = "INITIAL_PRICE")
    protected MonetaryAmount buyNowPrice;

    
    
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MonetaryAmount getBuyNowPrice() {
        return buyNowPrice;
    }

    public void setBuyNowPrice(MonetaryAmount buyNowPrice) {
        this.buyNowPrice = buyNowPrice;
    }

    
    
    // ...
}