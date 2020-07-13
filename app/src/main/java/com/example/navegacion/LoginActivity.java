package com.example.navegacion;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import BaseDatos.BaseDatos;

public class LoginActivity extends AppCompatActivity {
    private EditText eRut, ePassword;
    private RadioButton rProfesor,rAlumno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        eRut = findViewById(R.id.eRut);
        ePassword= findViewById(R.id.ePass);
        rProfesor = findViewById(R.id.rProfesor);
        rAlumno = findViewById(R.id.rAlumno);

    }
    public void login(View viex){
        String sRut = eRut.getText().toString();
        String sPass = ePassword.getText().toString();
        String sMensaje= "";


        if(sRut.isEmpty() && sPass.isEmpty()){
            Toast.makeText(this, R.string.string_msg_datos, Toast.LENGTH_SHORT).show();
        }else if(sRut.isEmpty()){
            Toast.makeText(this, R.string.string_msg_rut, Toast.LENGTH_SHORT).show();
        }else if(sPass.isEmpty()){
            Toast.makeText(this, R.string.string_msg_pass, Toast.LENGTH_SHORT).show();
        }else{
                this.validarUsuario(sRut,sPass);

            }


        }



    public void mensajes(String mensaje){
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
    public void validarUsuario(String sRut,String sPass){
        //instancia de la clase qeu hereda de SQLiteOpenHelper, llamando al constructor
        BaseDatos admin = new BaseDatos(this, "educatech.db", null, 1);
        //intancia para poder escribir y consuiltar la base de datos
        SQLiteDatabase BaseDeDatabase = admin.getWritableDatabase();
        String sQuery ="";
        if (rAlumno.isChecked() == true){
            sQuery = "select rut from alumno where rut =" + sRut + " and contrasena =" + sPass;

        }else {
            sQuery = "select rut from profesor where rut =" + sRut + " and contrasena =" + sPass;
        }
            Cursor fila = BaseDeDatabase.rawQuery
                    (sQuery, null);
            //solo accedo al primer y unico registro
            if(fila.moveToFirst()){
                if (rProfesor.isChecked() == true){
                    Intent pantalla2 = new Intent(this, MainActivity.class);
                    startActivity(pantalla2);
                }else if(rAlumno.isChecked() == true){
                    Intent pantalla3 = new Intent(this, Main2Activity.class);
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
