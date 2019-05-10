package modelo;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

import java.util.ArrayList;
import java.util.List;

public class InfoSensores {
    Context ctx;
    public InfoSensores(Context ctx){
        this.ctx=ctx;
    }
    public List<String> getSensores(){
        SensorManager sm=(SensorManager)ctx.getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensores=sm.getSensorList(Sensor.TYPE_ALL);
        List<String> listado=new ArrayList<>();
        for(Sensor s:sensores){
           listado.add(s.getName());
        }
        return listado;
    }
}
