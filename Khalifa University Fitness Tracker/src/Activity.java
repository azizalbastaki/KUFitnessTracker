public class Activity 
{
	private String name;
	private Time duration;
	private int caloriesBurned;
	private KUDate activityDate;
	private String time;
	public Activity(){}
	
	public Activity(String name2, Time duration, int calories, KUDate date2, String time2) {
		this.name=name2;
		this.duration=duration;
		this.caloriesBurned=calories;
		this.activityDate=date2;
		this.time=time2;
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
	public KUDate getActivityDate() {
		return activityDate;
	}
	public void setActivityDate(KUDate activityDate) {
		this.activityDate = activityDate;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Activity [name=" + name + ", duration=" + duration + ", caloriesBurned=" + caloriesBurned
				+ ", activityDate=" + activityDate + ", time=" + time + "]";
	}
}
