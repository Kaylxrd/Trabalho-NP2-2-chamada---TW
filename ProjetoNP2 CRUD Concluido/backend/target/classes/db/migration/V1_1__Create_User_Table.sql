CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `curso` varchar(100) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_4vih17mube9j7cqyjlfbcrk4m` (`email`),
  ADD UNIQUE KEY `UK_qht682qvopcx5f41dc2rbs5jf` (`login`);

ALTER TABLE `tb_user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
 COMMIT;
  
  
 CREATE TABLE `tb_curso` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `semestres` varchar(255) DEFAULT NULL,
  `vagas` varchar(100) DEFAULT NULL,
  `campus` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `tb_professor` (
   `id` bigint(20) NOT NULL AUTO_INCREMENT,
   `disciplina` varchar(100) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `tb_campus` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`localizacao` varchar(100) DEFAULT NULL,
	`cursos` varchar(100) DEFAULT NULL,
	`laboratorios` varchar(100) DEFAULT NULL,
	`bibliotecas` varchar(100) DEFAULT NULL,
	PRIMARY KEY (`id`)
);



