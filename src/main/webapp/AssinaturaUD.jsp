<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.mycompany.aplicacaoweblabiii.model.Assinatura"%>
<%@page import="com.mycompany.aplicacaoweblabiii.db.controller.AssinaturaJpaController"%>
<%@page import="com.mycompany.aplicacaoweblabiii.model.User"%>
<%@page import="com.mycompany.aplicacaoweblabiii.db.controller.UserJpaController"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.aplicacaoweblabiii.model.Role"%>
<%@page import="com.mycompany.aplicacaoweblabiii.db.controller.RoleJpaController"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
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
                    <li><a href="menu.html">Relatórios</a></li>
                </ul>   
            </div>
            <ul class="nav navbar-nav">
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Papéis <span class="caret"></span></a>        
                    <ul class="dropdown-menu">
                        <li>
                            <a href="RolesView.jsp">Cadastrar papel</a>
                            <a href="RolesUD.jsp">Listar papéis</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Usuários <span class="caret"></span></a>        
                    <ul class="dropdown-menu">
                        <li>
                            <a href="UsersView.jsp">Cadastrar usuário</a>
                            <a href="UsersUD.jsp">Listar usuários</a>
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

    <form style="border:1px solid #ccc">
        <table class="table table-striped">    
            <tr>
                <th>Código da Assinatura</th>
                <th>Usuário</th>
                <th>Plano</th>
                <th>Status</th>
                <th>Forma de Pagamento</th>
                <th>Data de início</th>
                <th>Data de fim</th>
                <th>Valor de Desconto</th>
                <th>Atualizações</th>
                <th>Remoções</th>
            </tr>
            <tr>
                <%
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_AplicacaoWebLabIII_war_1.0-SNAPSHOTPU");
                AssinaturaJpaController ajc = new AssinaturaJpaController(emf);
                List<Assinatura> assinaturas = ajc.findAssinaturaEntities();
                for (int i = 0; i < assinaturas.size(); i++) {
                %><td><%out.print(assinaturas.get(i).getIdAssinatura());%></td>
                <td><%out.print(assinaturas.get(i).getIdUser().getName());%></td>
                <td><%out.print(assinaturas.get(i).getIdPlano().getDescricao());%></td>
                <td><%out.print(assinaturas.get(i).getStatus());%></td>
                <td><%out.print(assinaturas.get(i).getIdFormaPgt().getDescricao());%></td>
                <td><%out.print(assinaturas.get(i).getDataInicial());%></td>
                <td><%out.print(assinaturas.get(i).getDataFinal());%></td>
                <td><%out.print(assinaturas.get(i).getDesconto());%></td>
                <td><a href="AssinaturaView.jsp?id=<%out.print(assinaturas.get(i).getIdAssinatura());%>"><button class="btn btn-default" type="button" ><span class="glyphicon glyphicon-pencil"></span></button></td>
                    <td><button type="submit" class="btn btn-default" formmethod="post" formaction="ServletAssinaturaDelete" name="id" value="<%out.println(assinaturas.get(i).getIdAssinatura());%>"><span class="glyphicon glyphicon-remove"></span></button></td>
                </tr> 
                <%
            }%>
        </tr>
    </table>
</form>
<p></p>
<a href="menu.html"><button type="button" class="btn btn-default"><span class="glyphicon glyphicon-arrow-left"></span> Voltar</button></a>
</body>
<script>
    function myFunction() {
        alert("Erro no cadastro!");
    }
</script>
</html>

