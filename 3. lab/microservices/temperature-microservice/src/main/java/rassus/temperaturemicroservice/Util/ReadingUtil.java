package rassus.temperaturemicroservice.Util;

import java.io.*;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import rassus.temperaturemicroservice.model.CompleteReading;
import rassus.temperaturemicroservice.model.SensorReading;

import java.nio.charset.StandardCharsets;
import java.util.Iterator;

public class ReadingUtil {

    public static SensorReading getTemperatureReading() throws Exception {
        int row = getReadingRow();
        CompleteReading completeReading = null;
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(
                    new InputStreamReader(
                            ReadingUtil.class.getResourceAsStream("/readings.csv"),
                            StandardCharsets.UTF_8));
        } catch (Exception e) {
            System.out.println("ERROR");
            e.printStackTrace();
            return null;
        }

        CsvToBean<CompleteReading> csvReader = new CsvToBeanBuilder(reader)
                .withType(CompleteReading.class)
                .withSeparator(',')
                .withIgnoreLeadingWhiteSpace(true)
                .withIgnoreEmptyLine(true)
                .build();

        Iterator<CompleteReading> it = csvReader.iterator();
        int i = 0;
        while (i < row) {
            completeReading = it.next();
            i++;
        }

        // couldn't find
        if (completeReading == null) {
            throw new FileNotFoundException("File reading.csv not found");
        }

        return completeReading.toTemperature();
    }

    /**
     * Helper method that calculates row based on current time
     *
     * @return row of needed record
     */
    private static int getReadingRow() {
        return (int) ((System.currentTimeMillis() / 60000) % 100) + 1;
    }

}
