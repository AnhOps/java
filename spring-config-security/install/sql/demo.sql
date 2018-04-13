CREATE TABLE `accounts` (
  `account_id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(100) NOT NULL,
  `enabled` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `authorities` (
  `id` int(11) NOT NULL,
  `account_id` int(11) NOT NULL,
  `authority_id` int(11) NOT NULL,
  `authority` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `accounts`
  ADD PRIMARY KEY (`account_id`);

ALTER TABLE `authorities`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_authorities_accounts` (`account_id`);

ALTER TABLE `accounts`
  MODIFY `account_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

ALTER TABLE `authorities`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

ALTER TABLE `authorities`
  ADD CONSTRAINT `fk_authorities_accounts` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`account_id`);
COMMIT;

INSERT INTO `accounts` (`account_id`, `username`, `password`, `email`, `enabled`) VALUES
(1, 'admin', '$2a$10$hbxecwitQQ.dDT4JOFzQAulNySFwEpaFLw38jda6Td.Y/cOiRzDFu', 'admin@mail.com', 1);

INSERT INTO `authorities` (`id`, `account_id`, `authority_id`, `authority`) VALUES
(1, 1, 1, 'ROLE_ADMIN');
