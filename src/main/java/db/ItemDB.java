package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import bo.Item;

public class ItemDB extends Item {

    private ItemDB(int id, String name, String description, double price) {
        super(id, name, description, price);
    }

    public static Collection<Item> searchItems() {
        ArrayList<Item> items = new ArrayList<>();
        try (Connection con = DBManager.getConnection();
             Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery("SELECT id, name, description, price FROM items")) {
            while (rs.next()) {
                items.add(new ItemDB(rs.getInt("id"), rs.getString("name"),
                        rs.getString("description"), rs.getDouble("price")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public static Item searchItem(int id) {
        try (Connection con = DBManager.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "SELECT id, name, description, price FROM items WHERE id = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new ItemDB(rs.getInt("id"), rs.getString("name"),
                        rs.getString("description"), rs.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
