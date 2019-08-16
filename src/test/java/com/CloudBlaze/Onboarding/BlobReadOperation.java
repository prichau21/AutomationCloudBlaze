package com.CloudBlaze.Onboarding;
import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.blob.*;
import com.relevantcodes.extentreports.LogStatus;
public class BlobReadOperation {
	
	 public static void verifyReadBlob() throws InterruptedException 
	    {
			
			 Thread.sleep(1000);
		    
			 // Define the connection-string with your values
		
			 
			 final String storageConnectionString =
			 "DefaultEndpointsProtocol=http;" +"AccountName=cb0oanfb2ihritaidemo1ba;" +"AccountKey=2QC18Yh+kYU1QM47dlq+kSDLUNS8Lpy5qc8HQO1j8cUB/VwuBwQxcl7vB+cSke5IGlhAJwZqqBTMPN60mB5dfw==";
			 
			 try
			 {
			    // Retrieve storage account from connection-string.
			     CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);

			     // Create the blob client.
			     CloudBlobClient blobClient = storageAccount.createCloudBlobClient();

			     // Retrieve reference to a previously created container.
			     CloudBlobContainer container = blobClient.getContainerReference("schema");

			     // Loop over blobs within the container and output the URI to each of them.
			     for (ListBlobItem blobItem : container.listBlobs()) {
			       System.out.println(blobItem.getUri());
			  
			   }
			 }
			 catch (Exception e)
			 {
			    // Output the stack trace.
			    e.printStackTrace();
			 }
			 
		

}}
