package dk.itu.moapd.sensorsmonitor

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TabHost
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.*
import java.util.*

class MainFragment : Fragment() {

    private var mCurrentAccelerationX = Float.NaN
    private var mCurrentAccelerationY = Float.NaN
    private var mCurrentAccelerationZ = Float.NaN
    private var mCurrentGravityX = Float.NaN
    private var mCurrentGravityY = Float.NaN
    private var mCurrentGravityZ = Float.NaN
    private var mCurrentGyroscopeX = Float.NaN
    private var mCurrentGyroscopeY = Float.NaN
    private var mCurrentGyroscopeZ = Float.NaN
    private var mCurrentRotationalX = Float.NaN
    private var mCurrentRotationalY = Float.NaN
    private var mCurrentRotationalZ = Float.NaN

    private var mCurrentTemperature = Float.NaN
    private var mCurrentLight = Float.NaN
    private var mCurrentPressure = Float.NaN
    private var mCurrentHumidity = Float.NaN

    private var mCurrentAccelerometerX = Float.NaN
    private var mCurrentAccelerometerY = Float.NaN
    private var mCurrentAccelerometerZ = Float.NaN
    private var mCurrentGeomagneticX = Float.NaN
    private var mCurrentGeomagneticY = Float.NaN
    private var mCurrentGeomagneticZ = Float.NaN
    private var mCurrentProximity = Float.NaN

    private lateinit var mSensorManager: SensorManager
    private lateinit var mTimer: Timer

    private val mAccelerationListener: SensorEventListener =
        object : SensorEventListener {

        override fun onSensorChanged(sensorEvent: SensorEvent) {
            mCurrentAccelerationX = sensorEvent.values[0]
            mCurrentAccelerationY = sensorEvent.values[1]
            mCurrentAccelerationZ = sensorEvent.values[2]
        }

        override fun onAccuracyChanged(sensor: Sensor, i: Int) {}
    }

    private val mGravityListener: SensorEventListener =
        object : SensorEventListener {

        override fun onSensorChanged(sensorEvent: SensorEvent) {
            mCurrentGravityX = sensorEvent.values[0]
            mCurrentGravityY = sensorEvent.values[1]
            mCurrentGravityZ = sensorEvent.values[2]
        }

        override fun onAccuracyChanged(sensor: Sensor, i: Int) {}
    }

    private val mGyroscopeListener: SensorEventListener =
        object : SensorEventListener {

        override fun onSensorChanged(sensorEvent: SensorEvent) {
            mCurrentGyroscopeX = sensorEvent.values[0]
            mCurrentGyroscopeY = sensorEvent.values[1]
            mCurrentGyroscopeZ = sensorEvent.values[2]
        }

        override fun onAccuracyChanged(sensor: Sensor, i: Int) {}
    }

    private val mRotationalListener: SensorEventListener =
        object : SensorEventListener {

        override fun onSensorChanged(sensorEvent: SensorEvent) {
            mCurrentRotationalX = sensorEvent.values[0]
            mCurrentRotationalY = sensorEvent.values[1]
            mCurrentRotationalZ = sensorEvent.values[2]
        }

        override fun onAccuracyChanged(sensor: Sensor, i: Int) {}
    }

    private val mTemperatureListener: SensorEventListener =
        object : SensorEventListener {

        override fun onSensorChanged(sensorEvent: SensorEvent) {
            mCurrentTemperature = sensorEvent.values[0]
        }

        override fun onAccuracyChanged(sensor: Sensor, i: Int) {}
    }

    private val mLightListener: SensorEventListener =
        object : SensorEventListener {

        override fun onSensorChanged(sensorEvent: SensorEvent) {
            mCurrentLight = sensorEvent.values[0]
        }

        override fun onAccuracyChanged(sensor: Sensor, i: Int) {}
    }

    private val mPressureListener: SensorEventListener =
        object : SensorEventListener {

        override fun onSensorChanged(sensorEvent: SensorEvent) {
            mCurrentPressure = sensorEvent.values[0]
        }

        override fun onAccuracyChanged(sensor: Sensor, i: Int) {}
    }

    private val mHumidityListener: SensorEventListener =
        object : SensorEventListener {

