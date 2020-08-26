package com.frh.mvvmsample2.Data;

import com.frh.mvvmsample2.Model.PersonModel;
import com.frh.mvvmsample2.ViewModel.TransactionViewModel;

import java.util.ArrayList;

public class Api {

    ArrayList<PersonModel> personModels = new ArrayList<>();


    public void callApi(TransactionViewModel viewModel){

        for (int i = 0; i < 50 ; i++) {
            PersonModel personmodel = new PersonModel();
            personmodel.setName(String.valueOf(i));
            personmodel.setNumber("09129129129" + i);
            personModels.add(personmodel);
        }

        viewModel.getLiveData().postValue(personModels);
    }

}
