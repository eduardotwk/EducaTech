package com.example.navegacion.ui.asignatura;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.navegacion.R;


public class AsignaturaFragment extends Fragment {

    private AsignaturaViewModel asignaturaViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        asignaturaViewModel =
                ViewModelProviders.of(this).get(AsignaturaViewModel.class);
        View root = inflater.inflate(R.layout.asignatura_gallery, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        asignaturaViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

}
