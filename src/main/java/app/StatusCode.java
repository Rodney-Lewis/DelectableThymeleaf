package app;

public enum StatusCode {
	
	//TODO Determine code system i.e 2xx = DB, 3xx = API
	DATABASE_UPDATE_OKAY(200, "OK"),
	DATABASE_UPDATE_ERROR(202, "DATABASE UPDATE FAILED"),
	DATABASE_NO_EFFECTED_ROWS(204, "DATABASE UPDATE NO ROWS EFFECTED");

	private final int code;
	private final String message;
	
	private StatusCode(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public String ToString() {
		return code + ": " + message;
	}
}
