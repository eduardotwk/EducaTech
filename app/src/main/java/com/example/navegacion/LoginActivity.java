package com.example.navegacion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText eRut, ePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        eRut = findViewById(R.id.eRut);
        ePassword= findViewById(R.id.ePass);

    }
    public void login(View viex){
        String sRut = eRut.getText().toString();
        String sPass = ePassword.getText().toString();
        String sMensaje= "";


        if(sRut.isEmpty() && sPass.isEmpty()){
            sMensaje = String.valueOf(R.string.string_msg_datos);
            mensajes(sMensaje);
        }else if(sRut.isEmpty()){
            Toast.makeText(this, R.string.string_msg_rut, Toast.LENGTH_SHORT).show();
        }else if(sPass.isEmpty()){
            Toast.makeText(this, R.string.string_msg_pass, Toast.LENGTH_SHORT).show();
        }else{
            //validar datos correctos
            if(!sRut.equals(R.string.string_rut)){
                Toast.makeText(this, "Rut Incorrecto", Toast.LENGTH_SHORT).show();
            }else if(!sPass.equals(R.string.string_password)){
                Toast.makeText(this, "Password Incorrecto", Toast.LENGTH_SHORT).show();
            }else{
                sMensaje = "Login correcto";
                //Llamando a la función , pasando un parametro
                mensajes(sMensaje);

                Intent pantalla2 = new Intent(this, MainActivity.class);
                startActivity(pantalla2);
            }


        }

    }
    //recibir y mostrar todos los mensajes
    public void mensajes(String mensaje){
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}
