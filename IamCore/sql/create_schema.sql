CREATE TABLE IDENTITIES
	(
	IDENTITY_UID INT NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT IDENTITIES_PK PRIMARY KEY, 
	IDENTITY_DISPLAYNAME VARCHAR(255),
	IDENTITY_EMAIL  VARCHAR(255),
	);

