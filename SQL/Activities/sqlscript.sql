REM   Sql Activities - Alchemy

CREATE TABLE Salesman (  
    salesman_id int NOT NULL,  
    salesman_name varchar(20),  
    salesman_city varchar(32),  
    commission int,  
);

CREATE TABLE Salesman (  
    salesman_id int NOT NULL,  
    salesman_name varchar(20),  
    salesman_city varchar(32),  
    commission int 
);

DESCRIBE salesman


INSERT ALL  
    INTO Salesman VALUES (5001, 'James Hoog', 'New York', 15)  
	INTO Salesman VALUES (5002, 'Nail Knite', 'Paris', 13)  
    INTO Salesman VALUES (5005, 'Pit Alex', 'London', 11)  
    INTO Salesman VALUES (5006, 'McLyon', 'Paris', 14)  
    INTO Salesman VALUES (5007, 'Paul Adam', 'Rome', 13) 
    INTO Salesman VALUES (5003, 'Lauson Hen', 'San Jose', 12) 
SELECT 1 FROM DUAL;

SELECT * FROM SALESMAN;

SELECT SALESMAN_ID, SALESMAN_CITY FROM SALESMAN;

SELECT * FROM SALESMAN WHERE SALESMAN_CITY = 'PARIS';

SELECT * FROM SALESMAN WHERE SALESMAN_CITY = 'Paris';

SELECT SALESMAN_ID, SALESMAN_CITY FROM SALESMAN;

SELECT SALESMAN_ID, COMMISSION FROM SALESMAN WHERE SALESMAN_NAME = 'Paul Adam';

ALTER TABLE SALESMAN ADD GRADE INT;

UPDATE SALESMAN SET GRADE = 100;

SELECT * FROM SALESMAN;

UPDATE SALESMAN SET GRADE = 200 WHERE SALESMAN_CITY = 'Rome';

SELECT * FROM SALESMAN;

UPDATE SALESMAN SET GRADE = 300 WHERE SALESMAN_NAME = 'James Hoog';

SELECT * FROM SALESMAN;

UPDATE SALESMAN SET SALESMAN_NAME = 'Pierre' WHERE SALESMAN_ID = 5006;

SELECT * FROM SALESMAN;

create table orders( 
    order_no int primary key, purchase_amount float, order_date date, 
    customer_id int, salesman_id int);

INSERT ALL 
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002)  
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005) 
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002) 
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001) 
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006) 
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002) 
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007) 
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001) 
SELECT 1 FROM DUAL;

SELECT * FROM orders;

SELECT DISTINCT salesman_id FROM ORDERS;

SELECT * FROM orders;

SELECT * FROM ORDERS ORDER BY ORDER_DATE;

SELECT ORDER_NO FROM ORDERS ORDER BY ORDER_DATE;

SELECT ORDER_NO, ORDER_DATE FROM ORDERS ORDER BY ORDER_DATE;

SELECT * FROM orders;

SELECT ORDER_NO, PURCHASE_AMOUNT FROM ORDERS ORDER BY PURCHASE_AMOUNT DESC;

SELECT * FROM ORDERS WHERE PURCHASE_AMOUNT<500;

SELECT * FROM ORDERS WHERE PURCHASE_AMOUNT BETWEEN 1000 AND 2000;

SELECT SUM(PURCHASE_AMOUNT) FROM ORDERS;

SELECT AVG(PURCHASE_AMOUNT) FROM ORDERS;

SELECT MAX(PURCHASE_AMOUNT) FROM ORDERS;

SELECT MIN(PURCHASE_AMOUNT) FROM ORDERS;

SELECT * FROM orders;

SELECT DISTINCT COUNT(SALESMAN_ID) FROM ORDERS;

SELECT  COUNT( DISTINCT SALESMAN_ID) FROM ORDERS;

SELECT * FROM orders;

SELECT * FROM ORDERS 
GROUP BY CUSTOMER_ID ;

SELECT CUSTOMER_ID, MAX(PURCHASE_AMOUNT) FROM ORDERS 
GROUP BY CUSTOMER_ID ;

SELECT * FROM ORDERS;

