package com.example.customcellproject;


import com.tutecentral.navigationdrawer.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter extends ArrayAdapter{
	Context context;

	public ListAdapter(Context context, int resource, int textViewResourceId,
			Object[] objects) {
		super(context, R.layout.list_row, R.id.artist, objects);
		// TODO Auto-generated constructor stub
		this.context = context;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.list_row,parent,false);
		
		return view;
		
		
	}

}
