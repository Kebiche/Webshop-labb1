<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Collection, ui.ItemInfo" %>
<%
    Collection<ItemInfo> items = (Collection<ItemInfo>) request.getAttribute("items");
%>
<!DOCTYPE html>
<html lang="sv">
<head>
  <meta charset="UTF-8">
  <title>Butik</title>
</head>
<body>
<%@ include file="header.jspf" %>
  <h1>Varor</h1>
  <table border="1">
    <tr><th>Vara</th><th>Beskrivning</th><th>Pris</th><th></th></tr>
    <% for (ItemInfo item : items) { %>
      <tr>
        <td><%= item.getName() %></td>
        <td><%= item.getDescription() %></td>
        <td><%= String.format("%.2f kr", item.getPrice()) %></td>
        <td>
          <form method="post" action="<%= ctx %>/cart">
            <input type="hidden" name="action" value="add">
            <input type="hidden" name="itemId" value="<%= item.getId() %>">
            <input type="number" name="quantity" value="1" min="1" max="99">
            <button type="submit">Lägg i kundvagn</button>
          </form>
        </td>
      </tr>
    <% } %>
  </table>
</body>
</html>