SELECT CUSTOMER_ID, MAX(PURCHASE_AMOUNT) FROM ORDERS 
WHERE ORDER_DATE = '2012-08-17' 
GROUP BY CUSTOMER_ID;

SELECT * FROM ORDERS;

SELECT CUSTOMER_ID, MAX(PURCHASE_AMOUNT) FROM ORDERS 
WHERE ORDER_DATE = '17-AUG-12' 
GROUP BY CUSTOMER_ID;

SELECT salesman_id, order_date, MAX(purchase_amount) AS "Max Amount" FROM orders  
WHERE order_date=To_DATE('2012/08/17', 'YYYY/MM/DD') GROUP BY salesman_id, order_date;

SELECT SALESMAN_ID, MAX(PURCHASE_AMOUNT) FROM ORDERS 
WHERE ORDER_DATE = '17-AUG-12' 
GROUP BY CUSTOMER_ID;

SELECT SALESMAN_ID, MAX(PURCHASE_AMOUNT) FROM ORDERS 
WHERE ORDER_DATE = '17-AUG-12' 
GROUP BY SALESMAN_ID;

SELECT CUSTOMER_ID , MAX(PURCHASE_AMOUNT) FROM ORDERS 
WHERE MAX(PURCHASE_AMOUNT) IN (2030, 3450, 5760, 6000) 
GROUP BY CUSTOMER_ID;

SELECT CUSTOMER_ID , MAX(PURCHASE_AMOUNT) FROM ORDERS 
GROUP BY CUSTOMER_ID 
HAVING MAX(PURCHASE_AMOUNT) IN (2030, 3450, 5760, 6000);

SELECT customer_id, order_date, MAX(purchase_amount) AS "Max Amount" FROM orders 
GROUP BY customer_id, order_date 
HAVING MAX(purchase_amount) IN(2030, 3450, 5760, 6000);

create table customers ( 
    customer_id int primary key, customer_name varchar(32), 
    city varchar(20), grade int, salesman_id int);

INSERT ALL 
    INTO customers VALUES (3002, 'Nick Rimando', 'New York', 100, 5001) 
    INTO customers VALUES (3007, 'Brad Davis', 'New York', 200, 5001) 
    INTO customers VALUES (3005, 'Graham Zusi', 'California', 200, 5002) 
    INTO customers VALUES (3008, 'Julian Green', 'London', 300, 5002) 
    INTO customers VALUES (3004, 'Fabian Johnson', 'Paris', 300, 5006) 
    INTO customers VALUES (3009, 'Geoff Cameron', 'Berlin', 100, 5003) 
    INTO customers VALUES (3003, 'Jozy Altidor', 'Moscow', 200, 5007) 
    INTO customers VALUES (3001, 'Brad Guzan', 'London', 300, 5005) 
SELECT 1 FROM DUAL;

SELECT * FROM CUSTOMERS;

SELECT * FROM ORDERS;

SELECT O.SALESMAN_ID, C.CUSTOMERS  
FROM ORDERS O, CUSTOMERS C 
WHERE 0.CUSTOMER_ID = C.CUSTOMER_ID;

SELECT * FROM CUSTOMERS;

SELECT * FROM ORDERS;

SELECT * FROM CUSTOMERS;

SELECT * FROM SALESMAN;

SELECT * FROM CUSTOMERS;

SELECT S.SALESMAN_ID, C.CUSTOMERS_ID 
FROM CUSTOMERS C 
INNER JOIN SALESMAN S 
ON C.SALESMAN_ID = S.SALESMAN_ID;

SELECT * FROM CUSTOMERS;

SELECT S.SALESMAN_ID, C.CUSTOMER_ID 
FROM CUSTOMERS C 
INNER JOIN SALESMAN S 
ON C.SALESMAN_ID = S.SALESMAN_ID;

SELECT * FROM ORDERS;

SELECT * FROM CUSTOMERS;

SELECT * FROM SALESMAN;

SELECT * FROM CUSTOMERS;

SELECT * FROM SALESMAN;

SELECT S.SALESMAN_ID, S.GRADE  
FROM SALESMAN S 
LEFT JOIN CUSTOMERS C 
ON S.SALESMAN_ID = C.SALESMAN_ID;

