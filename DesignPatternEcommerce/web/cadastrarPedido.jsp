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
    <title>Criar Contato</title>
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
        <div class='corpo'>
            <h1>Cadastro de Pedido</h1>
            <form action="FrontController?action=GravarPedido" method="post">
                <div class='corpo-input'>
                    <label for='textNome'>Data da Compra</label><br />
                    <input type="date" name="textDataCompra" /><br />
                </div>
                <div class='corpo-input'>
                    <label for='clienteId'>Cliente</label><br>
                    <select name="clienteId" required <c:if test="${operacao == 'Excluir'}"> disabled </c:if>>
                        <c:forEach items="${clientes}" var="cliente">
                            <option value="${cliente.id}">
                                <c:out value="${cliente.nome}" />
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <div class='corpo-input'>
                    <label for='produtoId'>Produto</label><br>
                    <select name="produtoId" required <c:if test="${operacao == 'Excluir'}"> disabled </c:if>>
                        <c:forEach items="${produtos}" var="produto">
                            <option value="${produto.id}">
                                <c:out value="${produto.nome}" />
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn-1">Cadastrar</button>
            </form>
        </div>
    </div>
</body>


</html>