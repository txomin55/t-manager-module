# TMANAGER-MODULE

## Detalles de autenticación
```
Credenciales de login para usuarios open-source 
user-open-source
password-open-source
```
## Frontend
### Comandos Vue
```
npm install
npm run serve
npm run build
npm run test
npm run lint
```
### El módulo
```
El módulo launcher setea window.t_manager_access_token con su token de acceso y window.t_manager_access_token_validity con el tiempo de validez de este.

Si es un módulo nuevo y está incluido en el launcher, también hay que añadir que el módulo está ensamblado en el launcher con el objeto window.isModuleEnsambled con module:valor => {'t-manager-MODULE': true} para que luego el modulo pueda verificar si está o no incluido para asi llamar al servicio de recuperar el token por su cuenta o cogerlo de window.t_manager_access_token.

En el index.html tiene que existir un div con el id de store.state.module, osea el nombre del módulo que decidamos
```
### Node
```
La versión de node que se instala para el clean install es v10.16.0, la versión de npm no hace falta definirla
```
## Sobre la seguridad
### Datos de keystore
```
keystore name: t-manager
keypass: t-manager-password
store pass: t-manager-password
```
### A tener en cuenta con OAUTH2
```
El resourceId dado de alta en users de mongo tiene que tener el mismo que la aplicacion module en OAuth2ResourceServerConfigJwt -> config.resourceId("foo");
```
## SWAGGER
```
http://localhost:8002/module/swagger-ui.html
```