SELECT S.SALESMAN_ID, S.GRADE  
FROM SALESMAN S 
LEFT JOIN CUSTOMERS C 
ON S.SALESMAN_ID = C.SALESMAN_ID 
HAVING GRADE < 300;

SELECT S.SALESMAN_ID, S.GRADE  
FROM SALESMAN S 
LEFT JOIN CUSTOMERS C 
ON S.SALESMAN_ID = C.SALESMAN_ID 
WHERE S.GRADE < 300;

CREATE TABLE Salesman (  
    salesman_id int NOT NULL,  
    salesman_name varchar(20),  
    salesman_city varchar(32),  
    commission int 
);

DESCRIBE salesman


INSERT ALL  
    INTO Salesman VALUES (5001, 'James Hoog', 'New York', 15)  
	INTO Salesman VALUES (5002, 'Nail Knite', 'Paris', 13)  
    INTO Salesman VALUES (5005, 'Pit Alex', 'London', 11)  
    INTO Salesman VALUES (5006, 'McLyon', 'Paris', 14)  
    INTO Salesman VALUES (5007, 'Paul Adam', 'Rome', 13) 
    INTO Salesman VALUES (5003, 'Lauson Hen', 'San Jose', 12) 
SELECT 1 FROM DUAL;

SELECT * FROM SALESMAN;

SELECT SALESMAN_ID, SALESMAN_CITY FROM SALESMAN;

SELECT * FROM SALESMAN WHERE SALESMAN_CITY = 'Paris';

SELECT SALESMAN_ID, COMMISSION FROM SALESMAN WHERE SALESMAN_NAME = 'Paul Adam';

ALTER TABLE SALESMAN ADD GRADE INT;

UPDATE SALESMAN SET GRADE = 100;

SELECT * FROM SALESMAN;

UPDATE SALESMAN SET GRADE = 200 WHERE SALESMAN_CITY = 'Rome';

UPDATE SALESMAN SET GRADE = 300 WHERE SALESMAN_NAME = 'James Hoog';

UPDATE SALESMAN SET SALESMAN_NAME = 'Pierre' WHERE SALESMAN_ID = 5006;

SELECT * FROM SALESMAN;

create table orders( 
    order_no int primary key, purchase_amount float, order_date date, 
    customer_id int, salesman_id int);

INSERT ALL 
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002)  
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005) 
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002) 
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001) 
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006) 
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002) 
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007) 
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001) 
SELECT 1 FROM DUAL;

SELECT * FROM orders;

SELECT DISTINCT salesman_id FROM ORDERS;

SELECT ORDER_NO, ORDER_DATE FROM ORDERS ORDER BY ORDER_DATE;

SELECT ORDER_NO, PURCHASE_AMOUNT FROM ORDERS ORDER BY PURCHASE_AMOUNT DESC;

SELECT * FROM ORDERS WHERE PURCHASE_AMOUNT<500;

SELECT * FROM ORDERS WHERE PURCHASE_AMOUNT BETWEEN 1000 AND 2000;

SELECT SUM(PURCHASE_AMOUNT) FROM ORDERS;

SELECT AVG(PURCHASE_AMOUNT) FROM ORDERS;

SELECT MAX(PURCHASE_AMOUNT) FROM ORDERS;

SELECT MIN(PURCHASE_AMOUNT) FROM ORDERS;

SELECT  COUNT( DISTINCT SALESMAN_ID) FROM ORDERS;

SELECT CUSTOMER_ID, MAX(PURCHASE_AMOUNT) FROM ORDERS 
GROUP BY CUSTOMER_ID ;

SELECT SALESMAN_ID, MAX(PURCHASE_AMOUNT) FROM ORDERS 
WHERE ORDER_DATE = '17-AUG-12' 
GROUP BY SALESMAN_ID;

SELECT CUSTOMER_ID , MAX(PURCHASE_AMOUNT) FROM ORDERS 
GROUP BY CUSTOMER_ID 
HAVING MAX(PURCHASE_AMOUNT) IN (2030, 3450, 5760, 6000);

