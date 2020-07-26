CREATE TABLE library (
    id int NOT NULL AUTO_INCREMENT,
    user_id int NOT NULL,
    book_id int NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE,
    created_user varchar(250),
    created_date_time DATE,
    modified_user varchar(250),
    modified_date_time DATE,
    version BIGINT,
    PRIMARY KEY (id)
); 