package com.hellodg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.hellodg.data.Company;
import com.hellodg.data.SoftwareDeveloperGroup;
import com.hellodg.socity.DaggerCompanyComponent;
import com.hellodg.socity.DaggerSoftwareDeveloperGroupComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
	@Inject Company mCompany;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		//Init the Company by injection implicitly .
		DaggerCompanyComponent.builder()
		                      .build()
		                      .buildCompany(this);
		TextView companyTv = (TextView) findViewById(R.id.company_output_tv);
		companyTv.setText("Company: \n\n" + mCompany.toString() + ", Boss: " + mCompany.getBoss() + ", Super-user:" + mCompany.getSuperUser());


		//Init the SoftwareDeveloperGroup by injection explicitly.
		SoftwareDeveloperGroup softwareDeveloperGroup = DaggerSoftwareDeveloperGroupComponent.builder()
		                                                                                     .build()
		                                                                                     .buildSoftwareDeveloperGroup();
		TextView softwareTv = (TextView) findViewById(R.id.software_developer_group_output_tv);
		softwareTv.setText("Software developer group: \n\n" + softwareDeveloperGroup.toString() + ", Boss: " + softwareDeveloperGroup.getBoss() + ", Super-user:" + softwareDeveloperGroup.getSuperUser() + ", " +
				                   "Internal-user:" + softwareDeveloperGroup.getInternalUser() + ", External-user:" + softwareDeveloperGroup.getExternalUser());
	}
}
