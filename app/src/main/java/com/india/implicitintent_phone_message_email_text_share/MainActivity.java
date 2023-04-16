package com.india.implicitintent_phone_message_email_text_share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // this code is use to open and set the mobile number on the dial pad

                Intent iDial = new Intent(Intent.ACTION_DIAL);      // use to open the dial pad on the device
                iDial.setData(Uri.parse("tel: +911234567890"));     // use to parse and set mobile number on the dial
                startActivity(iDial);

            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // this code is use to write the message on the given number

                Intent iMessage = new Intent(Intent.ACTION_SENDTO);     // use to open the dial pad on the device
                iMessage.setData(Uri.parse("smsto:"+Uri.encode("+910987654321")));      // use to set the details of the message
                iMessage.putExtra("sms_body","This is the dummy message from Gangesh Kumar");   // use to write the message
                startActivity(iMessage);

            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // This code is use to write the EMail

                Intent iEMail = new Intent(Intent.ACTION_SENDTO);   // use to open the EMail writer on the device
                iEMail.setType("message/rfc822");   // to set the type
                iEMail.putExtra(Intent.EXTRA_EMAIL,new String[] {"dummyEmail123@gmail.com"});  // to set the Email Addresses
                iEMail.putExtra(Intent.EXTRA_SUBJECT,"Queries");    // to set the Subject of the EMail
                iEMail.putExtra(Intent.EXTRA_TEXT,"Please resolve the query ASAP.");     // to set the Body of the EMail
                startActivity(Intent.createChooser(iEMail,"Email Using"));  // to open all the EMail sharable mediums in the device

            }
        });

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // This code is use to send the text/link

                Intent iLink = new Intent(Intent.ACTION_SEND);
                iLink.setType("text/plain");    // to set the type
                iLink.putExtra(Intent.EXTRA_TEXT,"https://localhost:12345:gangeshKumar123.com");    // to set the link text
                startActivity(Intent.createChooser(iLink,"Send Using"));    // to open all the sharable mediums in the device

            }
        });

    }
}