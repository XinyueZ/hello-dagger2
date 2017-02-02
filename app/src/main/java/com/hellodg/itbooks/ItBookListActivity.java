package com.hellodg.itbooks;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.hellodg.R;
import com.hellodg.data.itbooks.ItBooks;
import com.hellodg.databinding.ItBooksActivityBinding;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public final class ItBookListActivity extends AppCompatActivity {
	@Inject Observable<ItBooks> mItBooksObservable;
	private ItBooksListAdapter mItBooksListAdapter;
	private ItBooksActivityBinding mBinding;
	private RetrofitComponent mRetrofitComponent;

	/**
	 * Show single instance of {@link ItBookListActivity}
	 *
	 * @param cxt {@link Activity}.
	 */
	public static void showInstance(@NonNull Activity cxt) {
		Intent intent = new Intent(cxt, ItBookListActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
		ActivityCompat.startActivity(cxt, intent, Bundle.EMPTY);
	}

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mBinding = DataBindingUtil.setContentView(this, R.layout.activity_itbooks_list);

		mBinding.itBooksRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

		mRetrofitComponent = DaggerRetrofitComponent.builder()
		                                            .retrofitModule(new RetrofitModule("http://it-ebooks-api.info/"))
		                                            .build();
		DaggerServiceComponent.builder()
		                      .serviceModule(new ServiceModule())
		                      .retrofitComponent(mRetrofitComponent)
		                      .build()
		                      .injectItBooksObservable(this);

		mItBooksObservable.subscribe(new Consumer<ItBooks>() {
			@Override
			public void accept(ItBooks itBooks) throws Exception {
				DaggerServiceComponent.builder()
				                      .serviceModule(new ServiceModule(itBooks))
				                      .retrofitComponent(mRetrofitComponent)
				                      .build()
				                      .injectItBooks((ItBooksListAdapter) mBinding.itBooksRv.getAdapter());
				mBinding.itBooksRv.getAdapter().notifyDataSetChanged();
			}
		});
		mBinding.itBooksRv.setAdapter(new ItBooksListAdapter());
	}
}
