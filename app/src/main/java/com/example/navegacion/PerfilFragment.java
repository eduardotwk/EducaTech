package com.example.navegacion;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;




public class PerfilFragment extends Fragment {

    private EditText eRut,eNombre,eApellido,ePass;

    public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)

    {
        // Inflate the layout for this fragment
       View main = inflater.inflate(R.layout.fragment_perfil, container, false);
       eRut = main.findViewById(R.id.eRut);
       eNombre = main.findViewById(R.id.eNombre);
       eApellido = main.findViewById(R.id.eApellido);
       ePass = main.findViewById(R.id.ePass);
        return main;
    }
    public void mostrarUser (int sRut,String sNombre,String sApellido,String sPass){
    

    }

}
