CREATE TABLE person
(
    id    INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name  VARCHAR        NOT NULL,
    age   INT CHECK (age > 0),
    email VARCHAR UNIQUE NOT NULL
);

INSERT INTO person (name, age, email)
VALUES ('Tom', 18, 'tom@mail.ru'),
       ('Bob', 28, 'bob@mail.ru'),
       ('Bob1', 38, 'bob346@mail.ru'),
       ('Bob2', 45, 'bob34563467@mail.ru');

SELECT P.name name,
       O.item_name
FROM Person AS P,
     Order_ AS O
WHERE P.user_id = O.order_id;

SELECT P.name name,
       O.item_name
FROM Person P
         JOIN Order_ O on P.user_id = O.user_id;

SELECT *
FROM Person AS P
         CROSS JOIN
     Order_ AS O;