package com.example.mddeloarhossain.mvvmarchitecture.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.example.mddeloarhossain.mvvmarchitecture.model.User;
import com.example.mddeloarhossain.mvvmarchitecture.model.UserRepository;

/**
 * Created by MD. DELOAR HOSSAIN on 21-Aug-20.
 */

public class MainActivityViewModel extends AndroidViewModel {

    UserRepository userRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
    }

    public LiveData<User[]> getAllUserData(){

        return userRepository.getUserData();
    }

    /*MutableLiveData<String> resultLiveData;

    public MutableLiveData<String> additionFunction(String value1,String value2){
        int num1 = Integer.parseInt(value1);
        int num2 = Integer.parseInt(value2);
        int result = num1+num2;

        if(resultLiveData == null){
            resultLiveData = new MutableLiveData<>();
        }
        resultLiveData.setValue(String.valueOf(result));

        return resultLiveData;
    }*/
}
