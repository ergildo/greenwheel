# Project Brief
The GreenWheel car manufacturer is updating their product line. They have decided to produce a limited run of 200 new products.
GreenWheel has 50 dealerships already selling their cars. <b>
The new vehicles use components from existing cars. <b>
You have been tasked with gathering the components for the new vehicle line and distributing the completed 200 cars to the dealerships.<b>
# GreenWheel new product names:
BigGreenAutoCar <b>
SmallGreenMini <b>
MediumGreenSaloon <b>
GreenBus <b>
Existing Cars: <b>
GreenWheelX1, GreenWheelX2, GreenWheelX3, GreenWheelX4, GreenWheelX5 <b>
GreenWheelX6, GreenWheelX7, GreenWheelX8, GreenWheelX9, GreenWheelX10 <b>

Existing Car details: <b>
name: (GreenWheelX2 / GreenWheelX9 etc.) <b>
vinNumber: (vehicle id) <b>
gearbox: (5 / 6 / 8 speed) <b>
transmission: (automatic / manual / NA) <b>
engineType: (diesel / petrol / electric) <b>
engineSize: (1.0 litre to 4.0 litre(petrol or diesel) 50 hp to 140 hp (electric)) <b>
numberOfDoors (2 to 5) <b>
wheelSize (16 to 20 inch alloys) <b>
colour (any colour you like) <b>
Example output of existing car: <b>
GreenWheelX5 (vin : 12) <b>
2.5 litre petrol engine, 6 speed automatic transmission <b>
20 inch alloy wheels, 3 doors, in cherry red. <b>
Rules for new Vehicle: <b>
(1) A new vehicle cannot use more than two components from any one existing car. <b>
i.e - a gearbox and engine type from GreenWheelX1(vin:15) (that is the maximum we can take <b>
from that particular GreenWheelX1(vin:15), we must use the other vehicles to fill the remaining <b>
requirements of the new vehicle) <b>
(2) A new vehicle must state where its components came from. <b>
(i.e donor vehicle name and vin number). <b>
## Example output of new car:
MediumGreenSaloon (vin:24) <b>
1.5 litre diesel engine (GreenWheelX1(vin:15)), <b>
8 speed (GreenWheelX1 (vin:15)), automatic transmission (GreenWheelX7(vin:11)), <b>
17 inch alloy wheels (GreenWheelX7(vin:11)), 3 doors(GreenWheelX5(vin:17)), in cherry red. <b>
+ GreenWheel cars are sold in the GreenWheel dealerships. 
## GreenWheel Dealership details:
name <b>
address <b>
inventory (stock of cars: min of 5 - max of 20) <b>
Example output of GreenWheel dealership: <b>
Gerry’s GreenWheel Dealership of 123 my road, my street, my County
Presents: <b>
4 BigGreenAutoCar in cherry red, sky blue, autumn orange and GreenWheel green. <b>
3 GreenWheelX3 in sunset yellow, midnight blue and panther black. <b>
1 SmallGreenMini in panther black <b>
# Requirements:
Your program must be able to: <b>
(1) Generate at least 300 existing GreenWheel products (see existing car details). <b>
(2) Generate the 200 new products using values from the existing products <b>
(see rules for new vehicles (1)). <b>
(3) Generate 50 GreenWheel dealerships and supply them with a mix of new and old products.<b>
(see GreenWheel Dealership details) <b>
Your end user must be able to: <b>
(1) View all the existing products <b>
(2) View all the new products <b>
(3) Select a single new product to view <b>
(4) View the dealerships and their products <b>
(5) Select a product from a dealership to view <b>
# Project Requirements / Rules: 
+ You are required to implement the preceding program specification, in order to do this you must: <b>
Generate data on first run of program. (not hard coded). <b> 
+  Data must be persistent while program is running.(i.e program must use the generated data). <b> All data may be (but does not have to be) saved to a .txt file to be used for subsequent runs of the program (program must then use this data). 
+ Java standard edition 7, 8 or 9 (8 recommended) only, to be used.
+ Dependencies allowed (can be, but do not have to be used): AWT / Swing. .txt file/s.
+ Dependencies NOT allowed (must not be used): No additional java libraries. No Database.
