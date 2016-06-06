package onlineService;

public class NoSessionException extends ServiceException {

	private static final long serialVersionUID = 8759021636475023682L;
	private static final int CODE = 50;

	public NoSessionException(String message) {
		super(CODE, message);
	}

}
