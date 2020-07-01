package BaseDatos;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class BaseDatos extends SQLiteOpenHelper{


    public BaseDatos(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //creamos la(s) tabla(s)
        String sQuery= "CREATE TABLE Alumno (id INTEGER PRIMARY KEY AUTOINCREMENT,rut INTEGER, nombre TEXT, apellido TEXT, contrasena TEXT, curso_id FOREIGN KEY)";
        String sQuery2= "CREATE TABLE Profesor (id INTEGER PRIMARY KEY AUTOINCREMENT,rut INTEGER, nombre TEXT, apellido TEXT, contrasena TEXT )";
        String sQuery3= "CREATE TABLE Curso (id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT, numero FLOAT, letra TEXT, nivel_id FOREIGN KEY )";
        String sQuery4= "CREATE TABLE Nivel (id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT)";
        String sQuery5= "CREATE TABLE Asignatura (id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT)";
        String sQuery6= "CREATE TABLE Contenido (id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT,asignatura_id FOREIGN KEY, alumno_id FOREIGN KEY, profesor_id FOREIGN KEY)";
        String sQuery7= "CREATE TABLE Curso_profesor  (id INTEGER PRIMARY KEY AUTOINCREMENT,curso_id FOREIGN KEY ,profesor_id FOREIGN KEY )";
        String sQuery8= "CREATE TABLE Asignatura_profesor  (id INTEGER PRIMARY KEY AUTOINCREMENT,asignatura_id FOREIGN KEY ,profesor_id INTEGER FOREIGN KEY )";
        String sQuery9= "CREATE TABLE Asignatura_alumno  (id INTEGER PRIMARY KEY AUTOINCREMENT,asignatura_id FOREIGN KEY ,alumno_id FOREIGN KEY )";
        String sQuery10= "CREATE TABLE Detalle_contenido  (id INTEGER PRIMARY KEY AUTOINCREMENT,formato TEXT,contenido_id FOREIGN KEY)";
        db.execSQL(sQuery);
        db.execSQL(sQuery2);
        db.execSQL(sQuery3);
        db.execSQL(sQuery4);
        db.execSQL(sQuery5);
        db.execSQL(sQuery6);
        db.execSQL(sQuery7);
        db.execSQL(sQuery8);
        db.execSQL(sQuery9);
        db.execSQL(sQuery10);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
