<!-- <%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%> -->
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="assets/css/estilo.css">
    <link rel="stylesheet" type="text/css" href="assets/css/dashboard.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" type="text/css" href="assets/fontawesome-free-5.7.2-web/css/all.css">
    <title>Cadastrar Produto</title>
</head>

<body>
    <div class='corpo-pagina'>
        <div class='dashboard-corpo'>
            <a href='cadastrarProduto.jsp' rel='noopener noreferrer' class='dashboard-card'>
                <div>
                    <p><i class="fas fa-plus"></i></p>
                    <p>Cadastrar Produto</p>
                </div>
            </a>
            <!-- <a href='lerProduto.jsp' rel='noopener noreferrer' class='dashboard-card'>
                <div>
                    <p><i class="fas fa-search"></i></p>
                    <p>Pesquisar Produto</p>
                </div>
            </a> -->
            <!-- <a href='FrontController?action=ListarEmpresas&page=1' rel='noopener noreferrer' class='dashboard-card'>
                <div>
                    <p><i class="fas fa-users"></i></p>
                    <p>Listar Empresas</p>
                </div>
            </a> -->
            <a href='apagarProduto.jsp' rel='noopener noreferrer' class='dashboard-card'>
                <div>
                    <p><i class="fas fa-trash-alt"></i></p>
                    <p>Apagar Produto</p>
                </div>
            </a>
        </div>
        <div class='corpo'>
            <h1>Cadastro de Produto</h1>
            <form action="FrontController?action=GravarProduto" method="post">
                <div class='corpo-input'>
                    <label for='textNome'>Nome</label><br />
                    <input type="text" name="textNome" /><br />
                </div>
                <div class='corpo-input'>
                    <label for='textPreco'>Preço</label>
                    <input type="number" name="textPreco" /><br />
                </div>
                <button type="submit" class="btn-1">Cadastrar</button>
            </form>
        </div>
    </div>
</body>

</html>