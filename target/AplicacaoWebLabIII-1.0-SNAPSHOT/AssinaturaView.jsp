<%@page import="com.mycompany.aplicacaoweblabiii.model.FormaPgt"%>
<%@page import="com.mycompany.aplicacaoweblabiii.db.controller.FormaPgtJpaController"%>
<%@page import="com.mycompany.aplicacaoweblabiii.model.Plano"%>
<%@page import="com.mycompany.aplicacaoweblabiii.db.controller.PlanoJpaController"%>
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

        <form action="ServletAssinatura" method="post" style="border:1px solid #ccc">
            <div class="container">
                <h2>Cadastro de assinatauras</h2>
                <hr>
                <label for="email"><b>Selecione o plano:</b></label>
                <select class="form-control" name="plano">
                    <%
                        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_AplicacaoWebLabIII_war_1.0-SNAPSHOTPU");
                        PlanoJpaController pjc = new PlanoJpaController(emf);
                        List<Plano> planos = pjc.findPlanoEntities();
                        for (int i = 0; i < planos.size(); i++) {
                    %> <option> <%out.println(planos.get(i).getDescricao());%></option>
                    <%}%></select>
                <label for="email"><b>Selecione o desconto:</b></label>
                <input class="form-control" type="text" placeholder="Digite o valor de desconto..." name="desconto" required>

                <label for="email"><b>Data inicial</b></label>
                <input class="form-control" type="date"  name="dataInicial" required>
                <label for="email"><b>Data final</b></label>
                <input class="form-control" type="date" name="dataFinal" required>


                <label for="email"><b>Status</b></label>
                <select class="form-control" name="status">
                    <option>Aberto</option>
                    <option>Fechado</option>
                    <option>Conclu�do</option>
                    <option>Cancelado</option>
                </select>

                <label for="email"><b>Selecione a forma de pagamento:</b></label>
                <select class="form-control" name="formaPagamento">
                    <%
                        FormaPgtJpaController fpjc = new FormaPgtJpaController(emf);
                        List<FormaPgt> pagamentos = fpjc.findFormaPgtEntities();
                        for (int i = 0; i < pagamentos.size(); i++) {
                    %> <option> <%out.println(pagamentos.get(i).getDescricao());%></option>
                    <%}%></select>

                <label for="email"><b>Selecione o usu�rio:</b></label>
                <select class="form-control" name="usuario">
                    <%
                        UserJpaController ujc = new UserJpaController(emf);
                        List<User> users = ujc.findUserEntities();
                        for (int i = 0; i < users.size(); i++) {
                    %> <option> <%out.println(users.get(i).getName());%></option>
                    <%}%></select>

                <input type="hidden" value="<%out.print(request.getParameter("id"));%>" name="id">    
                <p></p>

                <p></p>    
                <div class="clearfix">
                    <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-ok"></span>  Cadastrar</button> ou <a href="menu.html"><button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-arrow-left"></span> Voltar</button></a>
                </div>
            </div>
            <p></p>
        </form>
    </body>
    <script>
        function myFunction() {
            alert("Erro no cadastro!");
        }
    </script>
</html>

