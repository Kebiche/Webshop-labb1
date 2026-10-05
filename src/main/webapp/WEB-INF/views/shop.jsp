<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Collection, se.kth.kebiche.labb1dis.bo.Item" %>
<%
    Collection<Item> items = (Collection<Item>) request.getAttribute("items");
%>
<!DOCTYPE html>
<html lang="sv">
<head>
  <meta charset="UTF-8">
  <title>Butik</title>
</head>
<body>
<%@ include file="header.jspf" %>
<main>
  <h1>Varor</h1>
  <table>
    <tr><th>Vara</th><th>Beskrivning</th><th class="num">Pris</th><th></th></tr>
    <% for (Item item : items) { %>
      <tr>
        <td><%= item.getName() %></td>
        <td><%= item.getDescription() %></td>
        <td class="num"><%= String.format("%.2f kr", item.getPrice()) %></td>
        <td>
          <form method="post" action="<%= ctx %>/cart" class="inline">
            <input type="hidden" name="action" value="add">
            <input type="hidden" name="itemId" value="<%= item.getId() %>">
            <input type="number" name="quantity" value="1" min="1" max="99" class="qty">
            <button type="submit">Lägg i kundvagn</button>
          </form>
        </td>
      </tr>
    <% } %>
  </table>
</main>
</body>
</html>
