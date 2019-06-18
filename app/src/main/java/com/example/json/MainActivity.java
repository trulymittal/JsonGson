package com.example.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.security.auth.login.LoginException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /* Java objects to JSON */
    public void todoToJson(View view) {
        Log.i(TAG, "todoToJson: " + MyApi.MY_CHANNEL_NAME);
//        Gson gson = new Gson();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Todo todo = new Todo(18, 267, "this is some body", true);
        String jsonTodoString = gson.toJson(todo);
        Log.i(TAG, "todoToJson: " + jsonTodoString);
    }

    public void todoListToJsonArray(View view) {
        Log.i(TAG, "todoListToJsonArray: ");
        List<Todo> todoList = new ArrayList<>();
        Todo todo1 = new Todo(1, 2, "123", false);
        Todo todo2 = new Todo(2, 22, "123", true);
        Todo todo3 = new Todo(3, 222, "123", true);
        todoList.add(todo1);
        todoList.add(todo2);
        todoList.add(todo3);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonArrayString = gson.toJson(todoList);
        Log.i(TAG, "todoListToJsonArray: " + jsonArrayString);
    }

    public void userToJson(View view) {
        Log.i(TAG, "userToJson: ");

        Geo geo = new Geo(23.234, 23.45646);
        Address address = new Address("Street 123", "Mumbai", geo);
        User user = new User(267, "Truly Mittal", "yourstruly267@gmail.com", address);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String userJsonString = gson.toJson(user);
        Log.i(TAG, "userToJson: " + userJsonString);

    }



    /* Json objects(arrays) to Java Objects */

    public void todoJsonToTodoObject(View view) {
        Log.i(TAG, "todoJsonToTodoObject: ");
        Gson gson = new Gson();
        Todo todo = gson.fromJson(MyApi.TODO_JSON_STRING, Todo.class);
        Log.i(TAG, "todoJsonToTodoObject: " + todo.toString());
        Log.i(TAG, "todoJsonToTodoObject: " + todo.getBody());
    }

    public void todoJsonArrayToTodoArray(View view) {
        Log.i(TAG, "todoJsonArrayToTodoArray: ");
        Gson gson = new Gson();
        Todo[] todos = gson.fromJson(MyApi.TODO_JSON_ARRAY_STRING, Todo[].class);
        Log.i(TAG, "todoJsonArrayToTodoArray: "+ Arrays.toString(todos));
    }

    public void todoJsonArrayToTodoList(View view) {
        Log.i(TAG, "todoJsonArrayToTodoList: ");
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Todo>>(){}.getType();
//        List<Todo> todoList = gson.fromJson(MyApi.TODO_JSON_ARRAY_STRING, List<Todo>.class);
        List<Todo> todoList = gson.fromJson(MyApi.TODO_JSON_ARRAY_STRING, listType);
        Todo todo = todoList.get(0);
        Log.i(TAG, "todoJsonArrayToTodoList: " + todo.toString());
    }

    public void userJsonToUserObject(View view) {
        Log.i(TAG, "userJsonToUserObject: ");

        Gson gson = new Gson();
        User user = gson.fromJson(MyApi.USER_JSON_STRING, User.class);
        Log.i(TAG, "userJsonToUserObject: City" + user.getAddress().getCity());
        Log.i(TAG, "userJsonToUserObject: Lat " + user.getAddress().getGeo().getLat());
    }


}
