<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h3 class="row justify-content-center font-weight-bold" id="titlePage">
</h3>
<h4 id="info-save"></h4>
<div>
	<hr>
	<form name="formDetailEmployee" id="formDetailEmployee" enctype="multipart/form-data">
		<input type="hidden" id="employeeId" name="employeeId">
		<input type="hidden" id="accountId" name="accountId">
		<div class="form-group field" id="validAccount">
			<label for="userName">Account <span class="text-danger">(*)</span></label>
			<input type="text" class="form-control" id="userName" name="userName" placeholder="Account">
			<span id="validate-account" class="form-message text-danger"></span>
		</div>

		<div class="form-group">
			<label for="password">Password <span class="text-danger">(*)</span></label>
			<input type="password" class="form-control field" id="password" name="password" placeholder="Account">
			<span class="form-message text-danger"></span>
		</div>

		<div class="form-group" id="fieldCfPassword">
			<label for="cfPassword">Confirm Password <span class="text-danger">(*)</span></label>
			<input
					type="password"
					class="form-control"
					id="cfPassword"
					name="cfPassword"
					placeholder="Confirm password"
			> <span class="form-message text-danger"></span>
		</div>

		<div class="form-group">
			<label for="fullName">Full Name <span class="text-danger">(*)</span></label>
			<input
					type="text"
					class="form-control"
					id="fullName"
					name="fullName"
					placeholder="Full Name"
			> <span
				class="form-message text-danger"
		></span>
		</div>

		<div class="form-group">
			<label for="dateOfBirth">Date of Birth <span class="text-danger">(*)</span></label>
			<input
					type="date"
					class="form-control"
					id="dateOfBirth"
					name="dateOfBirth"
					placeholder="Date of birth"
			>
			<span
					class="form-message text-danger"
			></span>
		</div>

		<div class="form-group">
			<label>Gender <span class="text-danger">(*)</span></label>
			<div>
				<label for="genderFemale"></label>
				<input
						type="radio"
						class="flat"
						name="gender"
						id="genderFemale"
						value="M"
						checked
				/> Nam
				<label for="genderMale"></label><input
					type="radio"
					class="flat ml-4"
					name="gender"
					id="genderMale"
					value="F"
			/> Nữ
			</div>
			<span class="form-message text-danger"></span>

		</div>

		<div class="form-group">
			<label for="identityCard">Identity card <span class="text-danger">(*)</span></label>
			<input
					type="text"
					class="form-control"
					id="identityCard"
					name="identityCard"
					placeholder="identityCard"
			>
			<span id="validate-identityCard" class="form-message text-danger"></span>
		</div>

		<div class="form-group">
			<label for="email">Email <span class="text-danger">(*)</span></label>
			<input type="text" class="form-control" id="email" name="email" placeholder="Email">
			<span class="form-message text-danger"></span>
		</div>

		<div class="form-group">
			<label for="address">Address <span class="text-danger">(*)</span></label>
			<input type="text" class="form-control" id="address" name="address" placeholder="address"> <span
				class="form-message text-danger"
		></span>
		</div>

		<div class="form-group">
			<label for="phoneNumber">Phone number <span class="text-danger">(*)</span></label>
			<input
					id="phoneNumber"
					type="text"
					placeholder="Phone number"
			>
			<span class="form-message text-danger"></span>
		</div>

		<div class="form-group">
			<label for="file">Image</label>
			<input
					type="file" id="file" class="form-control" name="file"
					style="line-height: 100%;"
			>

			<span id="validate-img" class="form-message text-danger"></span>
		</div>

		<button id="btnSaveEmployee" type="submit" class="btn btnCustom mt-3">
			<i class="fas fa-check"></i> Save
		</button>

		<button id="btnBackEmployee" type="button" class="btn btnCustom mt-3">
			<i class="fas fa-times"></i> Back
		</button>

	</form>


	<script>
        function filePreview(input) {
            if (input.files && input.files[0]) {
                let reader = new FileReader();
                reader.onload = function (e) {
                    $('#file + embed').remove();
                    $('#file').after('<embed src="' + e.target.result + '" width="70" height="70" class="mt-2 ml-2 rounded-circle">');
                };
                reader.readAsDataURL(input.files[0]);
            }
        }

        $("#file").change(function () {
            filePreview(this);
        });
	</script>


</div>
<script src="${pageContext.request.contextPath}/resources/js/employee/detail-employee.js"></script>
