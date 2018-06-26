package connection;


import android.os.StrictMode;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import models.CanalData;

import static json.Mapper.MAPPER;
import static utils.JSONUtils.getJsonObject;

public class CanalInformation {


    public List<CanalData> getCanalInfromation() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String url = "https://canalstatus.com/api/v1/bridges";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        List<CanalData> canalData = new ArrayList<>();
        try {
            String result = restTemplate.getForObject(url, String.class);
            JSONObject responose = getJsonObject(result);
            JSONArray canalInfo = (JSONArray) responose.get("bridges");
            for (int i = 0; i < canalInfo.size(); i++) {
                canalData.add(MAPPER.readValue(canalInfo.get(i).toString(), CanalData.class));
            }

            return canalData;
        } catch (Exception e) {
            return null;
        }
    }


}
