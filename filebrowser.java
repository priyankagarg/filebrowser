package com.example.random;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ListActivity {
 private List<String> item = null;
 private List<String> path = null;
 private String root="/";
 private TextView myPath;
 File f = new File(root);
 File[] files = f.listFiles();
 Button n;
 Button s;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myPath = (TextView)findViewById(R.id.path);
        n=(Button)findViewById(R.id.name);
        s=(Button)findViewById(R.id.size);
        n.setOnClickListener(sortn);
        s.setOnClickListener(sorts);
        getDir(root);
    }
    private void getDir(String dirPath)
    {
     myPath.setText("Location: " + dirPath);
     item = new ArrayList<String>();
     path = new ArrayList<String>();
    
     if(!dirPath.equals(root))
     {
      item.add(root);
      path.add(root);
      item.add("../");
      path.add(f.getParent());
     }
     
     for(int i=0; i < files.length; i++)
     {
       File file = files[i];
       path.add(file.getPath());
       if(file.isDirectory())
        item.add(file.getName() + "/");
       else
        item.add(file.getName());
     }

     ArrayAdapter<String> fileList =
      new ArrayAdapter<String>(this, R.layout.row, item);
     setListAdapter(fileList);
    }
    
    View.OnClickListener sortn= new View.OnClickListener()
    {
    	
		@Override
		public void onClick(View v) {
			int i,j;
			for(i=0;i<files.length;i++)
    		{
    			for(j=i;j<files.length;j++)
    			{
    				if(strcmp(files[j],files[j+1])>0)
    				{
    					file temp=files[j];
    					files[j]=files[j+1];
    					files[j+1]=temp;
    					
    				}
    			}
    		}
		}

		private int strcmp(File file, File file2) {
			// TODO Auto-generated method stub
			return 0;
		}
    };
    View.OnClickListener sorts= new View.OnClickListener()
    {
		
		@Override
		public void onClick(View v) 
		{
		int i,j;
		for(i=0;i<files.length;i++)
		{
			for(j=0;j<files.length;j++)
			{
				if(files[j].s()>files[j+1].s())
				{
					file temp=files[j];
					files[j]=files[j+1];
					files[j+1]=temp;
				}
			}
		}
		
			
		}
	};
	
}