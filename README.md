# Arquitectura de Software

Arquitectura de Software NRC: 8360

## Proyecto: Core Pasivos Banco BanQuito

## Java version

- java 11.0.13 2021-10-19 LTS
- Java(TM) SE Runtime Environment 18.9 (build 11.0.13+10-LTS-370)
- Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.13+10-LTS-370, mixed mode)

## SWAGGER
> **`http://<host>:<port>/swagger-ui.html`**
Ex: http://localhost:8082/swagger-ui.html

## LINEAMIENTOS HACER LA URL DEL REST
____________________________________________________________________________________________________________________________________________________________________________________________________________________________

> **POST    `/{class}`** _Crea un {class} (informacion del {class} por body)._

> **GET `/{class}`** _Retorna todos los {class}._

> **GET `/{class}/{id}`** _Retorna el usuario que pertenece al {id} enviado._

> **GET `/{class}/{subclass}/{id}`** _Retorna el usuario que pertenece al {id} segun la {subclass}._

> **PUT `/{class}/{id}`** _Actualiza el usuario que pertenece al {id} enviado con la info enviada por body._

> **PUT `/{class}({subclass}/{id}`**  _Actualiza el usuario que pertenece al {id} segun la {subclass} con la info enviada._

> **DELETE `/{class}/{id}`** _Elimina el usuario que pertenece al {id} enviado._

> **DELETE `/{class}/{subclass}/{id}`**   _Elimina el usuario que pertenece al {id} segun la {subclass}._
____________________________________________________________________________________________________________________________________________________________________________________________________________________________

Toda clase que sea conformada por mas de una palabra tendra la siguiente forma en la URL:



|   |  |
| ------------- | ------------- |
| Clase  | URL  |
| UserDirection  | user-direction  |