-- With an embedded database like H2 this is the default location and file to look at.
-- If we would run something like PostGresSQL we would have to define the location and file
-- explicitly in 'application.properties'
CREATE TABLE IF NOT EXISTS Content (
    id INTEGER AUTO_INCREMENT,
    title varchar(255) NOT NULL,
    desc text,
    status VARCHAR(255) NOT NULL,
    content_type VARCHAR(50) NOT NULL,
    date_created TIMESTAMP NOT NULL,
    date_updated TIMESTAMP,
    url VARCHAR(255),
    primary key (id)
);

-- We could insert data here but now we are doing it in our CalendardemoApplication.java
-- INSERT INTO Content(title, desc, status, content_type, date_created)
-- VALUES ('My Spring Data Blog Post', 'A post about Spring Data', 'IDEA', 'ARTICLE', CURRENT_TIMESTAMP());