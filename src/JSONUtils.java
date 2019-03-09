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
	
	public static boolean objectExists(String key) {
		try {
	        JSONObject obj = JSONUtils.getJSONObjectFromFile("/players.json");
	        String[] names = JSONObject.getNames(obj);
	        for(String string : names) {
	        	//System.out.println(obj.get(string));
	        	if (obj.get(string).equals(key)) {
	        		return true;
	        	}
	        }
	        return false;
		}
		catch(Exception e){
			return false;
		}
	}
}
