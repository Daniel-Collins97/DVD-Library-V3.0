import java.util.Scanner;


public class Driver 
{
	private Library library;
	private Scanner input;
	private String title = "";
	
	public Driver()
	{
		input = new Scanner(System.in);
		library = new Library();
	}
	
	public void addDVD()
	{
		input.nextLine();
		System.out.println("Enter the title of the DVD.");
		String title = input.nextLine();
		library.add(new DVD(title));
	}
	
	
	public void updateDVD()
	{
		System.out.println(library.listDVDs());
		
		if(library.getDVDs().size() !=0)
		{
			System.out.println("Index of DVD to be edited: ");
			int index = input.nextInt();
			
			if(index <= library.getDVDs().size())
			{
				input.nextLine();
				System.out.println("Enter a new name for the DVD: ");
				String name = input.nextLine();
				
				DVD DVD =library.getDVDs().get(index-1);
				DVD.setDVDTitle(name);
			}
			else
			{
				System.out.println("There is no DVD for this index");
			}
		}
	}
	
	
	
	
	public void deleteDVD()
	{
		{
			System.out.println(library.listDVDs());
			
			if(library.getDVDs().size() !=0)
			{
				System.out.println("Index of DVD to be Deleted: ");
				int index = input.nextInt();
				
				if(index <= library.getDVDs().size())
				{
					input.nextLine();
					System.out.println("Are you sure you want to Delete the DVD at index " + index + "? (y/n)");
					char confo = input.next().charAt(0);
					if ((confo == 'y')||(confo == 'Y'))
					{
						library.getDVDs().remove(index-1);
						System.out.println("DVD " + (index) + " deleted.");
					}
				}
				else
				{
					System.out.println("There is no DVD for this index");
				}
			}
		}
	}
	
	
    private int mainMenu()
    { 
        System.out.println("My DVD Library");
        System.out.println("---------");     
        System.out.println("  1) Add a DVD");    
        System.out.println("  2) List all DVDs"); 
        System.out.println("  3) Update a DVD");
        System.out.println("  4) Delete a DVD");
        System.out.println("---------");
        System.out.println("  5) Save DVD's to dvds.xml");
        System.out.println("  6) Load DVD's from dvds.xml");
        System.out.println("  0) Exit");
        System.out.print("==>> ");
        int option = input.nextInt();
        return option;
    }
    
    
	
    
    
    private void run()
    {
        int option = mainMenu();
        while (option != 0)
        {
            switch (option)
            {
            case 1:
                addDVD();
                break;
            case 2:
                System.out.println(library.listDVDs());
                break;
            case 3:
            	updateDVD();
            	break;
            case 4:
            	deleteDVD();
            	break;
            case 5:	  try
				{
					library.save();
			  	}
			  	catch (Exception e)
			  	{
			  		System.out.println("Error writing to file: " + e);
			  	}
			  	break;
            case 6:
            	try
            	{
            		library.load();
            	}
            	catch (Exception e)
            	{
            		System.out.println("Error: " + e);
            	}
            default:
                System.out.println("Invalid option selected.");
                break;
            }

            //display the main menu again
            System.out.println("");
            option = mainMenu();
        }
        System.out.println("Exiting... bye");
    }
    
    
    
    
    public static void main (String[] args)
    {
        Driver app = new Driver();
        app.run();
    }

}
