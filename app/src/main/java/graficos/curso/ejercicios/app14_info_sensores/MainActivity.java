package graficos.curso.ejercicios.app14_info_sensores;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import modelo.InfoSensores;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lvSensores=this.findViewById(R.id.lvSensores);
        InfoSensores info=new InfoSensores(this);
        ArrayAdapter<String> sensores=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,info.getSensores());
        lvSensores.setAdapter(sensores);

        //capturar eventos en sensor de presión
        SensorManager sm=(SensorManager)this.getSystemService(Context.SENSOR_SERVICE);
        Sensor spresion=sm.getDefaultSensor(Sensor.TYPE_PRESSURE);
        sm.registerListener(
                new SensorEventListener() {
                    @Override
                    public void onSensorChanged(SensorEvent sensorEvent) {
                        float vActual=sensorEvent.values[0];
                        if(vActual>1000){
                            Toast.makeText(MainActivity.this,"Presión excesiva",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onAccuracyChanged(Sensor sensor, int i) {

                    }
                }
                , spresion, SensorManager.SENSOR_DELAY_NORMAL);
    }
}
