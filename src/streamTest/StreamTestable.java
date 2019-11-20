package streamTest;
import java.util.List;

public interface StreamTestable<T> {

	List<T> getResult(List<T> tsrLoc ,List<T> tsrExt);
	
}
