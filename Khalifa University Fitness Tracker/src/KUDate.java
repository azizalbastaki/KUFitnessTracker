public class KUDate 
{
	private int day;
	private int month;
	private int year;
	public KUDate() {}
	public KUDate(int date,int month,int year) 
	{
		this.day=date;
		this.month=month;
		this.year=year;
	}

	public KUDate(String str) {
		this.day = Integer.parseInt(str.substring(0, 2));
		this.month = Integer.parseInt(str.substring(2, 4));
		this.year = Integer.parseInt(str.substring(4, 8));
	}
	
	public void setDate(int date,int month,int year)
	{
		this.day=date;
		this.month=month;
		this.year=year;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String toString() 
	{
    	return day + "/" + month + "/" + year;
	}

}
