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
        db.execSQL("CREATE TABLE alumno (id INTEGER PRIMARY KEY AUTOINCREMENT,rut INTEGER, nombre TEXT, apellido TEXT, contrasena NUMBER)");
        db.execSQL("CREATE TABLE profesor (id INTEGER PRIMARY KEY AUTOINCREMENT,rut INTEGER, nombre TEXT, apellido TEXT, contrasena NUMBER )");
        db.execSQL("CREATE TABLE curso (id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT, numero INTEGER, letra TEXT, FOREIGN KEY (nivel_id) REFERENCES Nivel(id) )");
        db.execSQL("CREATE TABLE nivel (id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT)");
        db.execSQL("CREATE TABLE asignatura (id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT)");
        db.execSQL("CREATE TABLE contenido (id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT,FOREIGN KEY (asignatura_id)REFERENCES Asignatura(id),FOREIGN KEY (alumno_id) REFERENCES Alumno(id), FOREIGN KEY (profesor_id) REFERENCES Profesor(id))");
        db.execSQL("CREATE TABLE curso_profesor  (id INTEGER PRIMARY KEY AUTOINCREMENT, FOREIGN KEY(curso_id)REFERENCES Curso(id), FOREIGN KEY(profesor_id)REFERENCES Profesor(id))");
        db.execSQL("CREATE TABLE asignatura_profesor  (id INTEGER PRIMARY KEY AUTOINCREMENT,FOREIGN KEY (asignatura_id)REFERENCES Asignatura(id),FOREIGN KEY (profesor_id)REFERENCES Profesor(id) )");
        db.execSQL("CREATE TABLE asignatura_alumno  (id INTEGER PRIMARY KEY AUTOINCREMENT, FOREIGN KEY (asignatura_id)REFERENCES Asignatura(id) ,FOREIGN KEY (alumno_id) REFERENCES Alumno(id))");
        db.execSQL("CREATE TABLE fecha_importante  (id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT,fecha DATE,FOREIGN KEY (asignatura_id) REFERENCES asignatura(id),FOREIGN KEY (profesor_id) REFERENCES profesor(id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
