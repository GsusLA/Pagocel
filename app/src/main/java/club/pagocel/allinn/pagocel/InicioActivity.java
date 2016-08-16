package club.pagocel.allinn.pagocel;

import android.content.Context;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InicioActivity extends AppCompatActivity {
    String Im;
    EditText telefono;
    EditText passw;
    Button acceso;
    Procesos procesos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        // Permite la conexion de datos/internet del telefono
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        // Inicia arministrador de telefono para obtener el IMEI
        TelephonyManager datTel = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        Im = datTel.getDeviceId().toString();

        // Inicia las clases y metodos necesarios
        procesos = new Procesos();

        // Inicia los elementos del XML
        telefono = (EditText)findViewById(R.id.etInicioTel);
        passw = (EditText)findViewById(R.id.etInicioPass);
        acceso = (Button)findViewById(R.id.bttIngresar);

        // Clase que maneja el evento del boton Ingresar
        Acceso();
    }

    void Acceso(){
        acceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pswd = passw.getText().toString();
                String user = telefono.getText().toString();
                if(procesos.inicioSesion(user, pswd)){

                }
            }
        });
    }
}
