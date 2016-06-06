package onlineService;

public class EventOwnerException extends ServiceException {

	private static final long serialVersionUID = 8759021636475023682L;
	private static final int CODE = 20;

	public EventOwnerException(String message) {
		super(CODE, message);
	}

}
