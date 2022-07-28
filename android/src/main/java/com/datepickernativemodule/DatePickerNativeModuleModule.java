package com.datepickernativemodule;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.text.format.Time;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.Switch;
import android.widget.TimePicker;

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
    public static final String NAME = "NativeDatePicker";
    public DatePickerDialog mDatPickerDialog;
    public TimePickerDialog mTimePickerDialog;
    public static Calendar newDate = Calendar.getInstance();
    public static Time newTime = new Time();
    public Promise mCalenderPromise;
    public Promise mTimePickerPromise;

  private final ActivityEventListener mActivityEventListener = new BaseActivityEventListener() {
//    @Override
    public void onActivityResult() {
      try {
          mCalenderPromise.resolve(newDate);
          mTimePickerPromise.resolve(newTime);
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

    @ReactMethod
    public void getDatePicker(int pickerThemeId, Promise promise) {
      Activity currentActivity = getCurrentActivity();

      mCalenderPromise = promise;

      Calendar newCalendar = Calendar.getInstance();

      this.mDatPickerDialog = new DatePickerDialog(currentActivity, pickerThemeId, new DatePickerDialog.OnDateSetListener() {

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

//TODO: Min and Max date
      
//      DatePicker dp = this.mDatPickerDialog.getDatePicker();

//      if(setMaxDate != -1) {
//        dp.setMaxDate(setMaxDate);
//      }
//
//      if(setMinDate != -1) {
//        dp.setMinDate(setMinDate);
//      }

      mDatPickerDialog.show();
    }

  @ReactMethod
  public void getTimePicker(Boolean is24HoursView, String colorMode, int pickerThemeId, Promise promise) {
    Activity currentActivity = getCurrentActivity();

    mTimePickerPromise = promise;

    Time time = new Time();
    time.setToNow();

    this.mTimePickerDialog = new TimePickerDialog(currentActivity, pickerThemeId, new TimePickerDialog.OnTimeSetListener() {

      public void onTimeSet(TimePicker timePicker, int hours, int minutes) {
        newTime.set(0, minutes, hours);
        WritableMap result = new WritableNativeMap();
        result.putString("action", "setTime");
        result.putInt("Hours", hours);
        result.putInt("Minutes", minutes);
        mTimePickerPromise.resolve(result);
      }
    }, time.hour, time.minute, is24HoursView);

    mTimePickerDialog.show();
  }
}
