
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h3 class="row justify-content-center">Add Employee</h3>
<h5 class="row justify-content-center text-primary">${message}</h5>
<div>
	<hr>
	<form action="#" method="post" name="frm-addEmp" id="addEployee">

		<div class="form-group">
			<label for="account">Account <span class="text-danger">(*)</span></label>
			<input type="text" class="form-control" id="account" name="account"
				placeholder="Account">
		</div>

		<div class="form-group">
			<label for="password">Password <span class="text-danger">(*)</span></label>
			<input type="text" class="form-control" id="password" name="password"
				placeholder="Account">
		</div>

		<div class="form-group">
			<label for="cfPassword">Password <span class="text-danger">(*)</span></label>
			<input type="text" class="form-control" id="cfPassword"
				name="cfPassword" placeholder="Confirm password">
		</div>

		<div class="form-group">
			<label for="fullName">Password <span class="text-danger">(*)</span></label>
			<input type="text" class="form-control" id="fullName" name="fullName"
				placeholder="Full name">
		</div>

		<div class="form-group">
			<label for="dateOfBirth">Date of Birth <span
				class="text-danger">(*)</span></label> <input type="text"
				class="form-control" id="dateOfBirth" name="dateOfBirth"
				placeholder="Date of birth">
		</div>

		<div class="form-group">
			<label for="exampleInputGender">Gender <span
				class="text-danger">(*)</span></label>
			<div>
				<input type="radio" class="flat" name="gender" id="genderFemale"
					value="M" checked /> Nam <input type="radio" class="flat ml-4"
					name="gender" id="genderMale" value="F" /> Nữ
			</div>

		</div>

		<div class="form-group">
			<label for="identityCard">Identity card <span
				class="text-danger">(*)</span></label> <input type="text"
				class="form-control" id="identityCard" name="identityCard"
				placeholder="identityCard">
		</div>

		<div class="form-group">
			<label for="email">Email <span class="text-danger">(*)</span></label>
			<input type="text" class="form-control" id="email" name="email"
				placeholder="Email">
		</div>

		<div class="form-group">
			<label for="address">Address <span class="text-danger">(*)</span></label>
			<input type="text" class="form-control" id="address" name="address"
				placeholder="address">
		</div>

		<div class="form-group">
			<label for="phoneNumber">Phone number <span
				class="text-danger">(*)</span></label> <input type="text"
				class="form-control" id="phoneNumber" name="phoneNumber"
				placeholder="Phone number">
		</div>

		<div class="form-group">
			<label for="phoneNumber">Image</label> <input type="file"
				class="form-control" id="image" name="image">
		</div>

		<button id="btnSaveEmployee" type="button" class="btn btn-primary">
			<i class="fas fa-plus"></i> Save
		</button>

		<button id="btnBackEmoployee" type="button" class="btn btn-primary">
			<i class="fas fa-arrow-left"></i> Back
		</button>

	</form>
</div>


<script>
$("body").on("click", "#btnSaveEmployee", function(e) {
	e.preventDefault();
	
	$.post({
		url : "/admin/employee/add-employee/",
		async : false,
		data : {
			
		},
		success : function(response) {
			$("#content-page").html(response);	
		},

	})

});
	
</script>