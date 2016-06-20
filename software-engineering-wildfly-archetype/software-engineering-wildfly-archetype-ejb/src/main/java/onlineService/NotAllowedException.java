/** 
 * @author Sylvia & Daniel
*/

package onlineService;

public class NotAllowedException extends ServiceException {

	private static final long serialVersionUID = 8759021636475023682L;
	private static final int CODE = 10;

	public NotAllowedException(String message) {
		super(CODE, message);
	}

}
