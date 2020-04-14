Forkify API
API CALLS 

"resources" package handles all the api calls directly from 3rd party.

CustomerResource.java handles 

1.GET -> /customers/{custId}?password=..

// takes customer mobile as path parameter and password as query parameter and returns the Customer information if the customer is found.

2. POST -> /customers

// takes the Customer information as URL parameter such as mobile,password,name,location,address,email and add that customer to database and returns the same.

3. GET -> /customers/{custId}/orders

// takes customer mobile as path parameter and returns all past orders of that customer.

4. POST -> /customers/orders

// takes Order information as URL parameter such as custId,date,orderId,orderStatus,restId and add that order to database and return the same.

5. GET -> /customers/{custId}/circle

// takes Customer mobile as path parameter and returns the recommendations(customer and the restaurant recommended) of all the customers in its Circle.

6. POST -> /customers/{custId}/recommend

// takes restaurant Id as URL parameter and custId as path parameter and add that recommendation of the following customer.  