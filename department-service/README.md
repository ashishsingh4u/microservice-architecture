# Department Microservice

## To Save Department
URL: [Post URL](http://localhost:9001/departments/)

Request Body:
```json
{
  "departmentName": "IT",
  "departmentAddress": "Pasir Panjang, Singapore",
  "departmentCode": "IT-006"
}
```

Response:

```json
{
    "departmentId": 1,
    "departmentName": "IT",
    "departmentAddress": "Pasir Panjang, Singapore",
    "departmentCode": "IT-001"
}
```

## To Read Department
URL: [Get URL](http://localhost:9001/departments/1)

Result
```json
{
    "departmentId": 1,
    "departmentName": "IT",
    "departmentAddress": "Pasir Panjang, Singapore",
    "departmentCode": "IT-001"
}
```