package com.datepickernativemodule;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.util.Log;
import android.widget.DatePicker;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;

import java.util.Calendar;

@ReactModule(name = DatePickerNativeModuleModule.NAME)
public class DatePickerNativeModuleModule extends ReactContextBaseJavaModule {
    public static final String NAME = "DatePickerNativeModule";
    public DatePickerDialog mDatPickerDialog;
    public static Calendar newDate = Calendar.getInstance();
    public Promise mCalenderPromise;

  private final ActivityEventListener mActivityEventListener = new BaseActivityEventListener() {
//    @Override
    public void onActivityResult() {
      try {
          mCalenderPromise.resolve(newDate);
//        mImagePickerPromise = null;
      } catch (Exception e) {
        mCalenderPromise.reject("Error", e);
      }
    }
  };

    public DatePickerNativeModuleModule(ReactApplicationContext reactContext) {
        super(reactContext);
        reactContext.addActivityEventListener(mActivityEventListener);
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
      Calendar newCalendar = Calendar.getInstance();
      mCalenderPromise = promise;
      this.mDatPickerDialog = new DatePickerDialog(currentActivity, new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
          newDate.set(year, monthOfYear, dayOfMonth);
          WritableMap result = new WritableNativeMap();
          result.putString("action", "setDate");
          result.putInt("year", year);
          result.putInt("month", monthOfYear);
          result.putInt("day", dayOfMonth);
          mCalenderPromise.resolve(result);
        }

      },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

      mDatPickerDialog.show();
    }
}
