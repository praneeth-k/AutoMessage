Creation of 2 fragments is done.
First fragment contains a button to go to next fragment
Second fragment contains a button to send a message (from jio number to airtel number).
Preferences class created to read write service enable flag to xml in local storage.
Preferences class is in java, updated to kotlin. Default switch state is false.
ServiceEnable switch updated to use preference class to store the state in local xml
Listen for incoming calls -Done
MinSDK version - 29(Android 10)

ToDo: If incoming call is in family Numbers(a set of numbers) and is valid number(i.e. digits = 10) then send a sample message.
ToDo: Implement UI to add custom text.
ToDo: Implement UI && Apply service only when set time interval.
ToDo: Implement UI to add groups.
ToDo: Add different timing for different groups.