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
	
	public static void savePlayer(String playerName) {
		JSONObject obj = JSONUtils.getJSONObjectFromFile("/players.json");
		if(!JSONUtils.objectExists(playerName)) {
			//obj.put(playerName, player.getBalance)
		}
	}
	
	public static int balanceOfPlayer(String playerName) {
		try {
	        JSONObject obj = JSONUtils.getJSONObjectFromFile("/players.json");
	        String[] players = JSONObject.getNames(obj);
	        
	        for(String name : players) {
	        	if (name.equals(playerName)) {
	        		int balance = obj.getInt(playerName);
	        		return balance;
	        	}
	        }
	        return 0;
		}
		catch(Exception e){
			return 0;
		}
	}
	
	public static boolean objectExists(String key) {
		try {
	        JSONObject obj = JSONUtils.getJSONObjectFromFile("/players.json");
	        String[] players = JSONObject.getNames(obj);
	        
	        for(String name : players) {
	        	if (name.equals(key)) {
	        		int balance = obj.getInt(key);
	        		//System.out.println(balance);
	        		
	        		//Player.setBalance(balance);
	        		
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
