
public class Constructor {
          String name;
          int id;
          Constructor()
          {	
        	  name="Raju";
        	  id=1035;
          }
          public static void main(String[] args) {
        	  Constructor con=new Constructor();
        	  System.out.println("Employee name is "+con.name+" and his ID:"+con.id);
          }
}

