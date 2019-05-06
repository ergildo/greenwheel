## Project Brief
The GreenWheel car manufacturer is updating their product line. They have decided to produce a limited run of 200 new products. <br>
GreenWheel has 50 dealerships already selling their cars. <br>
The new vehicles use components from existing cars. <br>
You have been tasked with gathering the components for the new vehicle line and distributing the completed 200 cars to the dealerships.<br>
## GreenWheel new product names:
BigGreenAutoCar <br>
SmallGreenMini <br>
MediumGreenSaloon <br>
GreenBus <br>
Existing Cars: <br>
GreenWheelX1, GreenWheelX2, GreenWheelX3, GreenWheelX4, GreenWheelX5 <br>
GreenWheelX6, GreenWheelX7, GreenWheelX8, GreenWheelX9, GreenWheelX10 <br>

## Existing Car details: 
name: (GreenWheelX2 / GreenWheelX9 etc.) <br>
vinNumber: (vehicle id) <br>
gearbox: (5 / 6 / 8 speed) <br>
transmission: (automatic / manual / NA) <br>
engineType: (diesel / petrol / electric) <br>
engineSize: (1.0 litre to 4.0 litre(petrol or diesel) 50 hp to 140 hp (electric)) <br>
numberOfDoors (2 to 5) <br>
wheelSize (16 to 20 inch alloys) <br>
colour (any colour you like) <br>
Example output of existing car: <br>
GreenWheelX5 (vin : 12) <br>
2.5 litre petrol engine, 6 speed automatic transmission <br>
20 inch alloy wheels, 3 doors, in cherry red. <br>
Rules for new Vehicle: <br>
(1) A new vehicle cannot use more than two components from any one existing car. <br>
i.e - a gearbox and engine type from GreenWheelX1(vin:15) (that is the maximum we can take <br>
from that particular GreenWheelX1(vin:15), we must use the other vehicles to fill the remaining <br>
requirements of the new vehicle) <br>
(2) A new vehicle must state where its components came from. <br>
(i.e donor vehicle name and vin number). <br>
## Example output of new car:
MediumGreenSaloon (vin:24) <br>
1.5 litre diesel engine (GreenWheelX1(vin:15)), <br>
8 speed (GreenWheelX1 (vin:15)), automatic transmission (GreenWheelX7(vin:11)), <br>
17 inch alloy wheels (GreenWheelX7(vin:11)), 3 doors(GreenWheelX5(vin:17)), in cherry red. <br>
+ GreenWheel cars are sold in the GreenWheel dealerships. 
## GreenWheel Dealership details:
name <br>
address <br>
inventory (stock of cars: min of 5 - max of 20) <br>
Example output of GreenWheel dealership: <br>
Gerry’s GreenWheel Dealership of 123 my road, my street, my County
Presents: <br>
4 BigGreenAutoCar in cherry red, sky blue, autumn orange and GreenWheel green. <br>
3 GreenWheelX3 in sunset yellow, midnight blue and panther black. <br>
1 SmallGreenMini in panther black <br>
## Requirements:
Your program must be able to: <br>
(1) Generate at least 300 existing GreenWheel products (see existing car details). <br>
(2) Generate the 200 new products using values from the existing products <br>
(see rules for new vehicles (1)). <br>
(3) Generate 50 GreenWheel dealerships and supply them with a mix of new and old products.<br>
(see GreenWheel Dealership details) <br>
Your end user must be able to: <br>
(1) View all the existing products <br>
(2) View all the new products <br>
(3) Select a single new product to view <br>
(4) View the dealerships and their products <br>
(5) Select a product from a dealership to view <br>
## Project Requirements / Rules: 
+ You are required to implement the preceding program specification, in order to do this you must: <br>
Generate data on first run of program. (not hard coded). <br> 
+  Data must be persistent while program is running.(i.e program must use the generated data). <br> All data may be (but does not have to be) saved to a .txt file to be used for subsequent runs of the program (program must then use this data). 
+ Java standard edition 7, 8 or 9 (8 recommended) only, to be used.
+ Dependencies allowed (can be, but do not have to be used): AWT / Swing. .txt file/s.
+ Dependencies NOT allowed (must not be used): No additional java libraries. No Database.
