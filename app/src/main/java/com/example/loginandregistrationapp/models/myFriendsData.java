package com.example.loginandregistrationapp.models;

import com.example.loginandregistrationapp.R;

public class myFriendsData {
    public static String[] nameArray = {"Rachel Green", "Joey Tribbiani", "Chandler Bing", "Ross Geller", "Monica Geller Bing", "Phoebe Buffay", "Mike Hannigan", "Janice Hosenstein", "Ben Geller", "Emma Geller Green"};
    public static String[] descriptionArray = {"Waitress", "Actor", "Accountant", "Paleontology", "Chef", "Masseuse", "Musician", "businesswoman", "Ross's son", "Ross and Rachel's daughter"};

    public static Integer[] drawableArray = {R.drawable.rachel, R.drawable.joey, R.drawable.chandler,
            R.drawable.ross, R.drawable.monica, R.drawable.phoebe, R.drawable.mike, R.drawable.jennice, R.drawable.ben, R.drawable.emma};

    public static Integer[] id_ = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    public static DataModelCharacter[] allCharacters = new DataModelCharacter[nameArray.length];

    static {
        for (int i = 0; i < nameArray.length; i++) {
            allCharacters[i] = new DataModelCharacter(
                    nameArray[i],
                    descriptionArray[i],
                    drawableArray[i],
                    id_[i]
            );
        }
    }
}