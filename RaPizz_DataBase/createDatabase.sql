drop database Rapizz;
create database Rapizz;

use Rapizz;

create table PizzaSize (
    namePizzaSize varchar(255),
    coefficient float not null,
    constraint pk_idPizzaSize primary key (namePizzaSize),
    constraint ck_namePizzaSize check ( namePizzaSize not like '% %')
);

create table Ingredient (
    idIngredient integer auto_increment,
    nameIngredient varchar(255) not null,
    constraint pk_idIngredient primary key (idIngredient)
);

create table Pizza (
    idPizza integer auto_increment,
    namePizza varchar(255) not null,
    basePrice float,
    constraint pk_idPizza primary key (idPizza),
    constraint ck_basePrice check ( basePrice > 0 )
);

create table Compose(
   idPizza integer not null,
   idIngredient integer not null,
   primary key(idPizza, idIngredient),
   foreign key fk_idPizza (idPizza) references Pizza(idPizza) on update cascade on delete cascade,
   foreign key fk_idIngredient (idIngredient) references Ingredient(idIngredient) on update cascade on delete cascade
);

create table Person (
    idPerson integer auto_increment,
    namePerson varchar(255) not null ,
    surnamePerson varchar(255) not null ,
    birthDate date not null ,
    mail varchar(255) not null unique,
    phone varchar(255) not null ,
    address varchar(255) not null ,
    pwd varchar(255) not null,
    ville varchar(255) not null ,
    postalCode integer not null ,
    constraint pk_idPerson primary key (idPerson)
);

create table Vehicle (
    plateNumber varchar(255),
    typeVehicle enum ('motor', 'car') not null,
    constraint ck_plateNumber check ( plateNumber not like '% %'),
    constraint pk_plateNumber primary key (plateNumber)
);

create table Deliverer (
    idDeliverer integer,
    constraint pk_idDeliverer primary key (idDeliverer),
    constraint fk_idDeliverer foreign key (idDeliverer) references Person(idPerson) on update cascade on delete cascade
);

create table Customer (
    idCustomer integer,
    balance float default 0,
    constraint pk_idCustomer primary key (idCustomer),
    constraint fk_idCustomer foreign key(idCustomer) references Person(idPerson) on update cascade on delete cascade
);

create table OrderPizza (
    idOrderPizza integer auto_increment,
    idPizza integer not null,
    idDeliverer integer not null,
    idCustomer integer not null,
    plateNumber varchar(255) not null,
    namePizzaSize varchar(255) not null,
    timeDelivery time not null ,
    dateOrder datetime default now(),
    constraint pk_idOrderPizza primary key (idOrderPizza),
    constraint fk_idDelivererOrder foreign key(idDeliverer) references Deliverer(idDeliverer) on update cascade on delete cascade,
    constraint fk_idCustomerOrder foreign key (idCustomer) references Customer(idCustomer) on update cascade on delete cascade,
    constraint fk_idPizza foreign key(idPizza) references Pizza(idPizza) on update cascade on delete cascade,
    constraint fk_PlateNumber foreign key (PlateNumber) references Vehicle(PlateNumber) on update cascade on delete cascade,
    constraint fk_idPizzaSize foreign key(namePizzaSize) references PizzaSize(namePizzaSize) on update cascade on delete cascade
);










