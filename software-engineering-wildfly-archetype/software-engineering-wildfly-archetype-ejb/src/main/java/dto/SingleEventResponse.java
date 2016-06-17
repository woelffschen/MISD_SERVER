package dto;

public class SingleEventResponse extends ReturnCodeResponse {

	private static final long serialVersionUID = -5754928488884226775L;

	private EventTO event;

	public EventTO getEvent() {
		return event;
	}

	public void setEvent(EventTO event) {
		this.event = event;
	}

		
}
