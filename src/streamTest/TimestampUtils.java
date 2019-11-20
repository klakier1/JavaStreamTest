package streamTest;

import java.sql.Timestamp;
import java.util.concurrent.ThreadLocalRandom;

public class TimestampUtils {

	static public Timestamp nextDate(Timestamp min, Timestamp max) {

		return new Timestamp(ThreadLocalRandom.current().nextLong(min.getTime(), max.getTime()));
	}
	
	static public Timestamp nextDate() {

		return new Timestamp(ThreadLocalRandom.current().nextLong());
	}
	
}
