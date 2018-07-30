# Api para AvanzaMas

Con esta API se da solución a la parte BackEnd de la prueba técnica.

1. La ruta "/api/user" Contiene las cuatro operaciones básicas CRUD (Create, Read, Update y Delete) sobre el modelo 

Usuario:
 - id : Identificador
 - cc : Campo cc
 - name : Nombres
 - lastName : Apellidos
 - state : Estado
 
2. La ruta "/api/sale/report" por defecto muestra las ventas en los últimos 6 meses agrupado por meses. Si se proporciona el nombre del país se muestran las ventas por el país indicado y si se proporciona el comprador, las ventas por comprador.

- Paises disponibles: country_0, country_1, country_2
- Compradores disponibles: buyer_0, buyer_1, buyer_2

Enlace de la API: https://api-avanzamas.herokuapp.com/api-avanzamas/swagger-ui.html
