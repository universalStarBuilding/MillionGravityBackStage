CREATE TABLE `lu_user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(32) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `user_type` INT NOT NULL,
  `qq` INT NULL,
  `cellphone` INT NULL,
  `send_email` TINYINT(1) NULL DEFAULT 0,
  `send_phone` TINYINT(1) NULL DEFAULT 0,
  `send_private` TINYINT(1) NULL DEFAULT 1,
  `info_complete` TINYINT(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`));

  CREATE TABLE `person` (
    `user_id` INT NOT NULL,
    `real_name` VARCHAR(32) NULL,
    `sex` TINYINT(1) NULL,
    `birthday` DATE NULL,
    `certification_no` NVARCHAR(20) NULL,
    `photo` VARCHAR(45) NULL,
    UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC),
    CONSTRAINT `fk_person_1`
      FOREIGN KEY (`user_id`)
      REFERENCES `lu_user` (`id`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);

  CREATE TABLE `organization` (
    `org_id` INT NOT NULL,
    `org_name` VARCHAR(64) NULL,
    `org_registration_no` VARCHAR(64) NULL,
    `org_icon` VARCHAR(500) NULL,
    `registration_photo` VARCHAR(500) NULL,
    UNIQUE INDEX `org_id_UNIQUE` (`org_id` ASC),
    CONSTRAINT `fk_organization_1`
      FOREIGN KEY (`org_id`)
      REFERENCES `lu_user` (`id`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);

  CREATE TABLE `lu_role` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `role_name` VARCHAR(32) NOT NULL,
    `role_privilege` INT NOT NULL,
    PRIMARY KEY (`id`));