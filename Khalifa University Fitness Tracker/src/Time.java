public class Time 
{
	private int hours;
	private int minutes;
	private int seconds;
	public Time() {}
	public Time(int hours,int minutes,int seconds)
	{
		this.hours=hours;
		this.minutes=minutes;
		this.seconds=seconds;
	}

	public Time(String time) {
		String[] parts = time.split(":");
		this.hours = Integer.parseInt(parts[0]);
		this.minutes = Integer.parseInt(parts[1]);
		this.seconds = Integer.parseInt(parts[2]);
	}
	
	public void setTime(int hours,int minutes,int seconds)
	{
		this.hours=hours;
		this.minutes=minutes;
		this.seconds=seconds;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public int getSeconds() {
		return seconds;
	}
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	public String toString() 
	{
	    return hours + ":" + minutes + ":" + seconds;
	}
	
}
