# is-the-site-up-spring-boot
This is a simple Spring boot service to test if the given site is up or down.

How does it work?
To test its working, first clone the repository by using the below command:

`git clone` repo_url

Then run it locally and go the URL - [localhost:8080](http://localhost:8080/)

Now, you will see a whitelabel classic error page for a spring boot app. To check if a certain domain is up or down, try to make the below request:

[http://localhost:8080/check?url=https://www.google.com](http://localhost:8080/check?url=https://www.google.com)

What is essentially happening in the above URL is that you are making a get request to route called "check" which expects a url as its query parameter and here you can specify any web application URL to test if it is down or up. In this case we are testing [https://www.google.com](https://www.google.com)

