package br.com.exemplo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

import java.util.HashMap;
import java.util.Map;

public class TestReporterDemo {

    @Test
    public void reportSingleValue(TestReporter testReporter) {
        testReporter.publishEntry("a status message");
    }

    @Test
    public void reportKeyValuePair(TestReporter testReporter) {
        testReporter.publishEntry("a key", "a value");
    }

    @Test
    public void reportMultipleKeyValuePairs(TestReporter testReporter) {

        Map<String, String> map = new HashMap<>();
        map.put("user name", "dk38");
        map.put( "award year", "1974");

        testReporter.publishEntry(map);
    }

}