package com.example.ex456;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private EditText textLuminosity;
    private EditText textPressure;
    private EditText textLatitude;
    private EditText textLongitude;
    private SensorManager sensorManager;
    GPSTracker g;
    Location l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textLuminosity = (EditText) findViewById(R.id.textLuminosity);
        textPressure = (EditText) findViewById(R.id.textPressure);
        textLatitude = (EditText) findViewById(R.id.textLatitude);
        textLongitude = (EditText) findViewById(R.id.textLongitude);
        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT), SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE), SensorManager.SENSOR_DELAY_NORMAL);
        g = new GPSTracker(getApplicationContext());
        l = g.getLocation();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT){
            textLuminosity.setText("Luminosity: " + Float.toString(sensorEvent.values[0]));
        }
        if(sensorEvent.sensor.getType() == Sensor.TYPE_PRESSURE){
            textPressure.setText("Pressure: " + Float.toString(sensorEvent.values[0]));
        }
       // textLatitude.setText("Latitude: " + Double.toString(l.getLatitude()));
       // textLongitude.setText("Longitude: " + Double.toString(l.getLongitude()));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}