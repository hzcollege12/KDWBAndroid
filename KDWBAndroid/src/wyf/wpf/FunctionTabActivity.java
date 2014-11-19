//24苏宝招
package wyf.wpf;
 import android.AlertDialong;
 ...//此处省略部分引入相关类的代码
 import android.widger.TabHost;
 	public class FunctionTabActivity cxtends TabActivity{
 	static final int MENU_SEARCH =0;
	static final int MENU_SEARCH =1;
	String uno =null;
	protected void onCreate(Bundlle savedInstanceState){
		super.onCreate(savedInstanceState);
		Intent intent =getIntent();
		uno =intent.getStringExtea("uno");
		final TabHost tabHost =getTabHost();
		intent intentPublish =new Intent(this,wyf.PublishActivity.class);
		intentPublish.putExtra("uno",uno);
		Intent intent1 =new Intent(this,wyf.PublishActivity.class);
		intent1 putExtra("type",0);intent1.putExtra("uno",uno);
		intent intent2 =new Intent(this,wyf.PublishActivity.class);
		intent2.putExtra("type",1);intent2.putExtra("uno",uno);
		Intent iDiary =new Intent(this,wyf.MyDiaryActivity.class);
		iDiary.putExtra("uno",uno);
		Intent	iAIbum =new Intent(this,wyf.MyAlbumListActivity.class);
		iAlbum.putExtra("uno",uno);
		tabHost.addTab(tabHost.newTabSpec("tab1")
			.setIndicator("快速发布"，getResources().getDrawable(R.drawable.publish))
			.setContent(intentPublish));
		tabHost.addTab(tabHost.newTabSpec("tab2")"
			.setIndicator("我的好友"，getResources().getDrawable(R.drawable.friend))
			.setContent(intent1));
		tabHost.addTab(tabHost.newTabSpec("tab3")
			.setIndicator("最近访客"，getResources().getDrawable(R.drawable.visitor))
			.setContent(intent2));
		tabHost.addTab(tabHost.newTabSpec("tab4")
			.setIndicator("日志列表"，getResources().getDrawable(R.drawable.diary))
			.setContent(iDiary));
		tabHost.addTab(tabHost.newTabSpec("tab5")
			.setIndicator("相册列表"，getResources().getDrawable(R.drawable.album))
			.setContent(iAlbu));
		String tab =intent.getStirngExtra（tab）；
		if（tab！=null）{tabHost.setCurrenTabByTag（tab）
	}
		public boolean onCrateOptionsMenu（Menu menu）{
		public boolean onOptionItemSelected（MenuItem item）{
	}
