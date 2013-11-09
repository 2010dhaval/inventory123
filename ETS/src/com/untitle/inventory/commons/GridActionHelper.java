package com.untitle.inventory.commons;

import java.util.HashMap;
import java.util.Map;

public class GridActionHelper 
{
	static Map<String,Integer> values = new HashMap<String, Integer>();
	
	public synchronized  static Map<String, Integer> calculate(int count,String pageIntStr,String limitIntStr) 
	{
		 
		Integer start = new Integer(0);
		Integer totalPages = new Integer(0);;
		int pageInt = Integer.parseInt(pageIntStr);
		int limitInt = Integer.parseInt(limitIntStr);
		if(count > 0)
		{
			double longCount = count + 0.0;
			totalPages = ((Double)Math.ceil(longCount/limitInt)).intValue();
		}
		else
		{
			totalPages = 0;
		}
		if(pageInt>totalPages)
		{
			pageInt = totalPages;
		}
		start = limitInt*pageInt - limitInt;
		if (start < 0){
			start = 0;
		}
		values.put("start", start);
		values.put("totalPages", totalPages);
		
		return values;
		
	}
}

