<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="sv">
<head>
  <meta charset="UTF-8">
  <title>Logga in</title>
</head>
<body>
  <h1>Webbshoppen</h1>
  <h2>Logga in</h2>
  <% if (request.getAttribute("error") != null) { %>
    <p><%= request.getAttribute("error") %></p>
  <% } %>
  <form method="post" action="<%= request.getContextPath() %>/login">
    <p>Användarnamn: <input type="text" name="username"></p>
    <p>Lösenord: <input type="password" name="password"></p>
    <button type="submit">Logga in</button>
  </form>
</body>
</html>
