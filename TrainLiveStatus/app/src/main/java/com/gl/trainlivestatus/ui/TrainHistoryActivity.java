package com.gl.trainlivestatus.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.gl.trainlivestatus.R;
import com.gl.trainlivestatus.dependencyInjection.AppModule;
import com.gl.trainlivestatus.model.TrainStatusHistory;
import com.gl.trainlivestatus.store.ITrainStatusStore;
import com.gl.trainlivestatus.util.BaseApplication;

import javax.inject.Inject;

import io.realm.RealmResults;

public class TrainHistoryActivity extends BaseActivity {
    @Inject
    ITrainStatusStore mStore;
    private TextView tvHistoryShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_train_history);
        newInjector().inject(this);
        tvHistoryShow = (TextView) findViewById(R.id.textViewHistoryShow);
        setText(mStore.getTrainHistory());


    }


    private void setText(RealmResults<TrainStatusHistory> listTrainHistory) {
        StringBuilder stringBuilder = new StringBuilder();
        if (listTrainHistory != null) {
            for (TrainStatusHistory trainStatusHistory : listTrainHistory) {
                stringBuilder.append(trainStatusHistory.getId());
                stringBuilder.append("\t");
                stringBuilder.append(trainStatusHistory.getTrainName());
                stringBuilder.append("\t");
                stringBuilder.append(trainStatusHistory.getTrainNo());
                stringBuilder.append("\n");
            }
            tvHistoryShow.setText(stringBuilder.toString());
        }

    }
}
