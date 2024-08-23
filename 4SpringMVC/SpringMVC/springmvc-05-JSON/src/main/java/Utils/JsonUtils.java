package Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;

public class JsonUtils {
    public static String getJson(Object object) throws JsonProcessingException {
        return JsonUtils.getJson(object,"yyyy-MM-dd HH:mm:ss");
    }

    public static String getJson(Object object, String dateFormat) throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();

        SimpleDateFormat sdf=new SimpleDateFormat(dateFormat);
        mapper.setDateFormat(sdf);


        try {
            return mapper.writeValueAsString(object);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return null;
    }
}
