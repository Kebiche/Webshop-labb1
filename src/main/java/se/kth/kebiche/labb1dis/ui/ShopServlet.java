package se.kth.kebiche.labb1dis.ui;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import se.kth.kebiche.labb1dis.bo.ItemHandler;

@WebServlet("/shop")
public class ShopServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("items", ItemHandler.getItems());
        req.getRequestDispatcher("/WEB-INF/views/shop.jsp").forward(req, resp);
    }
}
