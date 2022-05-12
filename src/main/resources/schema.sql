DROP TABLE IF EXISTS  book;
CREATE TABLE IF NOT EXISTS book (
                               id INT AUTO_INCREMENT PRIMARY KEY,
                               isbn INT (10) NOT NULL,
                               title VARCHAR(50) NOT NULL,
                               author VARCHAR(20) NOT NULL,
                               date DATE
);
INSERT INTO book(isbn,title,author,date) VALUES (1,'Ramesh','Ahmedabad',CURRENT_DATE);
INSERT INTO book(isbn,title,author,date) VALUES (2,'k2','Ahmedabad',CURRENT_DATE);

/*
DROP TABLE IF EXISTS  employee;
CREATE TABLE IF NOT EXISTS employee(
                                       id INT,
                                       age INT,
                                       hourcount INT,
                                       name VARCHAR(50),
                                       salary DECIMAL,
                                       employer_id INT
);
INSERT INTO employee(id,age,hourcount,name,salary,employer_id) VALUES (1,18,96,'PISTA',720000,55);
*/