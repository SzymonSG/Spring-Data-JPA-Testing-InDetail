## The project aims to show the mapping of objects to the database using diffrent type of relationships in a wider practical context. 

## This is a schema how our entities are connected. 
![alt text](rldb.png "Tittle")
<font size="5">
 1.  Every Student has a Guardian 
     - @Embeddable and @Embedded.<br />
     (in this case we realize this linkage by embedding Guardian into Student)
 2.  Course Material is matched to one Course 
     - One to One
 3.  Techer learn multiple Courses
     - One to Many
 4.  Otherside multiple courses learning by one teacher
     - Many to One
 5.  Course can have a multiple Students
     - Many to Many

Comparing Bidirectional and Unidirectional realtionship connection.

### Project also testing diffrent types method JpaRepository like:
    - Query methods,
    - JPQL,
    - Native query and Native query with Params,
    - CRUD operations 
    - Pagination and Sorting

Proprietary tests show how easy it is to FILTER, SORT, and VIEWS data from a database using Spring Data JPA, 

SHOWS ALSO:
- how to work CASCADING between associated entity  
- differents between types of FETCHING of data LAZY or EGEAR.







