INSERT INTO Survey(survey_name, email) VALUES ("Testi", "testi@testi.fi");

INSERT INTO Question(survey_id, question_type, question_text) VALUES(1, 0, "Miltä nyt tuntuu?");

INSERT INTO Survey(survey_name, email) VALUES ("Jukan kysely", "random@testi.fi");

INSERT INTO Question(survey_id, question_type, question_text) VALUES(1, 1, "Onko hyvä fiilis?");

INSERT INTO AnswerChoice(question_id, achoice_text) VALUES(2, "Kyllä"),(2, "Ei"),(2, "En tiedä");

INSERT INTO Answer(question_id, answer_text) VALUES(1, "Ihan OK");
INSERT INTO Answer(question_id, achoice_id) VALUES(2, 1);

INSERT INTO Keyword(question_id, keyword_text) VALUES(1, "feelssit");
INSERT INTO Keyword(question_id, keyword_text) VALUES(2, "feelssit");
