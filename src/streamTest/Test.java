package streamTest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import streamTest.api.Java8Api;
import streamTest.api.LSA;
import streamTest.api.Loops;
import streamTest.api.StreamSupport171;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Test {

	public static void makeTest1(List<TimesheetRow> tsrLoc, List<TimesheetRow> tsrExt) {
		List<StreamTestable<TimesheetRow>> listaTestow = new ArrayList<StreamTestable<TimesheetRow>>();
		listaTestow.add(new Java8Api());
		listaTestow.add(new Loops());
		listaTestow.add(new StreamSupport171());
		listaTestow.add(new LSA());

		for (StreamTestable<TimesheetRow> test : listaTestow) {
			long millis = System.currentTimeMillis();
			List<TimesheetRow> wyniki = test.getResult(tsrLoc, tsrExt);
			long res = System.currentTimeMillis() - millis;
			System.out.println("Result:" + wyniki.size() + "\tTime:" + res + "\t\t" + test.getClass().getName());
			for (TimesheetRow wynik : wyniki) {
				System.out.println(wynik.getIdExternal() + " ");
			}
		}
	}


	public static void main(String args[]) {
		System.out.println("Start...");
		int no = 100;

		Calendar calendar = Calendar.getInstance();
		Date today = Date.valueOf(calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-"
				+ calendar.get(Calendar.DAY_OF_MONTH));
		Time timeFromDef = Time.valueOf("07:00:00");
		Time timeToDef = Time.valueOf("15:00:00");
		Time timeCustomerBreakDef = Time.valueOf("00:15:00");
		Time timeStatutoryBreakDef = Time.valueOf("00:15:00");
		Timestamp min = Timestamp.valueOf("2018-10-22 21:01:41.540052");
		Timestamp max = Timestamp.valueOf("2020-10-22 21:01:41.540052");

		List<TimesheetRow> tsrExt = new ArrayList<TimesheetRow>();
		tsrExt.add(new TimesheetRow(1, 10, today, timeFromDef, timeToDef, timeCustomerBreakDef, timeStatutoryBreakDef,
				null, 0, 0, false, null, Timestamp.valueOf("2019-10-22 21:01:41.540052")));
		for (int i = 2; i < no; i++) {
			tsrExt.add(new TimesheetRow(i, 10, today, timeFromDef, timeToDef, timeCustomerBreakDef,
					timeStatutoryBreakDef, null, 0, 0, false, null, TimestampUtils.nextDate(min, max)));
		}

		List<TimesheetRow> tsrLoc = new ArrayList<TimesheetRow>();
		tsrLoc.add(new TimesheetRow(1, 10, today, timeFromDef, timeToDef, timeCustomerBreakDef, timeStatutoryBreakDef,
				null, 0, 0, false, null, Timestamp.valueOf("2019-10-22 21:01:41.540052")));
		for (int i = 2; i < no; i++) {
			tsrLoc.add(new TimesheetRow(i, 10, today, timeFromDef, timeToDef, timeCustomerBreakDef,
					timeStatutoryBreakDef, null, 0, 0, false, null, TimestampUtils.nextDate(min, max)));
		}

		UpdateTest test = new UpdateTest();
		test.makeTest(tsrLoc, tsrExt);
		
		System.out.println("updated: " + test.getUpdated().size());
		System.out.println("newer in loc: " + test.getNewerLoc().size());
		System.out.println("newer in ext: " + test.getNewerExt().size());
	}

}
