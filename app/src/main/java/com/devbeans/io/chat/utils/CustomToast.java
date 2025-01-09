package com.devbeans.io.chat.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.devbeans.io.chat.R;

//************************************************************
public class CustomToast extends Toast
//************************************************************
{
    private Context context;
    private String message;

    //************************************************************
    public CustomToast(Context context, String message, boolean isLong)
    //************************************************************
    {
        super(context);
        this.context = context;
        this.message = message;
        View view = LayoutInflater.from(context).inflate(R.layout.custom_toast, null);
        TextView txtMsg = view.findViewById(R.id.txt_message);
        txtMsg.setText(message);
        setView(view);
        setGravity(Gravity.BOTTOM| Gravity.CENTER_HORIZONTAL,0,180);
        setDuration(isLong ? Toast.LENGTH_LONG : LENGTH_SHORT);
    }
}
