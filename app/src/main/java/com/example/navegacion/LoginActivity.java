package com.example.navegacion;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import BaseDatos.BaseDatos;

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
            if(sRut.equals(R.string.string_rut)){
                Toast.makeText(this, "Rut Incorrecto", Toast.LENGTH_SHORT).show();
            }else if(sPass.equals(R.string.string_password)){
                Toast.makeText(this, "Password Incorrecto", Toast.LENGTH_SHORT).show();
            }else{
                //capturar el check.
                String check ="";
                //BASE DE DATOS.
                this.validarUsuario(sRut,sPass,check);

            }


        }

    }

    public void mensajes(String mensaje){
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
    public void validarUsuario(String sRut,String sPass,String check){
        //instancia de la clase qeu hereda de SQLiteOpenHelper, llamando al constructor
        BaseDatos admin = new BaseDatos(this, "Educatech", null, 1);
        //intancia para poder escribir y consuiltar la base de datos
        SQLiteDatabase BaseDeDatabase = admin.getWritableDatabase();
        String sQuery ="";
        if (check == "alumno"){
            sQuery = "select rut from Alumno where rut =" + sRut + " and contrasena =" + sPass;
        }else{
            sQuery = "select rut from Profesor where rut =" + sRut + " and contrasena =" + sPass;
        }

            Cursor fila = BaseDeDatabase.rawQuery
                    (sQuery, null);
            //solo accedo al primer y unico registro
            if(fila.moveToFirst()){
                if (check == "profesor"){
                    Intent pantalla2 = new Intent(this, MainActivity.class);
                    startActivity(pantalla2);
                }else{
                    Intent pantalla3 = new Intent(this, MainActivity.class);
                    startActivity(pantalla3);
                }
            } else {
                String sMensaje = "No existe el registro";
                mensajes(sMensaje);
            }
            //siempre cerrar la conexion al realizar una consulta, existan datos o no
            BaseDeDatabase.close();


    }
}
