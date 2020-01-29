# TMANAGER-MODULE
MOTIVACIÓN DEL PROYECTO
## Detalles de autenticación
```
Credenciales de login para usuarios open-source 
user-open-source
password-open-source
```
## Frontend
### Node
```
La versión de node que se instala para el clean install es v10.16.0, la versión de npm no hace falta definirla
```
### Comandos Vue
```
npm install
npm run serve
npm run build
npm run lint
```
Fuentes de http://materialdesignicons.com/

### El módulo
```
El módulo launcher setea window.t_manager_access_token con su token de acceso y window.t_manager_access_token_validity con el tiempo de validez de este.

Si es un módulo nuevo y está incluido en el launcher, también hay que añadir que el módulo está ensamblado en el launcher con el objeto window.isModuleEnsambled con module:valor => {'t-manager-MODULE': true} para que luego el modulo pueda verificar si está o no incluido para asi llamar al servicio de recuperar el token por su cuenta o cogerlo de window.t_manager_access_token.

En el index.html tiene que existir un div con el id de store.state.module, osea el nombre del módulo que decidamos.

El main.js es el encargado de cargar e inicializar el frontend, en él se usa la librería común t-manager-commons para instalar componentes Vue, inicializar el refresco de token de oauth2 y la clase de Vuetify con los estilos del commons. Hace falta definir window.Vue = WindowVue y volver a ponerlo a nulo porque la libreria común del t-manager-commons es una libreria de Vue que espera que window.Vue esté seteado, pero luego los componentes se instalan en la instancia de Vue que se va a utilizar en este modulo; ya que al poder ir embebido en otra aplicación esto se tiene que diferenciar.

Los js router y store verifican que si la dependencia que van a usar esta ya en el objeto de Vue, no se use, esto también es para prevenir errores de plugins cargados más de una vez.
```
## Backend
EXPLICACION ARQUITECTURA HEXAGONAL
### Locale
```
En la clase WebMvcConfigurer se define el locale resolver, que en cada petición que recibe busca la cabecera "Accept-language" para definir el locale en el que tiene que mostrar los mensajes. Esta cabecera se setea gracias a un interceptor de Axios en el main.js del frontend.
```
### Gestión de excepciones
```
Las excepciones se recogen en CustomExceptionHandler, aquí es donde se transforman a CustomException para que el frontend reciba siempre los mismos campos independientemente del tipo de error.
```
#### Timeout
```
El timeout está gestionado con el filtro TimeoutFilter en el proyecto web, este corta el hilo según el valor definido de "module.timeoutValue" en el application.yml (5000ms por defecto).
```
#### Validaciones
```
Las rutas y objetos que se reciben en las peticiones se validacion con la anotación @Valid y en caso de no pasarla, el CustomExceptionHandler lo detecta, para un ejemplo ver el caso de createFoo en el proyecto web, donde recibe un objeto CreateFooWeb y el valor name es obligatorio, a su vez, se le dice la etiqueta a mostrar en el locale adecuado. Es una capa más de validación, ya que el frontend tambien valida esto.
```
### Seguridad
#### Spring
```
Solo se securizan las rutas que contengan "/api/*" o "/api/**", todo lo demás es público, esto se debe a que la aplicación (en el frontend) usa el modo history, evitando así tener que usar los # en el path, por lo que si se quiere acceder por ejemplo a la ruta /home, esta no puede estar securizada; además, todas las peticiones que no sean de api, ni de swagger, ni de recursos, se redirigen al index.html, para así poder copiar y pegar rutas en el navegador y no tener problema.
```
#### Datos de keystore
```
keystore name: t-manager
keypass: t-manager-password
store pass: t-manager-password
```
#### A tener en cuenta con OAUTH2
```
El resourceId dado de alta en users de mongo tiene que tener el mismo que la aplicacion module en OAuth2ResourceServerConfigJwt -> config.resourceId("foo");
```
### CORS
```
Al tratarse de una SPA con intención de ser usada como microservicio y microfrontend, el CORS debe permitir absolutamente todo, ya que en caso de que un usuario no identificado quiera acceder a un recurso del api no podrá por no tener el token de autenticación.
```
## Swagger
```
El swagger está montado para soportar Oauth2, por lo que en caso de querer llamar al API hay que loguearse en el icono de candado y luego añadir los parametros necesarios a la petición.
http://localhost:8002/module/swagger-ui.html
```
