/** 
 * @author Sylvia & Daniel
*/

package dto;

public class EventFilterCityListResponse extends ReturnCodeResponse {

	private static final long serialVersionUID = -5754928488884226775L;

	private EventTO[] eventList;

	public EventTO[] getEventList() {
		return eventList;
	}

	public void setEventList(EventTO[] eventList) {
		this.eventList = eventList;
	};
}
