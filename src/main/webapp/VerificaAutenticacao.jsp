<%
    if (session.getAttribute("autenticado") != "true") {
%> <jsp:forward page="index.html"></jsp:forward> <%
    }
%>