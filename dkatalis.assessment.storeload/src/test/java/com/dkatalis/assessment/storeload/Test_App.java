package com.dkatalis.assessment.storeload;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class Test_App {

    @Test
    public void test_store() {
        HashMap<String, String>[] hashMaps = new HashMap[2];

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("key1", "value1");
        hashMap.put("key2", "value2");
        hashMaps[0] = hashMap;

        hashMap = new HashMap<>();
        hashMap.put("keyA", "valueA");
        hashMaps[1] = hashMap;

        App app = new App();
        String text =  app.store(hashMaps);
        Assert.assertEquals("key1=value1;key2=value2\nkeyA=valueA", text);
    }

    @Test
    public void test_load() {
        App app = new App();
        HashMap<String, String>[] hashMaps = app.load("key1=value1;key2=value2\nkeyA=valueA");
        Assert.assertEquals(2, hashMaps.length);
    }
}
