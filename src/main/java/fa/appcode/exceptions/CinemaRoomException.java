package fa.appcode.exceptions;

import java.io.Serializable;

public class CinemaRoomException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CinemaRoomException(String message) {
		super(message);
	}

}
