/** 
 * @author Sylvia & Daniel
*/

package dto;

public class EventResponse extends ReturnCodeResponse {

	private static final long serialVersionUID = -5754928488884226775L;

	private int eventId;

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

}
