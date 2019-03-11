What actually OAuth2 is ?:
--------------------------------------
->It's an authorization framework which allows to retrive limited accessed userdetails from a HTTP service and by using these details, give access to a third-party application , which you want to access.

example: logging into github using your facebook or Google account or twitter account. (Here Github access limited used details from your facebook or google or twitter acount and if everything goes perfect you will be navigated to github page).

*Basically it delegates user authentication to a service(like FB,google, twitter)which already contains user account details previously and it also authorizes the third-party application to access the user account details.

Building blocks of OAuth2:
--------------------------------
1.Resource Owner (user, who wants to access the third-party application).

2.Client (Third-party application).

3.Resource server.(Server which hosts the API for user account details).

4.Authorization server. (Server which hosts the API to authorize the third-party application).

Grant-Types in OAuth2:
----------------------
1.Authorization Code: used with server-side Applications

2.Implicit: used with Mobile Apps or Web Applications (applications that run on the user's device)

3.Resource Owner Password Credentials: used with trusted Applications, such as those owned by the service itself

4.Client Credentials: used with Applications API access



About the Project:(springbootOAuth2)
------------------------------------
This project is build on spring boot (1.5.8) and it provides the facility to generate the access-tokan and refresh token.
The secured API's will be access by using the  access-token.

1.Steps to generate access-refresh-token:
----------------------------------------
  API POST Request:http://localhost:8082/springbootOAuth2/oauth/token
   Authorization:
   --------------
   username:dharmen-client
   password:dharmen-secret
   
   Click on "Update Request" button on Postman.
   After clicking, you will get a Header "Authorization" with a value in the Headers tab.
   
   body (x-www-form-urlencoded):
   --------------------------------
   username:present in your DB(User table)
   
   password:password
   
   grant_type:password
   
   *If everything goes fine, then you will receive:
   
                "access_token": string value,
                
                "token_type": "bearer",
                
                "refresh_token": string value,
                
                "expires_in": 2982,
                
                "scope": "read write trust"
 
2.Accessing secured api's using access-token received above:
------------------------------------------------------------
Example: API Request GET: http://localhost:8082/springbootOAuth2/users/user
        click on "params" button and provide the details as below:
            access_token: above value
       
       * On sucessful request, you will recive al the user details from DB.
   
   
   
   
   










