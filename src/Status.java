
public class Status {
	private int jobid;
	private int status;
	private String name;
	
	public Status() {
		
	}
	
	public Status(int jobid, int status, String name) {
		this.jobid=jobid;
		this.status = status;
		this.name = name;
	}
	
	public int getJobid() {
		return jobid;
	}
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return ("{\"jobid\":" + jobid + ",\n" +
				"\"status\":" + status + ",\n" +
				"\"name\":\"" + name + "\"" +
				"}");
	}

}
