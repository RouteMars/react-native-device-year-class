package com.routemars.react.yearclass;

import com.facebook.device.yearclass.YearClass;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.HashMap;
import java.util.Map;

public class DeviceYearModule extends ReactContextBaseJavaModule {

    private static final String MODULE_NAME = "DeviceYear";
    private static final String KEY = "KEY";

    public DeviceYearModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return MODULE_NAME;
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put(KEY, MODULE_NAME);
        return constants;
    }

    @ReactMethod
    public void get(Promise promise) {
        try {
            promise.resolve(YearClass.get(getReactApplicationContext()));
        } catch (Exception e) {
            promise.reject(MODULE_NAME, e);
        }
    }
}
