package onlineService;

public class ParticipantException extends ServiceException {

	private static final long serialVersionUID = 8759021636475023682L;
	private static final int CODE = 30;

	public ParticipantException(String message) {
		super(CODE, message);
	}

}
