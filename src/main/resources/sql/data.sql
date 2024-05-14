INSERT INTO mark (name) VALUES
   ('Lincoln'),
   ('Chery'),
   ('Nissan'),
   ('Bugatti'),
   ('Porsche'),
   ('Audi');

INSERT INTO user (time, firstname, name, lastname, mark_id, application_number) VALUES
    ('06:15:01', 'John', 'Doe', 'developer', 1, 22130),
    ('07:25:02', 'Jane', 'Smith', 'manager', 2, 53230),
    ('08:35:03', 'Mike', 'Johnson', 'analyst', 2, 13120),
    ('09:45:04', 'Emily', 'Brown', 'designer', 4, 53150),
    ('12:55:05', 'Chris', 'Wilson', 'engineer', 5, 76421),
    ('11:05:06', 'Sarah', 'Lee', 'consultant', 5, 1251);

COMMIT;
