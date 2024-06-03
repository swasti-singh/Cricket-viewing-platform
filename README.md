<h1>Sports Coverage Platform</h1>

Created a cricket news platform like Cricbuzz using Spring Boot and MySQL.

The following functions can be performed by any guest (no authentication needed):
1. Register a user
2. View match schedules
3. View match schedule for a particular match
4. View player statistics

The following functions can be performed only by the admin with an authentication token:
1. Add match
2. Add player to a team

To obtain the authentication token, use the endpoint "/api/admin/login" with the request body:
{"username":"swasti",
"password":"pass"}
(For now the above credentials only have the ADMIN access. This can be changed in AppConfig.java in the server side.)

To perform admin operation copy the token received from the response on hitting the above endpoint ("/api/admin/login"). This token has to be mentioned in the header value along with the keyword "Bearer". Please refer to the following format.

Eg: To add a player
[POST] /api/teams/{team_id}/squad

Header:
Key: Authorization
Value: Bearer <token_value>

Request Body : {
"name": "Adam Gilchrist",
"role": "Wicket-Keeper"
}

Please add dummy data into MySQL db to get appropriate responses. Database information is present in application.properties.

