import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
public class FileHandling {
	
	public static int a[]=new int[12];
	
	public static void main(String args[]) 
	{
		
		try 
		{
			//enter the path and dirname from keyboard 
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
			System.out.println("Enter dirpath:"); 
			String dirpath=br.readLine(); 
			System.out.println("Enter the dirname");
			String dname;
		
			dname = br.readLine();
		
  
			//create File object with dirpath and dname 
			//File f = new File(dirpath, dname); 
			File f = new File(dirpath+"\\"+dname);
  
			//if directory exists,then 
			if(f.exists()) 
			{ 
	         
				countFilesPerMonth(f);
				displayOutput();
			}
			else
			{
				System.out.println("Kuch galat h bhai");
			}	
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
   
   
   		public static void countFilesPerMonth(File directory)
   		{
   	 
   			File listOfFiles[] = directory.listFiles();
   		
   			for(File file: listOfFiles )
   			{
   				
   				createdMonth(file);
   				//System.out.println("after calling created month method");
   				
   			}
   			
   		}
   	
   	 public static void createdMonth(File file)
   	 {
   		
       try {

           Path file1 = Paths.get(file.getPath());

           BasicFileAttributes attr = Files.readAttributes(file1, BasicFileAttributes.class);

           //System.out.println("creationTime: " + attr.creationTime());
           
           long time = attr.creationTime().toMillis();
           
           
           ZonedDateTime t = Instant.ofEpochMilli(time).atZone(ZoneId.of("UTC"));
           String dateCreated = DateTimeFormatter.ofPattern("MM/dd/yyyy").format(t);
           //System.out.println(dateCreated);
           
           String s=dateCreated.substring(0,2);
           
           //System.out.println(s); 03/13/2020
      
           Integer temp= new Integer(s);
           
           int index=temp.intValue() - 1;
           
           a[index]=a[index]+1;
           
           //System.out.println(a[index]);
           
       
       	}catch(Exception e)
       	{
 	   		System.out.println(e);
 	   		e.printStackTrace();
       	}

   	 }
   	 
   	 
   	 
   	 public static void displayOutput()
   	 {
   		 List<String> l= new ArrayList<String>();
   		 
   		 l.add("January");
   		 l.add("February");
   		 l.add("March");
   		 l.add("April");
   		 l.add("May");
   		 l.add("June");
   		 l.add("July");
   		 l.add("August");
   		 l.add("September");
   		 l.add("October");
   		 l.add("November");
   		 l.add("December");
   		 
   		 for(int i=0;i<=11;i++)
   		 {
   			 if(a[i]==0)
   				 continue;
   			 System.out.println(l.get(i)+" " +a[i]);
   		 }
   	 }
}

