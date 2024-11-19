
public class Goal 
{
	private String goalId;
	private String goalDescription;
	private KUDate startDate;
	private KUDate endDate;
	private String status;
	public Goal() {}
	public Goal(String goalId, String goalDescription, KUDate startDate, KUDate endDate, String status) 
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
	public KUDate getStartDate() {
		return startDate;
	}
	public void setStartDate(KUDate startDate) {
		this.startDate = startDate;
	}
	public KUDate getEndDate() {
		return endDate;
	}
	public void setEndDate(KUDate endDate) {
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
