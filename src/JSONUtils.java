import java.io.InputStream;
import java.util.Scanner;

import org.json.JSONObject;

public class JSONUtils {

	public static String getJSONStringFromFile(String path) {
		Scanner scanner;
		InputStream in = FileHandle.InputStreamFromFile(path);
		scanner = new Scanner(in);
		String json = scanner.useDelimiter("\\2").next();
		scanner.close();
		return json;
	}
	public static JSONObject getJSONObjectFromFile(String path) {
		return new JSONObject(getJSONStringFromFile(path));
	}
	
	public static boolean objectExists(JSONObject jsonObjects, String key) {
		Object o;
		try {
			o = JSONObject.getNames(key);
		}
		catch(Exception e){
			return false;
		}
		return o != null;
	}
}
