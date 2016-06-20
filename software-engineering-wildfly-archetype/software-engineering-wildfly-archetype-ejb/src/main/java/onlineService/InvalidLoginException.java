/** 
 * @author Sylvia & Daniel
*/

package onlineService;

public class InvalidLoginException extends ServiceException {

	private static final long serialVersionUID = 8759021636475023682L;
	private static final int CODE = 40;

	public InvalidLoginException(String message) {
		super(CODE, message);
	}

}
