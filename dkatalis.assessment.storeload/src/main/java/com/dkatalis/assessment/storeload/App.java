package com.dkatalis.assessment.storeload;

import com.dkatalis.assessment.storeload.util.Spf4jConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spf4j.perf.MeasurementRecorder;

import java.util.HashMap;
import java.util.Iterator;

public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    HashMap<String, String>[] hashMaps;
    String text;

    public App() {
        Spf4jConfig.initialize();
    }

    public String store(HashMap<String, String>[] hashMaps) {
        long startTime = System.currentTimeMillis();
        MeasurementRecorder measurementRecorder = Spf4jConfig.getMeasurementRecorder(App.class + " storeData");
        this.hashMaps = hashMaps;
        parseArray(this.hashMaps);
        measurementRecorder.record(System.currentTimeMillis() - startTime);
        return this.text;
    }

    public HashMap[] load(String text) {
        long startTime = System.currentTimeMillis();
        MeasurementRecorder measurementRecorder = Spf4jConfig.getMeasurementRecorder(App.class + " loadText");
        this.text = text;
        parseText(this.text);
        measurementRecorder.record(System.currentTimeMillis() - startTime);
        return this.hashMaps;
    }

    private void parseArray(HashMap[] hashMaps) {
        this.text = "";
        for(HashMap hashMap : this.hashMaps) {
            for(Iterator iterator = hashMap.keySet().iterator(); iterator.hasNext(); ) {
                String key = (String) iterator.next();
                String value = (String) hashMap.get(key);
                String element = key +  "=" + value;
                this.text += key + "=" + value;
                this.text += ";";
            }
            this.text = this.text.substring(0, this.text.length()-1);
            this.text += "\n";
        }
        this.text = this.text.substring(0, this.text.length()-1);
    }

    private void parseText(String text) {
        this.text = text;
        String[] elements = this.text.split("\n");
        this.hashMaps = new HashMap[elements.length];

        int i = 0;
        for(String element : elements) {
            String[] keyValuePairs = element.split(";");
            HashMap<String, String> hashMap = new HashMap<>();
            for(String keyValuePair : keyValuePairs) {
                String key = keyValuePair.substring(0, keyValuePair.indexOf("="));
                String value = keyValuePair.substring(keyValuePair.indexOf("=") + 1, keyValuePair.length());
                hashMap.put(key, value);
            }
            this.hashMaps[i] = hashMap;
            i++;
        }

    }

    public static void main(String[] args) {
        App app = new App();
        HashMap<String, String>[] hashMaps = app.load("key1=value1;key2=value2\nkeyA=valueA");
        app.store(hashMaps);

        System.exit(0);
    }
}
