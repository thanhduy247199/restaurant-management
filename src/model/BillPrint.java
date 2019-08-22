/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Administrator
 */
public class BillPrint {
    private String foodName;
    private int amount;
    private float price;
    private float sumprice;

    public BillPrint(String foodName, int amount, float price, float sumprice) {
        this.foodName = foodName;
        this.amount = amount;
        this.price = price;
        this.sumprice = sumprice;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getSumprice() {
        return sumprice;
    }

    public void setSumprice(float sumprice) {
        this.sumprice = sumprice;
    }
    
    
    
    
}