        override fun onSensorChanged(sensorEvent: SensorEvent) {
            mCurrentHumidity = sensorEvent.values[0]
        }

        override fun onAccuracyChanged(sensor: Sensor, i: Int) {}
    }

    private val mAccelerometerListener: SensorEventListener =
        object : SensorEventListener {

        override fun onSensorChanged(sensorEvent: SensorEvent) {
            mCurrentAccelerometerX = sensorEvent.values[0]
            mCurrentAccelerometerY = sensorEvent.values[1]
            mCurrentAccelerometerZ = sensorEvent.values[2]
        }

        override fun onAccuracyChanged(sensor: Sensor, i: Int) {}
    }

    private val mGeomagneticListener: SensorEventListener =
        object : SensorEventListener {

        override fun onSensorChanged(sensorEvent: SensorEvent) {
            mCurrentGeomagneticX = sensorEvent.values[0]
            mCurrentGeomagneticY = sensorEvent.values[1]
            mCurrentGeomagneticZ = sensorEvent.values[2]
        }

        override fun onAccuracyChanged(sensor: Sensor, i: Int) {}
    }

    private val mProximityListener: SensorEventListener =
        object : SensorEventListener {

        override fun onSensorChanged(sensorEvent: SensorEvent) {
            mCurrentProximity = sensorEvent.values[0]
        }

