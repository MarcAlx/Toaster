# Toaster
Toaster is a Java API allowing developpers to create Notifications (smartphone like toast messages) in their Java Programs.

## Why Toaster ?
Because today Java doesn't provide any Toastmessage interface to developpers.

## How to use it ?
With toaster you can create personalisable toastmessage (max 2 lines or 50 characters). You can personalise font color, background color, aparition style, remove style, icon, corner style;

First instanciate the toaster using getInstance().

    Toaster myToaster;
	  myToaster = Toaster.getInstance();

Now you are ready to create toast ! Use one of the multiple Toast method provided by the toaster.
	            
    //Creates a toast with red background color, yellow font color and wich will stay on screen for 1s
	  myToaster.Toast("Hello",Color.RED,Color.YELLOW,1000);
	  //Creates a toast with red background color, yellow font color and wich will stay on screen until you click on it
	  myToaster.Toast("Hello",Color.RED,Color.YELLOW,0);
	  /*Creates a toast with square corners, red background color, yellow font color and wich will stay on screen for 1s. 
	  This toast will appear by sliding from the right of your screen.*/
	  myToaster.Toast("Hello",Color.RED,Color.YELLOW,ApparitionStyle.TrayLeft,RemoveStyle.TrayRight,AppearanceStyle.SquareCorners,1000);
    
## What you could get
	 
   ![alt text](screenshots/toast.png "sample")
              
## Javadoc

Java doc is in folder javadoc

## Jar

A jar is provided in dist folder

## License

Released under Apache License 2.0
