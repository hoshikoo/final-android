package nyc.c4q.android.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import nyc.c4q.android.R;

public class LoginActivity extends Activity {

  private EditText emailField;
  private EditText passwordField;
  private Button loginButton;
  private final AuthenticationManager manager;

  public LoginActivity() {
    // TODO - fix this
    manager = new AuthenticationManager() {
      @Override
      public boolean validateLogin(String email, String password) {

        return false;
      }
    };
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // TODO - load view hierarchy in R.layout.activity_login
    setContentView(R.layout.activity_login);

    // TODO - get references to views, and other setup
    TextView title = (TextView)findViewById(R.id.title_c4q);
    ImageView logo = (ImageView)findViewById(R.id.logo);
    final EditText emailInputText = (EditText)findViewById(R.id.email);
    final EditText password = (EditText)findViewById(R.id.password);
    Button loginBtn = (Button)findViewById(R.id.login);


    // TODO - call checkCredentials via OnClickListener
    loginBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        checkCredentials(String.valueOf(emailInputText.getText()), String.valueOf(password.getText()));
      }
    });
  }

  private void checkCredentials(String email, String password) {
    if(manager.validateLogin(email, password)) {
      // TODO - go to EmailListActivity
      Intent myIntent = new Intent(LoginActivity.this, EmailListActivity.class);
    }
    else {
      // TODO launch alert dialog on failed login
      // check strings.xml for dialog

      new AlertDialog.Builder(this)
              .setTitle(getResources().getText(R.string.alert_dialog_title))
              .setMessage("Please try again")
              .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                  dialog.dismiss();
                }
              })
              .show();
    }
  }
}
