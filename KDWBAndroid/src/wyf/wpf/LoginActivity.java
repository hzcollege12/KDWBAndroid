//����1��
package wyf.wpf;//���������
import static wyf.wpf.ConstantUtil.*;	//��̬����ConstantUtil��ľ�̬��Ա
...//�˴�ʡ�Բ������������Ĵ���
import android.widget.Toase;	//���������
public class LoginActivity extends Acitity{
	MyConnector mc = null;		//����MyConnector��������
	ProgressDialog pd;		//����ProgressDialog��������
	@Override
	public void onCreate(Bundle savedInstanceState){	//��дonCreate����
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);		//���õ�ǰ��Ļ
		checkIfRemember();		//����Ƿ�������¼���ʺź�����
		Button btnLogin = (Button)findViewById(R.id.btnLogin);		//��õ�¼Button����
			btnLogin.setOnClickListener(new View.OnClickListener(){		//Ϊ����¼����ť��Ӽ�����
				public void onCreate(View v){		//��дonClick
					pd = ProgressDialog.show(LoginActivity.this,"���Ժ�","�������ӷ�����...",true,true);
					login();		//����login�������
				}
			});
	Button btnReg = (Button)findViewById(R.id.btnReg);		//���ע��Button����
		btnReg.setOnClickListener(new View.OnClickListener(){		//Ϊ��ע�ᡱ��ť��Ӽ�����
			public void onClick(View v){		//��дonClick
				Intent Intent =new Intent(LoginActivity.this, wyf.wpf.RegActivity.class);
				startActivity(Intent);		//��������ע���Activity
				finish();		//������Activity������
			}
		});
		ImageButton ibExit = (ImageButton)findViewById(R.id.ibExit);
		//����˳� ImageButton ����
		ibExit.setOnClickListener(new View.OnClickListener(){
			public void onCreate(View v){
				android.os.Process.killProcess(android.os.Process.MyPid());
				//�������̣��˳�����
			}
		});
	}
	public void login(){
		public void rememberMe(String uid,String pwd){//���������û���id���������Preferences
			}
		public void checkIfRemember(){				//��������Preferences�ж�ȡ�û���������
			protected void onDestroy(){
				if(mc!==null){						//�ж�MyConnector�Ƿ�Ϊnull
					mc.sayBye();					//����֪ͨ�������ͻ��˽���ͨ��
					mc=null;
				}
			}
			super.onDestroy();						//���ø����onDestroy
			}
		}		
	}
