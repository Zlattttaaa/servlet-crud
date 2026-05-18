package org.example.repository;

import org.example.model.Order;

import java.util.HashMap;
import java.util.Map;

public class OrderRepository {

    private static final Map<Integer, Order> orders = new HashMap<>();

    public void save(Order order) {
        orders.put(order.getId(), order);
    }

    public Order findById(int id) {
        return orders.get(id);
    }

    public void update(Order order) {
        orders.put(order.getId(), order);
    }

    public void delete(int id) {
        orders.remove(id);
    }
}