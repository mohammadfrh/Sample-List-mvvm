package com.frh.mvvmsample2.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.frh.mvvmsample2.Data.Api;
import com.frh.mvvmsample2.Model.PersonModel;

import java.util.ArrayList;

public class TransactionViewModel extends ViewModel {

    MutableLiveData<ArrayList<PersonModel>> liveData = new MutableLiveData<>();
    Api api = new Api();

    public MutableLiveData<ArrayList<PersonModel>> getLiveData() {
        return liveData;
    }

    public void setData(TransactionViewModel personViewModel){
        api.callApi(personViewModel);
    }

}
