package test;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException, java.text.ParseException {
        Flights flightTimes = new Flights(ReadJsonFile.readFile("tickets.json"));
        System.out.println("Минимальное время полета между городами Владивосток и Тель-Авив для каждого авиаперевозчика (в минутах): " +
                flightTimes.getMin() + "\n" +
                "Разница между средней ценой  и медианой для полета между городами Владивосток и Тель-Авив: " +
                flightTimes.getPriceDifference());
    }
}
