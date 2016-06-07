package dto;


public class PublicUserResponse extends ReturnCodeResponse {

	private static final long serialVersionUID = -5754928488884226775L;

	private PublicUserTO publicUserTO;

	public PublicUserResponse() {
	};

	public PublicUserTO getPublicUserTO() {
		return publicUserTO;
	}

	public void setPulbicUserTO(PublicUserTO publicUserTO) {
		this.publicUserTO = publicUserTO;
	}

}
