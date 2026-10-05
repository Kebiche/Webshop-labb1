<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="sv">
<head>
  <meta charset="UTF-8">
  <title>Logga in</title>
</head>
<body>
<main class="login">
  <h1>Webbshoppen</h1>
  <h2>Logga in</h2>
  <% if (request.getAttribute("error") != null) { %>
    <p class="error"><%= request.getAttribute("error") %></p>
  <% } %>
  <form method="post" action="<%= request.getContextPath() %>/login">
    <label>Användarnamn
      <input type="text" name="username">
    </label>
    <label>Lösenord
      <input type="password" name="password">
    </label>
    <button type="submit">Logga in</button>
  </form>
</main>
</body>
</html>
