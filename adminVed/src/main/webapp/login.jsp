<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="apple-touch-icon" sizes="76x76"
	href="../assets/img/apple-icon.png">
<link rel="icon" type="image/png" href="../assets/img/favicon.png">
<title>VED</title>
<!--     Fonts and icons     -->
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900|Roboto+Slab:400,700" />
<!-- Nucleo Icons -->
<link href="css/nucleo-icons.css" rel="stylesheet" />
<link href="css/nucleo-svg.css" rel="stylesheet" />
<!-- Font Awesome Icons -->
<script src="https://kit.fontawesome.com/42d5adcbca.js"
	crossorigin="anonymous"></script>
<!-- Material Icons -->
<link
	href="https://fonts.googleapis.com/icon?family=Material+Icons+Round"
	rel="stylesheet">
<!-- CSS Files -->
<link id="pagestyle" href="css/material-dashboard.css?v=3.0.0"
	rel="stylesheet" />


</head>

<body class="bg-gray-200">
	<div class="container position-sticky z-index-sticky top-0">
		<div class="row">
			<div class="col-12"></div>
		</div>
	</div>
	<main class="main-content  mt-0">
		<div class="page-header align-items-start min-vh-100" style="">
			<span class="mask bg-gradient-dark opacity-6"></span>
			<div class="container my-auto">
				<div class="row">
					<div class="col-lg-4 col-md-8 col-12 mx-auto">
						<div class="card z-index-0 fadeIn3 fadeInBottom">
							<div
								class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
								<div class="btn-success border-radius-lg py-3 pe-1">
									<h4 class="text-white font-weight-bolder text-center mt-2 mb-0">
										Login
										<h4>
											<div class="row mt-3">
												<div class="col-2 text-center ms-auto">


													</a>
												</div>
												<div class="col-2 text-center px-1">


													</a>
												</div>
												<div class="col-2 text-center me-auto">


													</a>
												</div>
											</div>
								</div>
							</div>

							<div class="card-body">
								<form action="ServletLogin" method="post">
									<div class="input-group input-group-outline my-3">
										<label class="form-label">Email</label> <input type="email"
											class="form-control " name="email" required>
									</div>
									<div class="input-group input-group-outline mb-3">
										<label class="form-label">Senha</label> <input type="password"
											class="form-control " name="senha" required>
									</div>
									<div class="text-center">
										<button type="submit" value="Entrar"
											class="btn-success w-100 my-4 mb-2" name="opcao">Entrar</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</main>
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

		});
	</script>
	<!-- Github buttons -->
	<script async defer src="https://buttons.github.io/buttons.js"></script>
	<!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
	<script src="js/material-dashboard.min.js?v=3.0.0"></script>
</body>

</html>


