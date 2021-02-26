Creation of 2 fragments is done.
First fragment contains a button to go to next fragment
Second fragment contains a button to send a message (from jio number to airtel number).
Preferences class created to read write service enable flag to xml in local storage.
Preferences class is in java, updated to kotlin. Default switch state is false.
ServiceEnable switch updated to use preference class to store the state in local xml
Listen for incoming calls -Done
MinSDK version - 29(Android 10)
modify FirstFragment to start second Fragment to automatically start second fragment if all permissions are set
When add Filter button is clicked, start a new fragment.


ToDo: In addFilter fragment all the numbers saved in filter list should be displayed
      When you press + icon popUp should be shown to save number to filter(in the temp file)
      Auto Message should be sent only to the Filter contacts if != null
      if failed to send message to any number->display alert message to display that autoReply failed
      else->display success toast

ToDo: If incoming call is in family Numbers(a set of numbers) and is valid number(i.e. digits = 10) then send a sample message.
ToDo: Implement UI to add custom text.
ToDo: Implement UI && Apply service only when set time interval.
ToDo: Implement UI to add groups.
ToDo: Add different timing for different groups.