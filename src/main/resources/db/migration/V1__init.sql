CREATE TABLE perfil (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        nombre VARCHAR(50) NOT NULL
);

CREATE TABLE usuario (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         nombre VARCHAR(100) NOT NULL,
                         correoElectronico VARCHAR(150) NOT NULL UNIQUE,
                         contrasena VARCHAR(255) NOT NULL,
                         perfil_id BIGINT,
                         FOREIGN KEY (perfil_id) REFERENCES perfil(id)
);

CREATE TABLE curso (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       nombre VARCHAR(150) NOT NULL,
                       categoria VARCHAR(100)
);

CREATE TABLE topico (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        titulo VARCHAR(255) NOT NULL,
                        mensaje TEXT NOT NULL,
                        fecha_creacion DATETIME NOT NULL,
                        status VARCHAR(30) NOT NULL,
                        autor_id BIGINT NOT NULL,
                        curso_id BIGINT,
                        FOREIGN KEY (autor_id) REFERENCES usuario(id),
                        FOREIGN KEY (curso_id) REFERENCES curso(id)
);

CREATE TABLE respuesta (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           mensaje TEXT NOT NULL,
                           fecha_creacion DATETIME NOT NULL,
                           autor_id BIGINT,
                           topico_id BIGINT,
                           solucion BOOLEAN DEFAULT FALSE,
                           FOREIGN KEY (autor_id) REFERENCES usuario(id),
                           FOREIGN KEY (topico_id) REFERENCES topico(id)
);
