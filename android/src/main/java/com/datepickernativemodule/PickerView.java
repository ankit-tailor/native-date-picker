package com.datepickernativemodule;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class PickerView extends FrameLayout {
  private TextView textView;
  private DatePicker datePicker;
  private Button button;
  private LinearLayout linearLayout;
  private DatePickerDialog mDatePickerDialoge;
  private SimpleDateFormat dateFormatter;

  public PickerView(Context context) {
    super(context);
    this.setPadding(32,32,32,32);
    this.setBackgroundColor(Color.parseColor("#33B5FF"));

    this.linearLayout = new LinearLayout(context);
    this.textView = new TextView(context);
    this.button = new Button(context);
    dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
    Calendar newCalendar = Calendar.getInstance();
    this.mDatePickerDialoge = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {

      public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        Calendar newDate = Calendar.getInstance();
        newDate.set(year, monthOfYear, dayOfMonth);
        textView.setText(dateFormatter.format(newDate.getTime()));
        button.setText(dateFormatter.format(newDate.getTime()));
      }

    },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    this.textView.setText("Hello world");
    this.button.setText("Red Color Button");
    this.button.setTextColor(Color.parseColor("#ff0000"));
    this.button.setPadding(32, 32, 32, 32);
    this.linearLayout.setOrientation(LinearLayout.VERTICAL);

    this.button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        mDatePickerDialoge.show();
      }
    });

    this.linearLayout.addView(textView);
    this.linearLayout.addView(button);

    this.addView(linearLayout);
  }

  public void setText(String text) {
//    this.textView.setText(text);
  }

  public void setButtonText(String text) {
    this.button.setText(text);
    this.button.setBackgroundColor(Color.parseColor("#f56c42"));
    this.button.setPadding(32, 32, 32, 32);
    this.button.setTextColor(Color.parseColor("#42f5d1"));
  }

}
