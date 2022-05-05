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
		class="sidenav navbar navbar-vertical justify-content-center  align-items-center	 navbar-expand-xs border-0 border-radius-xl my-3 fixed-start ms-3   bg-gradient-dark"
		id="sidenav-main">
		<div class="sidenav-header  justify-content-center ">
			<a class="navbar-brand m-0" href="ServletindexCarol"> <img
				src="imagens/fav-icon.png" class="navbar-brand-img h-100"
				alt="main_logo"> <span class="ms-1 -bold text-white">VED</span>
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
								<li class="nav-item d-grid gap-2">
						<button type="submit" name="option" value="bandeiraSv"
							class="nav-link text-white justify-content-center btn-info ">Bandeira</button>
					</li>
										<li class="nav-item d-grid gap-2">
						<button type="submit" name="option" value="receitaSv"
							class="nav-link text-white justify-content-center btn-info ">Receita</button>
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
					<h1 class="-bolder mb-0">Produtos</h1>
					<form action="ServletProduto" method="post">
						<button type="submit" class=" btn btn-info mb-3" name="option"
							value="insertForm">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-plus-square-fill"
								viewBox="0 0 16 16">
                                    <path
									d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm6.5 4.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3a.5.5 0 0 1 1 0z" />
                                </svg>
						</button>
						<button type="submit" class="btn btn-success mb-3" name="option"
							value="listagem">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-arrow-counterclockwise"
								viewBox="0 0 16 16">
                                    <path fill-rule="evenodd"
									d="M8 3a5 5 0 1 1-4.546 2.914.5.5 0 0 0-.908-.417A6 6 0 1 0 8 2v1z" />
                                    <path
									d="M8 4.466V.534a.25.25 0 0 0-.41-.192L5.23 2.308a.25.25 0 0 0 0 .384l2.36 1.966A.25.25 0 0 0 8 4.466z" />
                                </svg>
						</button>
					</form>
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



		<div class="container">

			<!-- End Navbar -->
			<div class="container-fluid py-2">
				<div class="row">
					<div class="col-12">
						<div class="card my-4">
							<div
								class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
								<div class="btn-success border-radius-lg pt-4 pb-3">
									<h6 class="text-white text-capitalize ps-3">Tabela de
										Produtos</h6>
								</div>
							</div>
							<div class="card-body px-0 pb-2">
								<div class="table-responsive p-0 justify-content-center">
									<form action="ServletProduto" method="post">
										<div class="input-group mb-3 row px-2 ">
											<div class="col-11 ">
												<input type="text" class="form-control border" name="search"
													placeholder="Procure um Produto..."
													aria-label="Recipient's username"
													aria-describedby="button-addon2">
											</div>
											<div class="col-1 d-grid gap-2">
												<button class=" btn-outline-secondary " type="submit"
													name="option" value="btnsearch" id="button-addon2">
													<svg xmlns="http://www.w3.org/2000/svg" width="16"
														height="16" fill="currentColor" class="bi bi-search"
														viewBox="0 0 16 16">
  <path
															d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z" />
</svg>
												</button>
											</div>



										</div>
									</form>
									<table class="table mt-5  overflow-scroll over">
										<thead class="thead-dark">
											<tr class="text-center">
												<th scope="col">Id</th>
												<th scope="col">Nome</th>
												<th scope="col">Preço</th>
												<th scope="col">Categoria</th>
												<th scope="col">Marca</th>
												<th scope="col">Status</th>
												<th scope="col">Peso</th>
												<th scope="col" class="text-center">Opções</th>

											</tr>
										</thead>
										<tbody>
											<c:forEach var="produto" items="${lista}">
												<form action="ServletProduto" method="post">
													<tr class="text-center">
														<input type="hidden" name="id" value="${produto.id}" />

														<td>${produto.id}</td>
														<td>${produto.nome}</td>

														<td><fmt:setLocale value="pt_BR" /> R$ <fmt:formatNumber
																type="number" minFractionDigits="2"
																value="${produto.preco} " /></td>
														<td>${produto.categoria2}</td>
														<td>${produto.marca2}</td>
														<td>${produto.status2}</td>
														<td>KG ${produto.peso}</td>
														<!-- Modal -->
														<div class="modal fade" id="modelDelete-${produto.id}"
															tabindex="-1" aria-labelledby="modelDeleteLabel"
															aria-hidden="true">
															<div class="modal-dialog">
																<div class="modal-content">
																	<div class="modal-header">
																		<h5 class="modal-title" id="modelDeleteLabel">
																			Confirmação de Exclusão</h5>
																		<button type="button" class="btn-close"
																			data-bs-dismiss="modal" aria-label="Close"></button>
																	</div>
																	<div class="modal-body">
																		Deseja excluir permanentemente o Item:
																		${produto.nome} ? <input type="hidden"
																			name="id" value="${produto.id}" />
																	</div>

																	<div class="modal-footer">
																		<button type="button" class="btn btn-secondary"
																			data-bs-dismiss="modal">Close</button>
																		<button type="submit" class="btn btn-success"
																			name="option" value="delete">Deletar</button>
																	</div>
																</div>
															</div>
														</div>
														<td class="text-center">
															<button type="button" data-bs-toggle="modal"
																class="btn-success btn "
																data-bs-target="#modelDelete-${produto.id}">Remover</button>
															<button type="submit" name="option" value="updateForm"
																class="btn-success btn ">Alterar</button>
														</td>
													</tr>
												</form>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


		<div class="position-fixed bottom-0 end-0 p-3" style="z-index: 20">
			<div id="liveToast" class="toast" role="alert" aria-live="assertive"
				aria-atomic="true">
				<div class="toast-header">
					<img src="..." class="rounded me-3" alt="..."> <strong
						class="me-auto">Bootstrap</strong> <small>11 mins ago</small>
					<button type="button" class="btn-close" data-bs-dismiss="toast"
						aria-label="Close"></button>
				</div>
				<div class="toast-body">Hello, world! This is a toast message.
				</div>
			</div>
		</div>

		<script type="text/javascript">
			var toastTrigger = document.getElementById('liveToastBtn')
			var toastLiveExample = document.getElementById('liveToast')
			if (toastTrigger) {
				toastTrigger.addEventListener('click', function() {
					var toast = new bootstrap.Toast(toastLiveExample)

					toast.show()
				})
			}
		</script>
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
		<script>
			<script type="text/javascript" src="jquery-3.6.0.min.js">
		</script>
		<script type="text/javascript" src="jquery.mask.min.js"></script>
		<script src="js/material-dashboard.min.js?v=3.0.0"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$('#cpf').mask('000.000.000-00');
				$('.dinheiro').mask('#.##0.00');
				$('#peso').mask('00,000');
				$('#date').mask('00/00/0000');
				$('#cnpj').mask('00.000.000/0000-00');
				$('#telefone').mask('(00) 0000-0000');
				$('#anomes').mask('00/0000');
				$('#cep').mask('00000-000');

			});
		</script>
		<!-- Github buttons -->
		<script async defer src="https://buttons.github.io/buttons.js"></script>
		<!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
		<script src="js/material-dashboard.min.js?v=3.0.0"></script>
</body>

</html>