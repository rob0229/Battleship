import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.SwingUtilities;


public class RunClient {
	
	
}
/*
	
	private ObjectOutputStream output; // output stream to client
	private ObjectInputStream input; //
	 private ObjectOutputStream outputClient; // output stream to server
     private ObjectInputStream inputClient; // input stream from server
     private String message = ""; // message from server
     private String chatServer; // host server for this application
     private Socket client; // socket to communicate with server
     
	  //set up and run client
    public RunClient(String ipAddress){
     try // connect to server, get streams, process connection
      {
         connectToServer(); // create a Socket to make connection
         getStreamsClient(); // get the input and output streams
         processConnectionClient(); // process connection
      } // end try
      catch ( EOFException eofException ) 
      {
         displayMessage( "\nClient terminated connection" );
      } // end catch
      catch ( IOException ioException ) 
      {
         ioException.printStackTrace();
      } // end catch
     
      finally 
      {
          System.out.println("  gets to here run client line 514  ");
         closeConnectionClient(); // close connection
      } // end finally
    
    }
    
           // connect to server
   private void connectToServer() throws IOException{      
      displayMessage( "Attempting connection\n" );

      // create Socket to make connection to server
      client = new Socket( InetAddress.getByName( chatServer ), 12345 );

      // display connection information
      displayMessage( "Connected to: " + 
         client.getInetAddress().getHostName() );
   } // end method connectToServer

           // get streams to send and receive data
   private void getStreamsClient() throws IOException{
      // set up output stream for objects
      outputClient = new ObjectOutputStream( client.getOutputStream() );      
      outputClient.flush(); // flush output buffer to send header information

      // set up input stream for objects
      input = new ObjectInputStream( client.getInputStream() );

      displayMessage( "\nGot I/O streams\n" );
   } // end method getStreams

           // process connection with server
   private void processConnectionClient() throws IOException{
      // enable enterField so client user can send messages
      setTextFieldEditable( true );

      do // process messages sent from server
      { 
         try // read message and display it
         {
            message = ( String ) input.readObject(); // read new message
            displayMessage( "\n" + message ); // display message
         } // end try
         catch ( ClassNotFoundException classNotFoundException ) 
         {
            displayMessage( "\nUnknown object type received" );
         } // end catch

      } while ( !message.equals( "SERVER>>> TERMINATE" ) );
   } // end method processConnection

           // close streams and socket
   private void closeConnectionClient()  {
      displayMessage( "\nClosing connection" );
      setTextFieldEditable( false ); // disable enterField

      try 
      {
         outputClient.close(); // close output stream
         inputClient.close(); // close input stream
         client.close(); // close socket
      } // end try
      catch ( IOException ioException ) 
      {
         ioException.printStackTrace();
      } // end catch
   } // end method closeConnection
   
           // manipulates displayArea in the event-dispatch thread
   private void sendDataClient( String message ){
	      try // send object to client
	      {
	         outputClient.writeObject( "CLIENT>>> " + message );
	         outputClient.flush(); // flush output to client
	         displayMessage( "\nCLIENT>>> " + message );
	      } // end try
	      catch ( IOException ioException ) 
	      {
	         messageTextArea.append( "\nError writing object" );
	      } // end catch
	   } // end method sendData
/*end of server Methods*/


/*
   
   private void displayMessage( final String messageToDisplay ){
	      SwingUtilities.invokeLater(
	         new Runnable() 
	         {
	            public void run() // updates displayArea
	            {
	            	messageTextArea.append( messageToDisplay ); // append message
	            } // end method run
	         } // end anonymous inner class
	      ); // end call to SwingUtilities.invokeLater
	   } // end method displayMessage
	
   // manipulates enterField in the event-dispatch thread
   private void setTextFieldEditable( final boolean editable ){
	      SwingUtilities.invokeLater(
	         new Runnable()
	         {
	            public void run() // sets enterField's editability
	            {
	               userChatEnter.setEditable( editable );
	            } // end method run
	         }  // end inner class
	      ); // end call to SwingUtilities.invokeLater
	   } // end method setTextFieldEditable
	

}
*/

