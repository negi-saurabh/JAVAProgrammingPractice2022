import java.net.URI;
import java.net.http.*;
import com.fasterxml.jackson.databind.*;

public class RestTest{
    public static int totalCredits() throws Exception {

        HttpClient client = HttpClient.newHttpClient();
        ObjectMapper mapper = new ObjectMapper();
        List<JsonNode> allItems = new ArrayList<>();
        int page = 1, totalpages = 1;
        do{
            String url = ""+page
            HttpRequest req = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
            HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());

            JsonNode root = mapper.readTree(res.body());
            totalpages = root.get("total_pages").asInt();

            for(JsonNode item: root.get("data")){
                allItems.add(item);
            }
            page++;
        } while(page<=totalpages);

            return allItems.stream().
    }
}