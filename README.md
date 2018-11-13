## Mobile automation
### Answers for hw3 
- Try to use autoLaunch capability with app as before. Does this approach work?  

  This approach doesn't work, app doesn't install automatically from disk.
  
- Change settings to run web test on a certain iOS device on Mobile Test Farm. Run test with your changes. Did test pass?  
  
  Test passed.
- Change settings to run native test on a certain/random Android device on Mobile Test Farm. Run test with your changes. Did test pass?  
  
  Test passed.
- What’s wrong with our code? How to fix/improve it? Implement your suggestions.  
  
  There are problems with properties reading - we must comment some lines to change capabilities for running on mobile farm. Properties may be transferred to json file with all needed types of capabilities and properties.
  Also, there are many hardcoded values, some of them may be moved to enums and strings. For native test page object pattern may be implemented, because this test contains some elements.