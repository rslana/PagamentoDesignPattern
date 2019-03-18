<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="assets/css/estilo.css">
    <link rel="stylesheet" type="text/css" href="assets/css/dashboard.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" type="text/css" href="assets/fontawesome-free-5.7.2-web/css/all.css">
    <title>Dashboard</title>
</head>

<body>
    <div class='corpo-pagina'>
        <div class='dashboard-corpo'>
            <a href='cadastrarCliente.jsp' rel='noopener noreferrer' class='dashboard-card'>
                <div>
                    <p><i class="fas fa-users"></i></p>
                    <p>Clientes</p>
                </div>
            </a>
            <a href='cadastrarProduto.jsp' rel='noopener noreferrer' class='dashboard-card'>
                <div>
                    <p><i class="fas fa-boxes"></i></p>
                    <p>Produtos</p>
                </div>
            </a>
            <a href='FrontController?action=GravarPedido' rel='noopener noreferrer' class='dashboard-card'>
                <div>
                    <p><i class="fas fa-truck"></i></p>
                    <p>Pedidos</p>
                </div>
            </a>
        </div>
    </div>
</body>

</html>