        override fun onAccuracyChanged(sensor: Sensor, i: Int) {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        accelerationX.keyListener = null
        accelerationY.keyListener = null
        accelerationZ.keyListener = null
        gravityX.keyListener = null
        gravityY.keyListener = null
        gravityZ.keyListener = null
        gyroscopeX.keyListener = null
        gyroscopeY.keyListener = null
        gyroscopeZ.keyListener = null
        rotationalX.keyListener = null
        rotationalY.keyListener = null
        rotationalZ.keyListener = null

        temperature.keyListener = null
        light.keyListener = null
        pressure.keyListener = null
        humidity.keyListener = null

        accelerometerX.keyListener = null
        accelerometerY.keyListener = null
        accelerometerZ.keyListener = null
        geomagneticX.keyListener = null
        geomagneticY.keyListener = null
        geomagneticZ.keyListener = null
        proximity.keyListener = null

        val host: TabHost = view.findViewById(R.id.tabHost)
        host.setup()

        var spec = host.newTabSpec("One")
        spec.setContent(R.id.tabMotion)
        spec.setIndicator("One")
        host.addTab(spec)

        spec = host.newTabSpec("Two")
        spec.setContent(R.id.tabEnvironmental)
        spec.setIndicator("Two")
        host.addTab(spec)

        spec = host.newTabSpec("Three")
        spec.setContent(R.id.tabPosition)
        spec.setIndicator("Three")
        host.addTab(spec)

        mSensorManager = activity!!
            .getSystemService(Context.SENSOR_SERVICE) as SensorManager

        mTimer = Timer()
        mTimer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                updateUI()
            }
        }, 0, 100)
    }

    override fun onResume() {
        super.onResume()

        val acceleration = mSensorManager
            .getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION)
        if (acceleration != null)
            mSensorManager.registerListener(mAccelerationListener,
                acceleration, SensorManager.SENSOR_DELAY_NORMAL)
        else {
            accelerationX.setText(getString(R.string.unavailable))
            accelerationY.setText(getString(R.string.unavailable))
            accelerationZ.setText(getString(R.string.unavailable))
        }

        val gravity = mSensorManager
            .getDefaultSensor(Sensor.TYPE_GRAVITY)
        if (gravity != null)
            mSensorManager.registerListener(mGravityListener,
                gravity, SensorManager.SENSOR_DELAY_NORMAL)
        else {
            gravityX.setText(getString(R.string.unavailable))
            gravityY.setText(getString(R.string.unavailable))
            gravityZ.setText(getString(R.string.unavailable))
        }

        val gyroscope = mSensorManager
            .getDefaultSensor(Sensor.TYPE_GYROSCOPE)
        if (gyroscope != null)
            mSensorManager.registerListener(mGyroscopeListener,
                gyroscope, SensorManager.SENSOR_DELAY_NORMAL)
        else {
            gyroscopeX.setText(getString(R.string.unavailable))
            gyroscopeY.setText(getString(R.string.unavailable))
            gyroscopeZ.setText(getString(R.string.unavailable))
        }

        val rotation = mSensorManager
            .getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR)
        if (rotation != null)
            mSensorManager.registerListener(mRotationalListener,
                rotation, SensorManager.SENSOR_DELAY_NORMAL)
        else {
            rotationalX.setText(getString(R.string.unavailable))
            rotationalY.setText(getString(R.string.unavailable))
            rotationalZ.setText(getString(R.string.unavailable))
        }

        val valTemperature = mSensorManager
            .getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)
        if (valTemperature != null)
            mSensorManager.registerListener(mTemperatureListener,
                valTemperature, SensorManager.SENSOR_DELAY_NORMAL)
        else
            temperature.setText(getString(R.string.unavailable))

        val valLight = mSensorManager
            .getDefaultSensor(Sensor.TYPE_LIGHT)
        if (valLight != null)
            mSensorManager.registerListener(mLightListener,
                valLight, SensorManager.SENSOR_DELAY_NORMAL)
        else
            light.setText(getString(R.string.unavailable))

        val valPressure = mSensorManager
            .getDefaultSensor(Sensor.TYPE_PRESSURE)
        if (valPressure != null)
            mSensorManager.registerListener(mPressureListener,
                valPressure, SensorManager.SENSOR_DELAY_NORMAL)
        else
            pressure.setText(getString(R.string.unavailable))

        val valHumidity = mSensorManager
            .getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY)
        if (valHumidity != null)
            mSensorManager.registerListener(mHumidityListener,
                valHumidity, SensorManager.SENSOR_DELAY_NORMAL)
        else
            humidity.setText(getString(R.string.unavailable))

        val accelerometer = mSensorManager
            .getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        if (accelerometer != null)
            mSensorManager.registerListener(mAccelerometerListener,
                accelerometer, SensorManager.SENSOR_DELAY_NORMAL)
        else {
            accelerometerX.setText(getString(R.string.unavailable))
            accelerometerY.setText(getString(R.string.unavailable))
            accelerometerZ.setText(getString(R.string.unavailable))
        }

        val geomagnetic = mSensorManager
            .getDefaultSensor(Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR)
        if (geomagnetic != null)
            mSensorManager.registerListener(mGeomagneticListener,
                geomagnetic, SensorManager.SENSOR_DELAY_NORMAL)
        else {
            geomagneticX.setText(getString(R.string.unavailable))
            geomagneticY.setText(getString(R.string.unavailable))
            geomagneticZ.setText(getString(R.string.unavailable))
        }

        val valProximity = mSensorManager
            .getDefaultSensor(Sensor.TYPE_PROXIMITY)
        if (valProximity != null)
            mSensorManager.registerListener(mProximityListener,
                valProximity, SensorManager.SENSOR_DELAY_NORMAL)
        else
            proximity.setText(getString(R.string.unavailable))

    }

    override fun onPause() {
        super.onPause()

        mSensorManager.unregisterListener(mAccelerationListener)
        mSensorManager.unregisterListener(mGravityListener)
        mSensorManager.unregisterListener(mGyroscopeListener)
        mSensorManager.unregisterListener(mRotationalListener)

        mSensorManager.unregisterListener(mHumidityListener)
        mSensorManager.unregisterListener(mPressureListener)
        mSensorManager.unregisterListener(mLightListener)
        mSensorManager.unregisterListener(mTemperatureListener)

        mSensorManager.unregisterListener(mAccelerometerListener)
        mSensorManager.unregisterListener(mGeomagneticListener)
        mSensorManager.unregisterListener(mProximityListener)

        mTimer.cancel()
    }

    private fun updateUI() {
        activity!!.runOnUiThread {

            if (!mCurrentAccelerationX.isNaN())
                accelerationX.setText(String.format(
                    getString(R.string.meters_per_second_squared),
                    mCurrentAccelerationX)
                )

            if (!mCurrentAccelerationY.isNaN())
                accelerationY.setText(String.format(
                    getString(R.string.meters_per_second_squared),
                    mCurrentAccelerationY)
                )

            if (!mCurrentAccelerationZ.isNaN())
                accelerationZ.setText(String.format(
                    getString(R.string.meters_per_second_squared),
                    mCurrentAccelerationZ)
                )

            if (!mCurrentGravityX.isNaN())
                gravityX.setText(String.format(
                    getString(R.string.meters_per_second_squared),
                    mCurrentGravityX)
                )

            if (!mCurrentGravityY.isNaN())
                gravityY.setText(String.format(
                    getString(R.string.meters_per_second_squared),
                    mCurrentGravityY)
                )

            if (!mCurrentGravityZ.isNaN())
                gravityZ.setText(String.format(
                    getString(R.string.meters_per_second_squared),
                    mCurrentGravityZ)
                )

            if (!mCurrentGyroscopeX.isNaN())
                gyroscopeX.setText(String.format(
                    getString(R.string.radian_per_second),
                    mCurrentGyroscopeX)
                )

            if (!mCurrentGyroscopeY.isNaN())
                gyroscopeY.setText(String.format(
                    getString(R.string.radian_per_second),
                    mCurrentGyroscopeY)
                )

            if (!mCurrentGyroscopeZ.isNaN())
                gyroscopeZ.setText(String.format(
                    getString(R.string.radian_per_second),
                    mCurrentGyroscopeZ)
                )

            if (!mCurrentRotationalX.isNaN())
                rotationalX.setText(String.format(
                    getString(R.string.degrees),
                    mCurrentRotationalX)
                )

            if (!mCurrentRotationalY.isNaN())
                rotationalY.setText(String.format(
                    getString(R.string.degrees),
                    mCurrentRotationalY)
                )

            if (!mCurrentRotationalZ.isNaN())
                rotationalZ.setText(String.format(
                    getString(R.string.degrees),
                    mCurrentRotationalZ)
                )

            if (!mCurrentTemperature.isNaN())
                temperature.setText(String.format(
                    getString(R.string.degree_celsius),
                    mCurrentTemperature)
                )

            if (!mCurrentLight.isNaN())
                light.setText(getLightCondition())

            if (!mCurrentPressure.isNaN())
                pressure.setText(String.format(
                    getString(R.string.hectopascal),
                    mCurrentPressure)
                )

            if (!mCurrentHumidity.isNaN())
                humidity.setText(String.format(
                    getString(R.string.percent),
                    mCurrentHumidity)
                )

            if (!mCurrentAccelerometerX.isNaN())
                accelerometerX.setText(String.format(
                    getString(R.string.meters_per_second_squared),
                    mCurrentAccelerometerX)
                )

            if (!mCurrentAccelerometerY.isNaN())
                accelerometerY.setText(String.format(
                    getString(R.string.meters_per_second_squared),
                    mCurrentAccelerometerY)
                )

            if (!mCurrentAccelerometerZ.isNaN())
                accelerometerZ.setText(String.format(
                    getString(R.string.meters_per_second_squared),
                    mCurrentAccelerometerZ)
                )

            if (!mCurrentGeomagneticX.isNaN())
                geomagneticX.setText(String.format(
                    getString(R.string.microtesla),
                    mCurrentGeomagneticX)
                )

            if (!mCurrentGeomagneticY.isNaN())
                geomagneticY.setText(String.format(
                    getString(R.string.microtesla),
                    mCurrentGeomagneticY)
                )

            if (!mCurrentGeomagneticZ.isNaN())
                geomagneticZ.setText(String.format(
                    getString(R.string.microtesla),
                    mCurrentGeomagneticZ)
                )

            if (!mCurrentProximity.isNaN())
                proximity.setText(String.format(
                    getString(R.string.centimeter),
                    mCurrentProximity)
                )
        }
    }

    private fun getLightCondition() : String =
        when {
            mCurrentLight <= SensorManager.LIGHT_CLOUDY -> "Night"
            mCurrentLight <= SensorManager.LIGHT_OVERCAST -> "Cloudy"
            mCurrentLight <= SensorManager.LIGHT_SUNLIGHT -> "Overcast"
            else -> "Sunny"
        }

}
