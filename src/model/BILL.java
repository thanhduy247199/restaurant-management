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
public class BILL {
    private int id, idUser;
    private String dateCreate, tableOrder;
    private float sumPrice;

    public BILL(int id, int idUser, String dateCreate, String tableOrder, float sumPrice) {
        this.id = id;
        this.idUser = idUser;
        this.dateCreate = dateCreate;
        this.tableOrder = tableOrder;
        this.sumPrice = sumPrice;
    }
    
    

    public BILL(int id, String dateCreate, String tableOrder) {
        this.id = id;
   
        this.dateCreate = dateCreate;
        this.tableOrder = tableOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getTableOrder() {
        return tableOrder;
    }

    public void setTableOrder(String tableOrder) {
        this.tableOrder = tableOrder;
    }


    
}