create table customers ( 
    customer_id int primary key, customer_name varchar(32), 
    city varchar(20), grade int, salesman_id int);

INSERT ALL 
    INTO customers VALUES (3002, 'Nick Rimando', 'New York', 100, 5001) 
    INTO customers VALUES (3007, 'Brad Davis', 'New York', 200, 5001) 
    INTO customers VALUES (3005, 'Graham Zusi', 'California', 200, 5002) 
    INTO customers VALUES (3008, 'Julian Green', 'London', 300, 5002) 
    INTO customers VALUES (3004, 'Fabian Johnson', 'Paris', 300, 5006) 
    INTO customers VALUES (3009, 'Geoff Cameron', 'Berlin', 100, 5003) 
    INTO customers VALUES (3003, 'Jozy Altidor', 'Moscow', 200, 5007) 
    INTO customers VALUES (3001, 'Brad Guzan', 'London', 300, 5005) 
SELECT 1 FROM DUAL;

SELECT * FROM ORDERS;

SELECT * FROM CUSTOMERS;

SELECT * FROM SALESMAN;

SELECT S.SALESMAN_ID, C.CUSTOMER_ID 
FROM CUSTOMERS C 
INNER JOIN SALESMAN S 
ON C.SALESMAN_ID = S.SALESMAN_ID;

SELECT S.SALESMAN_ID, S.GRADE  
FROM SALESMAN S 
LEFT JOIN CUSTOMERS C 
ON S.SALESMAN_ID = C.SALESMAN_ID 
ORDER BY SALESMAN_ID 
WHERE S.GRADE < 300;

SELECT S.SALESMAN_ID, S.GRADE  
FROM SALESMAN S 
LEFT JOIN CUSTOMERS C 
ON S.SALESMAN_ID = C.SALESMAN_ID 
ORDER BY SALESMAN_ID 
WHERE S.GRADE < 300;

SELECT S.SALESMAN_ID, S.GRADE  
FROM SALESMAN S 
LEFT JOIN CUSTOMERS C 
ON S.SALESMAN_ID = C.SALESMAN_ID 
WHERE S.GRADE < 300 
ORDER BY SALESMAN_ID;

SELECT a.customer_name, a.city, a.grade, b.name AS "Salesman", b.city FROM customers a  
LEFT OUTER JOIN salesman b ON a.salesman_id=b.salesman_id WHERE a.grade<300  
ORDER BY a.customer_id;

SELECT a.customer_name, a.city, a.grade, b.name AS "Salesman" FROM customers a  
LEFT OUTER JOIN salesman b ON a.salesman_id=b.salesman_id WHERE a.grade<300  
ORDER BY a.customer_id;

SELECT a.customer_name, a.city, a.grade AS "Salesman" FROM customers a  
LEFT OUTER JOIN salesman b ON a.salesman_id=b.salesman_id WHERE a.grade<300  
ORDER BY a.customer_id;

SELECT C.CUSTOMERS_NAME, C.GRADE  
FROM CUSTOMERS C 
LEFT JOIN SALESMAN S 
ON S.SALESMAN_ID = C.SALESMAN_ID 
WHERE C.GRADE < 300 
ORDER BY C.CUSTOMER_ID;

SELECT C.CUSTOMER_NAME, C.GRADE  
FROM CUSTOMERS C 
LEFT JOIN SALESMAN S 
ON S.SALESMAN_ID = C.SALESMAN_ID 
WHERE C.GRADE < 300 
ORDER BY C.CUSTOMER_ID;

SELECT C.CUSTOMER_NAME, C.GRADE , C.CUSTOMER_ID 
FROM CUSTOMERS C 
LEFT JOIN SALESMAN S 
ON S.SALESMAN_ID = C.SALESMAN_ID 
WHERE C.GRADE < 300 
ORDER BY C.CUSTOMER_ID;

SELECT a.customer_name, a.city, a.grade AS "Salesman" FROM customers a  
LEFT OUTER JOIN salesman b ON a.salesman_id=b.salesman_id WHERE a.grade<300  
ORDER BY a.customer_id;

