package org.example.model;

import java.util.List;

public class Order {

    private int id;
    private String date;
    private double cost;
    private List<Product> products;

    public Order() {
    }

    public Order(int id, String date, double cost, List<Product> products) {
        this.id = id;
        this.date = date;
        this.cost = cost;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public double getCost() {
        return cost;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}