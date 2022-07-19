# Task Git API
***
Service return few simple information about Git repository.
Service work on Heroku. 
***
#### Get 

```http
https://task-git-api.herokuapp.com/repositories/{owner}/{repository}
```

| Parameter | Type   | Description  |
|:----------|:-------|:-------------|
| `owner`   | `String` | **Required** |
| `repository`   | `String` | **Required** |

#### Example
```http
https://task-git-api.herokuapp.com/repositories/gracjanch/task-git-api
```
#### JSON Result (if exists):
```json
{
  "fullName": "gracjanch/task-git-api",
    "description": null,
    "cloneUrl": "https://github.com/gracjanch/task-git-api.git",
    "stars": 0,
    "createdAt": "2022-07-19T05:21:30"
}
```
#### Result, when we use wrong user name:
```json
{
  "timestamp": "2022-07-19T15:29:50.900096",
    "httpCode": 404,
    "error": "NOT_FOUND",
    "errorMessage": "Wrong User name"
}
```
#### Result, when we use wrong repository name:
```json
{
  "timestamp": "2022-07-19T15:31:00.187327",
    "httpCode": 404,
    "error": "NOT_FOUND",
    "errorMessage": "User don't have repository with this name"
}
```