SELECT a.customer_name, a.city, a.grade AS "Salesman" , A.CUSTOMER_ID FROM customers a  
LEFT OUTER JOIN salesman b ON a.salesman_id=b.salesman_id WHERE a.grade<300  
ORDER BY a.customer_id;

SELECT * FROM ORDERS;

SELECT * FROM CUSTOMERS;

SELECT * FROM SALESMAN;

SELECT a.customer_name AS "Customer Name", a.city, b.name AS "Salesman", b.commission FROM customers a  
INNER JOIN salesman b ON a.salesman_id=b.salesman_id  
WHERE b.commission>12;

SELECT C.CUSTOMER_NAME, S.COMMISSION , C.CUSTOMER_ID 
    FROM CUSTOMERS C 
    INNER JOIN SALESMAN S 
    ON S.SALESMAN_ID = C.SALESMAN_ID 
    WHERE S.COMMISSION > 12;

SELECT a.customer_name AS "Customer Name", a.city, b.name AS "Salesman", b.commission FROM customers a  
INNER JOIN salesman b ON a.salesman_id=b.salesman_id  
WHERE b.commission>12;

SELECT a.customer_name AS "Customer Name", a.city, b.commission FROM customers a  
INNER JOIN salesman b ON a.salesman_id=b.salesman_id  
WHERE b.commission>12;

SELECT C.CUSTOMER_NAME, S.COMMISSION , C.CUSTOMER_ID 
    FROM CUSTOMERS C 
    INNER JOIN SALESMAN S 
    ON S.SALESMAN_ID = C.SALESMAN_ID 
    WHERE S.COMMISSION > 12;

SELECT * FROM SALESMAN;

SELECT O.ORDER_NO, O.ORDER_DATE, O.PURCHASE_AMOUNT, C.CUSTOMER_NAME, S.SALESMAN_NAME 
    FROM ORDERS 0 
    INNER JOIN CUSTOMER C ON C.CUSTOMER_ID = 0.CUSTOMER_ID 
    INNER JOIN SALESMAN S ON S.SALESMAN_ID = O.SALESMAN_ID;

SELECT O.ORDER_NO, O.ORDER_DATE, O.PURCHASE_AMOUNT, C.CUSTOMER_NAME, S.SALESMAN_NAME 
    FROM ORDERS O 
    INNER JOIN CUSTOMER C ON C.CUSTOMER_ID = O.CUSTOMER_ID 
    INNER JOIN SALESMAN S ON S.SALESMAN_ID = O.SALESMAN_ID;

SELECT O.ORDER_NO, O.ORDER_DATE, O.PURCHASE_AMOUNT, C.CUSTOMER_NAME, S.SALESMAN_NAME 
    FROM ORDERS O 
    INNER JOIN CUSTOMERS C ON C.CUSTOMER_ID = O.CUSTOMER_ID 
    INNER JOIN SALESMAN S ON S.SALESMAN_ID = O.SALESMAN_ID;

SELECT a.order_no, a.order_date, a.purchase_amount, b.customer_name AS "Customer Name", b.grade, c.name AS "Salesman", c.commission FROM orders a  
INNER JOIN customers b ON a.customer_id=b.customer_id  
INNER JOIN salesman c ON a.salesman_id=c.salesman_id;

SELECT a.order_no, a.order_date, a.purchase_amount, b.customer_name AS "Customer Name", b.grade,  c.commission FROM orders a  
INNER JOIN customers b ON a.customer_id=b.customer_id  
INNER JOIN salesman c ON a.salesman_id=c.salesman_id;

SELECT * FROM ORDERS WHERE CUSTOMER_ID = 3007;

SELECT * FROM orders 
WHERE salesman_id=(SELECT DISTINCT salesman_id FROM orders WHERE customer_id=3007);

SELECT SALESMAN_ID FROM ORDERS WHERE CUSTOMER_ID = 3007;

SELECT * FROM ORDERS  
    WHERE SALESMAN_ID IN (SELECT SALESMAN_ID FROM ORDERS WHERE CUSTOMER_ID = 3007);

SELECT * FROM orders 
WHERE salesman_id=(SELECT DISTINCT salesman_id FROM orders WHERE customer_id=3007);

