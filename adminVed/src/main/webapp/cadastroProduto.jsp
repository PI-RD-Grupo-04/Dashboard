<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">


<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="apple-touch-icon" sizes="76x76" href="img/apple-icon.png">
<link rel="icon" type="image/png" href="img/favicon.png">
<title>VED</title>
<!--     Fonts and icons     -->
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900|Roboto+Slab:400,700" />
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Nucleo Icons -->
<link href="css/nucleo-icons.css" rel="stylesheet" />
<link href="css/nucleo-svg.css" rel="stylesheet" />
<link href="css/ved.css" rel="stylesheet" />
<link href="css/material-dashboard.css" rel="stylesheet" />
<!-- Font Awesome Icons -->
<script src="https://kit.fontawesome.com/42d5adcbca.js"
	crossorigin="anonymous"></script>
<!-- Material Icons -->
<link
	href="https://fonts.googleapis.com/icon?family=Material+Icons+Round"
	rel="stylesheet">
<!-- CSS Files -->

</head>

<body class="g-sidenav-show  bg-gray-200">
	<aside
		class="sidenav navbar navbar-vertical navbar-expand-xs border-0 border-radius-xl my-3 fixed-start ms-3   bg-gradient-dark"
		id="sidenav-main">
		<div class="sidenav-header">
			<i
				class="fas fa-times p-3 cursor-pointer text-white opacity-5 position-absolute end-0 top-0 d-none d-xl-none"
				aria-hidden="true" id="iconSidenav"></i> <a class="navbar-brand m-0"
				href="ServletindexCarol"> <img src="imagens/fav-icon.png"
				class="navbar-brand-img h-100" alt="main_logo"> <span
				class="ms-1 -bold text-white">VED</span>
			</a>
		</div>
		<hr class="horizontal light mt-0 mb-2">
		<div class="overflow" id="sidenav-collapse-main">
					<form action="ServletTroca" method="post">
							<ul class="navbar-nav">
					<li class="nav-item  d-grid gap-2">
						<button type="submit" name="option" value="produtoSV"
							class="nav-link text-white justify-content-center btn-info ">
							Produtos</button>
					</li>
					<li class="nav-item d-grid gap-2">
						<button type="submit" name="option" value="marcaSV"
							class="nav-link text-white justify-content-center btn-info ">Marcas</button>
					</li>
<<<<<<< HEAD
					<li class="nav-item d-grid gap-2">
						<button type="submit" name="option" value="bandeiraSv"
							class="nav-link text-white justify-content-center btn-info ">Bandeira</button>
					</li>
					<li class="nav-item d-grid gap-2">
=======
							<li class="nav-item d-grid gap-2">
						<button type="submit" name="option" value="bandeiraSv"
							class="nav-link text-white justify-content-center btn-info ">Bandeira</button>
					</li>
						<li class="nav-item d-grid gap-2">
