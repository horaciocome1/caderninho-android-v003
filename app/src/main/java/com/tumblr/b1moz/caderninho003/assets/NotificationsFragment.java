package com.tumblr.b1moz.caderninho003.assets;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tumblr.b1moz.caderninho003.Helpers.Constants;
import com.tumblr.b1moz.caderninho003.R;
import com.tumblr.b1moz.caderninho003.adapters.MyNotificationRecyclerViewAdapter;
import com.tumblr.b1moz.caderninho003.domain.Notification;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationsFragment extends Fragment {

    @BindView(R.id.fragment_notifications_toolbar) Toolbar mToolbar;
    @BindView(R.id.fragment_notifications_recyclerview) RecyclerView mRecyclerView;

    private boolean IS_COSTUMER;

    public NotificationsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setIS_COSTUMER(getArguments().getInt(Constants.PASSING_USER_ACCOUNT_TYPE_KEY, -1));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        ButterKnife.bind(this, view);
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        setUpList(view.getContext());
        return view;
    }
    
    private void setIS_COSTUMER(int account_type) {
        if (account_type == Constants.USER_ACCOUNT_TYPE_COSTUMER)
            IS_COSTUMER = true;
        else if (account_type == Constants.USER_ACCOUNT_TYPE_CARRIER)
            IS_COSTUMER = false;
    }
    
    private void setUpList(Context context) {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        if (IS_COSTUMER)
            // Set the adapter for a costumer
        mRecyclerView.setAdapter(new MyNotificationRecyclerViewAdapter(getClientNotificationList(12)));
        else
            // Set the adapter for a carrier
            mRecyclerView.setAdapter(new MyNotificationRecyclerViewAdapter(getCarrierNotificationList(12)));
    }

    private List<Notification> getClientNotificationList(int size) {
        List<Notification> notifications = new ArrayList<>();
        Notification notification;

        for (int i = 0; i < size; i++) {
            notification = new Notification();
            notification.setTitle("Oferta");
            notification.setDescription("Mobi Madi oferece 15% de desconto para compras acima de 1000 MT ate 01/09/2018.");
            notification.setDate("12:58");
            notifications.add(notification);

            notification = new Notification();
            notification.setTitle("Alerta");
            notification.setDescription("O seu pedido ja se encontra na sua paragem.");
            notification.setDate("09:00");
            notifications.add(notification);

            notification = new Notification();
            notification.setTitle("Alerta");
            notification.setDescription("O seu pedido foi verificado por Mercearia Juka, e esta a ser processado.");
            notification.setDate("08:30");
            notifications.add(notification);

            notification = new Notification();
            notification.setTitle("Alerta");
            notification.setDescription("O seu pedido foi verificado por Mobi Madi, e esta a ser processado.");
            notification.setDate("08:30");
            notifications.add(notification);

            notification = new Notification();
            notification.setTitle("Oferta");
            notification.setDescription("Nike Shop oferece 50% de desconto na compra de uma BRS.");
            notification.setDate("18/08/2018");
            notifications.add(notification);

            notification = new Notification();
            notification.setTitle("Alerta");
            notification.setDescription("O seu pedido ja se encontra nas maos do transportador.");
            notification.setDate("17/08/2018");
            notifications.add(notification);
        }
        return notifications;
    }

    private List<Notification> getCarrierNotificationList(int size) {
        List<Notification> notifications = new ArrayList<>();
        Notification notification;

        for (int i = 0; i < size; i++) {
            notification = new Notification();
            notification.setTitle("Versalhes");
            notification.setDescription("O pacote Mobi Madi Lda. ja esta na paragem.");
            notification.setDate("12:58");
            notifications.add(notification);

            notification = new Notification();
            notification.setTitle("Baixa");
            notification.setDescription("O pacote Mega Fashion Shoes ja esta pronto.");
            notification.setDate("17/08/2018");
            notifications.add(notification);

            notification = new Notification();
            notification.setTitle("Versalhes");
            notification.setDescription("O pacote Mobi Madi Lda. ja esta pronto.");
            notification.setDate("09:00");
            notifications.add(notification);

            notification = new Notification();
            notification.setTitle("Macuacua");
            notification.setDescription("O cliente ja esta na paragem.");
            notification.setDate("08:30");
            notifications.add(notification);

            notification = new Notification();
            notification.setTitle("Primeira Entrada");
            notification.setDescription("O cliente ja esta na paragem");
            notification.setDate("08:30");
            notifications.add(notification);

            notification = new Notification();
            notification.setTitle("Malanga");
            notification.setDescription("O pacote Rite Price Lda. ja esta na paragem.");
            notification.setDate("18/08/2018");
            notifications.add(notification);
        }
        return notifications;
    }

}
