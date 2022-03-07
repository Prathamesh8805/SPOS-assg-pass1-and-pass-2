import java.io.*;
import java.util.*;
class pass2
{
public static void main(String args[])throws Exception
{

int n=0;
int q=0;

FileReader f1=new FileReader("intermediate.txt");
BufferedReader b1=new BufferedReader(f1);

FileReader f2=new FileReader("symtab.txt");
BufferedReader b2=new BufferedReader(f2);

FileReader f3=new FileReader("littab1.txt");
BufferedReader b3=new BufferedReader(f3);

FileWriter f4=new FileWriter("output.txt");
BufferedWriter  b4=new BufferedWriter(f4);


String s,s3,s4;
String s1[]=new String[10];
String s2[]=new String[12];
String s5[]=new String[12];
 while((s3=b3.readLine())!=null)
{
	      StringTokenizer st2=new StringTokenizer(s3);
	      while(st2.hasMoreTokens())
 	    {
	      s2[n]=st2.nextToken();
	      n++;
	    }
 }

while((s4=b2.readLine())!=null)
 {
		StringTokenizer st3=new StringTokenizer(s4);
	        while(st3.hasMoreTokens())
 	       {
	          s5[q]=st3.nextToken();
	          q++;
	       }
}
while((s=b1.readLine())!=null)
{
	int m=0;
	
	StringTokenizer st=new StringTokenizer(s);
     
	while(st.hasMoreTokens())
	{
	s1[m]=st.nextToken();
	m++;
	}
     
	if(s1[1].equals("AD") && s1[2].equals("01"))
	{ 
        b4.newLine();
        break;
        }
	
	else if(s1[1].equals("IS"))
	{ 
          b4.write(s1[0]+" "+s1[2]+" "+s1[3]);

		if(s1[4].equals("L"))
	        {
                   for(int i=0;i<n;i++)
	          { 
	              if(s2[i].equals(s1[5]))
		     {
	              b4.write(" "+s2[i+2]);
                      b4.newLine();		
                     }
		 
                  }
               }
	
		if(s1[4].equals("S"))
	        {
                   for(int i=0;i<q;i++)
	       
	           {              
			if(s5[i].equals(s1[5]))
		     {
	              b4.write(" "+s5[i+2]);
                      b4.newLine();		
                     }
		 
                  }
               }
	  }		
      else if(s1[1].equals("DL"))
	{   
	    if(s1[2].equals("01"))
        {
           b4.write(s1[0]+" -  -   "+s1[4]);
           b4.newLine();
        } 	     	    
	}
      else if(s1[1].equals("AD") && s1[2].equals("02"))
	{   
	     b4.write(s1[0]+" -  -  "+"0"+s1[4]);
            b4.newLine();
	}
}
b4.close();
}
}
