/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.jfoenix.controls.JFXButton;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Administrator
 */
public class FOOD {
    private int id,order,amount;
    private String foodName, dateCreate,dateEdit,image,type;
    private float price;
    private JFXButton editBtn, deleteBtn;
    private ImageView imgView;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public FOOD(String foodName, JFXButton editBtn) {
        this.foodName = foodName;
        this.editBtn = editBtn;
        this.amount = amount;
        this.id = id;
    }
    
    public FOOD(int id, String foodName, String image, String type, float price) {
        this.id = id;
        this.foodName = foodName;
        this.image = image;
        this.type = type;
        this.price = price;
    }

    public JFXButton getEditBtn() {
        return editBtn;
    }

    public void setEditBtn(JFXButton editBtn) {
        this.editBtn = editBtn;
    }

    public JFXButton getDeleteBtn() {
        return deleteBtn;
    }

    public void setDeleteBtn(JFXButton deleteBtn) {
        this.deleteBtn = deleteBtn;
    }

    public ImageView getImgView() {
        
        
        
        return imgView;
    }

    public void setImgView(ImageView imgView) {
        this.imgView = imgView;
    }

    public FOOD(int id, int order, String foodName, String dateCreate, String dateEdit, String image, String type, float price, JFXButton editBtn, JFXButton deleteBtn) {
        this.id = id;
        this.order = order;
        this.foodName = foodName;
        this.dateCreate = dateCreate;
        this.dateEdit = dateEdit;
        this.image = image;
        this.type = type;
        this.price = price;
        this.editBtn = editBtn;
        this.deleteBtn = deleteBtn;
        
    }

    public FOOD(int id, int order, String foodName, String dateCreate, String dateEdit, String image, String type, float price) {
        this.id = id;
        this.order = order;
        this.foodName = foodName;
        this.dateCreate = dateCreate;
        this.dateEdit = dateEdit;
        this.image = image;
        this.type = type;
        this.price = price;
          this.editBtn = new JFXButton("Edit");
        this.deleteBtn = new JFXButton("Delete");
       
        
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getDateEdit() {
        return dateEdit;
    }

    public void setDateEdit(String dateEdit) {
        this.dateEdit = dateEdit;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
}
