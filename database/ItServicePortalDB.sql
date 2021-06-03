CREATE DATABASE [seng2050_A3];
USE [seng2050_A3];
create login jdbcUser WITH PASSWORD = 'mypassword1';

create USER jdbcUser FOR LOGIN jdbcUser;

GRANT SELECT, INSERT, UPDATE, DELETE to jdbcUser;

CREATE TABLE userAccount (

userName VARCHAR(80) PRIMARY KEY,
passCode CHAR(60),
fistName VARCHAR(80),
lastName VARCHAR(80),
email VARCHAR (80),
contactNumber VARCHAR (80),
userRole VARCHAR (80)
);

CREATE TABLE ticket (

userAssigned VARCHAR (80) FOREIGN KEY REFERENCES userAccount(userName),
ticketID VARCHAR(80),
ticketKeyword VARCHAR (80),
ticketStatus VARCHAR (80),
ticketTitle VARCHAR(80),
ticketOpened VARCHAR (80),
ticketCategory VARCHAR(80),
ticketDescription VARCHAR(500),
);

CREATE TABLE knowledgeBase (

kbTitle VARCHAR (80),
kbCategory VARCHAR (80),
kbTicketSubCategory VARCHAR (80),
kbTicketOpenedTime VARCHAR (80),
kbTicketClosedTime VARCHAR (80),
kbUsername VARCHAR (80),
kbDescription VARCHAR (500),
kbKeyword VARCHAR (80),
kbComment VARCHAR (80),
kbResolution VARCHAR (500)
);

DROP TABLE ticket, userAccount, knowledgeBase;

SELECT * FROM ticket;