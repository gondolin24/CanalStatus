package connection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import models.CanalData;

import static json.Mapper.MAPPER;
import static utils.JSONUtils.getJsonObject;

public class NetworkConnection {

    public boolean testConnection() {
        String url = "https://canalstatus.com/api/v1/bridges";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

        try {
            String result = restTemplate.getForObject(url, String.class);
            JSONObject responose = getJsonObject(result);
            JSONArray canalInfo = (JSONArray) responose.get("bridges");
    String derp = canalInfo.get(1).toString();

            CanalData current;
            current = MAPPER.readValue(derp, CanalData.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
