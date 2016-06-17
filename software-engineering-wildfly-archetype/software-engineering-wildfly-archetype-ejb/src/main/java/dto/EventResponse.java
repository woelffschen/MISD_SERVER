package dto;

public class EventResponse extends ReturnCodeResponse {

	private static final long serialVersionUID = -5754928488884226775L;

	private int eventId;
//	private int menueId;

	public EventResponse() {
	};

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
//
//	public int getMenueId() {
//		return menueId;
//	}
//
//	public void setMenueId(int menueId) {
//		this.menueId = menueId;
//	}

}
