# tmanager-module

## Project setup
```
npm install
```

### Compiles and hot-reloads for development
```
npm run serve
```

### Compiles and minifies for production
```
npm run build
```

### Run your tests
```
npm run test
```

### Lints and fixes files
```
npm run lint
```

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).

### Authentication details
```
Credenciales de login para usuarios open-source 
user-open-source
password-open-source
```
###
```
El módulo launcher tiene que setear window.t_manager_access_token con su token de acceso y window.t_manager_access_token_validity con el tiempo de validez de este.

Si es un módulo nuevo y está incluido en el launcher, también hay que añadir que el módulo está ensamblado en el launcher con el objeto window.isModuleEnsambled con moduleName valor => {'t-manager-MODULE': true} para que luego el modulo pueda verificar si está o no incluido para asi llamar al servicio de recuperar el token por su cuenta o cogerlo de window.t_manager_access_token.
```
```
En el index.html tiene que existir un div con el id de store.state.module, osea el nombre del módulo que decidamos
```
store.state.module
```
keystore name: t-manager
keypass: t-manager-password
store pass: t-manager-password
```
```
El resourceId dado de alta en users de mongo tiene que tener el mismo que la aplicacion module en OAuth2ResourceServerConfigJwt -> config.resourceId("foo");
```
La versión de node que se instala para el clean install es v10.16.0, la versión de npm no hace falta definirla
```
swagger-ui.html
```
