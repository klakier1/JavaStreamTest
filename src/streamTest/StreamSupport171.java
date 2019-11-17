package streamTest;

import static java8.util.stream.Collectors.toList;

import java.util.List;

import java8.util.function.Predicate;
import java8.util.stream.StreamSupport;

public class StreamSupport171 implements StreamTest<TimesheetRow> {

	@Override
	public List<TimesheetRow> getResult(List<TimesheetRow> tsrLoc, List<TimesheetRow> tsrExt) {

		Predicate<TimesheetRow> predicateNotInExtDbSS171 = new Predicate<TimesheetRow>() {
			@Override
			public boolean test(TimesheetRow s) {
				return !StreamSupport.stream(tsrExt).anyMatch(new Predicate<TimesheetRow>() {
					@Override
					public boolean test(TimesheetRow t) {
						return s.getIdExternal().equals(t.getIdExternal());
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
		
		return notInExtDbSS171;
	}

}
