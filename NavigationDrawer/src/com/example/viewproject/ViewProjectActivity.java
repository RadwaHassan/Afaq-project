package com.example.viewproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.tutecentral.navigationdrawer.R;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;

public class ViewProjectActivity extends Activity {

	ExpandableListAdapter listAdapter;
	ExpandableListView expListView;
	List<String> listDataHeader;
	HashMap<String,List<String>> listDataChild;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_project);
		
		expListView = (ExpandableListView) findViewById(R.id.expandableListViewStep);
		
		prepareListData();
		
		listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
		
		expListView.setAdapter(listAdapter);
		
		expListView.setOnChildClickListener(new OnChildClickListener() {
			
			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				Intent i = new Intent(ViewProjectActivity.this,SearchResultActivity.class);
				startActivity(i);
				return false;
			}
		});
		
		ImageButton btnLike = (ImageButton) findViewById(R.id.imageBtnUp);
		ImageButton btnUnlike = (ImageButton) findViewById(R.id.imageBtnDown);
		
		//like button action
		btnLike.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "Project Liked", Toast.LENGTH_SHORT).show();
			}
		});
		
		//unlike button action
		btnUnlike.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "Project unliked", Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_actionbar, menu);
        // Add SearchWidget.
        SearchManager searchManager = (SearchManager) getSystemService( Context.SEARCH_SERVICE );
        SearchView searchView = (SearchView) menu.findItem( R.id.search_icon_id ).getActionView();

        searchView.setSearchableInfo( searchManager.getSearchableInfo( getComponentName() ) );

        return super.onCreateOptionsMenu( menu );
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.notificationicon) {
			Toast.makeText(getApplicationContext(), "Notification Here", Toast.LENGTH_SHORT).show();
			return true;
		}else if(id == R.id.search_icon_id){
			Toast.makeText(getApplicationContext(), "Search Here", Toast.LENGTH_SHORT).show();
		
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void prepareListData() {
		listDataHeader = new ArrayList<String>();
		listDataChild = new HashMap<String, List<String>>();
		// Adding child data
		listDataHeader.add("Step(1): Buy Material");
		listDataHeader.add("Step(2): Get Equipement");
		listDataHeader.add("Step(3): Get a designer");
		
		// Adding child data
		List<String> top250 = new ArrayList<String>();
		top250.add("Step 1 part a");
		top250.add("Step 1 part b");
		top250.add("Step 1 part c");
		
		List<String> nowShowing = new ArrayList<String>();
		nowShowing.add("Step 2 part a");
		nowShowing.add("Step 2 part b");
		
		List<String> comingSoon = new ArrayList<String>();
		comingSoon.add("Step 3 part a");
		comingSoon.add("Step 3 part b");
		comingSoon.add("Step 3 part b");
		comingSoon.add("Step 3 part b");
		comingSoon.add("Step 3 part b");
		comingSoon.add("Step 3 part b");
		comingSoon.add("Step 3 part b");
		comingSoon.add("Step 3 part b");
		comingSoon.add("Step 3 part b");
		comingSoon.add("Step 3 part b");
		comingSoon.add("Step 3 part b");
		comingSoon.add("Step 3 part b");
		comingSoon.add("Step 3 part b");
		comingSoon.add("Step 3 part b");
		comingSoon.add("Step 3 part b");
		comingSoon.add("Step 3 part b");
		comingSoon.add("Step 3 part b");
		
		

		listDataChild.put(listDataHeader.get(0), top250); 
		listDataChild.put(listDataHeader.get(1), nowShowing);
		listDataChild.put(listDataHeader.get(2), comingSoon);
	}
}
