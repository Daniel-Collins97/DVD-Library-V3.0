import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Library 
{
	private ArrayList<DVD>dvds;
	
	
	
	
	
	public Library()
	{
		dvds = new ArrayList<DVD>();
	}
	
	
    public ArrayList<DVD> getDVDs()
    {
        return dvds;
    }
	
	
	
	
	public void add(DVD DVD)
	{
		dvds.add(DVD);
	}
	
	
	
	
	
	public String listDVDs ()
	{
		if(dvds.size() !=0)
		{
			String listOfDVDs = "";
            for (int i = 0; i < dvds.size(); i++)
            {
                listOfDVDs = listOfDVDs + (i+1) + ": " + dvds.get(i) + "\n";
            }
            return listOfDVDs;
		}
		else
		{
			return "No DVD's";
		}
	}
	
	
    @SuppressWarnings("unchecked")
    public void load() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("DVD's.xml"));
        dvds = (ArrayList<DVD>) is.readObject();
        is.close();
    }

    public void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("DVD's.xml"));
        out.writeObject(dvds);
        out.close();    
    }
}