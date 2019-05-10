package graficos.curso.ejercicios.app14_info_sensores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
    }
}
