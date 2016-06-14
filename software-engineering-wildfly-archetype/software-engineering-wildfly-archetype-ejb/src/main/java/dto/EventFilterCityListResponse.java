package dto;

import java.util.List;

public class EventFilterCityListResponse extends ReturnCodeResponse {

	private static final long serialVersionUID = -5754928488884226775L;

	private List<EventTO> eventList;

	public EventFilterCityListResponse() {
	};

	public List<EventTO> getEventList() {
		return eventList;
	}

	public void setEventList(List<EventTO> eventList) {
		this.eventList = eventList;
	}

}
