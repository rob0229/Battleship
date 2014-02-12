import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;



public class RunServer {
	
	
	
}
	/*
ServerSocket serverSocket;
Socket connection;
int counter;
private ObjectOutputStream output; // output stream to client
private ObjectInputStream input; //
	
	public RunServer(){
		
 
	   
		      try // set up server to receive connections; process connections
		      {
		         serverSocket = new ServerSocket( 12345, 100 ); // create ServerSocket

		         while ( true ) 
		         {
		            try 
		            {
		               waitForConnection(); // wait for a connection
		               getStreams(); // get input & output streams
		               processConnection(); // process connection
		            } // end try
		            catch ( EOFException eofException ) 
		            {
		               displayMessage( "\nHost terminated connection" );
		            } // end catch
		            finally 
		            {
		               closeConnection(); //  close connection
		               counter++;
		            } // end finally
		         } // end while
		      } // end try
		      catch ( IOException ioException ) 
		      {
		         ioException.printStackTrace();
		      } // end catch
		   } // end method runServer

		   // wait for connection to arrive, then display connection info
	    private void waitForConnection() throws IOException{
		      displayMessage( "Waiting for connection\n" );
		      connection = serverSocket.accept(); // allow server to accept connection            
		      displayMessage( "Connection " + counter + " received from: " +
		         connection.getInetAddress().getHostName() );
		   } // end method waitForConnection

		   // get streams to send and receive data
	    private void getStreams() throws IOException{
		      // set up output stream for objects
		      output = new ObjectOutputStream( connection.getOutputStream() );
		      output.flush(); // flush output buffer to send header information

		      // set up input stream for objects
		      input = new ObjectInputStream( connection.getInputStream() );

		      displayMessage( "\nGot I/O streams\n" );
		   } // end method getStreams

		   // process connection with client
	    private void processConnection() throws IOException{
		      String message = "Connection successful, *sent from server* ";
		      sendData( message ); // send connection successful message

		      // enable enterField so server user can send messages
		      setTextFieldEditable( true );

		      do // process messages sent from client
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

		      } while ( !message.equals( "CLIENT>>> TERMINATE" ) );
		   } // end method processConnection

		   // close streams and socket
	    private void closeConnection() {
		      displayMessage( "\nTerminating connection\n" );
		      setTextFieldEditable( false ); // disable enterField
	               // connectButton.setEnabled(true);
	               // hostButton.setEnabled(true);
		      try 
		      {
		         output.close(); // close output stream
		         input.close(); // close input stream
		         connection.close(); // close socket
		      } // end try
		      catch ( IOException ioException ) 
		      {
		         ioException.printStackTrace();
		      } // end catch
	                        
	        //allows for multiple connections without restarting game
	             
		   } // end method closeConnection

		   // send message to client
	    private String sendData( String message ) {
		      try // send object to client
		      {
		         output.writeObject( "SERVER>>> " + message );
		         output.flush(); // flush output to client
		         displayMessage( "\nSERVER>>> " + message );
		      } // end try
		      catch ( IOException ioException ) 
		      {
		         return String ( "\nError writing object" );
		      } // end catch
		   } // end method sendData

		   // manipulates displayArea in the event-dispatch thread
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

		
		
		
		
	}//end class
	
	
	*/

