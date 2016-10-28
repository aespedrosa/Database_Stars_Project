
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UpdateQuery{
	   private Connection connection;
	   private Statement statement;
	   private ResultSet resultSet;
	   private boolean connectedToDatabase = false;
	   
	   public UpdateQuery( String driver, String url, 
			      String username, String password) 
			      throws SQLException, ClassNotFoundException
			   { 
		   
		      Class.forName( driver );

		      // connect to database
		      connection = DriverManager.getConnection( url, username, password );

		      // create Statement to query database
		      statement = connection.createStatement( 
		         ResultSet.TYPE_SCROLL_INSENSITIVE,
		         ResultSet.CONCUR_READ_ONLY );

		      // update database connection status
		      connectedToDatabase = true;

		      //if(numero==1)
		     // updateQuery( query );
		   
			  }
	   // set new database query string
	   public void updateQuery( String query ) 
	      throws SQLException, IllegalStateException 
	   {

	      if ( !connectedToDatabase ) 
	         throw new IllegalStateException( "Not Connected to Database" );

	      statement.executeUpdate(query);

	   } // end method setQuery

	   // close Statement and Connection               
	   public void disconnectFromDatabase()            
	   {              
	      if ( !connectedToDatabase )                  
	         return;

	      // close Statement and Connection            
	      try                                          
	      {                                            
	         statement.close();                        
	         connection.close();                       
	      } // end try                                 
	      catch ( SQLException sqlException )          
	      {                                            
	         sqlException.printStackTrace();           
	      } // end catch                               
	      finally  // update database connection status
	      {                                            
	         connectedToDatabase = false;              
	      } // end finally                             
	   } // end method disconnectFromDatabase     	
}
