package main.util;

import java.util.regex.Pattern;

public abstract class ExpReg 
{
	public static boolean containOnlyNumbers(String text)
	{
		return Pattern.matches("[0-9]\\d*", text);
	}
}
