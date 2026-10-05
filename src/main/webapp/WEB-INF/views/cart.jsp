<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="ui.CartItemInfo" %>
<!DOCTYPE html>
<html lang="sv">
<head>
  <meta charset="UTF-8">
  <title>Kundvagn</title>
</head>
<body>
<%@ include file="header.jspf" %>
  <h1>Kundvagn</h1>
  <% if (cartInfo.getItems().isEmpty()) { %>
    <p>Kundvagnen är tom. <a href="<%= ctx %>/shop">Till butiken</a></p>
  <% } else { %>
    <table border="1">
      <tr><th>Vara</th><th>Styckpris</th><th>Antal</th><th>Summa</th><th></th></tr>
      <% for (CartItemInfo item : cartInfo.getItems()) { %>
        <tr>
          <td><%= item.getName() %></td>
          <td><%= String.format("%.2f kr", item.getPrice()) %></td>
          <td><%= item.getQuantity() %></td>
          <td><%= String.format("%.2f kr", item.getSubtotal()) %></td>
          <td>
            <form method="post" action="<%= ctx %>/cart">
              <input type="hidden" name="action" value="remove">
              <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
              <button type="submit">Ta bort</button>
            </form>
          </td>
        </tr>
      <% } %>
      <tr>
        <th colspan="3">Totalt</th>
        <th><%= String.format("%.2f kr", cartInfo.getTotal()) %></th>
        <th></th>
      </tr>
    </table>
  <% } %>
</body>
</html>
