package dk.itu.moapd.sensorsmonitor;

import android.content.Context;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TabHost;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class MainFragment extends Fragment {

    private EditText mAccelerationX;
    private EditText mAccelerationY;
    private EditText mAccelerationZ;
    private EditText mGravityX;
    private EditText mGravityY;
    private EditText mGravityZ;
    private EditText mGyroscopeX;
    private EditText mGyroscopeY;
    private EditText mGyroscopeZ;
    private EditText mRotationalX;
    private EditText mRotationalY;
    private EditText mRotationalZ;

    private EditText mTemperature;
    private EditText mLight;
    private EditText mPressure;
    private EditText mHumidity;

    private EditText mAccelerometerX;
    private EditText mAccelerometerY;
    private EditText mAccelerometerZ;
    private EditText mGeomagneticX;
    private EditText mGeomagneticY;
    private EditText mGeomagneticZ;
    private EditText mProximity;

    private float mCurrentAccelerationX = Float.NaN;
    private float mCurrentAccelerationY = Float.NaN;
    private float mCurrentAccelerationZ = Float.NaN;
    private float mCurrentGravityX = Float.NaN;
    private float mCurrentGravityY = Float.NaN;
    private float mCurrentGravityZ = Float.NaN;
    private float mCurrentGyroscopeX = Float.NaN;
    private float mCurrentGyroscopeY = Float.NaN;
    private float mCurrentGyroscopeZ = Float.NaN;
    private float mCurrentRotationalX = Float.NaN;
    private float mCurrentRotationalY = Float.NaN;
    private float mCurrentRotationalZ = Float.NaN;

    private float mCurrentTemperature = Float.NaN;
    private float mCurrentLight = Float.NaN;
    private float mCurrentPressure = Float.NaN;
    private float mCurrentHumidity = Float.NaN;

    private float mCurrentAccelerometerX = Float.NaN;
    private float mCurrentAccelerometerY = Float.NaN;
    private float mCurrentAccelerometerZ = Float.NaN;
    private float mCurrentGeomagneticX = Float.NaN;
    private float mCurrentGeomagneticY = Float.NaN;
    private float mCurrentGeomagneticZ = Float.NaN;
    private float mCurrentProximity = Float.NaN;

    private SensorManager mSensorManager;
    private Timer mTimer;

    private final SensorEventListener
            mAccelerationListener = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            mCurrentAccelerationX = sensorEvent.values[0];
            mCurrentAccelerationY = sensorEvent.values[1];
            mCurrentAccelerationZ = sensorEvent.values[2];
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

    };

    private final SensorEventListener
            mGravityListener = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            mCurrentGravityX = sensorEvent.values[0];
            mCurrentGravityY = sensorEvent.values[1];
            mCurrentGravityZ = sensorEvent.values[2];
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

    };

    private final SensorEventListener
            mGyroscopeListener = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            mCurrentGyroscopeX = sensorEvent.values[0];
            mCurrentGyroscopeY = sensorEvent.values[1];
            mCurrentGyroscopeZ = sensorEvent.values[2];
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

    };

    private final SensorEventListener
            mRotationalListener = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            mCurrentRotationalX = sensorEvent.values[0];
            mCurrentRotationalY = sensorEvent.values[1];
            mCurrentRotationalZ = sensorEvent.values[2];
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

    };

    private final SensorEventListener
            mTemperatureListener = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            mCurrentTemperature = sensorEvent.values[0];
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

    };

    private final SensorEventListener
            mLightListener = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            mCurrentLight = sensorEvent.values[0];
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

    };

    private final SensorEventListener
            mPressureListener = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            mCurrentPressure = sensorEvent.values[0];
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

    };

    private final SensorEventListener
            mHumidityListener = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            mCurrentHumidity = sensorEvent.values[0];
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

    };

    private final SensorEventListener
            mAccelerometerListener = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            mCurrentAccelerometerX = sensorEvent.values[0];
            mCurrentAccelerometerY = sensorEvent.values[1];
            mCurrentAccelerometerZ = sensorEvent.values[2];
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

    };

    private final SensorEventListener
            mGeomagneticListener = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            mCurrentGeomagneticX = sensorEvent.values[0];
            mCurrentGeomagneticY = sensorEvent.values[1];
            mCurrentGeomagneticZ = sensorEvent.values[2];
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

    };

    private final SensorEventListener
            mProximityListener = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            mCurrentProximity = sensorEvent.values[0];
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        mAccelerationX = view.findViewById(R.id.accelerationX);
        mAccelerationY = view.findViewById(R.id.accelerationY);
        mAccelerationZ = view.findViewById(R.id.accelerationZ);
        mGravityX = view.findViewById(R.id.gravityX);
        mGravityY = view.findViewById(R.id.gravityY);
        mGravityZ = view.findViewById(R.id.gravityZ);
        mGyroscopeX = view.findViewById(R.id.gyroscopeX);
        mGyroscopeY = view.findViewById(R.id.gyroscopeY);
        mGyroscopeZ = view.findViewById(R.id.gyroscopeZ);
        mRotationalX = view.findViewById(R.id.rotationalX);
        mRotationalY = view.findViewById(R.id.rotationalY);
        mRotationalZ = view.findViewById(R.id.rotationalZ);

        mTemperature = view.findViewById(R.id.temperature);
        mLight = view.findViewById(R.id.light);
        mPressure = view.findViewById(R.id.pressure);
        mHumidity = view.findViewById(R.id.humidity);

        mAccelerometerX = view.findViewById(R.id.accelerometerX);
        mAccelerometerY = view.findViewById(R.id.accelerometerY);
        mAccelerometerZ = view.findViewById(R.id.accelerometerZ);
        mGeomagneticX = view.findViewById(R.id.geomagneticX);
        mGeomagneticY = view.findViewById(R.id.geomagneticY);
        mGeomagneticZ = view.findViewById(R.id.geomagneticZ);
        mProximity = view.findViewById(R.id.proximity);

        mAccelerationX.setKeyListener(null);
        mAccelerationY.setKeyListener(null);
        mAccelerationZ.setKeyListener(null);
        mGravityX.setKeyListener(null);
        mGravityY.setKeyListener(null);
        mGravityZ.setKeyListener(null);
        mGyroscopeX.setKeyListener(null);
        mGyroscopeY.setKeyListener(null);
        mGyroscopeZ.setKeyListener(null);
        mRotationalX.setKeyListener(null);
        mRotationalY.setKeyListener(null);
        mRotationalZ.setKeyListener(null);

        mTemperature.setKeyListener(null);
        mLight.setKeyListener(null);
        mPressure.setKeyListener(null);
        mHumidity.setKeyListener(null);

        mAccelerometerX.setKeyListener(null);
        mAccelerometerY.setKeyListener(null);
        mAccelerometerZ.setKeyListener(null);
        mGeomagneticX.setKeyListener(null);
        mGeomagneticY.setKeyListener(null);
        mGeomagneticZ.setKeyListener(null);
        mProximity.setKeyListener(null);

        TabHost host = view.findViewById(R.id.tabHost);
        host.setup();

        TabHost.TabSpec spec = host.newTabSpec("One");
        spec.setContent(R.id.tabMotion);
        spec.setIndicator("One");
        host.addTab(spec);

        spec = host.newTabSpec("Two");
        spec.setContent(R.id.tabEnvironmental);
        spec.setIndicator("Two");
        host.addTab(spec);

        spec = host.newTabSpec("Three");
        spec.setContent(R.id.tabPosition);
        spec.setIndicator("Three");
        host.addTab(spec);

        mSensorManager = (SensorManager)
                Objects.requireNonNull(getActivity())
                        .getSystemService(Context.SENSOR_SERVICE);

        mTimer = new Timer();
        mTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateUI();
            }
        }, 0, 100);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        Sensor acceleration =
                mSensorManager
                        .getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        if (acceleration != null)
            mSensorManager
                    .registerListener(mAccelerationListener,
                            acceleration, SensorManager.SENSOR_DELAY_NORMAL);
        else {
            mAccelerationX.setText(getString(R.string.unavailable));
            mAccelerationY.setText(getString(R.string.unavailable));
            mAccelerationZ.setText(getString(R.string.unavailable));
        }

        Sensor gravity =
                mSensorManager
                        .getDefaultSensor(Sensor.TYPE_GRAVITY);
        if (gravity != null)
            mSensorManager
                    .registerListener(mGravityListener,
                            gravity, SensorManager.SENSOR_DELAY_NORMAL);
        else {
            mGravityX.setText(getString(R.string.unavailable));
            mGravityY.setText(getString(R.string.unavailable));
            mGravityZ.setText(getString(R.string.unavailable));
        }

        Sensor gyroscope =
                mSensorManager
                        .getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if (gyroscope != null)
            mSensorManager
                    .registerListener(mGyroscopeListener,
                            gyroscope, SensorManager.SENSOR_DELAY_NORMAL);
        else {
            mGyroscopeX.setText(getString(R.string.unavailable));
            mGyroscopeY.setText(getString(R.string.unavailable));
            mGyroscopeZ.setText(getString(R.string.unavailable));
        }

        Sensor rotation =
                mSensorManager
                        .getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
        if (rotation != null)
            mSensorManager
                    .registerListener(mRotationalListener,
                            rotation, SensorManager.SENSOR_DELAY_NORMAL);
        else {
            mRotationalX.setText(getString(R.string.unavailable));
            mRotationalY.setText(getString(R.string.unavailable));
            mRotationalZ.setText(getString(R.string.unavailable));
        }

        Sensor temperature =
                mSensorManager
                        .getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        if (temperature != null)
            mSensorManager
                    .registerListener(mTemperatureListener,
                            temperature, SensorManager.SENSOR_DELAY_NORMAL);
        else
            mTemperature.setText(getString(R.string.unavailable));

        Sensor light =
                mSensorManager
                        .getDefaultSensor(Sensor.TYPE_LIGHT);
        if (light != null)
            mSensorManager
                    .registerListener(mLightListener,
                            light, SensorManager.SENSOR_DELAY_NORMAL);
        else
            mLight.setText(getString(R.string.unavailable));

        Sensor pressure =
                mSensorManager
                        .getDefaultSensor(Sensor.TYPE_PRESSURE);
        if (pressure != null)
            mSensorManager
                    .registerListener(mPressureListener,
                            pressure, SensorManager.SENSOR_DELAY_NORMAL);
        else
            mPressure.setText(getString(R.string.unavailable));

        Sensor humidity =
                mSensorManager
                        .getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        if (humidity != null)
            mSensorManager
                    .registerListener(mHumidityListener,
                            humidity, SensorManager.SENSOR_DELAY_NORMAL);
        else
            mHumidity.setText(getString(R.string.unavailable));

        Sensor accelerometer =
                mSensorManager
                        .getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (accelerometer != null)
            mSensorManager
                    .registerListener(mAccelerometerListener,
                            accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        else {
            mAccelerometerX.setText(getString(R.string.unavailable));
            mAccelerometerY.setText(getString(R.string.unavailable));
            mAccelerometerZ.setText(getString(R.string.unavailable));
        }

        Sensor geomagnetic =
                mSensorManager
                        .getDefaultSensor(Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR);
        if (geomagnetic != null)
            mSensorManager
                    .registerListener(mGeomagneticListener,
                            geomagnetic, SensorManager.SENSOR_DELAY_NORMAL);
        else {
            mGeomagneticX.setText(getString(R.string.unavailable));
            mGeomagneticY.setText(getString(R.string.unavailable));
            mGeomagneticZ.setText(getString(R.string.unavailable));
        }

        Sensor proximity =
                mSensorManager
                        .getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if (proximity != null)
            mSensorManager
                    .registerListener(mProximityListener,
                            proximity, SensorManager.SENSOR_DELAY_NORMAL);
        else
            mProximity.setText(getString(R.string.unavailable));
    }

    @Override
    public void onPause() {
        mSensorManager.unregisterListener(mAccelerationListener);
        mSensorManager.unregisterListener(mGravityListener);
        mSensorManager.unregisterListener(mGyroscopeListener);
        mSensorManager.unregisterListener(mRotationalListener);

        mSensorManager.unregisterListener(mHumidityListener);
        mSensorManager.unregisterListener(mPressureListener);
        mSensorManager.unregisterListener(mLightListener);
        mSensorManager.unregisterListener(mTemperatureListener);

        mSensorManager.unregisterListener(mAccelerometerListener);
        mSensorManager.unregisterListener(mGeomagneticListener);
        mSensorManager.unregisterListener(mProximityListener);

        mTimer.cancel();
        super.onPause();
    }

    private void updateUI() {
        Objects.requireNonNull(getActivity())
                .runOnUiThread(new Runnable() {

            @Override
            public void run() {
                Resources res = getResources();

                if (!Float.isNaN(mCurrentAccelerationX))
                    mAccelerationX.setText(String.format(
                            res.getString(R.string.meters_per_second_squared),
                            mCurrentAccelerationX)
                    );

                if (!Float.isNaN(mCurrentAccelerationY))
                    mAccelerationY.setText(String.format(
                            res.getString(R.string.meters_per_second_squared),
                            mCurrentAccelerationY)
                    );

                if (!Float.isNaN(mCurrentAccelerationZ))
                    mAccelerationZ.setText(String.format(
                            res.getString(R.string.meters_per_second_squared),
                            mCurrentAccelerationZ)
                    );

                if (!Float.isNaN(mCurrentGravityX))
                    mGravityX.setText(String.format(
                            res.getString(R.string.meters_per_second_squared),
                            mCurrentGravityX)
                    );

                if (!Float.isNaN(mCurrentGravityY))
                    mGravityY.setText(String.format(
                            res.getString(R.string.meters_per_second_squared),
                            mCurrentGravityY)
                    );

                if (!Float.isNaN(mCurrentGravityZ))
                    mGravityZ.setText(String.format(
                            res.getString(R.string.meters_per_second_squared),
                            mCurrentGravityZ)
                    );

                if (!Float.isNaN(mCurrentGyroscopeX))
                    mGyroscopeX.setText(String.format(
                            res.getString(R.string.radian_per_second),
                            mCurrentGyroscopeX)
                    );

                if (!Float.isNaN(mCurrentGyroscopeY))
                    mGyroscopeY.setText(String.format(
                            res.getString(R.string.radian_per_second),
                            mCurrentGyroscopeY)
                    );

                if (!Float.isNaN(mCurrentGyroscopeZ))
                    mGyroscopeZ.setText(String.format(
                            res.getString(R.string.radian_per_second),
                            mCurrentGyroscopeZ)
                    );

                if (!Float.isNaN(mCurrentRotationalX))
                    mRotationalX.setText(String.format(
                            res.getString(R.string.degrees),
                            mCurrentRotationalX)
                    );

                if (!Float.isNaN(mCurrentRotationalY))
                    mRotationalY.setText(String.format(
                            res.getString(R.string.degrees),
                            mCurrentRotationalY)
                    );

                if (!Float.isNaN(mCurrentRotationalZ))
                    mRotationalZ.setText(String.format(
                            res.getString(R.string.degrees),
                            mCurrentRotationalZ)
                    );

                if (!Float.isNaN(mCurrentTemperature))
                    mTemperature.setText(String.format(
                            res.getString(R.string.degree_celsius),
                            mCurrentTemperature)
                    );

                if (!Float.isNaN(mCurrentLight))
                    mLight.setText(getLightCondition());

                if (!Float.isNaN(mCurrentPressure))
                    mPressure.setText(String.format(
                            res.getString(R.string.hectopascal),
                            mCurrentPressure)
                    );

                if (!Float.isNaN(mCurrentHumidity))
                    mHumidity.setText(String.format(
                            res.getString(R.string.percent),
                            mCurrentHumidity)
                    );

                if (!Float.isNaN(mCurrentAccelerometerX))
                    mAccelerometerX.setText(String.format(
                            res.getString(R.string.meters_per_second_squared),
                            mCurrentAccelerometerX)
                    );

                if (!Float.isNaN(mCurrentAccelerometerY))
                    mAccelerometerY.setText(String.format(
                            res.getString(R.string.meters_per_second_squared),
                            mCurrentAccelerometerY)
                    );

                if (!Float.isNaN(mCurrentAccelerometerZ))
                    mAccelerometerZ.setText(String.format(
                            res.getString(R.string.meters_per_second_squared),
                            mCurrentAccelerometerZ)
                    );

                if (!Float.isNaN(mCurrentGeomagneticX))
                    mGeomagneticX.setText(String.format(
                            res.getString(R.string.microtesla),
                            mCurrentGeomagneticX)
                    );

                if (!Float.isNaN(mCurrentGeomagneticY))
                    mGeomagneticY.setText(String.format(
                            res.getString(R.string.microtesla),
                            mCurrentGeomagneticY)
                    );

                if (!Float.isNaN(mCurrentGeomagneticZ))
                    mGeomagneticZ.setText(String.format(
                            res.getString(R.string.microtesla),
                            mCurrentGeomagneticZ)
                    );

                if (!Float.isNaN(mCurrentProximity))
                    mProximity.setText(String.format(
                            res.getString(R.string.centimeter),
                            mCurrentProximity)
                    );
            }
        });
    }

    private String getLightCondition() {
        if (mCurrentLight <= SensorManager.LIGHT_CLOUDY)
            return "Night";

        else if (mCurrentLight <= SensorManager.LIGHT_OVERCAST)
            return "Cloudy";

        else if (mCurrentLight <= SensorManager.LIGHT_SUNLIGHT)
            return "Overcast";

        return "Sunny";
    }

}