SELECT * FROM ORDERS;

SELECT * FROM SALESMAN;

SELECT * FROM ORDERS WHERE SALESMAN_ID IN 
(SELECT SALESMAN_ID FROM SALESMAN WHERE SALESMAN_CITY = 'New York');

SELECT * FROM orders 
WHERE salesman_id IN (SELECT salesman_id FROM salesman WHERE city='New York');

SELECT * FROM orders 
WHERE salesman_id IN (SELECT salesman_id FROM salesman WHERE SALESMAN_CITY='New York');

SELECT * FROM SALESMAN;

SELECT * FROM CUSTOMERS;

SELECT GRADE, COUNT(*) FROM CUSTOMERS 
	GROUP BY GRADE  
    HAVING GRADE >(SELECT AVG(GRADE) FROM CUSTOMERS WHERE CITY='New York');

SELECT MAX(COMMISSION) FROM SALESMAN;

SELECT SALESMAN_ID FROM SALESMAN WHERE COMMISSION IN 
(SELECT MAX(COMMISSION) FROM SALESMAN);

SELECT * FROM ORDERS WHERE SALESMAN)ID IN ( 
SELECT SALESMAN_ID FROM SALESMAN WHERE COMMISSION IN 
(SELECT MAX(COMMISSION) FROM SALESMAN));

SELECT * FROM ORDERS WHERE SALESMAN_ID IN ( 
SELECT SALESMAN_ID FROM SALESMAN WHERE COMMISSION IN 
(SELECT MAX(COMMISSION) FROM SALESMAN));

SELECT order_no, purchase_amount, order_date, salesman_id FROM orders 
WHERE salesman_id IN( SELECT salesman_id FROM salesman 
WHERE commission=( SELECT MAX(commission) FROM salesman));

SELECT customer_id, customer_name FROM customers a 
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.customer_id = b.customer_id) 
UNION 
SELECT salesman_id, name FROM salesman a 
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.salesman_id = b.salesman_id) 
ORDER BY customer_name;

SELECT customer_id, customer_name FROM customers a 
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.customer_id = b.customer_id) 
UNION 
SELECT salesman_id, SALESMAN_NAME FROM salesman a 
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.salesman_id = b.salesman_id) 
ORDER BY customer_name;

SELECT a.salesman_id, name, order_no, 'highest on', order_date FROM salesman a, orders b 
WHERE a.salesman_id=b.salesman_id 
AND b.purchase_amount=(SELECT MAX(purchase_amount) FROM orders c WHERE c.order_date = b.order_date) 
UNION 
SELECT a.salesman_id, name, order_no, 'lowest on', order_date FROM salesman a, orders b 
WHERE a.salesman_id=b.salesman_id 
AND b.purchase_amount=(SELECT MIN(purchase_amount) FROM orders c WHERE c.order_date = b.order_date);

SELECT a.salesman_id, SALESMAN_NAME, order_no, 'highest on', order_date FROM salesman a, orders b 
WHERE a.salesman_id=b.salesman_id 
AND b.purchase_amount=(SELECT MAX(purchase_amount) FROM orders c WHERE c.order_date = b.order_date) 
UNION 
SELECT a.salesman_id, name, order_no, 'lowest on', order_date FROM salesman a, orders b 
WHERE a.salesman_id=b.salesman_id 
AND b.purchase_amount=(SELECT MIN(purchase_amount) FROM orders c WHERE c.order_date = b.order_date);

SELECT a.salesman_id, SALESMAN_NAME, order_no, 'highest on', order_date FROM salesman a, orders b 
WHERE a.salesman_id=b.salesman_id 
AND b.purchase_amount=(SELECT MAX(purchase_amount) FROM orders c WHERE c.order_date = b.order_date) 
UNION 
SELECT a.salesman_id, SALESMAN_NAME, order_no, 'lowest on', order_date FROM salesman a, orders b 
WHERE a.salesman_id=b.salesman_id 
AND b.purchase_amount=(SELECT MIN(purchase_amount) FROM orders c WHERE c.order_date = b.order_date);
