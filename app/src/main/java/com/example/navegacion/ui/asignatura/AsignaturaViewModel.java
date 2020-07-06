package com.example.navegacion.ui.asignatura;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class AsignaturaViewModel {
    private MutableLiveData<String> mText;

    public AsignaturaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Asignaturas");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
