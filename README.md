# Jwt-App
1. After sending valid username and password in requestbody, JWT token will be generated and returned as response.
```
{
  "userName" : valid_user_name,
   "password" : valid_password
}
```

2. This JWT token can be further used in header for accessing API 
```
# In headers,
"Authorization" : "Bearer jwt-token"

```

