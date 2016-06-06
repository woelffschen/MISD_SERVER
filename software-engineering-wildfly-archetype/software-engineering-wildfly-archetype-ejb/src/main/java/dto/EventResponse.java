package dto;

public class EventResponse extends ReturnCodeResponse {

	private static final long serialVersionUID = -5754928488884226775L;

	private EventTO eventTO;
	private MenueTO menueTO;

	public EventResponse() {
	};

	public EventTO getEventTO() {
		return eventTO;
	}

	public void setEventTO(EventTO eventTO) {
		this.eventTO = eventTO;
	}

	public MenueTO getMenueTO() {
		return menueTO;
	}

	public void setMenueTO(MenueTO menueTO) {
		this.menueTO = menueTO;
	}

}
