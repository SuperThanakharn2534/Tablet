package com.alignsolution.siamsmilemobileapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.alignsolution.siamsmilemobileapplication.Biz.Users;
import com.alignsolution.siamsmilemobileapplication.Biz.UsersMGR;

/**
 * Created by aligndev on 4/3/2017.
 */
public class LoginActivity extends AppCompatActivity{
    EditText Username, Password ;
    TextView Message;
    Button  btFogetP , btLogIn;
    UserLoginTask userLoginTask = null;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
      try {

          SetHeader("SiamSmile  Mobile Application", false, false);
          SetButton();
          SetDataBase();



      }catch (Exception e){}




    }
    public void  SetDataBase(){
          // Database
          DataBase database = new DataBase(this);
          database.getWritableDatabase();

          Log.i("creatData"," Pcreate01_Login");
          Username = (EditText) findViewById(R.id.txtUsername);
          Password = (EditText) findViewById(R.id.txtPassword);
          Message = (TextView) findViewById(R.id.txtmessage);

      }

    public  void  SetButton(){

       btFogetP = (Button) findViewById(R.id.btForgetP);
       btFogetP.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent it1 = new Intent(getBaseContext(),ForgetPasswordActivity.class);
               startActivity(it1);
           }
       });


       btLogIn = (Button) findViewById(R.id.btLogIn);
       btLogIn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               attemptLogin();


           }
       });

   }

    public void attemptLogin() {


        // Reset errors.
            Username.setError(null);
            Password.setError(null);

        // Store values at the time of the login attempt.
      String  mUser = Username.getText().toString();
      String  mPassword = Password.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password.
//        if (TextUtils.isEmpty(mPassword)) {
//            Password.setError(getString(R.string.error_field_required));
//            focusView = Password;
//            cancel = true;
//        } else if (mPassword.length() < 3) {
//            Password.setError(getString(R.string.error_invalid_password));
//            focusView = Password;
//            cancel = true;
//        }
//
//        // Check for a valid email address.
//        if (TextUtils.isEmpty(mUser)) {
//            Username.setError(getString(R.string.error_field_required));
//            focusView = Username;
//            cancel = true;
//        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
           // Message.setText(R.string.login_progress_signing_in);
//            Intent it2 = new Intent(getBaseContext(),DasboardActivity.class);
//            startActivity(it2);
//            Username.setText("");
//            Password.setText("");

             userLoginTask = new UserLoginTask();
             userLoginTask.execute((Void) null);

        }
    }

    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {
        @Override
        protected Boolean doInBackground(Void... params) {

//            UsersMGR usersMGR = new UsersMGR();
//            Users  users = new Users();
//            users =  usersMGR.SelectDataLogin(Username.getText().toString() ,Password.getText().toString() ,getBaseContext());
//
//
//            if(users != null){
//                Log.i("Log",users.getUserLogin());
//            }

            Intent it2 = new Intent(getBaseContext(),DasboardActivity.class);
            startActivity(it2);
            return  null;//userInfo.getRoles() != null;
        }

        @Override
        protected void onPostExecute(final Boolean success) {

        }

        @Override
        protected void onCancelled() {

        }
    }

    public void SetHeader(String TextTitle, boolean ShowAddButton, boolean ShowNotify) {

        getSupportActionBar().setDisplayOptions(getSupportActionBar().getDisplayOptions()
                | ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.activity_header);

        TextView Title = (TextView) getSupportActionBar().getCustomView().findViewById(R.id.txtTitle);
        Title.setText(TextTitle);

        if (!ShowAddButton) {
            ImageButton btnAdd = (ImageButton) getSupportActionBar().getCustomView().findViewById(R.id.btnAdd);
            btnAdd.setVisibility(View.GONE);
        }

        if (!ShowNotify) {

            ImageView imgNotify = (ImageView) getSupportActionBar().getCustomView().findViewById(R.id.imgnotify);
            imgNotify.setVisibility(View.GONE);
        }


    }


}
