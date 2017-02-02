package com.hellodg.society;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hellodg.itbooks.ItBookListActivity;
import com.hellodg.R;
import com.hellodg.data.society.Company;
import com.hellodg.data.society.SoftwareDeveloperGroup;
import com.hellodg.databinding.ActivityMainBinding;

import javax.inject.Inject;

public class SocietyActivity extends AppCompatActivity {
	@Inject Company mCompany;
	private ActivityMainBinding mBinding;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

		//Init the Company by injection implicitly .
		DaggerCompanyComponent.builder()
		                      .build()
		                      .buildCompany(this);
		mBinding.companyOutputTv.setText("Company: \n\n" + mCompany.toString() + ", Boss: " + mCompany.getBoss() + ", Super-user:" + mCompany.getSuperUser());

		//Init the SoftwareDeveloperGroup by injection explicitly.
		SoftwareDeveloperGroup softwareDeveloperGroup = DaggerSoftwareDeveloperGroupComponent.builder()
		                                                                                     .build()
		                                                                                     .buildSoftwareDeveloperGroup();
		mBinding.softwareDeveloperGroupOutputTv.setText("Software developer group: \n\n" + softwareDeveloperGroup.toString() + ", Boss: " + softwareDeveloperGroup.getBoss() + ", Super-user:" + softwareDeveloperGroup
				.getSuperUser() + ", " + "Internal-user:" + softwareDeveloperGroup.getInternalUser() + ", External-user:" + softwareDeveloperGroup.getExternalUser());
	}

	public void onNetSample(View view) {
		ItBookListActivity.showInstance(this);
	}

	public void onMvp(View view) {
	}
}
