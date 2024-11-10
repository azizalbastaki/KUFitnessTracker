
public class Goal 
{
	private String goalId;
	private String goalDescription;
	private Date startDate;
	private Date endDate;
	private String status;
	public Goal() {}
	public Goal(String goalId, String goalDescription, Date startDate, Date endDate, String status) 
	{
		this.goalId = goalId;
		this.goalDescription = goalDescription;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}
	public String getGoalId() {
		return goalId;
	}
	public void setGoalId(String goalId) {
		this.goalId = goalId;
	}
	public String getGoalDescription() {
		return goalDescription;
	}
	public void setGoalDescription(String goalDescription) {
		this.goalDescription = goalDescription;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		if (status.equals("pending") || status.equals("approved") || status.equals("completed"))
			this.status = status;
	}
	@Override
	public String toString() {
		return "Goal [goalId=" + goalId + ", goalDescription=" + goalDescription + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", status=" + status + "]";
	}
	
	
	
}
