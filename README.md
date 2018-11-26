# mailapplication

Problem Description:

Sending mails with big csv file as input

Given is a big csv file (size: multiple gigabytes, encoding: UTF-8) with email, firstname and lastname separated with ; and " as quotes.

The application should read the csv file and send emails to all reciptions in an effective way.

For testing please do not send any emails. Just implement a mock mail sending service. It should wait for half a second to mock the sending time needed and then log a success message mentioning the recipient.

Implementation notes:

This application is using below technology stack:

Java 8,
Maven,
simpleflatmappercsv,
java mail api,
Junits

Details:

The jar is executed with a csv file path as parameter. If the path and file is valid the application will read the csv line by line map to the person object and a job is queued to the custom thread pool(JobExecuter class) in the application.

This way csv file is being read line by line and the mail sending is done in parallel hence the objects created by csv are short lived till the mail is sent so that we do not get OutOfMemory if the number of objects are large and parallel processing ensures that the csv read and mail sending activities go on in parallel to enhance the performance.

Sample Person data csv can be found in the root of the repository.
