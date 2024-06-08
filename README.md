# RegistryCar
Usa BD h2, no se necesita ninguna libreria especial

1. Curl para insertar vehiculos:

curl --location 'localhost:8080/cars' \
--header 'Content-Type: application/json' \
--data '{
"plate" : "3",
"color" : "color",
"model" : "model",
"chassis" : "chassis",
"proprietary" : "proprietary"
}'



2. curl consulta todos los carros: 

curl --location --request GET 'localhost:8080/registry/all-cars' \
--header 'Content-Type: application/json' \
--data '{
"plate" : "plate1",
"color" : "color1",
"model" : "model1",
"chassis" : "chassis1",
"proprietary" : "proprietary1"
}'

3. curl servicio consulta si es o no permitido circular el vehiculo:

curl --location --request GET 'localhost:8080/registry/info/10?date=2024-06-07%2005%3A00%3A00' \
--header 'Content-Type: application/json' \
--data '{
"plate" : "plate1",
"color" : "color1",
"model" : "model1",
"chassis" : "chassis1",
"proprietary" : "proprietary1"
}'