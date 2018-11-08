## Mobile automation
### Answers for hw2 
- Rewrite (complete) Driver using “singleton” pattern. Are there any advantages?    
  
  When we use "singleton" pattern for Driver, there are no problems with different instances of driver in tests and Hooks class, we use one Driver object.
  
- Suggest improvements for .properties reading. What are the purposes?  
  
  Properties can be divided into 2 .properties files - for web tests and native tests. It's more convenient because we don't mix different properties. Also we don't have to change .properties file to define which type of tests is running now. 
  Moreover, .properties files can be moved to root of the project not to specify absolute paths of these files.
  
- Which checks would you place in the “web” test?    
  
  Check of web page URL and web page title. Also check of HTTP status code may be added.