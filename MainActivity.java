package com.example.dunglai.testandroid;
        import android.app.Activity;
        import android.opengl.Matrix;
        import android.os.Bundle;
        import android.widget.Button;
        import android.widget.TextView;
        import android.hardware.SensorManager;
        import android.hardware.SensorEventListener;
        import android.hardware.SensorEvent;
        import android.hardware.Sensor;
        import java.util.List;
        import com.google.vr.sdk.audio.GvrAudioEngine;
        import android.view.View;
        import android.widget.TextView;
        import android.widget.CheckBox;

public class MainActivity extends Activity {
    private GvrAudioEngine gvrAudioEngine;
//    private volatile int sourceId = GvrAudioEngine.INVALID_ID;
    private volatile int soundFieldId = GvrAudioEngine.INVALID_ID;
    private float[] mOrientation;
    private float[] mQuaternion;
    private float[] mMagneticField;
    private float[] mGravity;
    private float mAzimut;
    private float mPitch;
    private float mRoll;
    SensorManager sm = null;
    TextView textView1 = null;
    TextView testView;
    List list;

    SensorEventListener sel = new SensorEventListener(){
        public void onAccuracyChanged(Sensor sensor, int accuracy) {}
        public void onSensorChanged(SensorEvent event) {
            if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD)
                mMagneticField = event.values;
            if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
                mGravity = event.values;
            if ((mGravity == null) || (mMagneticField == null)) {
                textView1.setText("null");
                return;
            }

            float R[] = new float[9];
            float I[] = new float[9];
            boolean success = SensorManager.getRotationMatrix(R, I, mGravity, mMagneticField);
            if (success) {
                mOrientation = new float[3];
                mQuaternion = new float[4];
                SensorManager.getOrientation(R, mOrientation);
                mAzimut = mOrientation[0]; // orientation contains: azimut, pitch and roll
                mPitch = mOrientation[1];
                mRoll = mOrientation[2];

                SensorManager.getQuaternionFromVector(mQuaternion, mOrientation);
            }
            gvrAudioEngine.setSoundfieldRotation(soundFieldId, mQuaternion[0], mQuaternion[1], mQuaternion[2], mQuaternion[3]);

            // print rotation value to screen
            textView1.setText("x: "+ mAzimut +"\ny: "+ mPitch +"\nz: "+ mRoll);
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView)findViewById(R.id.textView1);
        testView = (TextView)findViewById(R.id.testView);
        Button radbut2 =(Button)findViewById(R.id.rad2);
        Button radbut17 =(Button)findViewById(R.id.rad17);
        Button radbut3 =(Button)findViewById(R.id.rad3);
        Button radbut5 =(Button)findViewById(R.id.rad5);
        Button radbut6 =(Button)findViewById(R.id.rad6);
        Button radbut7 =(Button)findViewById(R.id.rad7);

        /* Get a SensorManager instance */
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);

        sm.registerListener(sel,sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD), SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(sel,sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

        // Initialize 3D audio engine.
        gvrAudioEngine = new GvrAudioEngine(this, GvrAudioEngine.RenderingMode.BINAURAL_LOW_QUALITY);

//        //load ping sound
//        gvrAudioEngine.preloadSoundFile("ping.wav");
//        sourceId = gvrAudioEngine.createSoundObject("ping.wav");
//        gvrAudioEngine.setSoundObjectPosition(
//            sourceId, 0,0,0);
//        gvrAudioEngine.playSound(sourceId, true /* looped playback */);
//
//        //Checkbox for ping sound
//        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
//        if (checkBox.isChecked()) {
//            checkBox.setChecked(false);
//        }

        radbut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gvrAudioEngine.stopSound(soundFieldId);
                soundFieldId = gvrAudioEngine.createSoundfield("2-Bformat-32bits.wav");
                gvrAudioEngine.setSoundVolume(soundFieldId, 40);
                gvrAudioEngine.playSound(soundFieldId, true);
                testView.setText("Currently playing: Location 2");
            }
        });


        radbut17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gvrAudioEngine.stopSound(soundFieldId);
                soundFieldId = gvrAudioEngine.createSoundfield("17-Bformat-32bits.wav");
                gvrAudioEngine.setSoundVolume(soundFieldId, 40);
                gvrAudioEngine.playSound(soundFieldId, true);
                testView.setText("Currently playing: Location 17");
            }
        });

        radbut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gvrAudioEngine.stopSound(soundFieldId);
                soundFieldId = gvrAudioEngine.createSoundfield("3-Bformat-32bits.wav");
                gvrAudioEngine.setSoundVolume(soundFieldId, 40);
                gvrAudioEngine.playSound(soundFieldId, true);
                testView.setText("Currently playing: Location 3");
            }
        });

        radbut5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gvrAudioEngine.stopSound(soundFieldId);
                soundFieldId = gvrAudioEngine.createSoundfield("5-Bformat-32bits.wav");
                gvrAudioEngine.setSoundVolume(soundFieldId, 40);
                gvrAudioEngine.playSound(soundFieldId, true);
                testView.setText("Currently playing: Location 5");
            }
        });

        radbut6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gvrAudioEngine.stopSound(soundFieldId);
                soundFieldId = gvrAudioEngine.createSoundfield("6-Bformat-32bits.wav");
                gvrAudioEngine.setSoundVolume(soundFieldId, 40);
                gvrAudioEngine.playSound(soundFieldId, true);
                testView.setText("Currently playing: Location 6");
            }
        });

        radbut7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gvrAudioEngine.stopSound(soundFieldId);
                soundFieldId = gvrAudioEngine.createSoundfield("7-Bformat-32bits.wav");
                gvrAudioEngine.setSoundVolume(soundFieldId, 40);
                gvrAudioEngine.playSound(soundFieldId, true);
                testView.setText("Currently playing: Location 7");
            }
        });
    }

    @Override
    protected void onStop() {
        if(list.size()>0){
            sm.unregisterListener(sel);
        }
        super.onStop();
    }
}