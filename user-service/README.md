# User Microservice

## To User Department
URL: [Post URL](http://localhost:9002/users/)

Request Body:
```json
{
  "firstName": "Ashish",
  "lastName": "Singh",
  "email": "ashishsingh4u@gmail.com",
  "departmentId": "1"
}
```

Response:
```json
{
    "userId": 1,
    "firstName": "Ashish",
    "lastName": "Singh",
    "email": "ashishsingh4u@gmail.com",
    "departmentId": "1"
}
```

## To Read User with department
URL: [Get URL](http://localhost:9002/users/1)

Result
```json
{
  "user": {
    "userId": 1,
    "firstName": "Ashish",
    "lastName": "Singh",
    "email": "ashishsingh4u@gmail.com",
    "departmentId": "1"
  },
  "department": {
    "departmentId": 1,
    "departmentName": "IT",
    "departmentAddress": "Pasir Panjang, Singapore",
    "departmentCode": "IT-001"
  }
}
```