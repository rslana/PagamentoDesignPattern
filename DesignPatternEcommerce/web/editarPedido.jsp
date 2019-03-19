<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <title>Editar Contato</title>
</head>

<body>
    <div class='corpo-pagina'>
        <div class='dashboard-corpo'>
            <a href='FrontController?action=GravarPedido' rel='noopener noreferrer' class='dashboard-card'>
                <div>
                    <p><i class="fas fa-plus"></i></p>
                    <p>Cadastrar Pedido</p>
                </div>
            </a>
            <a href='FrontController?action=GravarPedido' rel='noopener noreferrer' class='dashboard-card'>
                <div>
                    <p><i class="fas fa-edit"></i></p>
                    <p>Alterar Estado do Pedido</p>
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
            <!-- <a href='apagarPedido.jsp' rel='noopener noreferrer' class='dashboard-card'>
                <div>
                    <p><i class="fas fa-trash-alt"></i></p>
                    <p>Apagar Pedido</p>
                </div>
            </a> -->
        </div>
        <hr>
        <div class="div-titulo">
            <h2>Alterar Estado do Pedido</h2>
        </div>
        <div class='dashboard-corpo'>
            <a href='FrontController?action=EditarPedido&estado=Realizado' rel='noopener noreferrer' class='dashboard-card'>
                <div>
                    <p><i class="fas fa-plus"></i></p>
                    <p>Realizar Pedido</p>
                </div>
            </a>
            <a href='FrontController?action=EditarPedido&estado=Cancelado' rel='noopener noreferrer' class='dashboard-card'>
                <div>
                    <p><i class="fas fa-times"></i></p>
                    <p>Cancelar Pedido</p>
                </div>
            </a>
            <a href='FrontController?action=EditarPedido&estado=PagamentoAprovado' rel='noopener noreferrer' class='dashboard-card'>
                <div>
                    <p><i class="fas fa-check"></i></p>
                    <p>Aprovar Pagamento</p>
                </div>
            </a>
            <a href='FrontController?action=EditarPedido&estado=PagamentoNaoAprovado' rel='noopener noreferrer' class='dashboard-card'>
                <div>
                    <p><i class="fas fa-times"></i></p>
                    <p>Não Aprovar Pagamento</p>
                </div>
            </a>
            <a href='FrontController?action=EditarPedido&estado=NaoPago' rel='noopener noreferrer' class='dashboard-card'>
                <div>
                    <p><i class="fas fa-question"></i></p>
                    <p>Pedido Não Pago</p>
                </div>
            </a>
            <a href='FrontController?action=EditarPedido&estado=EmSeparacao' rel='noopener noreferrer' class='dashboard-card'>
                <div>
                    <p><i class="fas fa-dolly"></i></p>
                    <p>Pedido em Separação</p>
                </div>
            </a>
            <a href='FrontController?action=EditarPedido&estado=EmTransporte' rel='noopener noreferrer' class='dashboard-card'>
                <div>
                    <p><i class="fas fa-shipping-fast"></i></p>
                    <p>Pedido em Transporte</p>
                </div>
            </a>
            <a href='FrontController?action=EditarPedido&estado=Entregue' rel='noopener noreferrer' class='dashboard-card'>
                <div>
                    <p><i class="fas fa-home"></i></p>
                    <p>Pedido Entregue</p>
                </div>
            </a>
        </div>
        <div class='corpo'>
            <h2>Estado Atual do Pedido</h2>

            <h3 class="estado-pedido">
                Em separação
                <c:out value="${pedido.estado}" />
            </h3>
        </div>
    </div>
</body>


</html>