package com.example.viewproject;

import java.util.HashMap;
import java.util.List;

import com.tutecentral.navigationdrawer.R;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class ExpandableListAdapter extends BaseExpandableListAdapter{

	private Context context;
	private List<String> listDataHeader;
	private HashMap<String, List<String>> listDataChild;
	
	public ExpandableListAdapter(Context myContext, List<String> myListDataHeader, HashMap<String,List<String>> myListChildData){
		setContext(myContext);
		setListDataHeader(myListDataHeader);
		setListDataChild(myListChildData);
	}
	
	@Override
	public Object getChild(int arg0, int arg1) {
		//arg0 is groupPosition and arg1 is childPosition
		return this.listDataChild.get(this.listDataHeader.get(arg0)).get(arg1);
	}

	@Override
	public long getChildId(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return arg1;
	}

	@Override
	public View getChildView(int arg0, int arg1, boolean arg2, View arg3,
			ViewGroup arg4) {
			
		//get text of child item
		final String childText = (String) getChild(arg0, arg1);
		
		if(arg3 == null){
			
			LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			arg3 = inflater.inflate(R.layout.list_item, null);
		}
		TextView txtListChild = (TextView) arg3.findViewById(R.id.item);
		txtListChild.setText(childText);
		return arg3;
	}

	@Override
	public int getChildrenCount(int arg0) {

		return listDataChild.get(listDataHeader.get(arg0)).size() ;
	}

	@Override
	public Object getGroup(int groupPosition) {
		return listDataHeader.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		return listDataHeader.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		String headerTitle = (String) getGroup(groupPosition);
		if(convertView == null){
			
			LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.list_group, null);
		}
		
		TextView listHeader = (TextView) convertView.findViewById(R.id.header);
		listHeader.setTypeface(null,Typeface.BOLD);
		listHeader.setText(headerTitle);
		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public List<String> getListDataHeader() {
		return listDataHeader;
	}

	public void setListDataHeader(List<String> listDataHeader) {
		this.listDataHeader = listDataHeader;
	}

	public HashMap<String, List<String>> getListDataChild() {
		return listDataChild;
	}

	public void setListDataChild(HashMap<String, List<String>> listDataChild) {
		this.listDataChild = listDataChild;
	}
	

}
