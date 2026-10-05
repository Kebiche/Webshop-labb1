<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="se.kth.kebiche.labb1dis.bo.CartItem" %>
<!DOCTYPE html>
<html lang="sv">
<head>
  <meta charset="UTF-8">
  <title>Kundvagn</title>
</head>
<body>
<%@ include file="header.jspf" %>
<main>
  <h1>Kundvagn</h1>
  <% if (cart.getItems().isEmpty()) { %>
    <p>Kundvagnen är tom. <a href="<%= ctx %>/shop">Till butiken</a></p>
  <% } else { %>
    <table>
      <tr><th>Vara</th><th class="num">Styckpris</th><th class="num">Antal</th><th class="num">Summa</th><th></th></tr>
      <% for (CartItem cartItem : cart.getItems()) { %>
        <tr>
          <td><%= cartItem.getItem().getName() %></td>
          <td class="num"><%= String.format("%.2f kr", cartItem.getItem().getPrice()) %></td>
          <td class="num"><%= cartItem.getQuantity() %></td>
          <td class="num"><%= String.format("%.2f kr", cartItem.getSubtotal()) %></td>
          <td>
            <form method="post" action="<%= ctx %>/cart" class="inline">
              <input type="hidden" name="action" value="remove">
              <input type="hidden" name="itemId" value="<%= cartItem.getItem().getId() %>">
              <button type="submit" class="secondary">Ta bort</button>
            </form>
          </td>
        </tr>
      <% } %>
      <tr>
        <th colspan="3">Totalt</th>
        <th class="num"><%= String.format("%.2f kr", cart.getTotal()) %></th>
        <th></th>
      </tr>
    </table>
  <% } %>
</main>
</body>
</html>
