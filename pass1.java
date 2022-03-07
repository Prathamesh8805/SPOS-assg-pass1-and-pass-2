import java.io.*;
import java.util.*;
class pass1
{
public static void main(String args[])throws Exception
{
int loc=0;
int j=0,k,sym=0,lit=0,v=0,w=0;
FileReader f1=new FileReader("input.txt");
BufferedReader b1=new BufferedReader(f1);

FileWriter f3=new FileWriter("symtab.txt");
BufferedWriter b3=new BufferedWriter(f3);

FileWriter f4=new FileWriter("intermediate.txt");
BufferedWriter  b4=new BufferedWriter(f4);

FileWriter f6=new FileWriter("littab1.txt");
BufferedWriter b6=new BufferedWriter(f6);

StringBuffer sb = new StringBuffer();
String s,s3,s4,tmp,sd,sl;
String s1[]=new String[4];
String s2[]=new String[4];
String s5[][]=new String[4][3];
b3.write(" No.   code      address");
while((s=b1.readLine())!=null)
{
	int flag=0;
	int m=0;
	StringTokenizer st=new StringTokenizer(s);
    for(int i=0;i<4;i++)
        s1[i]=null;
	while(st.hasMoreTokens())
	{
	s1[m]=st.nextToken();
	m++;
	}
	if(s1[1].equals("START"))
	{
		b4.write("          AD     01");		
		b4.write("         C  "+s1[2]);		
		loc=Integer.parseInt(s1[2]);
		b4.newLine();
	}
	else if(s1[1].equals("END"))
	{    
          b4.write(loc+"       AD     02  ");
		b4.newLine();
		for(int i=0;i<lit;i++)
		{
		s5[i][2]=Integer.toString(loc);
		loc=loc+1;
		}
	}
	else 
	{
		b4.write(loc+"  ");
		if(s1[0].equals("-")!=true)
		{
		b3.newLine();
		b3.write(" "+sym);
		b3.write("      "+s1[0]);
		b3.write("         "+loc+" ");
		sym++;
		}
          FileReader f2=new FileReader("optab.txt");
          BufferedReader b2=new BufferedReader(f2);
		while((sl=b2.readLine())!=null)
		{
			j=0;
			StringTokenizer se=new StringTokenizer(sl);
			while(se.hasMoreTokens())
			{
				s2[j]=se.nextToken();
				j++;
			}
			if(s1[1].equals(s2[0])==true)
			{
				for(int a=1;a<3;a++)
				{
					b4.write("  ");
					b4.write("   "+s2[a]);
				}
				if(s1[1].equals("DS"))
				{
					loc=loc+Integer.parseInt(s1[2])-1;
					b4.write("         C  "+s1[2]);
					break;
				}
			}
			if(s1[2].equals(s2[0])==true)
			{
				
				b4.write("  ");
				b4.write("   "+s2[1]);
				
			}
					
		}
		if((s1[3]!=null) && s1[3].contains("="))
		{
			int i;flag=0;
			for( i=0;i<lit;i++)
			{
				if(s5[i][1].equals(s1[3]))
				{
					flag=1;
					break;
				}
			}
			if(flag!=1)
			{
				
				s5[v][0]=Integer.toString(lit);
				s5[v][1]=s1[3];
				v++;
				b4.write(" ");
				b4.write(" "+"L  "+lit);
				lit++;
			}
			else
			{
			b4.write(" ");
			b4.write(" "+"L  "+s5[i][0]);
			}
				
		}

		else if((s1[3]).matches("[a-zA-Z]")&& s1[3]!=null)
		{

			b4.write(" ");
			b4.write(" "+"S  "+sym);	
				
		}
		loc=loc+1;
		b4.newLine();
		
		
	}
}
b6.write(" No.  code      address");
for(int x=0;x<v;x++)
{
	b6.newLine();
	b6.write(" "+s5[x][0]);
	b6.write("      "+s5[x][1]);
	b6.write("      "+s5[x][2]);
}
b4.close();
b3.close();
b6.close();
}
}

