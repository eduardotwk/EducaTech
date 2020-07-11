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
        db.execSQL("CREATE TABLE nivel (id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT)");
        db.execSQL("CREATE TABLE asignatura (id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT)");
        db.execSQL("CREATE TABLE curso (id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT, numero INTEGER, letra TEXT, nivel_id INTEGER,FOREIGN KEY (nivel_id) REFERENCES nivel(id) )");
        db.execSQL("CREATE TABLE contenido (id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT,asignatura_id INTEGER,alumno_id INTEGER,profesor_id INTEGER ,INTEGER,FOREIGN KEY (asignatura_id)REFERENCES asignatura(id),FOREIGN KEY (alumno_id) REFERENCES alumno(id), FOREIGN KEY (profesor_id) REFERENCES profesor(id))");
        db.execSQL("CREATE TABLE curso_profesor  (id INTEGER PRIMARY KEY AUTOINCREMENT, curso_id INTEGER,profesor_id INTEGER,FOREIGN KEY(curso_id)REFERENCES curso(id), FOREIGN KEY(profesor_id)REFERENCES profesor(id))");
        db.execSQL("CREATE TABLE asignatura_profesor  (id INTEGER PRIMARY KEY AUTOINCREMENT,asignatura_id INTEGER,profesor_id INTEGER,FOREIGN KEY (asignatura_id)REFERENCES asignatura(id),FOREIGN KEY (profesor_id)REFERENCES profesor(id) )");
        db.execSQL("CREATE TABLE asignatura_alumno  (id INTEGER PRIMARY KEY AUTOINCREMENT,asignatura_id INTEGER,alumno_id INTEGER ,FOREIGN KEY (asignatura_id)REFERENCES asignatura(id) ,FOREIGN KEY (alumno_id) REFERENCES alumno(id))");
        db.execSQL("CREATE TABLE fecha_importante  (id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT,fecha DATE,asignatura_id INTEGER,profesor_id INTEGER,FOREIGN KEY (asignatura_id) REFERENCES asignatura(id),FOREIGN KEY (profesor_id) REFERENCES profesor(id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
