package streamTest;

import java.util.List;
import java.util.stream.Collectors;

public class Java8Api implements StreamTest<TimesheetRow> {

	@Override
	public List<TimesheetRow> getResult(List<TimesheetRow> tsrLoc, List<TimesheetRow> tsrExt) {
		
		/*
		 * Predicate<TimesheetRow> predicateNotInExtDb = s -> !tsrExt.stream()
		 * .anyMatch(t -> s.getIdExternal() == t.getIdExternal());
		 * 
		 * Predicate<TimesheetRow> predicateNotInExtDb2 = new Predicate<TimesheetRow>()
		 * {
		 * 
		 * @Override public boolean test(TimesheetRow s) { return
		 * !tsrExt.stream().anyMatch(new Predicate<TimesheetRow>() {
		 * 
		 * @Override public boolean test(TimesheetRow t) { //
		 * System.out.println(s.getIdExternal() + " " + t.getIdExternal()); return
		 * s.getIdExternal() == t.getIdExternal(); } }); } };
		 */

		return tsrLoc.stream()
				.filter(s -> !tsrExt.stream().anyMatch(t -> s.getIdExternal().equals(t.getIdExternal())))
				.collect(Collectors.toList());
	}

}
