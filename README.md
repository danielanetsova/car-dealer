# Name

Car Dealer

## Description

A car dealer needs information about cars, their parts, parts suppliers, customers and sales.
- Cars have to make, model, and traveled distance in kilometers.
- Parts have name, price and quantity.
- Part supplier has name and info on whether he uses imported parts.
- Customer has a name, date of birth and info on whether he/she is a young driver (Young driver is a driver
that has less than 2 years of experience. Those customers get an additional 5% off for the sale).
- Sale has car, customer and discount percentage.
- A price of a car is formed by the total price of its parts.

Using Code First approach create a database following the above description.


## Tasks
### _Car Dealer Import Data_
Import data from the provided files (suppliers, parts, cars, customers in src/main/resources/input_files as xml or as json).
First, import the suppliers. When importing the parts, set to each part a random supplier from the already imported
suppliers. Then, when importing the cars add between 3 and 5 random parts to each car. Then import all
customers. Finally, import the sales records by randomly selecting a car, customer and the amount of discount to
be applied (discounts can be 0%, 5%, 10%, 15%, 20%, 30%, 40% or 50%).

### _Car Dealer Query and Export Data_

* _Query 1 – Ordered Customers_
 
Get all customers, ordered by their birthdate in ascending order. If two customers are born on the same date, first
print those, who are not young drivers (e.g. print experienced drivers first). Export the list of customers to JSON and to XML.
- _Query 2 – Cars from Make Toyota_

Get all cars from make Toyota and order them by model alphabetically and then by traveled distance descending.
Export the list of cars to JSON and to XML.

- _Query 3 – Local Suppliers_

Get all suppliers that do not import parts from abroad. Get their id, name and the number of parts they can offer
to supply. Export the list of suppliers to JSON and to XML.

- _Query 4 – Cars with Their List of Parts_

Get all cars along with their list of parts. For the car get only make, model and traveled distance. For the parts get
only the name and the price. Export the list of cars and their parts to JSON and to XML.

- Query 5 – Total Sales by Customer

Get all customers that have bought at least 1 car and get their names, count of cars bought and total money spent
on cars. Order the result list by total money spent in descending order then by total cars bought again in
descending order. Export the list of customers to JSON and to XML.

- Query 6 – Sales with Applied Discount

Get all sales with information about the car, the customer and the price of the sale with and without discount.
Export the list of sales to JSON and to XML.
