package com.example.customcellproject;

import com.example.viewproject.ViewProjectActivity;
import com.tutecentral.navigationdrawer.R;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.Touch;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class CustomList2 extends Fragment{
	ListView list;
	String[] values = new String[] { "Android1","Android2","Android3","Android4","Android5" };

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.activity_custom_list, container,
				false);
		return view;
	}
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		list = (ListView) getActivity().findViewById(R.id.list);
		final ListAdapter adapter = new ListAdapter(getActivity().getApplicationContext(), R.layout.list_row, R.id.artist, values);
		list.setAdapter(adapter);
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent i = new Intent(getActivity(),ViewProjectActivity.class);
				startActivity(i);
				
			}
		});
		
	}

}
