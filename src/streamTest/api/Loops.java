package streamTest.api;

import java.util.ArrayList;
import java.util.List;

import streamTest.StreamTestable;
import streamTest.TimesheetRow;

public class Loops implements StreamTestable<TimesheetRow> {

	@Override
	public List<TimesheetRow> getResult(List<TimesheetRow> tsrLoc, List<TimesheetRow> tsrExt) {
		
		List<TimesheetRow> notInExtDbLoops = new ArrayList<TimesheetRow>();
		for (TimesheetRow tsrL : tsrLoc) {
			boolean exist = false;
			for (TimesheetRow tsrE : tsrExt) {
				if (tsrL.getIdExternal().equals(tsrE.getIdExternal()))
					exist = true;
			}
			if (exist == false) {
				notInExtDbLoops.add(tsrL);
			}
		}
		return notInExtDbLoops;
	}

}
