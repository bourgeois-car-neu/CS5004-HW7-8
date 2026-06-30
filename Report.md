# Report

Submitted report to be manually graded. We encourage you to review the report as you read through the provided
code as it is meant to help you understand some of the concepts. 

## Technical Questions

1. Describe the purpose of a model in the MVC architecture. What is the model responsible for? What are some examples of what might be included in a model?
* MVC stands for Model View Controller, it's an application into three parts, each with their own responsibilities. The model holds the business and data logic. It represents what the data is and how it will behave. A model may include data structures, business logic, and external data sources.


2. Describe the purpose of a controller in the MVC architecture. What is the controller responsible for? What are some examples of what might be included in a controller?
* The "C" in MVC stands for Controller. The controller takes user input, decides what should happen, talks to the model to get/update data, then hands that data off to the view for display. The controller may include input handling, decision logic, and coordination like calling the model or view. 

3. Describe the word serialization, and how it relates to 'data-binding' in Jackson. What is the purpose of serialization? What is the purpose of data-binding? What is the relationship between the two?
* Serialization means converting an object into a format that can be stored or transmitted. Objects in memory disappear when a program ends, but serialized data can be saved, sent, or shared programs. Data binding in Jackson automatically maps Java object fields to or from a data format like JSON or XML. The purpose of data binding is to eliminate tedious work of manually reading and converting the Java object info. Jackson looks at class structure and automatically translates between object and data. Serialization is essentially the goal, data binding is the technique used to achieve the goal. 

4. Describe the differences between JSON and CSV - make sure to reference flat or hierarchical data in your answer. What are some advantages of JSON over CSV? What are some disadvantages?
* JSON is a hierarchical data format, it can use nested data structures. The data can also be represented as a string and integer.
* CSV stands for comma separated values, it's a flat data structure with rows and columns, like a spreadsheet. CSV data is always represented as a string when it comes into Java.
* Advantages of JSON over CSV include: 
  * supports complex and nested data
  * each field is next to the data, making it easy to understand what each value means
  * widely used in APIs 
* Disadvantages of JSON over CSV include:
  * repeated field names make the file size larger than CSV
  * not easily accessible, a CSV can be opened in Excel
  * slower to parse for large datasets, CSV are simple to read line by line with large tables

5. Why would we want to use InputStreams and OutputStreams throughout a program instead of specific types of streams (for most cases)?
* Input/Output Streams let your code work with any data source without caring what that source/destination actually is. 


6. What is the difference between a record and a class in Java? When might you use one over the other?
* Record is a special way to define an immutable data carrier. This means that once you build an object, none of its values can be modified. 
* Class gives you full control over everything, but you have to start from scratch. You write its purpose, mutability, inheritance.
* Use a record hen you have data that shouldn't change after creation. Use a class when things can change over time. 


7. What is a java "bean"? 
* A Java Bean is a plain Java class that follows a specific set of conventions. It's designed to make it easy for other tools (like Jackson) to inspect and manipulate it automatically.

## Deeper Thinking

The data for this assignment was downloaded from ipapi.co, and the data itself is publicly listed. For the pervious assignment, we used data from Board Game Geek, which a person has a unofficial collection of the BGArena games. It is also worth noting it is actually out of date, since BGGeek has added a category for Digital Implementations of games.

Data of many types are  often available online (Here is a list of a bunch of [free API](https://mixedanalytics.com/blog/list-actually-free-open-no-auth-needed-apis/)s), and even the owners of Board Game Geek have RPGGeek and VideoGameGeek. To try out Board Game geeks API, you can put into the url https://www.boardgamegeek.com/xmlapi2/thing?id=13 and you will get back an XML file with information about the game with id 13. 

Take some time to find other online data APIs that you might be interested in. What kind of data would you like to work with? What kind of data would be useful for you to have access to? Another example of an API a random dog image API https://dog.ceo/dog-api/!

🔥 Find at least two other APIs/Data sources (so downloadable data is also valid). Link them, and provide a brief description of what kind of data they provide. These will act as your references for this assignment.

However, just because information is freely available online, it does not mean

* You have legal rights to that information
* The information was collected ethically
* The information is accurate
* The information is without bias
  
🔥 Take some time to think about the ethical implications of using data from the internet. What are some ways that you can ensure that the data you are using is accurate and unbiased? Provide some examples of key questions you might ask yourself before using data in a project, and what are some questions you can use to help you evaluate the data you are using. Please include references if you use any, as there are plenty of articles out there talking about this topic.
