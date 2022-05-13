<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="apple-touch-icon" sizes="76x76" href="img/apple-icon.png">
<link rel="icon" type="image/png" href="img/favicon.png">
<title>ved</title>
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

<body class="">
	<div class="container position-sticky z-index-sticky top-0">
		<div class="row">
			<div class="col-12"></div>
		</div>
	</div>
	<main class="main-content  mt-0">
		<section>
			<div class="page-header min-vh-100">
				<div class="container">
					<div class="row">
						<div
							class="col-6 d-lg-flex d-none h-100 my-auto pe-0 position-absolute top-0 start-0 text-center justify-content-center flex-column">
							<div
								class="position-relative bg-gradient-primary h-100 m-3 px-7 border-radius-lg d-flex flex-column justify-content-center"
								style="background-image: url('img/illustrations/illustration-signup.jpg'); background-size: cover;">
							</div>
						</div>
						<div
							class="col-xl-4 col-lg-5 col-md-7 d-flex flex-column ms-auto me-auto ms-lg-auto me-lg-5">
							<div class="card card-plain">
								<div class="card-header">
									<h4 class="font-weight-bolder">Cadastrar</h4>
									<p class="mb-0">O E-mail e senha será sua forma de logar no
										VED</p>
								</div>
								<div class="card-body">
									<form method="post" action="ServletUsuario">
										<input type="hidden" name="id" value="${user.id}" />
										<div class="input-group input-group-outline mb-3">
											<label class="form-label">Nome</label> <input type="text"
												class="form-control" name="nome" value="${user.nome}">
										</div>
										<div class="input-group input-group-outline mb-3">
											<label class="form-label">Email</label> <input type="email"
												class="form-control" name="email" value="${user.email}">
										</div>
										<div class="input-group input-group-outline mb-3">
											<label class="form-label">Password</label> <input
												type="password" class="form-control" name="senha"
												value="${user.senha}">
										</div>
										<div class="text-center d-grid gap-2">
											<button type="submit"
												class="btn btn-lg bg-gradient-primary btn-lg mt-4 mb-0"
												name="opcao" value="insert">Cadastrar</button>
										</div>
									</form>
								</div>
								<div class="card-footer text-center pt-0 px-lg-2 px-1"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
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
	<script async defer src="https://buttons.github.io/buttons.js"></script>

	<script src="js/material-dashboard.min.js?v=3.0.0"></script>
</body>

</html>




