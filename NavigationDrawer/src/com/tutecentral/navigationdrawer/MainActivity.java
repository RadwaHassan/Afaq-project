package com.tutecentral.navigationdrawer;

import java.util.ArrayList;
import java.util.List;

import com.example.customcellproject.CustomList;
import com.example.customcellproject.CustomList2;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	CustomDrawerAdapter adapter;

	List<DrawerItem> dataList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Initializing
		dataList = new ArrayList<DrawerItem>();
		mTitle = mDrawerTitle = getTitle();
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);

		// Add Drawer Item to dataList
		dataList.add(new DrawerItem(true)); // adding a spinner to the list

		dataList.add(new DrawerItem("Projects")); // adding a header to the list
		dataList.add(new DrawerItem("Created", R.drawable.ic_action_email));
		dataList.add(new DrawerItem("Recommended", R.drawable.ic_action_good));
		dataList.add(new DrawerItem("Participated", R.drawable.ic_action_gamepad));
		dataList.add(new DrawerItem("Followed ", R.drawable.ic_action_labels));

		dataList.add(new DrawerItem("Questions and answers"));// adding a header to the list
		dataList.add(new DrawerItem("Asked", R.drawable.ic_action_search));
		dataList.add(new DrawerItem("Answered", R.drawable.ic_action_cloud));
		dataList.add(new DrawerItem("Followed", R.drawable.ic_action_camera));
		

		dataList.add(new DrawerItem("Message")); // adding a header to the list
