CREATE TABLE customer
(
    id   int     NOT NULL AUTO_INCREMENT,
    firstname varchar(50) NOT NULL,
    lastname varchar(50),
    username varchar(50),
    email varchar(50),
    password varchar(100),
    PRIMARY KEY (id),

);



CREATE TABLE stock
(
    id         int          NOT NULL AUTO_INCREMENT,
    name   varchar(50)  NOT NULL,
    availablequantity   int NOT NULL,
    price double  NULL,
    category varchar(50) NOT NULL
    PRIMARY KEY (id),

);

CREATE TABLE user_role
(
    id        int         NOT NULL AUTO_INCREMENT,
    user_id   int         NOT NULL,
    role_name varchar(50) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (user_id, role_name),
    FOREIGN KEY (user_id) REFERENCES user (id)
);

CREATE TABLE myorder
(
    id         int          NOT NULL AUTO_INCREMENT,
    order_description   varchar(50)  NOT NULL,
    availablequantity   int NOT NULL,
    price double  NULL,
    category varchar(50) NOT NULL
        PRIMARY KEY (id),

    FOREIGN KEY (user_id) REFERENCES user (id)
);

CREATE TABLE shopping_cart
(
    id         int NOT NULL AUTO_INCREMENT,
    amount       double precision NOT NULL,
    product_name       varchar(50),
    quantity  int NOT NULL ,
    PRIMARY KEY (id),

    FOREIGN KEY (order_id) REFERENCES country (id),
    FOREIGN KEY (product_id) REFERENCES country (id)
);

