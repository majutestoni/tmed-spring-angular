CREATE TABLE appointments(
    id bigint not null AUTO_INCREMENT,
    doctor_id bigint,
    patient_id bigint,
    dateA date,
    timeA time,
    foreign key(doctor_id) references doctors(id),
    foreign key(patient_id) references patients(id),
    primary key(id)
);
