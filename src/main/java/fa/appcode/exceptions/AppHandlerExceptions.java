package fa.appcode.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppHandlerExceptions {

	@ExceptionHandler(EntityNotFoundException.class)
	public String handlerNotFoundException(EntityNotFoundException entityNotFound, Model model) {
		model.addAttribute("message", entityNotFound.getLocalizedMessage());
		return "403";
	}


}
