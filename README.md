## Mobile automation
### Answers for hw1 
- For existing native mobile autotest try to use another locator (xpath, classname, ?). Are there any difference with id version?  
  
  To use other locator we need to use other methods of class By (By.id, By.xpath, By.className).  
  If there were more than 1 button, className probably wouldn't be unique.
  
- Modify existing tests to run on a real device. What should be changed?  
  
  Device name "emulator-5554" should be changed to name of a real device. It was known with the help of `adb devices`.  
- Connect a real device to Appium (describe required actions) and run tests. Are there any difference with run on emulator?  
  
  First, there can be some difficulties with permissions to run tests on a real device - permission to debug by usb and to install .apk by usb. Moreover, when ContactManager starts on a real device it dispays contacts from the phone. On default emulator there are no saved contacts. 
- What should be improved/changed in existing test code? Why, for what?  
  
  There are many hardcoded values, absolete path to .apk, not parametrized methods to setup driver and we have to choose method of setup by commenting lines in code. It should be improved to make our code easier to support and portable.  
  Thread.sleep should be removed, because testing system is real-time.
  Structure of the project should be improved, descriptions of classes and methods should be added to make our code more understandable.
