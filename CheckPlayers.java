import java.io.FileNotFoundException;
import java.io.IOException;

public class CheckPlayers {

    public void ifExists(String playerName) {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("players.json"));
            JSONObject jsonObject = (JSONObject) obj;
            String name = (String) jsonObject.get("name");
            System.out.println("Name is: " + name);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}