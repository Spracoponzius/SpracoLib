package it.unibs.fp.spracolib;
/*
This class represents a generic text menu with mutiple entries.
The exit entry is generated at the bottom and it is accessed using 0.
*/
public class MyMenu
{
  final private static String FRAME = "--------------------------------";
  final private static String EXIT_ENTRY = "0\tExit";
  final private static String INSERT_MSG = "Type the number of the desired entry > ";

  private String title;
  private String [] entries;
  private boolean exitEntry;


  public MyMenu (String title, String [] entries, boolean exit)
  {
	this.title = title;
	this.entries = entries;
    this.exitEntry = exit;
  }

  public int choose()
  {
	printMenu();
    int choice;
    if(exitEntry)
        choice = DataInput.readInteger(INSERT_MSG, 0, entries.length);
    else
        choice = DataInput.readInteger(INSERT_MSG, 1, entries.length);
	return choice;
  }
		
  public void printMenu()
  {
	System.out.println(FRAME);
	System.out.println(title);
	System.out.println(FRAME);
    for (int i = 0; i< entries.length; i++)
	 {
	  System.out.println( (i+1) + "\t" + entries[i]);
	 }
    System.out.println();
    if(exitEntry)
	    System.out.println(EXIT_ENTRY);
    System.out.println();
  }
		
}

