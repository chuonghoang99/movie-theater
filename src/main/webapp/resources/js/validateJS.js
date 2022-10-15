function Validator(options) {
	function getParent(element, selector) {
		while (element.parentElement) {
			if (element.parentElement.matches(selector)) {
				return element.parentElement;
			}
			element = element.parentElement;
		}
	}

	let selectorRules = {};

	function validate(inputElement, rule) {
		let errorElement = getParent(inputElement, options.formGroupSelector).querySelector(options.errorSelector);
		let errorMessage;
		let rules = selectorRules[rule.selector];

		for (let i = 0; i < rules.length; ++i) {
			switch (inputElement.type) {
				case 'radio':
				case 'checkbox':
					errorMessage = rules[i](
						formElement.querySelector(rule.selector + ':checked')
					);
					break;
				default:
					errorMessage = rules[i](inputElement.value);
			}
			if (errorMessage) break;
		}

		if (errorMessage) {
			errorElement.innerText = errorMessage;
			getParent(inputElement, options.formGroupSelector).classList.add('invalid');
		} else {
			errorElement.innerText = '';
			getParent(inputElement, options.formGroupSelector).classList.remove('invalid');
		}

		return !errorMessage;
	}


	var formElement = document.querySelector(options.form);

	if (formElement) {
		formElement.onsubmit = function (e) {
			e.preventDefault();
			let isFormValid = true;
			options.rules.forEach(function (rule) {
				let inputElement = formElement.querySelector(rule.selector);
				let isValid = validate(inputElement, rule);
				if (!isValid) {
					isFormValid = false;
				}
			});

			if (isFormValid) {
				options.onSubmit(formElement);
			}
		}
		options.rules.forEach(function (rule) {
			if (Array.isArray(selectorRules[rule.selector])) {
				selectorRules[rule.selector].push(rule.test);
			} else {
				selectorRules[rule.selector] = [rule.test];
			}
			let inputElements = formElement.querySelectorAll(rule.selector);
			Array.from(inputElements).forEach(function (inputElement) {
				inputElement.onblur = function () {
					validate(inputElement, rule);
				}
				inputElement.oninput = function () {
					let errorElement = getParent(inputElement, options.formGroupSelector).querySelector(options.errorSelector);
					errorElement.innerText = '';
					getParent(inputElement, options.formGroupSelector).classList.remove('invalid');
				}
			});
		});
	}

}


Validator.isRequire = function (selector, message) {
	return {
		selector: selector,
		test: function (value) {
			return value.trim() ? undefined : message
		}
	};

}

Validator.cfPassword = function (selector, message) {
	return {
		selector: selector,
		test: function (value) {
			return value === document.getElementById("password").value ? undefined : message
		}
	};

}

Validator.isEmail = function (selector, message) {
	return {
		selector: selector,
		test: function (value) {
			let regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
			return regex.test(value) ? undefined : message;
		}
	};
}

Validator.isPhone = function (selector, message) {
	return {
		selector: selector,
		test: function (value) {
			let regex = /\(?([0-9]{3})\)?([ .-]?)([0-9]{3})\2([0-9]{4})/;
			return regex.test(value) ? undefined : message;
		}
	};
}

Validator.maxDate = function (selector, message) {
	return {
		selector: selector,
		test: function (value) {
			let current = new Date();
			let date = new Date(value);
			return (current.getTime() > date.getTime()) ? undefined : message;
		}
	}
}


Validator.isIdentityCard = function (selector, message) {
	return {
		selector: selector,
		test: function (value) {
			let regex = /^(\d{9}|\d{12})$/;
			return regex.test(value) ? undefined : message;
		}
	};
}

Validator.minLength = function (selector, min, message) {
	return {
		selector: selector,
		test: function (value) {
			return value.length >= min ? undefined : message || `Vui lòng nhập tối thiểu ${min} kí tự`;
		}
	}

}


