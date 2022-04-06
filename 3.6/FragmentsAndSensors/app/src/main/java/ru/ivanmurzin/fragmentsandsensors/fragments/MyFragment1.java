package ru.ivanmurzin.fragmentsandsensors.fragments;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.ivanmurzin.fragmentsandsensors.R;

public class MyFragment1 extends Fragment implements SensorEventListener {

    TextView t1;
    TextView t2;
    TextView t3;

//    float[] orientation;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_layout, container, false);
        t1 = view.findViewById(R.id.t1);
        t2 = view.findViewById(R.id.t2);
        t3 = view.findViewById(R.id.t3);
        SensorManager sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY), SensorManager.SENSOR_DELAY_UI);

        return view;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.setText("X " + sensorEvent.values[0]);
        t2.setText("Y: " + sensorEvent.values[1]);
        t3.setText("Z: " + sensorEvent.values[2]);
        //sensorEvent.values;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i ) {
    }
}
