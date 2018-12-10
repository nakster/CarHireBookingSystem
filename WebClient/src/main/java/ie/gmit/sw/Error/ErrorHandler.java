package ie.gmit.sw.Error;

import java.net.ConnectException;
import java.rmi.RemoteException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Controller
public class ErrorHandler {

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public String notFoundHandler() {
		return "InternalError";
	}

	@ExceptionHandler(value = ConnectException.class)
	public String handleConnectException() {
		return "ConnectException";
	}

	// handles null pointers
	@ExceptionHandler(value = NullPointerException.class)
	public String handleError() {

		return "ErrorPageForOrder";
	}

}
