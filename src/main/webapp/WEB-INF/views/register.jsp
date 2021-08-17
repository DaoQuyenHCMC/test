<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body class="bg-primary">
	<div id="layoutAuthentication">
		<div id="layoutAuthentication_content">
			<main>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-7">
							<div class="card shadow-lg border-0 rounded-lg mt-5">
								<div class="card-header">
									<h3 class="text-center font-weight-light my-4">Đăng ký</h3>
								</div>
								<div class="card-body">
									<form>
										<div class="form-floating mb-3">
											<input class="form-control" id="inputEmail" type="text"
												placeholder="Nguyễn Văn A" /> <label for="inputEmail">Họ tên</label>
										</div>
										<div class="form-floating mb-3">
											<input class="form-control" id="inputEmail" type="text"
												placeholder="name@example.com" /> <label for="inputEmail">Tên tài khoản</label>
										</div>
										<div class="row mb-3">
											<div class="col-md-6">
												<div class="form-floating mb-3 mb-md-0">
													<input class="form-control" id="inputPassword"
														type="password" placeholder="Create a password" /> <label
														for="inputPassword">Mật khẩu</label>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-floating mb-3 mb-md-0">
													<input class="form-control" id="inputPasswordConfirm"
														type="password" placeholder="Confirm password" /> <label
														for="inputPasswordConfirm">Xác nhận lại mật khẩu</label>
												</div>
											</div>
										</div>
										<div class="mt-4 mb-0">
											<div class="d-grid">
												<a class="btn btn-primary btn-block" href="login.html">Xác nhận</a>
											</div>
										</div>
									</form>
								</div>
								<div class="card-footer text-center py-3">
									<div class="small">
										<a href="<c:url value='/dang-nhap' />">Đăng nhập</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>

</body>
</html>
