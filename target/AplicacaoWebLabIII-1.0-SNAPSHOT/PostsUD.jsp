<%@page import="com.mycompany.aplicacaoweblabiii.model.Tags"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.mycompany.aplicacaoweblabiii.model.Post"%>
<%@page import="com.mycompany.aplicacaoweblabiii.db.controller.PostJpaController"%>
<%@page import="com.mycompany.aplicacaoweblabiii.model.Category"%>
<%@page import="com.mycompany.aplicacaoweblabiii.db.controller.CategoryJpaController"%>
<%@page import="com.mycompany.aplicacaoweblabiii.model.Role"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="com.mycompany.aplicacaoweblabiii.db.controller.RoleJpaController"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<body>

    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">

                <ul class="nav navbar-nav">
                    <li><a href="menu.html">Relat�rios</a></li>
                </ul>   
            </div>
            <ul class="nav navbar-nav">
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Pap�is <span class="caret"></span></a>        
                    <ul class="dropdown-menu">
                        <li>
                            <a href="RolesView.jsp">Cadastrar papel</a>
                            <a href="RolesUD.jsp">Listar pap�is</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Usu�rios <span class="caret"></span></a>        
                    <ul class="dropdown-menu">
                        <li>
                            <a href="UsersView.jsp">Cadastrar usu�rio</a>
                            <a href="UsersUD.jsp">Listar usu�rios</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Planos <span class="caret"></span></a>        

                    <ul class="dropdown-menu">
                        <li>
                            <a href="PlanosView.jsp">Cadastrar plano</a>
                            <a href="PlanosUD.jsp">Listar planos</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Formas de Pagamento <span class="caret"></span></a>        
                    <ul class="dropdown-menu">
                        <li>
                            <a href="PagamentoView.jsp">Cadastrar forma de pagamento</a>
                            <a href="PagamentoUD.jsp">Listar formas de pagamento</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Assinaturas <span class="caret"></span></a>        

                    <ul class="dropdown-menu">
                        <li>
                            <a href="AssinaturaView.jsp">Cadastrar assinatura</a>
                            <a href="AssinaturaUD.jsp">Listar assinaturas</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Categorias <span class="caret"></span></a>        

                    <ul class="dropdown-menu">
                        <li>
                            <a href="CategoriasView.jsp">Cadastrar categoria</a>
                            <a href="CategoriaUD.jsp">Listar categorias</a>

                        </li>
                    </ul>
                </li>
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Tags <span class="caret"></span></a>        
                    <ul class="dropdown-menu">
                        <li>
                            <a href="TagsView.jsp">Cadastrar tag</a>
                            <a href="TagsUD.jsp">Listar tags</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Postagens <span class="caret"></span></a>        <ul class="dropdown-menu">
                    <li>
                        <a href="PostsView.jsp">Cadastrar post</a>
                        <a href="PostsUD.jsp">Listar posts</a>
                    </li>
                </ul>
            </li>
            <li class="nav navbar-nav">
                <li><%request.getSession().invalidate();%><a href="index.html"><span class="glyphicon glyphicon-log-out"></span> Sair</a></li>
            </li>   
        </div>
    </nav>

    <form action="ServletRoles" method="post" style="border:1px solid #ccc">
        <table class="table table-striped">
            <th>C�digo da Publica��o</th>
            <th>Publica��o</th>
            <th>Autor</th>
            <th>Categoria</th>
            <th>Data de Cria��o</th>
            <th>Data de Publica��o</th>
            <th>Atualiza��es</th>
            <th>Remo��es</th>

            <tr>
                <%
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_AplicacaoWebLabIII_war_1.0-SNAPSHOTPU");
                PostJpaController pjc = new PostJpaController(emf);
                List<Post> posts = pjc.findPostEntities();
                for (int i = 0; i < posts.size(); i++) {
                %><td><%out.print(posts.get(i).getIdPost());%></td>
                <td><%out.print(posts.get(i).getContent());%></td>
                <td><%out.print(posts.get(i).getIdAuthor().getName());%></td>
                <td><%out.print(posts.get(i).getIdCategory().getDescription());%></td>
                <td><%out.print(posts.get(i).getCreatedAt());%></td>
                <td><%out.print(posts.get(i).getPublishedAt());%></td>
                <td><a href="PostsView.jsp?id=<%out.print(posts.get(i).getIdPost());%>"><button type="button" class="btn btn-default"><span class="glyphicon glyphicon-pencil"></span></button></td>
                    <td><button class="btn btn-default" formmethod="post" formaction="ServletPostDelete" name="id" value="<%out.println(posts.get(i).getIdPost());%>"><span class="glyphicon glyphicon-remove"></span></button></td>
                </tr> 
                <%
            }%>
        </tr>
    </table>
</form>
<p></p>
<a href="menu.html"><button type="button" class="btn btn-default"><span class="glyphicon glyphicon-arrow-left"></span> Voltar</button></a>
<p></p>
</body>
</html>

