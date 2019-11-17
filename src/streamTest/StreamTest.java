package streamTest;
import java.util.List;

public interface StreamTest<T> {

	List<T> getResult(List<T> tsrLoc ,List<T> tsrExt);
	
}
