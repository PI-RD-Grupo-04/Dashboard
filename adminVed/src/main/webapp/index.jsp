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
		class="sidenav navbar navbar-vertical navbar-expand-xs border-0 border-radius-xl my-3 fixed-start ms-3   bg-gradient-dark "
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
		<div class="overflow" id="sidenav-collapse-main">			<form action="ServletTroca" method="post">
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
							<li class="nav-item d-grid gap-2">
						<button type="submit" name="option" value="bandeiraSv"
							class="nav-link text-white justify-content-center btn-info ">Bandeira</button>
					</li>
						<li class="nav-item d-grid gap-2">
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
						<li class="breadcrumb-item text-sm text-dark " aria-current="page">Home</li>
					</ol>
					<h1 class="-bolder mb-0">Home${Pedido.idpedido}</h1>
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

		<!-- IN�CIO DO PAINEL DE INDICADORES****************************************************************************************************************************************************************** -->

		<div class="container">

			<div class="container-fluid py-4">

				<div class="row">

					<div class="col-xl-3 col-sm-6 mb-xl-0 mb-4 mt-4">
						<div class="card">
							<div class="card-header p-3 pt-2">
								<div
									class="icon icon-lg icon-shape bg-gradient-dark shadow-dark text-center border-radius-xl mt-n4 position-absolute">
									<i class="material-icons opacity-10"> <font
										style="vertical-align: inherit;"> <font
											style="vertical-align: inherit;">pessoa</font>
									</font>
									</i>

								</div>
								<div class="text-end pt-1">
									<p class="text-sm mb-0 text-capitalize">
										<font style="vertical-align: inherit;"> <font
											style="vertical-align: inherit;">Usuários</font>
										</font>
									</p>
									<h4 class="mb-0">
										<font style="vertical-align: inherit;"> <span
											style="vertical-align: inherit;">${contUsuario} </span>

										</font>

									</h4>
								</div>
							</div>
							<hr class="dark horizontal my-0">
							<div class="card-footer p-3">
								<p class="mb-0">
									<span class="text-success text-sm font-weight-bolder"> </span>
									<font style="vertical-align: inherit;"> <font
										style="vertical-align: inherit;"> Total de usúarios
											cadastrados</font>
									</font>
								</p>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-sm-6 mb-xl-0 mb-4 mt-4">
						<div class="card">
							<div class="card-header p-3 pt-2">
								<div
									class="icon icon-lg icon-shape bg-gradient-primary shadow-primary text-center border-radius-xl mt-n4 position-absolute">
									<i class="material-icons opacity-10"> <font
										style="vertical-align: inherit;"> <font
											style="vertical-align: inherit;">produto</font>
									</font>
									</i>
								</div>
								<div class="text-end pt-1">
									<p class="text-sm mb-0 text-capitalize">
										<font style="vertical-align: inherit;"> <font
											style="vertical-align: inherit;">Produtos</font>
										</font>
									</p>
									<h4 class="mb-0">
										<font style="vertical-align: inherit;"> <span
											style="vertical-align: inherit;">${totalCadastrado} </span>

										</font>
									</h4>
								</div>
							</div>
							<hr class="dark horizontal my-0">
							<div class="card-footer p-3">
								<p class="mb-0">
									<font style="vertical-align: inherit;"> Total de
										produtos comercializados</font>
								</p>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-sm-6 mb-xl-0 mb-4 mt-4">
						<div class="card">
							<div class="card-header p-3 pt-2">
								<div
									class="icon icon-lg icon-shape bg-gradient-success shadow-success text-center border-radius-xl mt-n4 position-absolute">
									<i class="material-icons opacity-10"> <font
										style="vertical-align: inherit;"> <font
											style="vertical-align: inherit;">pessoa</font>
									</font>
									</i>
								</div>
								<div class="text-end pt-1">
									<p class="text-sm mb-0 text-capitalize">
										<font style="vertical-align: inherit;"> <font
											style="vertical-align: inherit;">Pedidos</font>
										</font>
									</p>
									<h4 class="mb-0">
										<font style="vertical-align: inherit;"> <span
											style="vertical-align: inherit;">${contPedido} </span>

										</font>
									</h4>
								</div>
							</div>
							<hr class="dark horizontal my-0">
							<div class="card-footer p-3">
								<p class="mb-0">
									<font style="vertical-align: inherit;"> Total de pedidos
										finalizados</font>

								</p>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-sm-6 mb-xl-0 mb-4 mt-4">
						<div class="card">
							<div class="card-header p-3 pt-2">
								<div
									class="icon icon-lg icon-shape bg-gradient-info shadow-info text-center border-radius-xl mt-n4 position-absolute">
									<i class="material-icons opacity-10"> <font
										style="vertical-align: inherit;"> <font
											style="vertical-align: inherit;">vendas</font>
									</font>
									</i>
								</div>
								<div class="text-end pt-1">
									<p class="text-sm mb-0 text-capitalize">
										<font style="vertical-align: inherit;"> <font
											style="vertical-align: inherit;">Vendas</font>
										</font>
									</p>
									<h4 class="mb-0">
										<font style="vertical-align: inherit;"><span
											style="vertical-align: inherit;"> <fmt:setLocale
													value="pt_BR" /> <fmt:formatNumber type="currency"
													value="${contVenda}" /></span> </font>
									</h4>
								</div>
							</div>
							<hr class="dark horizontal my-0">
							<div class="card-footer p-3">
								<p class="mb-0">
									<font style="vertical-align: inherit;">Total de vendas
										em território nacional</font>

								</p>
							</div>
						</div>
					</div>
				</div>

				<!-- Faturamento por estado  -->


				<div class="row mb-4 mt-5">

					<div class="col-md-6 col-sm-12">
						<div class="col-12 card bg-light mx-auto">
							<h3 class="text-center card-header">Faturamento Por Estado</h3>
							<form class="card-body" action="ServletindexCarol" method="post">
								<div class="form-group row">
									<label for="pricefrom" class="col-form-label">Localizaçao</label>
									<div class="input-group-prepend">

										<div class="input-group mb-3">

											<select name="uf" class="form-select form-select-md  border"
												style="background-color: rgb(255, 255, 255);">
												<option value="t">Escolha um estado</option>
												<c:forEach var="listauf" items="${listauf}">
													<option value="${listauf.id}"
														${listauf.selecionado == true ? 'selected="selected"' : ''}>
														${listauf.descricao}</option>
												</c:forEach>
											</select>
										</div>


										<div class="form-group row">
											<label for="pricefrom" class="col-form-label">Faturamento</label>
											<div class="input-group-prepend">

												<h4>
													<div class="text-left border text-info" id=" basic-addon1"
														name="" style="background-color: white;">
														<span style="vertical-align: inherit;"> <fmt:setLocale
																value="pt_BR" /> <fmt:formatNumber type="currency"
																value="${totalUf}" /></span>
													</div>
												</h4>
											</div>
										</div>
									</div>

									<p class="text-center">
										<button type="submit" class="btn btn-info mb-3" name="a"
											value="atualizar">Buscar</button>
									</p>
							</form>


						</div>
					</div>

					<!-- Fim do Faturamento por estado  -->






					<!-- Visão dos últimos pedidos  -->

				</div>
				<div class="col-md-6 col-sm-12">
					<div class="card h-100">
						<div class="bg-light">
							<h3 class="text-center card-header">Últimos Itens Vendidos</h3>

						</div>


						<!-- últimos pedidos -->
						<!-- Devo lembrar de trazer apenas os cinco ultimos  ATENÇÃO 
		                   
                               
                 <td>${pedidoRecente.descricao_uf}</td>-->
						<c:set var="d1" value="${pedidoRecente.data}" />
						<fmt:formatDate pattern="dd-MM-yyyy" value="${d1}" />




						<form action="ServletindexCarol" method="post">

							<c:forEach var="pedidoRecente" items="${listaPedidoRecente}">

								<div class="card-body p-2">
									<div class="timeline timeline-one-side">
										<div class="timeline-block mb-3">
											<span class="timeline-step"> </span>
											<div class="timeline-content">
												<h6 class="text-dark text-sm font-weight-bold mb-0">
													<font style="vertical-align: inherit;"> <font
														style="vertical-align: inherit;">Produto:
															${pedidoRecente.nome_produto}</font>
													</font>
												</h6>
												<p class="text-secondary font-weight-bold text-xs mt-1 mb-0">
													<font style="vertical-align: inherit;"> <font
														style="vertical-align: inherit;"> <c:set var="d1"
																value="${pedidoRecente.data}" /> Data: <fmt:formatDate
																pattern="dd-MM-yyyy" value="${d1 }" />


													</font>
													</font>
												</p>
												<p class="text-secondary font-weight-bold text-xs mt-1 mb-0">
													<font style="vertical-align: inherit;"> <font
														style="vertical-align: inherit;">Estado:
															${pedidoRecente.descricao_uf}</font>
													</font>
												</p>
											</div>
										</div>
									</div>
								</div>

							</c:forEach>
						</form>

					</div>
				</div>
			</div>

		</div>



		<hr>
		<footer class="text-center">
			<div class="container">
				<div class="row">
					<div class="col-12">
						<p>Copyright � VED. TODOS OS DIREITOS RESERVADOS.</p>
					</div>
				</div>
			</div>
		</footer>
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
				$('#dinheiro').mask('0.000,00');
				$('#peso').mask('00,000');
				$('#date').mask('00/00/0000');
				$('#cnpj').mask('00.000.000/0000-00');
				$('#telefone').mask('(00) 0000-0000');
				$('#anomes').mask('00/0000');
				$('#cep').mask('00000-000');
				$('.cartao').mask('0000 0000 0000 0000');
				$('.campoSenha').mask("**-*-***-*000");
			});
		</script>
		<!-- Github buttons -->
		<script async defer src="https://buttons.github.io/buttons.js"></script>
		<!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
		<script src="js/material-dashboard.min.js?v=3.0.0"></script>
</body>

</html>