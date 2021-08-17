<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="newURL" value="/quan-tri/danh-sach" />
<c:url var="editNewURL" value="/quan-tri/them-tai-khoan" />
<c:url var="newAPI" value="/api/new" />
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>
	<div class="main-content">
		<form:form
			action="<c:url value='/quan-tri/danh-sach?page=${mode.page}&limit=${model.limit}'/>"
			id="formSubmit" method="get">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
								chủ</a></li>
					</ul>
					<!-- /.breadcrumb -->
				</div>
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<c:if test="${not empty messageResponse}">
								<div class="alert alert-${alert}">${messageResponse}</div>
							</c:if>
							<div class="row">
								<div class="col-xs-12">
									<div class="table-responsive">
										<table class="table table-bordered">
											<thead>
												<tr>
													<th>Họ tên</th>
													<th><input class="form-control" type="text"
														placeholder="Nguyễn Văn A" name="fullName"/></th>

												</tr>
											</thead>
											<thead>
												<tr>
													<th>Tên tài khoản</th>
													<th><input class="form-control" type="text"
														placeholder="Nguyễn Văn A" name="userName"/></th>

												</tr>
											</thead>
											<thead>
												<tr>
													<th>Mật khẩu</th>
													<th><input class="form-control" type="text"
														placeholder="Nguyễn Văn A" name="password"/></th>

												</tr>
											</thead>
											

										</table>
										
										<button class="btn btn-info" type="button"
											id="btnAddOrUpdateNew">
											<i class="ace-icon fa fa-check bigger-110"></i> Thêm tài
											khoản
										</button>
										&nbsp; &nbsp; &nbsp;
										<button class="btn" type="reset">
											<i class="ace-icon fa fa-undo bigger-110"></i> Hủy
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form:form>
	</div>
	<script>
		$('#btnAddOrUpdateNew').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
				addNew(data);
		
		});

		function addNew(data) {
			$
					.ajax({
						url : '${newAPI}',
						type : 'POST',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							window.location.href = "${editNewURL}?id="
									+ result.id + "&message=insert_success";
						},
						error : function(error) {
							window.location.href = "${newURL}?page=1&limit=2&message=error_system";
						}
					});
		}

		function updateNew(data) {
			$.ajax({
				url : '${newAPI}',
				type : 'PUT',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					window.location.href = "${editNewURL}?id=" + result.id
							+ "&message=update_success";
				},
				error : function(error) {
					window.location.href = "${editNewURL}?id=" + result.id
							+ "&message=error_system";
				}
			});
		}
	</script>
</body>
</html>
