package com.datepickernativemodule;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

import java.util.Calendar;

@ReactModule(name = DatePickerNativeModuleModule.NAME)
public class DatePickerNativeModuleModule extends ReactContextBaseJavaModule {
    public static final String NAME = "DatePickerNativeModule";

    public DatePickerNativeModuleModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }


    // Example method
    // See https://reactnative.dev/docs/native-modules-android
    @ReactMethod
    public void multiply(double a, double b, Promise promise) {
        promise.resolve(a + b);
    }

    @ReactMethod
  public void getDatePicker(Promise promise) {
      Activity currentActivity = getCurrentActivity();
      Calendar mCalendar = Calendar.getInstance();
      int year = mCalendar.get(Calendar.YEAR);
      int month = mCalendar.get(Calendar.MONTH);
      int dayOfMonth = mCalendar.get(Calendar.DAY_OF_MONTH);
      new DatePickerDialog(currentActivity, null, year, month, dayOfMonth);
//      promise.resolve(10 * 10);
    }
}
