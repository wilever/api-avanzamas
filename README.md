# Api para AvanzaMas

Con esta API se da solución a la parte BackEnd de la prueba técnica.

1. La ruta "/api/user" Contiene las cuatro operaciones básicas CRUD (Create, Read, Update y Delete) sobre el modelo 

Usuario:
 - id : Identificador
 - cc : Campo cc
 - name : Nombres
 - lastName : Apellidos
 - state : Estado
 
2. La ruta "/api/sale/report" por defecto muestra las ventas en los últimos 6 meses agrupado por meses (Cantidad total), si se proporciona el nombre del país se muestran las ventas por paises y si se proporciona el comprador, las ventas por comprador.