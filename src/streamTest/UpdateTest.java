package streamTest;

import java.util.ArrayList;
import java.util.List;

import com.annimon.stream.Stream;

public class UpdateTest {

	List<TimesheetRow> newerExt = new ArrayList<TimesheetRow>();

	List<TimesheetRow> newerLoc = new ArrayList<TimesheetRow>();

	List<TimesheetRow> updated = new ArrayList<TimesheetRow>();

	public List<TimesheetRow> getNewerExt() {
		return newerExt;
	}
	public List<TimesheetRow> getNewerLoc() {
		return newerLoc;
	}
	public List<TimesheetRow> getUpdated() {
		return updated;
	}

	public void makeTest(List<TimesheetRow> tsrLoc, List<TimesheetRow> tsrExt) {
		Stream.of(tsrLoc).forEach(l -> {
			TimesheetRow e = Stream.of(tsrExt).filter(t -> l.getIdExternal().equals(t.getIdExternal())).findFirst()
					.get();

			int compare = l.getUpdatedAt().compareTo(e.getUpdatedAt());

			if (compare == 0)
				updated.add(l);
			else if (compare < 0)
				newerExt.add(e);
			else
				newerLoc.add(l);
		});
	}
}
