package streamTest;

import com.annimon.stream.Stream;
import com.annimon.stream.function.Predicate;

import java.util.List;

public class LSA implements StreamTest<TimesheetRow> {

	@Override
	public List<TimesheetRow> getResult(List<TimesheetRow> tsrLoc, List<TimesheetRow> tsrExt) {

		Predicate<TimesheetRow> predicateNotInExtDbLSA = new Predicate<TimesheetRow>() {
			@Override
			public boolean test(TimesheetRow s) {
				return !Stream.of(tsrExt).anyMatch(new Predicate<TimesheetRow>() {
					@Override
					public boolean test(TimesheetRow t) {
						return s.getIdExternal().equals(t.getIdExternal());
					}
				});
			}
		};

		Stream<TimesheetRow> sNotInExtDbLSA = Stream.of(tsrLoc).filter(predicateNotInExtDbLSA);
		List<TimesheetRow> notInExtDbLSA = sNotInExtDbLSA.toList();
		return notInExtDbLSA;
	}

}
