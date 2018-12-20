package com.example.aidl_server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.ArrayList;
import java.util.List;

public class MyAIDLService extends Service {

//    PersonGenerator personGenerator;
    List<Person> personList = new ArrayList<>();
    PersonDatabase personDatabase;

    public MyAIDLService() {
//        TODO set the number of people on list
//        personList.addAll(personGenerator.generate(10));
        personList = personDatabase.getPeople();    //retrieve the info from database

    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

//    TODO issue with reading the AIDL server
    private final IRemoteService.Stub binder = new IRemoteService.Stub() {

//        currently reading android.os.Person -> should be aidl_server.person
        @Override
        public List<Person> getPersonList() throws RemoteException {
            return personDatabase.getPeople();
        }
    };

}
