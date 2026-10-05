package se.kth.kebiche.labb1dis.ui;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import se.kth.kebiche.labb1dis.bo.CartHandler;
import se.kth.kebiche.labb1dis.bo.ShoppingCart;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShoppingCart cart = (ShoppingCart) req.getSession().getAttribute("cart");
        req.setAttribute("cartInfo", CartHandler.getCart(cart));
        req.getRequestDispatcher("/WEB-INF/views/cart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShoppingCart cart = (ShoppingCart) req.getSession().getAttribute("cart");
        String action = req.getParameter("action");
        int itemId = toNumber(req.getParameter("itemId"));

        if ("add".equals(action)) {
            int quantity = toNumber(req.getParameter("quantity"));
            CartHandler.addItem(cart, itemId, quantity);
            resp.sendRedirect(req.getContextPath() + "/shop");
        } else if ("remove".equals(action)) {
            CartHandler.removeItem(cart, itemId);
            resp.sendRedirect(req.getContextPath() + "/cart");
        }
    }

    // Returnerar 0 om texten inte är ett giltigt heltal
    private int toNumber(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
