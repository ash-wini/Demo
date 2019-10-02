package util;

import java.text.NumberFormat;
import java.util.Locale;

public class qaUtils
{
	public static double currencyToDecimal(String c)
	{
		return Double.parseDouble(c.replaceAll("[^\\d.]+", ""));
	}
	
	public static String decimalToCurrency(double d)
	{
		return NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(d);
	}
}