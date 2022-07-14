package com.datepickernativemodule;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

public class ReactDatePicker extends SimpleViewManager<PickerView> {

  public static final String REACT_CLASS = "PickerView";
  ReactApplicationContext mCallerContext;

  public ReactDatePicker(ReactApplicationContext reactContext) {
    mCallerContext = reactContext;
  }

  @Override
  public String getName() {
    return REACT_CLASS;
  }

  @Override
  public PickerView createViewInstance(ThemedReactContext context) {
    PickerView pickerView = new PickerView(context);
    return pickerView;
  }

  @ReactProp(name = "text")
  public void setText(PickerView view, @Nullable String text) {
    view.setButtonText(text);
  }

  @ReactProp(name = "buttonText")
  public void setButtonText(PickerView view, @Nullable String text) {
    view.setButtonText(text);
  }

}
