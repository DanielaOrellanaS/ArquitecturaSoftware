# Arquitectura de Software

Arquitectura de Software NRC: 8360

## Proyecto: Core Pasivos Banco BanQuito

## Java version

- java 11.0.13 2021-10-19 LTS
- Java(TM) SE Runtime Environment 18.9 (build 11.0.13+10-LTS-370)
- Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.13+10-LTS-370, mixed mode)


## LINEAMIENTOS PARA HACER URLS EN REST
____________________________________________________________________________________________________________________________________________________________________________________________________________________________

POST	 /{class}	     			Crea un {class} (informacion del {class} por body). 						Ej: POST   /user  			Crea un usuario con la data de body.
GET  	 /{class}      			Retorna todos los {class}. 										Ej: GET    /user  			Retorna todos los usuarios.
GET  	 /{class}/{id}  			Retorna el usuario que pertenece al {id} enviado.						Ej: GET    /user/16			Retorna el usuario con id=16.
GET  	 /{class}/{subclass}/{id} 	Retorna el usuario que pertenece al {id} segun la {subclass}.				Ej: GET    /user/local/16 		Retorna el usuario con localId=16.
																				Ej: GET    /user/international/16 	Retorna el usuario con internationalId=16.
PUT    /{class}/{id}			Actualiza el usuario que pertenece al {id} enviado con la info enviada por body.	Ej: PUT    /user/16			Actualiza el usuario con id=16 con la data de body.
PUT 	 /{class}({subclass}/{id}	Actualiza el usuario que pertenece al {id} segun la {subclass} con la info enviada	Ej: PUT    /user/local/16		Actualiza el usuario con localId=16 con la data de body.
																				Ej: PUT    /user/international/16	Actualiza el usuario con internationalId=16 con la data de body.
						por el body.
DELETE /{class}/{id}                Elimina el usuario que pertenece al {id} enviado.						Ej: DELETE /user/16			Elimina el usuario con id=16.
DELETE /{class}/{subclass}/{id}	Elimina el usuario que pertenece al {id} segun la {subclass}.				Ej: DELETE /user/local/16		Elimina el usuario con localId=16.
																				Ej: DELETE /user/international/16	Elimina el usuario con internationalId=16.
____________________________________________________________________________________________________________________________________________________________________________________________________________________________

Toda clase que sea conformada por mas de una palabra tendra la siguiente forma en la URL:

Clase			URL
UserDirection	user-direction