
package com.example.loginandregistrationapp.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.loginandregistrationapp.R;
import com.example.loginandregistrationapp.models.CustomeAdapter;
import com.example.loginandregistrationapp.models.DataModelCharacter;
import com.example.loginandregistrationapp.models.myFriendsData;

import java.util.ArrayList;

public class FragmentFriends extends Fragment {
    private ArrayList<DataModelCharacter> dataSet;
    private ArrayList<DataModelCharacter> filteredDataSet;
    private CustomeAdapter adapter;

    public FragmentFriends() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_friends, container, false);

        try {
            dataSet = new ArrayList<>();
            filteredDataSet = new ArrayList<>();

            RecyclerView recyclerView = rootView.findViewById(R.id.resView);
            EditText searchByName = rootView.findViewById(R.id.searchByName);

            LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());

            if (myFriendsData.nameArray != null) {
                for (int i = 0; i < myFriendsData.nameArray.length; i++) {
                    dataSet.add(new DataModelCharacter(
                            myFriendsData.nameArray[i],
                            myFriendsData.descriptionArray[i],
                            myFriendsData.drawableArray[i],
                            myFriendsData.id_[i]
                    ));
                }
            }

            filteredDataSet.addAll(dataSet);

            adapter = new CustomeAdapter(filteredDataSet, character -> {
                Bundle bundle = new Bundle();
                bundle.putInt("characterId", character.getId_());
                Navigation.findNavController(getView()).navigate(R.id.action_fragmentFriends_to_fragmentShowOneCharacter, bundle);
            });
            recyclerView.setAdapter(adapter);

            searchByName.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (s != null) {
                        filter(s.toString());
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {}
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rootView;
    }
    @SuppressLint("NotifyDataSetChanged")
    private void filter(String text) {
        filteredDataSet.clear();

        for (DataModelCharacter character : dataSet) {
            if (character.getName() != null && character.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredDataSet.add(character);
            }
        }

        filteredDataSet.sort((o1, o2) -> {
            boolean startsWithO1 = o1.getName().toLowerCase().startsWith(text.toLowerCase());
            boolean startsWithO2 = o2.getName().toLowerCase().startsWith(text.toLowerCase());

            if (startsWithO1 && !startsWithO2) {
                return -1;
            } else if (!startsWithO1 && startsWithO2) {
                return 1;
            } else {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });


        adapter.notifyDataSetChanged();
    }

}