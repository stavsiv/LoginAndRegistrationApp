package com.example.loginandregistrationapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.loginandregistrationapp.R;
import com.example.loginandregistrationapp.models.DataModelCharacter;
import com.example.loginandregistrationapp.models.myFriendsData;

public class FragmentShowOneCharacter extends Fragment {
    private int characterId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_show_onecharacter, container, false);

        if (getArguments() != null) {
            characterId = getArguments().getInt("characterId");
        }

        ImageView characterImage = rootView.findViewById(R.id.characterImage);
        TextView characterName = rootView.findViewById(R.id.characterName);
        TextView characterDescription = rootView.findViewById(R.id.characterDescription);

        DataModelCharacter character = getCharacterById(characterId);
        if (character != null) {
            characterImage.setImageResource(character.getImage());
            characterName.setText(character.getName());
            characterDescription.setText(character.getDescription());
        }

        return rootView;
    }

    private DataModelCharacter getCharacterById(int characterId) {
        for (DataModelCharacter character : myFriendsData.allCharacters) {
            if (character.getId_() == characterId) {
                return character;
            }
        }
        return null;
    }
}
