drop table if EXISTS TODO;

CREATE TABLE TODO(
TODO_ID INT AUTO_INCREMENT PRIMARY KEY,
TITLE VARCHAR(250) NOT NULL,
DETAIL VARCHAR(250),
STATE BOOLEAN NOT NULL
);

INSERT INTO TODO(TODO_ID, TITLE, DETAIL, STATE) values (1, 'Visionner la liste', 'Afficher la liste par ordre decroissant', 1);
INSERT INTO TODO(TODO_ID, TITLE, DETAIL, STATE) values (2, 'Modifier une tache', 'indiquer si la tache a été accomplie ou non', 1);