>>>>>>> 455bfa8dc82363303d1842ea8a2da0a0044808bc
						<button type="submit" name="option" value="receitaSv"
							class="nav-link text-white justify-content-center btn-info ">Receita</button>
					</li>
						<li class="nav-item d-grid gap-2">
						<button type="submit" name="option" value="armazenamentoSv"
							class="nav-link text-white justify-content-center btn-info ">Armazenamento</button>
					</li>
					<li class="nav-item d-grid gap-2">
						<button type="submit" name="option" value="cupomDescontoSv"
							class="nav-link text-white justify-content-center btn-info ">Cupom Desconto</button>
					</li>
					<li class="nav-item d-grid gap-2">
						<button type="submit" name="option" value="tipoFreteSv"
							class="nav-link text-white justify-content-center btn-info ">Tipo de Frete</button>
					</li>
						<li class="nav-item d-grid gap-2">
						<button type="submit" name="option" value="freteSv"
							class="nav-link text-white justify-content-center btn-info ">Frete</button>
					</li>
					
					<li class="nav-item d-grid gap-2">
						<button type="submit" name="option" value="fornecedorSV"
							class="nav-link text-white justify-content-center btn-info ">Fornecedores</button>
					</li>
					<li class="nav-item d-grid gap-2">
						<button type="submit" name="option" value="categoriaSV"
							class="nav-link text-white justify-content-center btn-info ">Categorias</button>
					</li>
					<li class="nav-item d-grid gap-2">
						<button type="submit" name="option" value="listaClienteSV"
							class="nav-link text-white justify-content-center btn-info ">Clientes</button>
					<li class="nav-item d-grid gap-2">
						<button type="submit" name="option" value="listaPedidoSV"
							class="nav-link text-white justify-content-center btn-info ">Pedidos</button>
					</li>
									<li class="nav-item d-grid gap-2">
						<button type="submit" name="option" value="statusProdutoSV"
							class="nav-link text-white justify-content-center btn-info ">Status
							Produto</button>
					</li>
					<li class="nav-item d-grid gap-2">
						<button type="submit" name="option" value="funcionarioSV"
							class="nav-link text-white justify-content-center btn-info ">Funcionario</button>
					</li>
				</ul>
			</form>
		</div>
		<div class="sidenav-footer position-absolute w-100 bottom-0 "></div>
	</aside>
	<main
		class="main-content position-relative max-height-vh-100 h-100 border-radius-lg ">
		<!-- Navbar -->
		<nav
			class="navbar navbar-main navbar-expand-lg px-0 mx-4 shadow-none border-radius-xl"
			id="navbarBlur" navbar-scroll="true">
			<div class="container-fluid py-1 px-3">
				<nav aria-label="breadcrumb">
					<ol
						class="breadcrumb bg-transparent mb-0 pb-0 pt-1 px-0 me-sm-6 me-5">
						<li class="breadcrumb-item text-sm"><a
							class="opacity-5 text-dark" href="#">Paginas</a></li>
						<li class="breadcrumb-item text-sm text-dark active"
							aria-current="page">Produto</li>
					</ol>
					<h1 class="-bolder mb-0"> Produto</h1>
				</nav>
				<div class="collapse navbar-collapse mt-sm-0 mt-2 me-md-0 me-sm-4"
					id="navbar">
					<div class="ms-md-auto pe-md-3 d-flex align-items-center"></div>
					<ul class="navbar-nav  justify-content-end">
						<li class="nav-item d-flex align-items-center "><i
							class="fa fa-user me-sm-1"></i> <c:choose>
								<c:when test="${applicationScope.nome != null}">
								Olá,
								${applicationScope.nome}
								</c:when>
								<c:otherwise>
									<%
									response.sendRedirect("login.jsp");
									%>
								</c:otherwise>
							</c:choose></li>
						<li class="nav-item d-xl-none ps-3 d-flex align-items-center">
							<a href="javascript:;" class="nav-link text-body p-0"
							id="iconNavbarSidenav">
								<div class="sidenav-toggler-inner">
									<i class="sidenav-toggler-line"></i> <i
										class="sidenav-toggler-line"></i> <i
										class="sidenav-toggler-line"></i>
								</div>
						</a>
						</li>
						<li
							class="nav-item px-3 d-flex align-items-center justify-content-center">
							<c:choose>
								<c:when test="${applicationScope.nome != null}">
									<a href="./login.jsp"><span><i
											class="material-icons opacity-10">login</i></span> </a>
								</c:when>
							</c:choose>
						</li>
					</ul>
				</div>
			</div>
		</nav>



		<div class="container-fluid ">
			<div class="row">
				<div class="col-md-5 mx-auto border text-center">
					<c:choose>
						<c:when test="${produto == null}">
							<h3>Cadastrar Produto</h3>
						</c:when>
						<c:otherwise>
							<h3>Atualizar Produto</h3>
						</c:otherwise>
					</c:choose>
					<form method="post" action="ServletProduto">
						<input type="hidden" name="id" value="${produto.id}" />

						<div class="modal fade" id="modelDelete" tabindex="-1"
							aria-labelledby="modelDeleteLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="modelDeleteLabel">Sua ação
											foi concluida com sucesso!</h5>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="d-grid gap-2">
										<div class="modal-footer">
											<c:choose>
												<c:when test="${produto == null}">
													<button type="submit" class="btn-success btn "
														name="option" value="insert">ok</button>
												</c:when>
												<c:otherwise>
													<button type="submit" class="btn-success btn "
														name="option" value="update">ok</button>
												</c:otherwise>
											</c:choose>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="form-group text-left">
							<label for="nome" class="form-label">Nome Produto:</label> <input
								type="text" style="background-color: rgb(255, 255, 255);"
								class="form-control" name="nome" value="${produto.nome}"
								required>
						</div>

						<div class="form-group text-left">
							<label for="nome" class="form-label ">Preço:</label> <input
								type="text" style="background-color: rgb(255, 255, 255);"
								class="form-control dinheiro" name="preco"
								value="${produto.preco}" id="dinheiro" required>
						</div>

						<div class="form-group" style="text-align-last: left;">
							<label for="nome" class="form-label">Imagem url:</label> <input
								type="text" style="background-color: rgb(255, 255, 255);"
								class="form-control" name="imagem" value="${produto.url}"
								required>
						</div>

						<div class="form-group mt-3" style="text-align-last: left;">
							<label for="nome" class="form-label">Categoria:</label> <select
								style="background-color: rgb(255, 255, 255);" id="categoria"
								name="categoria" class="form-select form-select-md">
								<c:forEach var="categoria" items="${listaCategoria}">
									<option value="${categoria.id}">
										${categoria.descricao}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group mt-3" style="text-align-last: left;">
							<label for="fornecedor" class="form-label">Fornecedor:</label> <select
								style="background-color: rgb(255, 255, 255);" id="fornecedor"
								name="fornecedor" class="form-select form-select-md">
								<c:forEach var="fornecedor" items="${listaFornecedor}">
									<option value="${fornecedor.id}">
										${fornecedor.razao_social}</option>
								</c:forEach>
							</select>
						</div>

						<div class="form-group mt-3" style="text-align-last: left;">
							<label for="armazenamento " class="form-label">Armazenamento:</label>
							<select style="background-color: rgb(255, 255, 255);"
								id="armazenamento" name="armazenamento"
								class="form-select form-select-md">
								<c:forEach var="armazenamento" items="${listaArmazenamento}">
									<option value="${armazenamento.id}">
										${armazenamento.descricao}</option>
								</c:forEach>
							</select>
						</div>

						<div class="form-group mt-3" style="text-align-last: left;">
							<label for="receita " class="form-label">Receita:</label> <select
								style="background-color: rgb(255, 255, 255);" id="receita"
								name="receita" class="form-select form-select-md">
								<c:forEach var="receita" items="${listaReceita}">
									<option value="${receita.id}">${receita.titulo}</option>
								</c:forEach>
							</select>
						</div>

						<div class="form-group mt-3" style="text-align-last: left;">
							<label for="nome" class="form-label">Marca:</label> <select
								style="background-color: rgb(255, 255, 255);" id="marca"
								name="marca" class="form-select form-select-md">
								<c:forEach var="marca" items="${listaMarca}">
									<option value="${marca.id}">${marca.descricao}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group" style="text-align-last: left;">
							<label for="nome" class="form-label">Quantidade:</label> <input
								type="number" style="background-color: rgb(255, 255, 255);"
								class="form-control" name="quantidade"
								value="${produto.quantidade}" required>
						</div>
						<div class="form-group mt-3" style="text-align-last: left;">
							<label for="nome" class="form-label">Descrição:</label> <input
								style="background-color: rgb(255, 255, 255);" type="text"
								class="form-control" name="descricao"
								value="${produto.descricao}" required>
						</div>

						<div class="form-group mt-3" style="text-align-last: left;">
							<label for="nome" class="form-label">Status:</label> <select
								style="background-color: rgb(255, 255, 255);" id="status"
								name="status" class="form-select form-select-md">
								<c:forEach var="status" items="${listaStatus}">
									<option value="${status.id}">${status.descricao}</option>
								</c:forEach>
							</select>
						</div>

						<div class="form-group mt-3" style="text-align-last: left;">
							<label for="nome" class="form-label">Peso:</label> <input
								type="text" style="background-color: rgb(255, 255, 255);"
								class="form-control" name="peso" value="${produto.peso}"
								id="peso" required>
						</div>
						<div class="d-grid gap-2">
							<c:choose>
								<c:when test="${categoria == null}">
									<button type="button" data-bs-toggle="modal"
										class="btn-success btn " data-bs-target="#modelDelete">Salvar</button>
								</c:when>
								<c:otherwise>
									<button type="button" data-bs-toggle="modal"
										class="btn-success btn " data-bs-target="#modelDelete">atualizar</button>
								</c:otherwise>
							</c:choose>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!--   Core JS Files   -->
		<script src="js/core/popper.min.js"></script>
		<script src="js/core/bootstrap.min.js"></script>
		<script src="js/plugins/perfect-scrollbar.min.js"></script>
		<script src="js/plugins/smooth-scrollbar.min.js"></script>
		<script>
			var win = navigator.platform.indexOf('Win') > -1;
			if (win && document.querySelector('#sidenav-scrollbar')) {
				var options = {
					damping : '0.5'
				}
				Scrollbar.init(document.querySelector('#sidenav-scrollbar'),
						options);
			}
		</script>
		<script type="text/javascript" src="jquery-3.6.0.min.js"></script>
		<script type="text/javascript" src="jquery.mask.min.js"></script>
		<script src="js/material-dashboard.min.js?v=3.0.0"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$('#cpf').mask('000.000.000-00');
				$('#peso').mask('000');
				$('#date').mask('31/12/0000');
				$('#cnpj').mask('00.000.000/0000-00');
				$('#telefone').mask('(00) 0000-0000');
				$('#anomes').mask('00/0000');
				$('#cep').mask('00000-000');
				$('.dinheiro').mask('###0,00');

			});
		</script>
		<script>
			function funcao1() {
				alert("cadastrado!");
			}
		</script>
		<!-- Github buttons -->
		<script async defer src="https://buttons.github.io/buttons.js"></script>
		<!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
		<script src="js/material-dashboard.min.js?v=3.0.0"></script>
</body>

</html>


