CREATE TABLE Survey(
	survey_id INT NOT NULL AUTO_INCREMENT,
	owner_id INT,
	survey_name VARCHAR(50) NOT NULL,
	email VARCHAR(254) NOT NULL,
	create_date TIMESTAMP,
	PRIMARY KEY (survey_id)
) CHARACTER SET UTF8;
 
CREATE TABLE Question(
	question_id INT NOT NULL AUTO_INCREMENT,
	survey_id INT NOT NULL,
	question_type INT NOT NULL,
	question_text VARCHAR(100) NOT NULL,
	question_order INT NOT NULL,
	PRIMARY KEY (question_id),
	FOREIGN KEY (survey_id) REFERENCES Survey(survey_id)
) CHARACTER SET UTF8;

CREATE TABLE AnswerChoice(
	achoice_id INT NOT NULL AUTO_INCREMENT,
	question_id INT NOT NULL,
	achoice_text VARCHAR(100) NOT NULL,
	PRIMARY KEY (achoice_id),
	FOREIGN KEY (question_id) REFERENCES Question(question_id)
) CHARACTER SET UTF8;

CREATE TABLE Answer(
    	answer_id INT NOT NULL AUTO_INCREMENT,
   	question_id INT NOT NULL,
   	achoice_id INT,
   	answer_text varchar(3000),
	PRIMARY KEY (answer_id),
   	FOREIGN KEY (question_id) REFERENCES Question(question_id),
   	FOREIGN KEY (achoice_id) REFERENCES AnswerChoice(achoice_id)
) CHARACTER SET UTF8;

CREATE TABLE Keyword(
	keyword_id INT NOT NULL AUTO_INCREMENT,
	question_id INT NOT NULL,
	keyword_text VARCHAR(25) NOT NULL,
	PRIMARY KEY (keyword_id),
	FOREIGN KEY (question_id) REFERENCES Question(question_id)
) CHARACTER SET UTF8;
