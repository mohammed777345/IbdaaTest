package com.example.ibdaatest.ui.home;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

import com.example.ibdaatest.LocaleHelper;
import com.example.ibdaatest.MyNewsApp.NewsActivity;
import com.example.ibdaatest.R;
import com.example.ibdaatest.Recyclerfromlocal.Recyclerlist;
import com.example.ibdaatest.ui.Customview;
import com.example.ibdaatest.ui.SharedPrefActivity;
import com.google.android.material.snackbar.Snackbar;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private CardView btnShowToast,btnShowNotification, btnShowSnack , rvLocal, bntChangeLanguage,btnCustomView,btnShowSharedPref,brnShowDB;
    TextView messageView;
    Button btnGujarati, btnEnglish;
    Context context;
    Resources resources;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        /*final TextView textView = root.findViewById(R.id.text_home);*/

        btnShowToast = root.findViewById(R.id.btnShowToast);
        btnShowNotification = root.findViewById(R.id.btnshowNotification);
        btnShowSnack = root.findViewById(R.id.btnShowSnack);

        rvLocal = root.findViewById(R.id.btnRecyclerTask);
        bntChangeLanguage = root.findViewById(R.id.bntChangeLanguage);
        btnCustomView = root.findViewById(R.id.btnCustomView);
        btnShowSharedPref = root.findViewById(R.id.btnShowSharedPref);

        brnShowDB = root.findViewById(R.id.btnshowDB);

        btnCustomView.setOnClickListener(view -> {
            try {
                Intent g = new Intent(getContext(), Customview.class);
                startActivity(g);
            } catch(Exception e) {
                e.printStackTrace();
            }
        });

        btnShowToast.setOnClickListener(view -> {
            Toast.makeText(getActivity(), " Toast message!",
                    Toast.LENGTH_LONG).show();
        });

        rvLocal.setOnClickListener(view -> {
            try {
                Intent k = new Intent(getContext(), Recyclerlist.class);
                startActivity(k);
            } catch(Exception e) {
                e.printStackTrace();
            }
        });


        btnShowNotification.setOnClickListener(view -> {
            addNotification();
        });

        btnShowSnack.setOnClickListener(view -> {

            Snackbar.make(getActivity().findViewById(android.R.id.content),
                    "text to show", Snackbar.LENGTH_LONG).show();



        });

        bntChangeLanguage.setOnClickListener(view -> {
            context = LocaleHelper.setLocale(getContext(), "en");
            resources = context.getResources();
            /*    messageView.setText(resources.getString(R.string.language));*/



        });

        btnShowSharedPref.setOnClickListener(view -> {
            try {
                Intent k = new Intent(getContext(), SharedPrefActivity.class);
                startActivity(k);
            } catch(Exception e) {
                e.printStackTrace();
            }
        });


        brnShowDB.setOnClickListener(view -> {
            try {
                Intent g = new Intent(getContext(), NewsActivity.class);
                startActivity(g);
            } catch(Exception e) {
                e.printStackTrace();
            }
        });






        return root;
    }

    private void addNotification() {

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(getContext())
                        .setSmallIcon(R.drawable.button_wh)
                        .setContentTitle("Notifications Example")
                        .setContentText("This is a test notification");

        Intent notificationIntent = new Intent(getContext(), HomeFragment.class);
        PendingIntent contentIntent = PendingIntent.getActivity(getContext(), 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getContext().getSystemService(getContext().NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());

    }
}