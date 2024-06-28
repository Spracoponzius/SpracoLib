package it.unibs.fp.spracolib;
public class NiceStrings
{

 private final static String WHITESPACE = " ";
 private final static String FRAME = "---------------------------------------------------";
 private final static String NEWLINE = "\n";

	/**
	 * Frames a string with dashes at the top and bottom
	 * TO TEST
	 * @param s
	 * @return the provided string, framed
	 */
	public static String frame(String s, int width)
	{
		StringBuffer res = new StringBuffer();

		res.append(FRAME+NEWLINE);
		res.append(s+NEWLINE);
		res.append(FRAME+NEWLINE);

		return res.toString();

  }

 
 public static String incolumn(String s, int width)
	{
	 StringBuffer res = new StringBuffer(width);
	 int numCharDaStampare = Math.min(width,s.length());
	 res.append(s.substring(0, numCharDaStampare));
	 for (int i=s.length()+1; i<=width; i++)
		res.append(WHITESPACE);
	 return res.toString();
	}

 public static String center(String s, int width)
	{
	 StringBuffer res = new StringBuffer(width);
	 if (width <= s.length())
		res.append(s.substring(width));
	 else
		{
		 int spaziPrima = (width - s.length())/2;
		 int spaziDopo = width - spaziPrima - s.length();
		 for (int i=1; i<=spaziPrima; i++)
			res.append(WHITESPACE);
			
		 res.append(s);
		
		 for (int i=1; i<=spaziDopo; i++)
			res.append(WHITESPACE);
		}
	 	 return res.toString();

	}

	/**
	 *
	 * @param element char to repeat
	 * @param width number of times to repeat
	 * @return a string with the character repeated the times specified in width
	 */
	public static String repeatChar(char element, int width)
	 {
		 StringBuffer result = new StringBuffer(width);
		 for (int i = 0; i < width; i++)
			{
			 result.append(element);
			}
		 return result.toString();

	 }

	/**
	 * Returns the provided string separated at the beginning and at the end by two newline characters.
	 * @param toIsolate
	 * @return the isolated String
	 */
	public static String isolatedLine(String toIsolate)
	 {
		 StringBuffer result = new StringBuffer();
		 result.append(NEWLINE);
		 result.append(toIsolate);
		 result.append(NEWLINE);
		 return result.toString();
	 }
 
}

