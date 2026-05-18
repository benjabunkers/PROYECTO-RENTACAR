CREATE TABLE estados_reserva (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(120) NOT NULL, descripcion VARCHAR(120) NOT NULL,
    orden_flujo INT NOT NULL, requiere_pago BOOLEAN NOT NULL, activo BOOLEAN NOT NULL,
    fecha_creacion DATE NOT NULL);
CREATE TABLE reservas (id INT AUTO_INCREMENT PRIMARY KEY,
    codigo_reserva VARCHAR(120) NOT NULL,
    cliente_id INT NOT NULL,
    vehiculo_id INT NOT NULL, fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    dias INT NOT NULL, total DECIMAL(12,2) NOT NULL,
    activa BOOLEAN NOT NULL, fecha_creacion DATE NOT NULL,
    estado_reserva_id INT NOT NULL);
INSERT INTO estados_reserva (nombre,descripcion,orden_flujo,requiere_pago,activo,fecha_creacion)
VALUES ('Pendiente','Creada',1,false,true,CURRENT_DATE),
       ('Confirmada','Confirmada',2,true,true,CURRENT_DATE),
       ('Finalizada','Cerrada',3,false,true,CURRENT_DATE);
INSERT INTO reservas (codigo_reserva,cliente_id,vehiculo_id,fecha_inicio,fecha_fin,dias,total,activa,fecha_creacion,estado_reserva_id)
VALUES ('RES1',1,1,DATE_ADD(CURRENT_DATE, INTERVAL 3 DAY)
,DATE_ADD(CURRENT_DATE, INTERVAL 6 DAY),3,156000,true,CURRENT_DATE,1)
     ,('RES2',2,2,DATE_ADD(CURRENT_DATE, INTERVAL 5 DAY)
     ,DATE_ADD(CURRENT_DATE, INTERVAL 9 DAY),4,132000,true,CURRENT_DATE,2)
     ,('RES3',3,3,DATE_ADD(CURRENT_DATE, INTERVAL 7 DAY),DATE_ADD(CURRENT_DATE, INTERVAL 10 DAY)
     ,3,210000,true,CURRENT_DATE,2);