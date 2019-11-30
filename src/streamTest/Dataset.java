package streamTest;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class Dataset {

	static Calendar calendar = Calendar.getInstance();
	static Date today = Date.valueOf(calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-"
			+ calendar.get(Calendar.DAY_OF_MONTH));
	static Time timeFromDef = Time.valueOf("07:00:00");
	static Time timeToDef = Time.valueOf("15:00:00");
	static Time timeCustomerBreakDef = Time.valueOf("00:15:00");
	static Time timeStatutoryBreakDef = Time.valueOf("00:15:00");
	Timestamp min = Timestamp.valueOf("2018-10-22 21:01:41.540052");
	Timestamp max = Timestamp.valueOf("2020-10-22 21:01:41.540052");
	int[] arr = new int[10];
	
	public Dataset() {
	      Random rd = new Random(); // creating Random object
	      for (int i = 0; i < arr.length; i++) {
	         arr[i] = rd.nextInt(999); // storing random integers in an array
	         System.out.println(arr[i]); // printing each array element
	      }
	}
	
	public List<TimesheetRow> getExtDataSet() {

		List<TimesheetRow> tsrExt = new ArrayList<TimesheetRow>();

		tsrExt.add(new TimesheetRow(1, 10, today, timeFromDef, timeToDef, timeCustomerBreakDef, timeStatutoryBreakDef,
				null, 0, 0, false, null, Timestamp.valueOf("2019-10-22 21:01:41.540052")));
		tsrExt.add(new TimesheetRow(2, 10, today, timeFromDef, timeToDef, timeCustomerBreakDef, timeStatutoryBreakDef,
				null, 0, 0, false, null, Timestamp.valueOf("2019-10-22 21:01:41.540052")));
		
		//NOWE W EXT DB
		tsrExt.add(new TimesheetRow(3, 10, today, timeFromDef, timeToDef, timeCustomerBreakDef, timeStatutoryBreakDef,
				null, 0, 0, false, null, Timestamp.valueOf("2019-10-22 21:01:41.540052")));
		tsrExt.add(new TimesheetRow(4, 10, today, timeFromDef, timeToDef, timeCustomerBreakDef, timeStatutoryBreakDef,
				null, 0, 0, false, null, Timestamp.valueOf("2019-10-22 21:01:41.540052")));
		
		//USUNIETE W LOC DB
		tsrExt.add(new TimesheetRow(17, 10, today, timeFromDef, timeToDef, timeCustomerBreakDef, timeStatutoryBreakDef,
				null, 0, 0, false, null, Timestamp.valueOf("2019-10-22 21:01:41.540052")));
		tsrExt.add(new TimesheetRow(18, 10, today, timeFromDef, timeToDef, timeCustomerBreakDef, timeStatutoryBreakDef,
				null, 0, 0, false, null, Timestamp.valueOf("2019-10-22 21:01:41.540052")));
		
		//ROZNE TIMESTAMP
		tsrExt.add(new TimesheetRow(31, 10, today, timeFromDef, timeToDef, timeCustomerBreakDef, timeStatutoryBreakDef,
				null, 0, 0, false, null, Timestamp.valueOf("2020-10-22 22:01:41.66666")));
		tsrExt.add(new TimesheetRow(32, 10, today, timeFromDef, timeToDef, timeCustomerBreakDef, timeStatutoryBreakDef,
				null, 0, 0, false, null, Timestamp.valueOf("2019-10-22 21:01:41.11111")));

		return tsrExt;
	}

	public List<TimesheetRow> getLocDataSet() {

		List<TimesheetRow> tsrLoc = new ArrayList<TimesheetRow>();

		tsrLoc.add(new TimesheetRow(1, 10, today, timeFromDef, timeToDef, timeCustomerBreakDef, timeStatutoryBreakDef,
				null, 0, 0, false, null, Timestamp.valueOf("2019-10-22 21:01:41.540052")));
		tsrLoc.add(new TimesheetRow(2, 10, today, timeFromDef, timeToDef, timeCustomerBreakDef, timeStatutoryBreakDef,
				null, 0, 0, false, null, Timestamp.valueOf("2019-10-22 21:01:41.540052")));
		
		//NOW W LOC DB - bo nie maja ExtID
		tsrLoc.add(new TimesheetRow(0, 10, today, timeFromDef, timeToDef, timeCustomerBreakDef, timeStatutoryBreakDef,
				null, 0, 0, false, null, Timestamp.valueOf("2019-10-22 21:01:41.540052")));
		tsrLoc.add(new TimesheetRow(0, 10, today, timeFromDef, timeToDef, timeCustomerBreakDef, timeStatutoryBreakDef,
				null, 0, 0, false, null, Timestamp.valueOf("2019-10-22 21:01:41.540052")));
		
		//OZNACZONE DO USUNIECIA Z EXT DB
		tsrLoc.add(new TimesheetRow(-17, 10, today, timeFromDef, timeToDef, timeCustomerBreakDef, timeStatutoryBreakDef,
				null, 0, 0, false, null, Timestamp.valueOf("2019-10-22 21:01:41.540052")));
		tsrLoc.add(new TimesheetRow(-18, 10, today, timeFromDef, timeToDef, timeCustomerBreakDef, timeStatutoryBreakDef,
				null, 0, 0, false, null, Timestamp.valueOf("2019-10-22 21:01:41.540052")));
		
		//DO USUNIECIA Z LOC DB - brakuje ich w ext
		tsrLoc.add(new TimesheetRow(21, 10, today, timeFromDef, timeToDef, timeCustomerBreakDef, timeStatutoryBreakDef,
				null, 0, 0, false, null, Timestamp.valueOf("2019-10-22 21:01:41.540052")));
		tsrLoc.add(new TimesheetRow(22, 10, today, timeFromDef, timeToDef, timeCustomerBreakDef, timeStatutoryBreakDef,
				null, 0, 0, false, null, Timestamp.valueOf("2019-10-22 21:01:41.540052")));
		
		//ROZNE TIMESTAMP
		tsrLoc.add(new TimesheetRow(31, 10, today, timeFromDef, timeToDef, timeCustomerBreakDef, timeStatutoryBreakDef,
				null, 0, 0, false, null, Timestamp.valueOf("2019-10-22 21:01:41.541011")));
		tsrLoc.add(new TimesheetRow(32, 10, today, timeFromDef, timeToDef, timeCustomerBreakDef, timeStatutoryBreakDef,
				null, 0, 0, false, null, Timestamp.valueOf("2020-10-22 30:01:41.999999")));

		for(int i = 0; i < tsrLoc.size(); i++)		{
			tsrLoc.get(i).setIdLocal(arr[i]);
		}
		return tsrLoc;
	}
}