//		dataList.add(new DrawerItem("About", R.drawable.ic_action_about));
//		dataList.add(new DrawerItem("Settings", R.drawable.ic_action_settings));
//		dataList.add(new DrawerItem("Help", R.drawable.ic_action_help));

		adapter = new CustomDrawerAdapter(this, R.layout.custom_drawer_item,
				dataList);

		mDrawerList.setAdapter(adapter);

		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				invalidateOptionsMenu(); // creates call to
											// onPrepareOptionsMenu()
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				invalidateOptionsMenu(); // creates call to
											// onPrepareOptionsMenu()
			}
		};

		mDrawerLayout.setDrawerListener(mDrawerToggle);

		if (savedInstanceState == null) {

			if (dataList.get(0).isSpinner()
					& dataList.get(1).getTitle() != null) {
				//SelectItem(2);
			} else if (dataList.get(0).getTitle() != null) {
				SelectItem(1);
			} else {
				SelectItem(0);
			}
		}

	}//onCreate Method

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_actionbar, menu);
        // Add SearchWidget.
        SearchManager searchManager = (SearchManager) getSystemService( Context.SEARCH_SERVICE );
        SearchView searchView = (SearchView) menu.findItem( R.id.search_icon_id ).getActionView();

        searchView.setSearchableInfo( searchManager.getSearchableInfo( getComponentName() ) );

        return super.onCreateOptionsMenu( menu );
	}//onCreateOptionsMenu Method
	


	public void SelectItem(int possition) {

		Fragment fragment = null;
		Bundle args = new Bundle();
		switch (possition) {

		case 2:
//			Intent i  = new Intent(MainActivity.this,CustomList.class);
//			startActivity(i);
			fragment = new CustomList2();
			
			break;
		case 3:
//			Intent i1  = new Intent(MainActivity.this,CustomList.class);;
//			startActivity(i1);
//			fragment = new FragmentOne();
//			args.putString(FragmentOne.ITEM_NAME, dataList.get(possition)
//					.getItemName());
//			args.putInt(FragmentOne.IMAGE_RESOURCE_ID, dataList.get(possition)
//					.getImgResID());
			fragment = new CustomList2();
			break;
		case 4:
//			fragment = new FragmentTwo();
//			args.putString(FragmentTwo.ITEM_NAME, dataList.get(possition)
//					.getItemName());
//			args.putInt(FragmentTwo.IMAGE_RESOURCE_ID, dataList.get(possition)
//					.getImgResID());
//			Intent i2  = new Intent(MainActivity.this,CustomList.class);;
//			startActivity(i2);
			fragment = new CustomList2();
			break;
		case 5:
			Intent i3  = new Intent(MainActivity.this,CustomList.class);;
			startActivity(i3);
			break;
		case 7:
			fragment = new FragmentTwo();
			args.putString(FragmentTwo.ITEM_NAME, dataList.get(possition)
					.getItemName());
			args.putInt(FragmentTwo.IMAGE_RESOURCE_ID, dataList.get(possition)
					.getImgResID());
			break;
		case 8:
			fragment = new FragmentThree();
			args.putString(FragmentThree.ITEM_NAME, dataList.get(possition)
					.getItemName());
			args.putInt(FragmentThree.IMAGE_RESOURCE_ID, dataList
					.get(possition).getImgResID());
			break;
		case 9:
			fragment = new FragmentOne();
			args.putString(FragmentOne.ITEM_NAME, dataList.get(possition)
					.getItemName());
			args.putInt(FragmentOne.IMAGE_RESOURCE_ID, dataList.get(possition)
					.getImgResID());
			break;
		case 10:
			fragment = new FragmentTwo();
			args.putString(FragmentTwo.ITEM_NAME, dataList.get(possition)
					.getItemName());
			args.putInt(FragmentTwo.IMAGE_RESOURCE_ID, dataList.get(possition)
					.getImgResID());
			break;
		case 11:
			fragment = new FragmentThree();
			args.putString(FragmentThree.ITEM_NAME, dataList.get(possition)
					.getItemName());
			args.putInt(FragmentThree.IMAGE_RESOURCE_ID, dataList
					.get(possition).getImgResID());
			break;
		case 12:
			fragment = new FragmentOne();
			args.putString(FragmentOne.ITEM_NAME, dataList.get(possition)
					.getItemName());
			args.putInt(FragmentOne.IMAGE_RESOURCE_ID, dataList.get(possition)
					.getImgResID());
			break;
		case 14:
			fragment = new FragmentThree();
			args.putString(FragmentThree.ITEM_NAME, dataList.get(possition)
					.getItemName());
			args.putInt(FragmentThree.IMAGE_RESOURCE_ID, dataList.get(possition)
					.getImgResID());
			break;	
		case 15:
			fragment = new FragmentOne();
			args.putString(FragmentOne.ITEM_NAME, dataList.get(possition)
					.getItemName());
			args.putInt(FragmentOne.IMAGE_RESOURCE_ID, dataList.get(possition)
					.getImgResID());
			break;
		case 16:
			fragment = new FragmentTwo();
			args.putString(FragmentTwo.ITEM_NAME, dataList.get(possition)
					.getItemName());
			args.putInt(FragmentTwo.IMAGE_RESOURCE_ID, dataList.get(possition)
					.getImgResID());
			break;
		default:
			break;
		}

//		fragment.setArguments(args);
		FragmentManager frgManager = getFragmentManager();
		frgManager.beginTransaction().replace(R.id.content_frame, fragment)
				.commit();
		
		mDrawerList.setItemChecked(possition, true);
		setTitle(dataList.get(possition).getItemName());
		mDrawerLayout.closeDrawer(mDrawerList);
		
		
		Log.i("2rf", "2rf");

	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggles
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// The action bar home/up action should open or close the drawer.
		// ActionBarDrawerToggle will take care of this.
		int id = item.getItemId();
		if (id == R.id.notificationicon) {
			Toast.makeText(getApplicationContext(), "Notification Here", Toast.LENGTH_SHORT).show();
			return true;
		}else if(id == R.id.search_icon_id){
			Toast.makeText(getApplicationContext(), "Search Here", Toast.LENGTH_SHORT).show();
		return true;
		}else if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		return super.onOptionsItemSelected(item);

	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			if (dataList.get(position).getTitle() == null) {
				SelectItem(position);
			}

		}
	}

}
