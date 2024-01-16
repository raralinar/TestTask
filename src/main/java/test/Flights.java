package test;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Flights {
    JSONObject jsonObject;
    Flights(JSONObject object) {
        this.jsonObject = object;
    }
    public Map<String, Long> getMin() throws ParseException {
        JSONArray tickets = (JSONArray) jsonObject.get("tickets");
        Map<String,Long> airlines = new HashMap<>();
        for (Object ticket : tickets) {
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yy HH:mm");
            JSONObject ticket1 = (JSONObject) ticket;
            String start = ticket1.get("departure_date") + " " + ticket1.get("departure_time");
            String stop = ticket1.get("arrival_date") + " " + ticket1.get("arrival_time");
            Date d1 = format.parse(start);
            Date d2 = format.parse(stop);
            long diff = d2.getTime() - d1.getTime();
            diff = diff / (60 * 1000);
            String carrier = String.valueOf(ticket1.get("carrier"));
            airlines.put(carrier, airlines.containsKey(carrier) ?
                    Math.min(airlines.get(carrier), diff) : diff);
        }
        return airlines;
    }

    public double getPriceDifference() {
        JSONArray tickets = (JSONArray) jsonObject.get("tickets");
        List<Integer> prices = new ArrayList<>();
        for (Object ticket : tickets) {
            JSONObject ticket1 = (JSONObject) ticket;
            prices.add(Integer.parseInt(ticket1.get("price").toString()));
        }
        Collections.sort(prices);
        int average = prices.stream().reduce(0, Integer::sum)/prices.size();
        double median = prices.size() % 2 == 0 ? prices.stream().skip(prices.size()/2-1).limit(2).reduce(0, Integer::sum)/2 : prices.stream().skip(prices.size()/2).findFirst().get();
        return Math.abs(median - average);
    }

}
