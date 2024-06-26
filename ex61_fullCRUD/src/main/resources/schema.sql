CREATE TABLE appointment (
    id SERIAL PRIMARY KEY,
    firstName VARCHAR(255),
    email VARCHAR(255),
    appointmentDate DATE,
    appointmentTime TIME
);
