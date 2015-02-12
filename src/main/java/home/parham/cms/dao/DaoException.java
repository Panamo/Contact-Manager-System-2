package home.parham.cms.dao;

public class DaoException extends Exception {

	private static final long serialVersionUID = -5208276865666249503L;

	public DaoException() {
		super();
	}

	public DaoException(Throwable cause) {
		super(cause);
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

}
