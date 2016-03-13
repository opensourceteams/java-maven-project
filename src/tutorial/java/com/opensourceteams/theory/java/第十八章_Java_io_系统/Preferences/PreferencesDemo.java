package com.opensourceteams.theory.java.第十八章_Java_io_系统.Preferences;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/1/22  下午4:09
 * 功能描述:
 */

public class PreferencesDemo {
    public static void main(String[] args) throws BackingStoreException {
        Preferences prefs = Preferences.userNodeForPackage(PreferencesDemo.class);
        prefs.put("a","我");
        prefs.put("subRecursionListFiles","爱");
        prefs.put("c","中");
        prefs.put("d","国");

        prefs.putBoolean("is",true);

        for(String key : prefs.keys()){
            System.out.println("key:" + key +" value:" + prefs.get(key,null));
        }

        int usageCount = prefs.getInt("UsageCount",0);
        usageCount++;
        prefs.putInt("UsageCount",usageCount);
        System.out.println("UsageCount:" + prefs.getInt("UsageCount",0));

    }
}
