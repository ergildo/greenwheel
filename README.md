#Project Brief
The GreenWheel car manufacturer is updating their product line. They have decided to produce a limited run of 200 new products.
GreenWheel has 50 dealerships already selling their cars.
The new vehicles use components from existing cars.
You have been tasked with gathering the components for the new vehicle line and distributing the completed 200 cars to the dealerships.
GreenWheel new product names:
BigGreenAutoCar
SmallGreenMini
MediumGreenSaloon
GreenBus
Existing Cars:
GreenWheelX1, GreenWheelX2, GreenWheelX3, GreenWheelX4, GreenWheelX5
GreenWheelX6, GreenWheelX7, GreenWheelX8, GreenWheelX9, GreenWheelX10
Existing Car details:
name: (GreenWheelX2 / GreenWheelX9 etc.)
vinNumber: (vehicle id)
gearbox: (5 / 6 / 8 speed)
transmission: (automatic / manual / NA)
engineType: (diesel / petrol / electric)
engineSize: (1.0 litre to 4.0 litre(petrol or diesel) 50 hp to 140 hp (electric))
numberOfDoors (2 to 5)
wheelSize (16 to 20 inch alloys)
colour (any colour you like)
Example output of existing car:
GreenWheelX5 (vin : 12)
2.5 litre petrol engine, 6 speed automatic transmission
20 inch alloy wheels, 3 doors, in cherry red.
Rules for new Vehicle:
(1) A new vehicle cannot use more than two components from any one existing car.
i.e - a gearbox and engine type from GreenWheelX1(vin:15) (that is the maximum we can take
from that particular GreenWheelX1(vin:15), we must use the other vehicles to fill the remaining
requirements of the new vehicle)
(2) A new vehicle must state where its components came from.
(i.e donor vehicle name and vin number).
Example output of new car:
MediumGreenSaloon (vin:24)
1.5 litre diesel engine (GreenWheelX1(vin:15)),
8 speed (GreenWheelX1 (vin:15)), automatic transmission (GreenWheelX7(vin:11)),
17 inch alloy wheels (GreenWheelX7(vin:11)), 3 doors(GreenWheelX5(vin:17)), in cherry red.
##GreenWheel cars are sold in the GreenWheel dealerships.
GreenWheel Dealership details:
name
address
inventory (stock of cars: min of 5 - max of 20)
Example output of GreenWheel dealership:
Gerry’s GreenWheel Dealership of 123 my road, my street, my County
Presents:
4 BigGreenAutoCar in cherry red, sky blue, autumn orange and GreenWheel green.
3 GreenWheelX3 in sunset yellow, midnight blue and panther black.
1 SmallGreenMini in panther black.
Requirements:
Your program must be able to:
(1) Generate at least 300 existing GreenWheel products (see existing car details).
(2) Generate the 200 new products using values from the existing products
(see rules for new vehicles (1)).
(3) Generate 50 GreenWheel dealerships and supply them with a mix of new and old products.
(see GreenWheel Dealership details)
Your end user must be able to:
(1) View all the existing products
(2) View all the new products
(3) Select a single new product to view
(4) View the dealerships and their products
(5) Select a product from a dealership to view
##Project Requirements / Rules:
You are required to implement the preceding program specification, in order to do this you must:
Generate data on first run of program. (not hard coded). Data must be persistent while program is running.(i.e program must use the generated data). All data may be (but does not have to be) saved to a .txt file to be used for subsequent runs of the program (program must then use this data). Java standard edition 7, 8 or 9 (8 recommended) only, to be used.
Dependencies allowed (can be, but do not have to be used): AWT / Swing. .txt file/s.
Dependencies NOT allowed (must not be used): No additional java libraries. No Database.
Tip: produce enough existing products to be able to use them for parts for your 200 new products and have enough untouched existing products to send to the dealerships, i.e.- try to avoid giving a car to a dealership that you have already used for parts.
