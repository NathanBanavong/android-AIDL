// IRemoteService.aidl
package com.example.consultants.aidl_server;

// Declare any non-default types here with import statements
import com.example.consultants.aidl_client.Person;

interface IRemoteService {

     List<Person> getPersonList();

}
