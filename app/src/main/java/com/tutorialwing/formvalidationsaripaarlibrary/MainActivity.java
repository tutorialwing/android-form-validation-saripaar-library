package com.tutorialwing.formvalidationsaripaarlibrary;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.annotation.Checked;
import com.mobsandgeeks.saripaar.annotation.ConfirmEmail;
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.Max;
import com.mobsandgeeks.saripaar.annotation.Min;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Or;
import com.mobsandgeeks.saripaar.annotation.Order;
import com.mobsandgeeks.saripaar.annotation.Password;
import com.mobsandgeeks.saripaar.annotation.Pattern;

public class MainActivity extends AppActivity {

	@NotEmpty(message = "Please enter Name")
	private EditText name;

	@Email
	private EditText email;

	@ConfirmEmail
	private EditText confirmEmail;

	@Password(min = 6, message = "Password must have at-least 6 characters")
	private EditText password;

	@ConfirmPassword
	private EditText confirmPassword;

	@Pattern(regex = "[789][0-9]{9}", message = "Please enter valid Phone number")
	private EditText phone;

	@Length(max = 12, min = 6, message = "Input must be between 6 and 12 characters")
	private EditText alphaNumeric;

	@Max(value = 10)
	private EditText etMaxValue;

	@Min(value = 2)
	private EditText etMinValue;

	@Min(value = 2)
	@Or
	@Max(value = 10)
	private EditText etValueRange;

	@Order(value = 1)
	@NotEmpty
	private EditText etFirstVerify;

	@Checked
	private CheckBox termsAndCondition;

	private Button submit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();
	}

	private void initView() {
		name = (EditText) findViewById(R.id.etName);
		email = (EditText) findViewById(R.id.etEmail);
		confirmEmail = (EditText) findViewById(R.id.etConfirmEmail);
		password = (EditText) findViewById(R.id.etPassword);
		confirmPassword = (EditText) findViewById(R.id.etConfirmPassword);
		phone = (EditText) findViewById(R.id.etPhone);
		alphaNumeric = (EditText) findViewById(R.id.etAlphaNum);
		termsAndCondition = (CheckBox) findViewById(R.id.termsAccept);
		etMaxValue = (EditText) findViewById(R.id.etMaxValue);
		etMinValue = (EditText) findViewById(R.id.etMinValue);
		etValueRange = (EditText) findViewById(R.id.etValueRange);
		etFirstVerify = (EditText) findViewById(R.id.etFirstVerify);

		submit = (Button) findViewById(R.id.submit);
		submit.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		super.onClick(v);

		if (validated) {
			// Our form is successfully validated, so, do your stuffs here...
			Toast.makeText(this, "Form Successfully Validated", Toast.LENGTH_LONG).show();
		}
	}
}
