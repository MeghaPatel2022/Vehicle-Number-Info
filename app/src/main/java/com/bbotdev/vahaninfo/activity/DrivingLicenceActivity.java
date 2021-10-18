package com.bbotdev.vahaninfo.activity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;

import com.bbotdev.vahaninfo.R;
import com.bbotdev.vahaninfo.customclass.ConnectionDetector;
import com.bbotdev.vahaninfo.databinding.ActivityDrivingLicenceBinding;
import com.bbotdev.vahaninfo.objectdata.LicenceData;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import cz.msebera.android.httpclient.Header;

public class DrivingLicenceActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    ActivityDrivingLicenceBinding drivingLicenceBinding;
    MyClickHandlers myClickHandlers;

    Boolean isInternetPresent = false;
    ConnectionDetector connectionDetector;

    Calendar myCalendar;
    DatePickerDialog datePickerDialog;
    ProgressDialog pd;
    ArrayList<LicenceData> licenceDataArrayList;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drivingLicenceBinding = DataBindingUtil.setContentView(DrivingLicenceActivity.this,R.layout.activity_driving_licence);
        myClickHandlers = new MyClickHandlers(DrivingLicenceActivity.this);
        drivingLicenceBinding.setOnClick(myClickHandlers);
        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        initUi();
    }

    public void initUi() {

        connectionDetector = new ConnectionDetector(getApplicationContext());
        isInternetPresent = connectionDetector.isConnectingToInternet();

        drivingLicenceBinding.etBirthDate.setEnabled(true);
        drivingLicenceBinding.etBirthDate.setFocusable(false);
        drivingLicenceBinding.etBirthDate.setFocusableInTouchMode(false);

        Typeface face = ResourcesCompat.getFont(DrivingLicenceActivity.this, R.font.montserrat_medium);
        drivingLicenceBinding.etLicenceNo.setTypeface(face);
        drivingLicenceBinding.etBirthDate.setTypeface(face);

        drivingLicenceBinding.etLicenceNo.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        myCalendar = Calendar.getInstance();

        datePickerDialog = new DatePickerDialog(
                DrivingLicenceActivity.this, this, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH));

    }

    public class MyClickHandlers {
        Context context;

        public MyClickHandlers(Context context) {
            this.context = context;
        }

        public void onBirthDateClicked(View view) {
            if (datePickerDialog != null) {
                datePickerDialog.show();
            }
        }

        public void onSearchClick(View view) {
            String regex
                    = "^(([A-Z]{2}[0-9]{2})"
                    + "( )|([A-Z]{2}-[0-9]"
                    + "{2}))((19|20)[0-9]"
                    + "[0-9])[0-9]{7}$";
            if (drivingLicenceBinding.etLicenceNo.getText().toString().matches(regex)) {

                if (drivingLicenceBinding.etBirthDate.getText().length() != 0) {
                    if (isInternetPresent) {
                        getLicenceDetail(drivingLicenceBinding.etLicenceNo.getText().toString(), drivingLicenceBinding.etBirthDate.getText().toString());
                        GetChallanDetailActivity.hideKeyboardFrom(getApplicationContext(), drivingLicenceBinding.etLicenceNo);

                    } else {
                        Toast.makeText(getApplicationContext(), "Please connect to your mobile data!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Please Enter Valid Birth date.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Please Enter Valid Licence Number.", Toast.LENGTH_SHORT).show();

            }
        }

        public void onBackClick(View view) {
            onBackPressed();
        }
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
        myCalendar = Calendar.getInstance();
        myCalendar.set(Calendar.YEAR, year);
        myCalendar.set(Calendar.MONTH, monthOfYear);
        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        updateLabel();
    }

    private void updateLabel() {
        String myFormat = "dd-MM-YYYY"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        drivingLicenceBinding.etBirthDate.setText(sdf.format(myCalendar.getTime()));
    }

    @Override
    public void onBackPressed() {
        GetChallanDetailActivity.hideKeyboardFrom(getApplicationContext(), drivingLicenceBinding.etLicenceNo);
        super.onBackPressed();
    }

    public void getLicenceDetail(String licencenumber, String date) {

        RequestParams params = new RequestParams();
        AsyncHttpClient client = new AsyncHttpClient();
        client.setTimeout(60 * 1000);

        fireDetailAnalytics("SearchLicenceNumber", licencenumber);

        client.post("https://search-data.online/web_GetDrivingLicenceDetail.php?RTOLicenceNumber=" + licencenumber + "&RTOBirthDate=" + date, params, new getLicenceDetailResponseHandler());

    }

    private String getAge(int year, int month, int day) {
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(year, month, day);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        Integer ageInt = new Integer(age);
        String ageS = ageInt.toString();

        return ageS;
    }

    private void fireAnalytics(String arg1, String arg2) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "DrivingLicenceActivity");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, arg1);
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, arg2);
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }

    private void fireDetailAnalytics(String arg0, String arg1) {
        Bundle params = new Bundle();
        params.putString(arg0, arg1);
        mFirebaseAnalytics.logEvent("select_image", params);
    }

    public class getLicenceDetailResponseHandler extends AsyncHttpResponseHandler {

        @Override
        public void onStart() {
            // TODO Auto-generated method stub

            pd = ProgressDialog.show(DrivingLicenceActivity.this, "", "Please Wait...", true, false);
            pd.show();

            super.onStart();
        }

        @Override
        public void onFinish() {
            // TODO Auto-generated method stub
            pd.dismiss();
            super.onFinish();
        }

        @Override
        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
            pd.dismiss();

            fireAnalytics("searchLicenceDetails", "text");

            licenceDataArrayList = new ArrayList<>();
            String response = new String(responseBody);
            if (response.length() > 0) {
                try {
                    Log.e("licence", "" + response);
                    JSONObject jsonObject = new JSONObject(response);
                    LicenceData licenceData = new LicenceData();
                    licenceData.setKey("Licence No");
                    licenceData.setValue(drivingLicenceBinding.etLicenceNo.getText().toString());
                    licenceDataArrayList.add(licenceData);
                    licenceData = new LicenceData();
                    licenceData.setKey("Holder's Name");
                    licenceData.setValue(jsonObject.getString("HolderName"));
                    licenceDataArrayList.add(licenceData);
                    licenceData = new LicenceData();
                    licenceData.setKey("Holder's Age");
                    licenceData.setValue(getAge(myCalendar
                                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                            myCalendar.get(Calendar.DAY_OF_MONTH)));
                    licenceDataArrayList.add(licenceData);
                    licenceData = new LicenceData();
                    licenceData.setKey("Current Status");
                    licenceData.setValue(jsonObject.getString("CurrentStatus"));
                    licenceDataArrayList.add(licenceData);
                    licenceData = new LicenceData();
                    licenceData.setKey("Date Of Issue");
                    licenceData.setValue(jsonObject.getString("DateOfIssue"));
                    licenceDataArrayList.add(licenceData);
                    licenceData = new LicenceData();
                    licenceData.setKey("Valid From");
                    licenceData.setValue(jsonObject.getString("ValidationFromNonTransport"));
                    licenceDataArrayList.add(licenceData);
                    licenceData = new LicenceData();
                    licenceData.setKey("Valid Upto");
                    licenceData.setValue(jsonObject.getString("ValidationToNonTransport"));
                    licenceDataArrayList.add(licenceData);
                    licenceData = new LicenceData();
                    licenceData.setKey("Last Transacton At");
                    licenceData.setValue(jsonObject.getString("LastTransactionAtRTO"));
                    licenceDataArrayList.add(licenceData);
                    drivingLicenceBinding.etBirthDate.setText("");
                    drivingLicenceBinding.etLicenceNo.setText("");
                    Intent intent = new Intent(DrivingLicenceActivity.this, DrivingDetailActivity.class);
                    Bundle args = new Bundle();
                    args.putSerializable("array", licenceDataArrayList);
                    intent.putExtra("BUNDLE", args);
                    startActivity(intent);

                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), "Data not available, Please enter valid data or Please try later!!", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }


            } else {
                Toast.makeText(getApplicationContext(), "Data not available, Please enter valid data or Please try later!!", Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            pd.dismiss();
        }


    }

}
