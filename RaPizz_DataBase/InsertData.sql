use rapizz;

insert into Pizzasize (namePizzaSize, coefficient) values ('naine', '-1.3');
insert into Pizzasize (namePizzaSize, coefficient) values ('humaine', '1');
insert into Pizzasize (namePizzaSize, coefficient) values ('ogresse', '1.3');

insert into Ingredient (nameIngredient) values ('Tomate');
insert into Ingredient (nameIngredient) values ('Basilic');
insert into Ingredient (nameIngredient) values ('Mozzarella');
insert into Ingredient (nameIngredient) values ('Anchois');
insert into Ingredient (nameIngredient) values ('Origan');
insert into Ingredient (nameIngredient) values ('Jambon');
insert into Ingredient (nameIngredient) values ('Parmesan');
insert into Ingredient (nameIngredient) values ('Poivron');
insert into Ingredient (nameIngredient) values ('Salami');
insert into Ingredient (nameIngredient) values ('Ail');
insert into Ingredient (nameIngredient) values ('Olive');
insert into Ingredient (nameIngredient) values ('Salade');
insert into Ingredient (nameIngredient) values ('Champignon');
insert into Ingredient (nameIngredient) values ('Oeuf');
insert into Ingredient (nameIngredient) values ('Sauce Tomate');

insert into Pizza (namePizza, basePrice) values ('Napolitaine', 15);
insert into Pizza (namePizza, basePrice) values ('Diavola', 14);
insert into Pizza (namePizza, basePrice) values ('Calzone', 12);
insert into Pizza (namePizza, basePrice) values ('Reine', 13.5);
insert into Pizza (namePizza, basePrice) values ('Margherita', 11.5);
insert into Pizza (namePizza, basePrice) values ('Romaine', 14.5);

insert into Compose (idPizza, idIngredient) values (1, 2);
insert into Compose (idPizza, idIngredient) values (1, 4);
insert into Compose (idPizza, idIngredient) values (1, 6);
insert into Compose (idPizza, idIngredient) values (2, 1);
insert into Compose (idPizza, idIngredient) values (2, 2);
insert into Compose (idPizza, idIngredient) values (2, 5);
insert into Compose (idPizza, idIngredient) values (3, 8);
insert into Compose (idPizza, idIngredient) values (3, 1);
insert into Compose (idPizza, idIngredient) values (4, 3);
insert into Compose (idPizza, idIngredient) values (4, 5);
insert into Compose (idPizza, idIngredient) values (4, 4);
insert into Compose (idPizza, idIngredient) values (4, 10);
insert into Compose (idPizza, idIngredient) values (5, 12);
insert into Compose (idPizza, idIngredient) values (5, 14);
insert into Compose (idPizza, idIngredient) values (6, 7);
insert into Compose (idPizza, idIngredient) values (6, 11);
insert into Compose (idPizza, idIngredient) values (6, 15);

insert into Person (namePerson, surnamePerson, birthDate, mail, pwd, phone, address, ville, postalCode) values ('Loutre', 'Maurice', '2000-04-01', 'maurice@free.fr', 'test1', '06 04 02 05 01', '2 rue Moule', 'Paris', 75001);
insert into Person (namePerson, surnamePerson, birthDate, mail, pwd, phone, address, ville, postalCode) values ('Lacasse', 'Philipe', '1998-06-08', 'philipe@free.fr', 'test2', '06 42 08 05 81', '4 avenue Caulard', 'Paris', 75001);
insert into Person (namePerson, surnamePerson, birthDate, mail, pwd, phone, address, ville, postalCode) values ('lof', 'Lucas', '1998-02-25', 'lucas@free.fr', 'test3', '06 78 12 01 22', '5 rue LaPinte', 'Saint-Denis', 93066);
insert into Person (namePerson, surnamePerson, birthDate, mail, pwd, phone, address, ville, postalCode) values ('Pato', 'Daniel', '2002-11-12', 'daniel@gmail.com', 'test4', '07 58 15 43 02', '6 avenue Lepo', 'Courbevoie', 92026);
insert into Person (namePerson, surnamePerson, birthDate, mail, pwd, phone, address, ville, postalCode) values ('Ban', 'Mohamed', '2001-04-13', 'mohamed@gmail.com', 'test5', '06 52 89 72 43', '15 rue Lamal', 'Paris', 75010);
insert into Person (namePerson, surnamePerson, birthDate, mail, pwd,  phone, address, ville, postalCode) values ('Mobon', 'Rachel', '1995-09-02', 'rachel@free.fr', 'test6', '07 02 12 15 36', '18 rue Malo', 'Paris', 75009);
insert into Person (namePerson, surnamePerson, birthDate, mail, pwd, phone, address, ville, postalCode) values ('Polard', 'Julie', '2010-01-14', 'julie@free.fr', 'test7', '06 59 64 72 30', '25 avenue Poulin', 'La Courneuve', 93120);
insert into Person (namePerson, surnamePerson, birthDate, mail, pwd, phone, address, ville, postalCode) values ('Boulieud', 'Marc', '1998-06-23', 'marc@gmail.com', 'test8', '07 15 12 38 45', '14 Boulevard Tulin', 'Paris', 75014);

insert into vehicle (plateNumber, typeVehicle) values ('AA-123-PR', 'motor');
insert into vehicle (plateNumber, typeVehicle) values ('AB-115-XV', 'car');
insert into vehicle (plateNumber, typeVehicle) values ('DB-025-AF', 'car');
insert into vehicle (plateNumber, typeVehicle) values ('XC-983-FR', 'motor');

insert into Deliverer (idDeliverer) values (1);
insert into Deliverer (idDeliverer) values (8);
insert into Deliverer (idDeliverer) values (5);

insert into Customer (idCustomer, balance) values (2, default);
insert into Customer (idCustomer, balance) values (3, 20);
insert into Customer (idCustomer, balance) values (4, 45.5);
insert into Customer (idCustomer, balance) values (6, 10.5);
insert into Customer (idCustomer, balance) values (7, default);

insert into Orderpizza (idPizza, idDeliverer, idCustomer, PlateNumber, namePizzaSize, timeDelivery, dateOrder) values (1, 1, 2, 'AA-123-PR', 'humaine', '00:15:12', default);
insert into Orderpizza (idPizza, idDeliverer, idCustomer, PlateNumber, namePizzaSize, timeDelivery, dateOrder) values (6, 8, 4, 'DB-025-AF', 'naine', '00:35:20', default);
insert into Orderpizza (idPizza, idDeliverer, idCustomer, PlateNumber, namePizzaSize, timeDelivery, dateOrder) values (5, 8, 7, 'AA-123-PR', 'humaine', '00:14:05', default);
insert into Orderpizza (idPizza, idDeliverer, idCustomer, PlateNumber, namePizzaSize, timeDelivery, dateOrder) values (1, 1, 4, 'DB-025-AF', 'ogresse', '00:40:59', default);
insert into Orderpizza (idPizza, idDeliverer, idCustomer, PlateNumber, namePizzaSize, timeDelivery, dateOrder) values (5, 5, 2, 'XC-983-FR', 'humaine', '00:10:56', default);

