The Art Gallery Project

Link for video:
https://drive.google.com/file/d/1IZFPHjW3tK-K5pbdKjCj5b51dUs_0TRF/view?usp=sharing

The project simulates a smart picture frame that can display images available through the API of
the Metropolitan Museum of Art. The museum’s core API provides access to the total number of
artworks housed in the museum and a unique identifier for each art object. The collection
includes nearly 500,000 art objects, organized by department. Requests to the api can be
filtered on department number. Images of the art objects are stored as urls.
When the project is running, a user can go to the project’s web page and enter a department
number. They can then click a button which will load the images of each object in the
department on the screen, one at a time. Every 10 seconds the next image in the sequence
(ordered by object id ) will be rendered.
The backend of the application is built in Java and Spring boot, defined as a Web application.
The Model Class of the application has two fields:total and ObjectIDs. These represent the total
number of art objects in the department and an integer array that contains all of the art object
ids. The Controller Class creates the API needed to execute the GET request from the browser .
The Service Interface and its implementation enable one method that returns the total number
of art objects in a department and an array containing all the department’s art object ids. The
application uses Feign Client to create a query string with departmentID that returns the
response in JSON format.
The frontend of the application is an HTML web page that accepts the user input of the
department number and loads the images onto the page. The page presents an input box in
which the user enters a department number and a LOAD IMAGE button which the user can
push to begin rendering the images. The page’s functionality is supported primarily by two
functions written in JavaScript: load_image() and process_images(). load_images() creates a
query string by appending the department number entered by the user to the project’s api. For
example:
let response = await
fetch('http://localhost:8080/api/v1/art-gallery'+'?departmentID=' +
dID);
If the user enters 3, the query string would be the following:
http://localhost:8080/api/v1/art-gallery'+'?departmentID=3
The process_image() function loops through all of the art objectIDs returned by load_image on
a 10 second timer. Images are rendered in succession after the timer of the previous image has
expired. The program uses the onmouseover event ( user hovers the mouse over the image) to
stop the 10 second timer and displays the description of the art object. And onmouseout to
resume the processing. Once the user moves the mouse away, the 10 second timer will resume.
TO RUN THE PROGRAM:
Run the program as a Spring Boot application and then load the following in your browser:
localhost:8080/index.html



Unit Tests:
The backend should return a not null response if a the GET method is called with a valid
department id parameter
The backend should return an empty response if the GET method is called with a department id
that has no art objects.
Exceptions:
If the GET call is unable to reach the museum API (for example if the API is down) the user
should see a custom message.
