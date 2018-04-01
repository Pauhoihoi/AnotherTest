package com.example.android.anothertest.calendarmodule;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.anothertest.R;

import java.util.ArrayList;

/**
 * Created by Bobek on 27/03/2018.
 */

public class CalendarAdapter extends ArrayAdapter<MonthDays> {

    Context mContext;

    // 1
    public CalendarAdapter(Context context, ArrayList<MonthDays> monthDays) {
        super(context, 0, monthDays);
        mContext = context;
    }

    // 5
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.day_layout, parent, false);
        }

        MonthDays monthDay = getItem(position);
        TextView nameTextView = (TextView) convertView.findViewById(R.id.tv_daynumber);
        nameTextView.setText("" + monthDay.getDate());

        TextView climbTextView = (TextView) convertView.findViewById(R.id.calendar_climb_symbol);
        TextView workoutTextView = (TextView) convertView.findViewById(R.id.calendar_workout_symbol);
        TextView workoutClimbTextView = (TextView) convertView.findViewById(R.id.calendar_workoutclimb_symbol);

        if (monthDay.getFlagCurrentDay() == 1) {
            //nameTextView.setTypeface(Typeface.DEFAULT, 1);
            int color = ContextCompat.getColor(mContext, R.color.colorAccent);
            nameTextView.setTextColor(color);
        }

        if (monthDay.getFlagCurrentMonth() == 0) {
            nameTextView.setTypeface(Typeface.DEFAULT, 2);
        }

        if (monthDay.getFlagClimbing() == 0) {
            climbTextView.setVisibility(View.GONE);
        } else {
            climbTextView.setVisibility(View.VISIBLE);
        }

        if (monthDay.getFlagWorkout() == 0) {
            workoutTextView.setVisibility(View.GONE);
        } else {
            workoutTextView.setVisibility(View.VISIBLE);
        }

        if (monthDay.getFlagWorkoutClimb() == 0) {
            workoutClimbTextView.setVisibility(View.GONE);
        } else {
            workoutClimbTextView.setVisibility(View.VISIBLE);
        }

        return convertView;
    }


}