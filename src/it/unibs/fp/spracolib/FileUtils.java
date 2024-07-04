package it.unibs.fp.spracolib;
import java.io.*;
import java.util.Scanner;


public class FileUtils
{
	private final static String MSG_NO_FILE = "ERROR: FILE NOT FOUND: ";
	private final static String MSG_READ_ERROR = "AN ERROR HAPPENED WHILE READING THE FILE ";
	private final static String MSG_WRITE_ERROR = "AN ERROR HAPPENED WHILE WRITING ON THE FILE ";
	private final static String MSG_CLOSING_ERROR ="AN ERROR HAPPENED WHILE CLOSING THE FILE ";
  	
	public static Object loadSingleObject(File f)
	 {
		 Object read = null;
		 ObjectInputStream input = null;
			
		 try
			{
			 input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
				
			 read = input.readObject();
				
			}
		 catch (FileNotFoundException excNotFound)
			{
			 System.out.println(MSG_NO_FILE + f.getName() );
			}
		 catch (IOException readExc)
			{
			 System.out.println(MSG_READ_ERROR + f.getName() );
			}
		 catch (ClassNotFoundException readExc)
			{
			 System.out.println(MSG_READ_ERROR + f.getName() );
			}
  	 finally
			{
			 if (input != null)
				{
				 try 
					{
				   input.close();
					}
				 catch (IOException closeExc)
					{
			 			System.out.println(MSG_CLOSING_ERROR + f.getName() );
					}
				}
			} // finally

		 return read;
		  
	 }
	
	
	public static void saveSingleObject(File f, Object toSave) {
		ObjectOutputStream output = null;

		try {
			output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));

			output.writeObject(toSave);

		} catch (IOException writeExc) {
			System.out.println(MSG_WRITE_ERROR + f.getName());
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException closeExc) {
					System.out.println(TermColors.RED+MSG_CLOSING_ERROR+f.getName()+TermColors.RESET);
				}
			}
		}

	}

	public static String readFromFile(String fileLocation){
		File f = new File(fileLocation);
		StringBuffer sb = new StringBuffer();
		Scanner in = null;
		try {
			in = new Scanner(new FileReader(f));
			while(in.hasNext()){
				sb.append(in.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println(TermColors.RED+MSG_READ_ERROR+f.getName()+TermColors.RESET);
		}
		finally{
			if(in != null){
				try{
					in.close();
				}catch(Exception e){
					System.out.println(TermColors.RED+MSG_CLOSING_ERROR+f.getName()+TermColors.RESET);
				}
			}
		}
		return sb.toString();
	}

	public static void writeOnFileAppendMode(String fileLocation, String content){
		File f = new File(fileLocation);
		try {
			PrintWriter pw = new PrintWriter(
					new BufferedWriter(
							new FileWriter(f, true)));
			pw.append(content);
			pw.close();
		}
		catch(IOException e){
			System.out.println(TermColors.RED);
			e.printStackTrace();
			System.out.println(TermColors.RESET);
		}
	}
	public static void writeOnFile(String fileLocation, String content){
		File f = new File(fileLocation);
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(
					new BufferedWriter(
							new FileWriter(f, false)));
			pw.append(content);
		}
		catch(IOException e){
			System.out.println(TermColors.RED);
			System.out.println(MSG_WRITE_ERROR + f.getName());
			System.out.println(TermColors.RESET);
		}
		finally{
			try{
				if(pw!=null)
					pw.close();
			}catch(Exception e){
				System.out.println(TermColors.RED+MSG_CLOSING_ERROR+f.getName()+TermColors.RESET);
			}

		}
	}
}

