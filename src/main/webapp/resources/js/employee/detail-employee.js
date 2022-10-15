$(document).ready(function () {
    Validator({
        form: '#formDetailEmployee',
        formGroupSelector: '.form-group',
        errorSelector: '.form-message',
        rules: [
            Validator.isRequire('#userName', 'The account is required'),
            Validator.isRequire('#password', 'The password is required'),
            Validator.cfPassword('#cfPassword', 'Not same with password'),
            Validator.isRequire('#fullName', 'The full name is required'),
            Validator.isRequire('#dateOfBirth',
                'The date of birth is required'),
            Validator.maxDate('#dateOfBirth',
                'The date of birth must be less than current date'),

            Validator.isRequire('#identityCard',
                'The identity card is required'),
            Validator.isIdentityCard('#identityCard',
                'The identity card has 9 or 12 digits'),

            Validator.isRequire('#email', 'The email is required'),
            Validator.isEmail('#email',
                'The email is not in the correct format'),
            Validator.isRequire('#address', 'The address is required'),
            Validator.isRequire('#phoneNumber',
                'The phone number is required'),
            Validator.isPhone('#phoneNumber',
                'The phone number is not in the correct format')],
        onSubmit: function () {
            let formData = new FormData($('#formDetailEmployee')[0]);

            // Display the key/value pairs
            for (let pair of formData.entries()) {
                console.log(pair[0] + ': ' + pair[1]);
            }

            $.post({
                async: false,
                url: "/admin/employee/save",
                processData: false,
                contentType: false,
                data: formData,
                success: function (response) {
                    JSON.parse(JSON.stringify(response))
                    $('#info-save').removeClass('text-danger').addClass("text-primary").text(response.message);
                    if (response.status === 'SAVE-OK') {
                        let spanValidAcc = $('#validate-account')
                        spanValidAcc.parent().removeClass('invalid')
                        spanValidAcc.text('');
                        let spanValidImg = $('#validate-img')
                        spanValidImg.parent().removeClass('invalid')
                        spanValidImg.text('');
                        let spanValidIdentity = $('#validate-identityCard')
                        spanValidIdentity.parent().removeClass('invalid')
                        spanValidIdentity.text('');
                    }
                },

                error: function (response) {
                    JSON.parse(JSON.stringify(response))
                    $('#info-save').addClass("text-danger").text(response.responseJSON.message)
                    if (response.responseJSON.status === 'ERROR-ACCOUNT-EXISTS') {

                        let spanValidAcc = $('#validate-account')

                        spanValidAcc.parent().addClass('invalid')
                        spanValidAcc.text(response.responseJSON.message);
                    }
                    if (response.responseJSON.status === 'ERROR-IMAGE-INVALID') {

                        let spanValidImg = $('#validate-img')
                        spanValidImg.parent().addClass('invalid')
                        spanValidImg.text(response.responseJSON.message);
                    }
                    if (response.responseJSON.status === 'ERROR-SERVER-ERROR')
                    {
                        let spanValidAcc = $('#validate-account')
                        spanValidAcc.parent().addClass('invalid')
                        spanValidAcc.text(response.responseJSON.message);
                    }
                    if (response.responseJSON.status === 'ERROR-IDENTITY-CARD-EXISTS') {
                        let spanValidIdentity= $('#validate-identityCard')
                        spanValidIdentity.parent().addClass('invalid')
                        spanValidIdentity.text(response.responseJSON.message);
                    }
                }
            })

        }
    });

});