// IRemoteService.aidl
package com.example.consultants.aidl_server;

// Declare any non-default types here with import statements
//TODO add path for the 'Person' class
package com.example.consultants.aidl_server.Person;

interface IRemoteService {
    List<Person> getPersonList();
}
