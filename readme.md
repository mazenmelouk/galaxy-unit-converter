#Galaxy unit converter

####Notes:
I couldn't figure out the exact requirements with in/out-put,
therefore I made the following assumptions to keep it simple, 
but with more requirements we can make it less fragile

- In/out-put are single line
- Queries should always end with ? or start with `how`
- Metals(Iron,Silver..) Can be doubles, thus the query answer can be double.
- Input for learning should be in the form of (Words) 'is' (Value),
where Words doesn't contain `how`
- Input for queries should (Question) 'is' (Words),
where Question doesn't contain `how`
- I couldn't get the exact logic for credit, so I ignore it.

####Build using maven:
`mvn clean install`


####Run using maven:
`mvn exec:java -Dexec.mainClass="com.personal.test.Main"`