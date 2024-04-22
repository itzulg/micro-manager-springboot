# micro-manager-springboot
A **REST API** connected to a **PostgreSQL** database with its own **CRUD** operations, URL, and HTTP methods. It’s connected to a **Gateway Server** and **Eureka Server**.

Resouce Paths.
- POST: http://localhost:8002/api/manager/list/retrieve
- POST: http://localhost:8002/api/manager/id/retrieve
- POST: http://localhost:8002/api/manager/create

JSON Body:

{
>"name": "Fabiola",\
"lastnameFather": "Fernández",\
"lastnameMother": "Ramírez",\
"area": "B5",\
"telephone": "5556784532",\
"adress": {
>> "street": "Av. Carlota",\
   "number": "A-12",\
   "cp": "98456",\
  "state": "Sonora",\
  "city": "Los Nogales"
>>
>}


}

- PUT: http://localhost:8002/api/manager

JSON Body (same as the previous one but including the **id** field).

- DELETE: http://localhost:8002/api/manager/remove
- POST: http://localhost:8002/api/manager/retrieve/data


JSON Body (to get search matches):

{
>"nombre": "Fabi",\
"apellidoPaterno": "Fer",\
"apellidoMaterno": "Ram",

}
