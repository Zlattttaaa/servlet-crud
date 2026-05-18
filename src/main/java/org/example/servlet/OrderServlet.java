package org.example.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.model.Order;
import org.example.repository.OrderRepository;

import java.io.IOException;

@WebServlet("/orders")
public class OrderServlet extends HttpServlet {

    private final OrderRepository repository = new OrderRepository();
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        Order order = mapper.readValue(req.getInputStream(), Order.class);

        repository.save(order);

        resp.getWriter().write("Order created");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        Order order = repository.findById(id);

        if (order != null) {
            mapper.writeValue(resp.getWriter(), order);
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            resp.getWriter().write("Order not found");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        Order order = mapper.readValue(req.getInputStream(), Order.class);

        repository.update(order);

        resp.getWriter().write("Order updated");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        repository.delete(id);

        resp.getWriter().write("Order deleted");
    }
}