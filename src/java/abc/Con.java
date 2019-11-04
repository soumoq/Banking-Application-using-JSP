package abc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Con {
	 public static void main(String... args)
	    {
	    	new Con().balance(1000, 11);
	    }
   
    public void test()
    {
    	
        
    }
    private static int id1=0;
    public void setId(int id)
    {
        this.id1=id;
    }
    public int getId()
    {
        return id1;
    }
	
    private String pass="";
    private String uname="root";
    private String url="jdbc:mysql://localhost:3308/test";
    public Connection connection;
    
	 public Connection con()
	 {
	        try {
	            System.out.println("Start");
	            Class.forName("com.mysql.jdbc.Driver");
	            System.out.println("Lode");
	            connection = DriverManager.getConnection(url, uname, pass);
	            System.out.println("Connected");

	        }catch (Exception e)
	        {
	            System.out.println(e);
	        }
	        return connection;
	  }
	 
	    int id;
	 
	 public int insert(String name,String pass)
	    {
	        int i=0;
	        try {

	            String check="SELECT `id`,`name`, `password` FROM `bank` WHERE `name`= ? AND `password`= ? ;";
	            Connection con = con();
	            PreparedStatement ps = con.prepareStatement(check);
	            ps.setString(1, name);
	            ps.setString(2, pass);

	            ResultSet rs=ps.executeQuery();
	            if(rs.next())
	            {
	                System.out.println("Login success");
	                i=1;
	                id=rs.getInt("id");
	                System.out.println(id);
	                i=id;
	                //Afterlogin al=new Afterlogin();
	            }else{
	                System.out.println("login failed");
	                i=0;
	            }
	            return id;
	        }catch (Exception e)
	        {
	            System.out.println(e);
	        }
	        return i;
	    }
	 
	 
	 public int register(String uname,String uPass)
	    {
		 	int f=0;
		 	String name=uname;
		 	String pass=uPass;
	        try {
	     
	            Connection con=con();
	            String sql="INSERT INTO `bank` (`id`, `name`, `password`, `amount`) VALUES (NULL, ?, ?, '');";
	           
	            
	            if(name!=null && pass!= null)
	            {
	                PreparedStatement ps=con.prepareStatement(sql);
	                ps.setString(1,name);
	                ps.setString(2,pass);

	                int rs=ps.executeUpdate();
	                if(rs==1)
	                {
	                	f++;
	                    return f;
	                }
	                else
	                {
	                    return f;
	                }
	                
	             
	            }

	        }catch (Exception e)
	        {
	            System.out.println(e);
	        }
			return f;
	    }
	 
	  public int checkBal(int id) {
	        int bal = 0;
	        Connection con = con();
	        String balance = "SELECT `amount` FROM `bank` WHERE `id` = " + id + ";";
	        try {
	            PreparedStatement ps = con.prepareStatement(balance);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next())
	            {
	                String fatchBal=rs.getString("amount");
	                bal=Integer.parseInt(fatchBal);
	            }else
	            {
	                System.out.println("fail");
	            }
	        } catch (Exception e)
	        {
	            System.out.println(e);
	        }
	        return bal;
	    }
          
    public void balance(int bal,int id)
    {
        int balance = 0;
        try {
            int am=checkBal(id);
            bal=bal+am;
            String bal1=String.valueOf(bal);
            System.out.println(id);
            
            String update = "UPDATE `bank` SET `amount` = ? WHERE `bank`.`id` = "+id+";";
            Connection con = con();
            PreparedStatement ps = con.prepareStatement(update);
            ps.setString(1, bal1);

            int rs = ps.executeUpdate();
            if (rs==1) {
                    System.out.println("Amount updated");
                //Afterlogin al=new Afterlogin();
            } else {
                System.out.println("failed");
            }
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

}