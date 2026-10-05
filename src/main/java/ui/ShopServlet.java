package ui;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import bo.CartHandler;
import bo.ItemHandler;
import bo.ShoppingCart;

@WebServlet("/shop")
public class ShopServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShoppingCart cart = (ShoppingCart) req.getSession().getAttribute("cart");
        req.setAttribute("items", ItemHandler.getItems());
        req.setAttribute("cartInfo", CartHandler.getCart(cart));
        req.getRequestDispatcher("/WEB-INF/views/shop.jsp").forward(req, resp);
    }
}
