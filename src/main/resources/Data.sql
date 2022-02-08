insert into users (id, name, email)
values (1, 'Siamak', 'Codeengine11@gmail.com'),
       (2, 'John', 'John@john.com'),
       (3, 'Adam', 'adam@adam.com');

insert into category (id, name)
values (1, 'Travel'),
       (2, 'Auto Loan'),
       (3, 'Student Loan');

insert into expense (id, description, expensedate, location, user_id, category_id)
values (1, 'New York Business Trip', '2019-06-16T17:00:00.000Z', 'New York', 1, 1),
       (2, 'Ford Mustang Payment', '2019-06-15T15:00:00.000Z', 'Los Angeles', 2, 2),
       (3, 'Grand Canyon Trip with Friends', '2019-06-14T15:00:00.000Z', 'Arizona', 3, 1);