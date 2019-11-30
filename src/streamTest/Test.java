package streamTest;

import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.abs;

import streamTest.api.Java8Api;
import streamTest.api.LSA;
import streamTest.api.Loops;
import streamTest.api.StreamSupport171;

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

		Dataset dataset = new Dataset();
		List<TimesheetRow> tsrExt = dataset.getExtDataSet();
		List<TimesheetRow> tsrLoc = dataset.getLocDataSet();

		System.out.println("EXT********************************************");
		tsrExt.forEach(e -> System.out.println(e.toString()));
		System.out.println("LOC********************************************");
		tsrLoc.forEach(l -> System.out.println(l.toString()));

		List<TimesheetRow> AddToLoc = new ArrayList<TimesheetRow>();
		List<TimesheetRow> AddToExt = new ArrayList<TimesheetRow>();
		List<TimesheetRow> DeleteFromLoc = new ArrayList<TimesheetRow>();
		List<TimesheetRow> DeleteFromExt = new ArrayList<TimesheetRow>();
		List<TimesheetRow> NewerInLoc = new ArrayList<TimesheetRow>();
		List<TimesheetRow> NewerInExt = new ArrayList<TimesheetRow>();
		List<TimesheetRow> Equals = new ArrayList<TimesheetRow>();
		List<TimesheetRow> NotEquals = new ArrayList<TimesheetRow>();

		tsrExt.stream().forEach(e -> {
			TimesheetRow loc = tsrLoc.stream().filter(l -> e.getIdExternal().equals(abs(l.getIdExternal()))).findFirst()
					.orElse(null);

			if (loc != null) {
				if (e.getIdExternal().equals(loc.getIdExternal())) {
					int compare = loc.getUpdatedAt().compareTo(e.getUpdatedAt());
					if (compare == 0) {
						if (loc.hashCode() == e.hashCode())
							Equals.add(loc);
						else
							NotEquals.add(loc);
					} else if (compare < 0) {
						e.setIdLocal(loc.getIdLocal());
						NewerInExt.add(e);
					} else {
						NewerInLoc.add(loc);
					}
				} else {
					DeleteFromExt.add(e);
					DeleteFromLoc.add(e);
				}
			} else {
				;
				AddToLoc.add(e);
			}
		});

		tsrLoc.stream().forEach(l -> {
			if (l.getIdExternal() == 0) {
				AddToExt.add(l);
			} else if (tsrExt.stream().noneMatch(e -> e.getIdExternal().equals(abs(l.getIdExternal())))) {
				DeleteFromLoc.add(l);
			}

		});

		System.out.println("AddToLoc:" + AddToLoc.size());
		AddToLoc.forEach(l -> System.out.println(l.toString()));
		System.out.println("AddToExt:" + AddToExt.size());
		AddToExt.forEach(l -> System.out.println(l.toString()));
		System.out.println("DeleteFromLoc:" + DeleteFromLoc.size());
		DeleteFromLoc.forEach(l -> System.out.println(l.toString()));
		System.out.println("DeleteFromExt:" + DeleteFromExt.size());
		DeleteFromExt.forEach(l -> System.out.println(l.toString()));
		System.out.println("NewerInLoc:" + NewerInLoc.size());
		NewerInLoc.forEach(l -> System.out.println(l.toString()));
		System.out.println("NewerInExt:" + NewerInExt.size());
		NewerInExt.forEach(l -> System.out.println(l.toString()));
		System.out.println("Equals:" + Equals.size());
		Equals.forEach(l -> System.out.println(l.toString()));
		System.out.println("NotEquals:" + NotEquals.size());
		NotEquals.forEach(l -> System.out.println(l.toString()));

		
		List<TimesheetRow> newTsrExt = dataset.getExtDataSet();
		List<TimesheetRow> newTsrLoc = dataset.getLocDataSet();

		newTsrExt.addAll(AddToExt);
		newTsrExt.removeIf(n -> DeleteFromExt.stream().anyMatch(d -> d.getIdExternal().equals(n.getIdExternal())));
		NewerInLoc.forEach(n -> {
			int index = newTsrExt.indexOf(
					newTsrExt.stream().filter(d -> d.getIdExternal().equals(n.getIdExternal())).findFirst().get());
			newTsrExt.set(index, n);
		});
		System.out.println("EXT NEW *************************************************************************");
		newTsrExt.forEach(e -> System.out.println(e));
		
		newTsrLoc.addAll(AddToLoc);
		newTsrLoc.removeIf(n -> DeleteFromLoc.stream().anyMatch(d -> d.getIdExternal().equals(abs(n.getIdExternal()))));
		NewerInExt.forEach(n -> {
			int index = newTsrLoc.indexOf(
					newTsrLoc.stream().filter(d -> d.getIdExternal().equals(n.getIdExternal())).findFirst().get());
			newTsrLoc.set(index, n);
		});
		System.out.println("LOC NEW *************************************************************************");
		newTsrLoc.forEach(e -> System.out.println(e));
	}
}
