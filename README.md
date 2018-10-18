# Parcial 2 ARSW

- Heroku link: https://arws-2-parcial.herokuapp.com

- [X] El cliente Web debe ser un cliente asíncrono que use servicios REST desplegados en Heroku y use Json como formato para los mensajes.
- [X] El servidor de Heroku servirá como un gateway para encapsular llamadas a otros servicios Web externos.
- [X] La aplicación debe ser multiusuario.
- [X] Todos los protocolos de comunicación serán sobre HTTP.
- [X] Los formatos de los mensajes de intercambio serán siempre JSON.
- [X] La interfaz gráfica del cliente debe ser los más limpia y agradable posible y debe utilizar Bootstrap. Para invocar métodos REST desde el cliente usted puede utilizar la tecnología que desee.
- [ ] Debe construir un cliente Java que permita probar las funciones tanto el servidor fachada. El cliente utiliza simples conexiones http para conectarse a los servicios. Este cliente debe hacer pruebas de concurrencia en su servidor Spring.
- [ ] La fachada de servicios tendrá un caché que permitirá que llamados que ya se han realizado a las implementaciones concretas con parámetros específicos no se realicen nuevamente. Recuerde que el caché es una simple estructura de datos.
- [X] Se debe poder extender fácilmente, por ejemplo, es fácil agregar nuevas funcionalidades, o es fácil cambiar el proveedor de una funcionalidad.
- [X] Debe utilizar maven para gestionar el ciclo de vida, git y github para almacenar al código fuente y Heroku como plataforma de producción.
