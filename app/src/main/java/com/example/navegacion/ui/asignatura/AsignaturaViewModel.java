package com.example.navegacion.ui.asignatura;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AsignaturaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AsignaturaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Aquí van las asignaturas..");
    }

    public LiveData<String> getText() {
        return mText;
    }
}