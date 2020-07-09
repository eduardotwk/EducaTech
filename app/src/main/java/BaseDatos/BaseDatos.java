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
        db.execSQL("CREATE TABLE Alumno (id INTEGER PRIMARY KEY AUTOINCREMENT,rut INTEGER, nombre TEXT, apellido TEXT, contrasena NUMBER)");
        db.execSQL("CREATE TABLE Profesor (id INTEGER PRIMARY KEY AUTOINCREMENT,rut INTEGER, nombre TEXT, apellido TEXT, contrasena NUMBER )");
        db.execSQL("CREATE TABLE Curso (id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT, numero INTEGER, letra TEXT, FOREIGN KEY (nivel_id) REFERENCES Nivel(id) )");
        db.execSQL("CREATE TABLE Nivel (id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT)");
        db.execSQL("CREATE TABLE Asignatura (id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT)");
        db.execSQL("CREATE TABLE Contenido (id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT,FOREIGN KEY (asignatura_id)REFERENCES Asignatura(id),FOREIGN KEY (alumno_id) REFERENCES Alumno(id), FOREIGN KEY (profesor_id) REFERENCES Profesor(id))");
        db.execSQL("CREATE TABLE Curso_profesor  (id INTEGER PRIMARY KEY AUTOINCREMENT, FOREIGN KEY(curso_id)REFERENCES Curso(id), FOREIGN KEY(profesor_id)REFERENCES Profesor(id))");
        db.execSQL("CREATE TABLE Asignatura_profesor  (id INTEGER PRIMARY KEY AUTOINCREMENT,FOREIGN KEY (asignatura_id)REFERENCES Asignatura(id),FOREIGN KEY (profesor_id)REFERENCES Profesor(id) )");
        db.execSQL("CREATE TABLE Asignatura_alumno  (id INTEGER PRIMARY KEY AUTOINCREMENT, FOREIGN KEY (asignatura_id)REFERENCES Asignatura(id) ,FOREIGN KEY (alumno_id) REFERENCES Alumno(id))");
        db.execSQL("CREATE TABLE Detalle_contenido  (id INTEGER PRIMARY KEY AUTOINCREMENT,formato TEXT,FOREIGN KEY (contenido_id) REFERENCES Contenido(id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
