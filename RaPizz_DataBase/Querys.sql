use rapizz;

#1 Objectif Système :

#Vérifier le solde du client
# Dans  l'application on passera un id choisi
select balance from customer where idCustomer=2;
#Facturation Client
#Exemple
# Dans  l'application on passera le bon prix et un id choisi
update Customer set balance = balance - 0 where idCustomer=2;

#Chiffe d'affaire
select sum(orders) as CA from (select sum(pizza.basePrice * coefficient) as orders from pizza inner join orderpizza o on pizza.idPizza = o.idPizza inner join pizzasize p on o.namePizzaSize = p.namePizzaSize where coefficient > 0 union select sum(pizza.basePrice / ABS(coefficient)) as orders from pizza inner join orderpizza o on pizza.idPizza = o.idPizza inner join pizzasize p on o.namePizzaSize = p.namePizzaSize where coefficient < 0) as TotalOrders;

#Vérifier si le client a le solde pour payer
# If balance < pricePizza not getOrder

#Vérifier la fidélité du client, si count(order) % 10 == 0. On vérifie s'il a atteint 10 commandes.
# Dans  l'application on passera un id choisi
select c.idCustomer, namePerson, surnamePerson, count(idOrderPizza) as fidelity from orderpizza inner join customer c on orderpizza.idCustomer = c.idCustomer inner join person p on c.idCustomer = p.idPerson where c.idCustomer =  2;

#2 Statistiques activité :

# Récupération meilleur client
select idCustomer, namePerson, surnamePerson, birthDate, mail, phone, address, ville, postalCode, balance,  max(Orders) from (select c.idCustomer, namePerson, surnamePerson, birthDate, mail, phone, address, ville, postalCode, balance,  count(idOrderPizza) as Orders from orderpizza inner join customer c on orderpizza.idCustomer = c.idCustomer inner join person p on c.idCustomer = p.idPerson group by 1) as Orders;

#Récupération plus mauvais livreur et matériel utilisé
select d.idDeliverer, namePerson, surnamePerson, birthDate, mail, phone, address, ville, postalCode , max(timeDelivery) as Delays, typeVehicle, o.plateNumber from orderpizza as o inner join deliverer d on o.idDeliverer = d.idDeliverer inner join person p on d.idDeliverer = p.idPerson inner join vehicle v on o.plateNumber = v.plateNumber;

#Récupération de la pizza la plus commandé
select p.idPizza, namePizza, basePrice, count(orderpizza.idPizza) as mostRequetedPizza from orderpizza inner join pizza p on orderpizza.idPizza = p.idPizza group by 1 order by mostRequetedPizza desc limit 1;

#Récupération de la pizza la moins commandé
select p.idPizza, namePizza, basePrice, count(orderpizza.idPizza) as mostRequetedPizza from orderpizza inner join pizza p on orderpizza.idPizza = p.idPizza group by 1 order by mostRequetedPizza asc limit 1;

#Récupération de l'ingrédient favori
select c.idIngredient, nameIngredient, count(c.idIngredient) as bestIngredient from orderpizza inner join pizza p on orderpizza.idPizza = p.idPizza inner join compose c on p.idPizza = c.idPizza inner join ingredient i on c.idIngredient = i.idIngredient group by 2 order by bestIngredient desc limit 1;

#3 Questions Diverses

#Récupération des véhicules n'ayant jamais servi
select plateNumber, typeVehicle from vehicle where plateNumber not in (select plateNumber from orderpizza);

#Récupération du nombre de commande par client
select c.idCustomer, namePerson, surnamePerson, birthDate, mail, phone, address, ville, postalCode, balance, count(idOrderPizza) as OrderByCustomer from orderpizza inner join customer c on orderpizza.idCustomer = c.idCustomer inner join person p on c.idCustomer = p.idPerson group by 1 order by OrderByCustomer desc;

#Récupération de la moyenne des commandes
select avg(OrderByCustomer) as AvgOrders from (select count(idOrderPizza) as OrderByCustomer from orderpizza inner join customer c on orderpizza.idCustomer = c.idCustomer group by c.idCustomer order by 1 desc) as TableOrderByCustomer ;

#Récupération des clients ayant commandés plus que la moyenne
select idCustomer, namePerson, surnamePerson, birthDate, mail, phone, address, ville, postalCode, balance, OrderByCustomer from (select c.idCustomer, namePerson, surnamePerson, birthDate, mail, phone, address, ville, postalCode, balance, count(idOrderPizza) as OrderByCustomer from orderpizza inner join customer c on orderpizza.idCustomer = c.idCustomer inner join person p on c.idCustomer = p.idPerson group by 1 order by 2 desc) as TableOrderByCustomer where OrderByCustomer > (select avg(OrderByCustomer) from (select count(idOrderPizza) as OrderByCustomer from orderpizza inner join customer c on orderpizza.idCustomer = c.idCustomer group by c.idCustomer order by 1 desc) as TableOrderByCustomer);

#Fiche de Livraison :

#Récupération du livreur en fonction d'un id de livraison. Dans  l'application on passera un id choisi
select namePerson as deliverer, typeVehicle from deliverer inner join person p on deliverer.idDeliverer = p.idPerson inner join orderpizza o on deliverer.idDeliverer = o.idDeliverer inner join vehicle v on o.plateNumber = v.plateNumber where idOrderPizza = 2;

#Récupération du client en fonction d'un id de livraison. Dans  l'application on passera un id choisi
select namePerson as customer from customer inner join person p on customer.idCustomer = p.idPerson inner join orderpizza o on customer.idCustomer = o.idCustomer where idOrderPizza = 2;

#Récupération du retard s'il en un en fonction d'un id de livraison. Dans  l'application on passera un id choisi
select idOrderPizza, subtime(delay, '00:30:00') from (select  idOrderPizza,timeDelivery as delay from orderpizza where timeDelivery > '00:30:00') as TableDelay where idOrderPizza = 2;

#Récupération de la date de commande, du nom de la pizza et du prix de base. Dans  l'application on passera un id choisi
select dateOrder, namePizza, basePrice from orderpizza inner join pizza p on orderpizza.idPizza = p.idPizza where idOrderPizza = 2;

#On fait appel à ces 4 requêtes afin d'avoir toutes les informations pour remplir la fiche de livraison
#On aurait peut être pu passer par une view en fusionnat toutes ces requêtes


drop view if exists Livraison;
create view Livraison as
  select
    namePizza,
    basePrice,
    cast(concat('[', group_concat(json_quote(nameIngredient) separator ','), ']') as json) AS ArrayIngredient
  from pizza inner join compose c on pizza.idPizza = c.idPizza inner join ingredient i on c.idIngredient = i.idIngredient group by pizza.idPizza;

select * from Livraison;

#Menu
select namePizza, basePrice, nameIngredient from pizza inner join compose c on pizza.idPizza = c.idPizza inner join ingredient i on c.idIngredient = i.idIngredient;

drop view if exists Menu;
create view Menu as
  select
    namePizza,
    basePrice,
    cast(concat('[', group_concat(json_quote(nameIngredient) separator ','), ']') as json) AS ArrayIngredient
  from pizza inner join compose c on pizza.idPizza = c.idPizza inner join ingredient i on c.idIngredient = i.idIngredient group by pizza.idPizza;

select * from Menu;
