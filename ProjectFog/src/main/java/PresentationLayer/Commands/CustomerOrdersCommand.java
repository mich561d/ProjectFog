/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer.Commands;

import FunctionLayer.Entities.Carport;
import FunctionLayer.Entities.Order;
import FunctionLayer.LogicFacade;
import PresentationLayer.Command;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Michael & Christian
 */
public class CustomerOrdersCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int id = (int)request.getSession().getAttribute("CustomerID");
        ArrayList<Order> orders = LogicFacade.getAllOrdersByCustomerID(id);
        ArrayList<Carport> products = new ArrayList();
        for (int i = 0; i < orders.size(); i++) {
            products.add(LogicFacade.getProductFromOrderByID(orders.get(i).getProductsID()));
        }
        request.getSession().setAttribute("Orders", orders);
        request.getSession().setAttribute("Products", products);
        return "CustomerOrders";
    }

}
