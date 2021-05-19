package service;

import javax.jws.WebService;
import java.util.*;

@WebService(endpointInterface = "service.WebServiceImpl")
public class WebServiceImpl implements MyWebService {

    private static Map<String, Integer> resorts = new HashMap<>();

    static {
        resorts.put("Ибица", 750);
        resorts.put("Коста-Брава", 540);
        resorts.put("Гоа", 250);
        resorts.put("Эйлат", 550);
        resorts.put("Римини", 450);
        resorts.put("Кипр", 350);
        resorts.put("Анапа", 450);
        resorts.put("Одесса", 250);
        resorts.put("Ницца", 850);
        resorts.put("Нарочь", 250);
    }

    public Integer getPrice(String resort) {
        return resorts.get(resort);
    }

    public ArrayList<String> getResorts(int price) {
        ArrayList<String> newResorts = new ArrayList<>();
        resorts.forEach((k, v) -> {
            if(v < price)
                newResorts.add(k);
        });
        return newResorts;
    }
}