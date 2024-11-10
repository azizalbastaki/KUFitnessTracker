public class Activity 
{
	private String name;
	private Time duration;
	private int caloriesBurned;
	private Date activityDate;
	private Time time;
	public Activity(){}
	public Activity(String name,Time duration,int caloriesBurned, Date activityDate,Time time)
	{
		this.name=name;
		this.duration=duration;
		this.caloriesBurned=caloriesBurned;
		this.activityDate=activityDate;
		this.time=time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Time getDuration() {
		return duration;
	}
	public void setDuration(Time duration) {
		this.duration = duration;
	}
	public int getCaloriesBurned() {
		return caloriesBurned;
	}
	public void setCaloriesBurned(int caloriesBurned) {
		this.caloriesBurned = caloriesBurned;
	}
	public Date getActivityDate() {
		return activityDate;
	}
	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Activity [name=" + name + ", duration=" + duration + ", caloriesBurned=" + caloriesBurned
				+ ", activityDate=" + activityDate + ", time=" + time + "]";
	}
}
