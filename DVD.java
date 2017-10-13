
public class DVD
{
	public String title;
	
	public DVD()
	{
		
	}
	
	public DVD(String title)
	{
		this.title = title;
	}
	
	private String getDVDTitle()
	{
		return title;
	}
	
	public void setDVDTitle(String title)
	{
		
			this.title = title;
	}
	
	public String toString()
	{
		return "Title: " + title + "\n";
	}
}
