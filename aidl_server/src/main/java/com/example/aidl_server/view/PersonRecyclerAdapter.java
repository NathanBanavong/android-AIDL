package com.example.aidl_server.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aidl_server.Person;
import com.example.aidl_server.PersonDatabase;
import com.example.aidl_server.R;

import java.util.List;

public class PersonRecyclerAdapter extends RecyclerView.Adapter<PersonRecyclerAdapter.ViewHolder> {

    PersonDatabase personDatabase;
    List<Person> personList;

    public PersonRecyclerAdapter(List<Person>personList){
        this.personList = personList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_item_list,viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Person person = personList.get(position);

        viewHolder.tvPersonName.setText(person.getName());
        viewHolder.tvPersonAge.setText(person.getAge());
        viewHolder.tvPersonGender.setText(person.getGender());

    }

    @Override
    public int getItemCount() {
        return personList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvPersonName;
        private final TextView tvPersonAge;
        private final TextView tvPersonGender;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPersonName = itemView.findViewById(R.id.tvPersonName);
            tvPersonAge = itemView.findViewById(R.id.tvPersonAge);
            tvPersonGender = itemView.findViewById(R.id.tvPersonGender);
        }
    }
}
