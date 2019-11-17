import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
//import java.util.function.Predicate;
//import java.util.stream.Collectors;

import java8.util.function.Predicate;
import java8.util.stream.Collectors;
import java8.util.stream.Stream;
import java8.util.stream.StreamSupport;
import static java8.util.stream.Collectors.toList;
//import com.annimon.stream.Stream;
//import com.annimon.stream.function.Predicate;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Test {

	public static void main(String args[]) {
		System.out.println("Start...");

		Calendar calendar = Calendar.getInstance();
		Date today = Date.valueOf(calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-"
				+ calendar.get(Calendar.DAY_OF_MONTH));
		Time timeFromDef = Time.valueOf("07:00:00");
		Time timeToDef = Time.valueOf("15:00:00");
		Time timeCustomerBreakDef = Time.valueOf("00:15:00");
		Time timeStatutoryBreakDef = Time.valueOf("00:15:00");

		List<TimesheetRow> tsrExt = new ArrayList<TimesheetRow>();
		tsrExt.add(new TimesheetRow(1, 2, today, timeFromDef, timeToDef, timeCustomerBreakDef, timeStatutoryBreakDef,
				null, 0, 0, false, null, Timestamp.valueOf("2019-10-22 21:01:41.540052")));
		tsrExt.add(new TimesheetRow(2, 3, today, timeFromDef, timeToDef, timeCustomerBreakDef, timeStatutoryBreakDef,
				null, 0, 0, false, null, Timestamp.valueOf("2019-10-22 21:01:41.540052")));
		tsrExt.add(new TimesheetRow(3, 4, today, timeFromDef, timeToDef, timeCustomerBreakDef, timeStatutoryBreakDef,
				null, 0, 0, false, null, Timestamp.valueOf("2019-10-22 21:01:41.540052")));
		tsrExt.add(new TimesheetRow(4, 5, today, timeFromDef, timeToDef, timeCustomerBreakDef, timeStatutoryBreakDef,
				null, 0, 0, false, null, Timestamp.valueOf("2019-10-22 21:01:41.540052")));

		List<TimesheetRow> tsrLoc = new ArrayList<TimesheetRow>();
		tsrLoc.add(new TimesheetRow(5, 6, today, timeFromDef, timeToDef, timeCustomerBreakDef, timeStatutoryBreakDef,
				null, 0, 0, false, null, Timestamp.valueOf("2019-10-23 21:01:41.540052")));
		tsrLoc.add(new TimesheetRow(1, 2, today, timeFromDef, timeToDef, timeCustomerBreakDef, timeStatutoryBreakDef,
				null, 0, 0, false, null, Timestamp.valueOf("2019-10-22 21:01:41.540052")));
		tsrLoc.add(new TimesheetRow(2, 3, today, timeFromDef, timeToDef, timeCustomerBreakDef, timeStatutoryBreakDef,
				null, 0, 0, false, null, Timestamp.valueOf("2019-10-22 21:01:41.540052")));
		tsrLoc.add(new TimesheetRow(3, 4, today, timeFromDef, timeToDef, timeCustomerBreakDef, timeStatutoryBreakDef,
				null, 0, 0, false, null, Timestamp.valueOf("2019-10-21 21:01:41.540052")));
		tsrLoc.add(new TimesheetRow(4, 5, today, timeFromDef, timeToDef, timeCustomerBreakDef, timeStatutoryBreakDef,
				null, 0, 0, false, null, Timestamp.valueOf("2019-10-23 21:01:41.540052")));

		// JAVA 8 API *************************************************************

//		long millisJ8 = System.currentTimeMillis();
//
//		Predicate<TimesheetRow> predicateNotInExtDb = s -> !tsrExt.stream()
//				.anyMatch(t -> s.getIdExternal() == t.getIdExternal());
//
//		Predicate<TimesheetRow> predicateNotInExtDb2 = new Predicate<TimesheetRow>() {
//			@Override
//			public boolean test(TimesheetRow s) {
//				return !tsrExt.stream().anyMatch(new Predicate<TimesheetRow>() {
//					@Override
//					public boolean test(TimesheetRow t) {
//						// System.out.println(s.getIdExternal() + " " + t.getIdExternal());
//						return s.getIdExternal() == t.getIdExternal();
//					}
//				});
//			}
//		};
//
//		List<TimesheetRow> notInExtDb = tsrLoc.stream().filter(predicateNotInExtDb2).collect(Collectors.toList());
//
//		millisJ8 = System.currentTimeMillis() - millisJ8;
		// StreamSupport 1.7.1 ****************************************************

		Stream<TimesheetRow> sTsrLocSS171 = StreamSupport.stream(tsrLoc);

		Predicate<TimesheetRow> predicateNotInExtDbSS171 = new Predicate<TimesheetRow>() {
			@Override
			public boolean test(TimesheetRow s) {
				return !StreamSupport.stream(tsrExt).anyMatch(new Predicate<TimesheetRow>() {
					@Override
					public boolean test(TimesheetRow t) {
						return s.getIdExternal() == t.getIdExternal();
					}
				});
			}
		};
		
		List<TimesheetRow> notInExtDbSS171 = StreamSupport
				.stream(tsrLoc)
				.filter(predicateNotInExtDbSS171)
				.collect(toList());
				
//		List<TimesheetRow> qwe = StreamSupport.stream(tsrLoc)
//				.filter(s -> !StreamSupport.stream(tsrExt).anyMatch(t -> s.getIdExternal() == t.getIdExternal()))
//				.collect(toList());
		
		// LSA ********************************************************************
		System.out.println("LSA*********************");

		final com.annimon.stream.Stream<TimesheetRow> sTsrExtLSA = com.annimon.stream.Stream.of(tsrExt);
		final com.annimon.stream.Stream<TimesheetRow> sTsrLocLSA = com.annimon.stream.Stream.of(tsrLoc);

		com.annimon.stream.function.Predicate<TimesheetRow> predicateNotInExtDbLSA = new com.annimon.stream.function.Predicate<TimesheetRow>() {
			@Override
			public boolean test(TimesheetRow s) {
				return !sTsrExtLSA.anyMatch(new com.annimon.stream.function.Predicate<TimesheetRow>() {
					@Override
					public boolean test(TimesheetRow t) {
						System.out.println(s.getIdExternal() + " " + t.getIdExternal());
						return s.getIdExternal() == t.getIdExternal();
					}
				});
			}
		};

		com.annimon.stream.Stream<TimesheetRow> sNotInExtDbLSA = sTsrLocLSA.filter(predicateNotInExtDbLSA);
		List<TimesheetRow> notInExtDbLSA = sNotInExtDbLSA.toList();

		// LOOPS ********************************************************************

		long millisLOOPS = System.currentTimeMillis();

		List<TimesheetRow> notInExtDbLoops = new ArrayList<TimesheetRow>();
		for (TimesheetRow tsrL : tsrLoc) {
			boolean exist = false;
			for (TimesheetRow tsrE : tsrExt) {
				if (tsrL.getIdExternal() == tsrE.getIdExternal())
					exist = true;
			}
			if (exist == false) {
				notInExtDbLoops.add(tsrL);
			}
		}

		millisLOOPS = System.currentTimeMillis() - millisLOOPS;
		// ******************************* RESULTS *********************************

//		System.out.println("JAVA 8 Size: " + notInExtDb.size());
//		for (TimesheetRow tsr : notInExtDb) {
//			System.out.println(tsr.getUserId());
//		}
		System.out.println("LSA    Size: " + notInExtDbLSA.size());
		for (TimesheetRow tsr : notInExtDbLSA) {
			System.out.println(tsr.getUserId());
		}
		System.out.println("LOOPS  Size: " + notInExtDbLoops.size());
		for (TimesheetRow tsr : notInExtDbLoops) {
			System.out.println(tsr.getUserId());
		}
		System.out.println("LOOPS  Size: " + notInExtDbSS171.size());
		for (TimesheetRow tsr : notInExtDbSS171) {
			System.out.println(tsr.getUserId());
		}

	}

}
