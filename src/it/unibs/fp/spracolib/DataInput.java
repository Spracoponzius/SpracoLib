package it.unibs.fp.spracolib;
import jdk.jshell.spi.ExecutionControl;

import java.util.*;
public class DataInput
{
	  private static Scanner reader = createScanner();
	  
	  private final static String FORMAT_ERROR = "Error: wrong format provided.";
	  private final static String MINIMUM_ERROR = "Error: a value greater or equal than ";
	  private final static String IS_REQUIRED_MSG = " is required.";
	  private final static String ERROR_EMPTY_STRING = "Error: no characters inserted.";
	  private final static String MAXIMUM_ERROR = "Error: a value inferior or equal than ";
	  private final static String ALLOWED_CHARS_MSG = "Attention: the following characters are allowed: ";

	  private final static char REPLY_YES ='Y';
	  private final static char REPLY_NO ='N';

	  
 
	  private static Scanner createScanner()
	  {
	   Scanner created = new Scanner(System.in);
	   created.useDelimiter(System.getProperty("line.separator"));
	   return created;
	  }
	  
	  public static String readString(String message)
	  {
		  System.out.print(message);
		  return reader.next();
	  }
	  
	  public static String readNonEmptyString(String message)
	  {
	   boolean finished=false;
	   String read = null;
	   do
	   {
		 read = readString(message);
		 read = read.trim();
		 if (read.length() > 0)
		  finished=true;
		 else
		  System.out.println(String.format("%s%s"+ERROR_EMPTY_STRING+"%s",TermColors.SLOW_BLINK,TermColors.RED,TermColors.RESET));
	   } while (!finished);
	   
	   return read;
	  }
	  
	  public static char readChar(String message)
	  {
	   boolean finished = false;
	   char readValue = '\0';
	   do
	    {
	     System.out.print(message);
	     String read = reader.next();
	     if (read.length() > 0)
	      {
	       readValue = read.charAt(0);
	       finished = true;
	      }
	     else
	      {
			  System.out.println(String.format("%s%s"+ERROR_EMPTY_STRING+"%s",TermColors.SLOW_BLINK,TermColors.RED,TermColors.RESET));
	      }
	    } while (!finished);
	   return readValue;
	  }
	  
	  public static char readUpperChar(String message, String allowed)
	  {
	   boolean finished = false;
	   char readValue = '\0';
	   do
	   {
	    readValue = readChar(message);
	    readValue = Character.toUpperCase(readValue);
	    if (allowed.indexOf(readValue) != -1)
		 finished  = true;
	    else
	     System.out.println(TermColors.RED + ALLOWED_CHARS_MSG + allowed + TermColors.RESET);
	   } while (!finished);
	   return readValue;
	  }
	  
	  
	  public static int readInteger(String message)
	  {
	   boolean finished = false;
	   int readValue = 0;
	   do
	    {
	     System.out.print(message);
	     try
	      {
	       readValue = reader.nextInt();
	       finished = true;
	      }
	     catch (InputMismatchException e)
	      {
			  System.out.println(String.format("%s%s"+FORMAT_ERROR+"%s",TermColors.SLOW_BLINK,TermColors.RED,TermColors.RESET));
			  String throwAway = reader.next();
	      }
	    } while (!finished);
	   return readValue;
	  }

	  public static int readPositiveInteger(String message)
	  {
		  return readIntegerWithMinimum(message,1);
	  }
	  
	  public static int readNonNegativeInteger(String message)
	  {
		  return readIntegerWithMinimum(message,0);
	  }
	  
	  
	  public static int readIntegerWithMinimum(String message, int minimum)
	  {
	   boolean finished = false;
	   int readValue = 0;
	   do
	    {
	     readValue = readInteger(message);
	     if (readValue >= minimum)
	      finished = true;
	     else
	      System.out.println(TermColors.RED + MINIMUM_ERROR + minimum + IS_REQUIRED_MSG + TermColors.RESET);
	    } while (!finished);
	     
	   return readValue;
	  }

	  public static int readInteger(String message, int minimum, int maximum)
	  {
	   boolean finished = false;
	   int readValue = 0;
	   do
	    {
	     readValue = readInteger(message);
	     if (readValue >= minimum && readValue<= maximum)
	      finished = true;
	     else
	      if (readValue < minimum)
	         System.out.println(TermColors.RED + MINIMUM_ERROR + minimum + IS_REQUIRED_MSG + TermColors.RESET);
	      else
	    	 System.out.println(TermColors.RED + MAXIMUM_ERROR + maximum + IS_REQUIRED_MSG + TermColors.RESET);
	    } while (!finished);
	     
	   return readValue;
	  }

	  
	  public static double readDouble(String message)
	  {
	   boolean finished = false;
	   double readValue = 0;
	   do
	    {
	     System.out.print(message);
	     try
	      {
	       readValue = reader.nextDouble();
	       finished = true;
	      }
	     catch (InputMismatchException e)
	      {
			  System.out.println(String.format("%s%s"+FORMAT_ERROR+"%s",TermColors.SLOW_BLINK,TermColors.RED,TermColors.RESET));
			  String throwAway = reader.next();
	      }
	    } while (!finished);
	   return readValue;
	  }
	 
	  public static double readDoubleWithMinimum(String message, double minimum)
	  {
	   boolean finished = false;
	   double readValue = 0;
	   do
	    {
	     readValue = readDouble(message);
	     if (readValue >= minimum)
	      finished = true;
	     else
	      System.out.println(MINIMUM_ERROR + minimum + IS_REQUIRED_MSG);
	    } while (!finished);
	     
	   return readValue;
	  }

	  public static double readDoubleWithRange(String message, double minimum, double maximum){
		  boolean finished = false;
		  double readValue = 0;
		  do
		  {
			  readValue = readDouble(message);
			  if (readValue >= minimum && readValue<= maximum)
				  finished = true;
			  else
			  if (readValue < minimum)
				  System.out.println(TermColors.RED + MINIMUM_ERROR + minimum + IS_REQUIRED_MSG + TermColors.RESET);
			  else
				  System.out.println(TermColors.RED + MAXIMUM_ERROR + maximum + IS_REQUIRED_MSG + TermColors.RESET);
		  } while (!finished);

		  return readValue;
	  }

	  
	  public static boolean yesOrNo(String message)
	  {
		  String myMessage = message + "("+ REPLY_YES +"/"+ REPLY_NO +")";
		  char readValue = readUpperChar(myMessage,String.valueOf(REPLY_YES)+String.valueOf(REPLY_NO));
		  
		  if (readValue == REPLY_YES)
			return true;
		  else
			return false;
	  }

}
