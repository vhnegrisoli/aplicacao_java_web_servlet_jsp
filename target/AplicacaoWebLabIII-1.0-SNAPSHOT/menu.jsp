<!DOCTYPE html>
<jsp:include page="VerificaAutenticacao.jsp"></jsp:include>
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
        <div class="embed-responsive embed-responsive-16by9">
            <iframe id="iframetroca" src="https://app.powerbi.com/view?r=eyJrIjoiYTQ1MzkwNTQtNjQwOC00ZTI5LWIxNzktZDg4NDE4ZjE3ODE5IiwidCI6Ijg2ZjhmOGY5LTk3YTQtNDZkMS05ZTc3LWY2ZGRkYTgwNjkzOCJ9" frameborder="0" allowFullScreen="true"></iframe>
        </div>

    </body>
</html>