package demo;

public class JsonData {
	private String detail;
	private String message;
	private String status;
	private String serviceName;
	private String version;
	private String response;
	
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	@Override
	public String toString() {
		return "JsonData [detail=" + detail + ", message=" + message
				+ ", status=" + status + ", serviceName=" + serviceName
				+ ", version=" + version + ", response=" + response + "]";
	}
}
