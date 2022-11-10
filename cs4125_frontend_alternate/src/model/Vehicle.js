/**
 * Constructor function for the class Vehicle 
 * @constructor
 * @param {{isbn: string, title: string, year: number}} slots - Object creation slots.
 */
function Vehicle( slots) {
  this.isbn = slots.isbn;
  this.title = slots.title;
  this.year = slots.year
  this.availability = slots.availability;
};
/***********************************************
***  Class-level ("static") properties  ********
************************************************/
Vehicle.instances = {};  // initially an empty associative array

/*********************************************************
***  Class-level ("static") storage management methods ***
**********************************************************/
// Convert row to object
Vehicle.convertRow2Obj = function (vehicleRow) {
  var vehicle = new Vehicle( vehicleRow);
  return vehicle;
};
// Load the vehicle table from Local Storage
Vehicle.loadAll = function () {
  var key="", keys=[], vehiclesString="", vehicles={}, i=0;  
  try {
    if (localStorage.getItem("vehicles")) {
      vehiclesString = localStorage.getItem("vehicles");
    }
  } catch (e) {
    alert("Error when reading from Local Storage\n" + e);
  }
  if (vehiclesString) {
    vehicles = JSON.parse( vehiclesString);
    keys = Object.keys( vehicles);
    console.log( keys.length +" vehicles loaded.");
    for (i=0; i < keys.length; i++) {
      key = keys[i];
      Vehicle.instances[key] = Vehicle.convertRow2Obj( vehicles[key]);
    }
  }
};
//  Save all vehicle objects to Local Storage
Vehicle.saveAll = function () {
  var vehiclesString="", error=false,
      nmrOfVehicles = Object.keys( Vehicle.instances).length;  
  try {
    vehiclesString = JSON.stringify( Vehicle.instances);
    localStorage.setItem("vehicles", vehiclesString);
  } catch (e) {
    alert("Error when writing to Local Storage\n" + e);
    error = true;
  }
  if (!error) console.log( nmrOfVehicles + " vehicles saved.");
};
//  Create a new vehicle row
Vehicle.add = function (slots) {
  var vehicle = new Vehicle( slots);
  Vehicle.instances[slots.isbn] = vehicle;
  console.log("Vehicle " + slots.isbn + " created!");
};
//  Update an existing vehicle row
Vehicle.update = function (slots) {
  var vehicle = Vehicle.instances[slots.isbn];
  var year = parseInt( slots.year);
  if (vehicle.title !== slots.title) { vehicle.title = slots.title;}
  if (vehicle.year !== slots.year) { vehicle.year = year;}
  if (vehicle.availability !== slots.availability) { vehicle.availability;}
  console.log("Vehicle " + slots.isbn + " modified!");
};
//  Delete a vehicle row from persistent storage
Vehicle.destroy = function (isbn) {
  if (Vehicle.instances[isbn]) {
    console.log("Vehicle " + isbn + " deleted");
    delete Vehicle.instances[isbn];
  } else {
    console.log("There is no vehicle with ISBN " + isbn + " in the database!");
  }
};
/*******************************************
*** Auxiliary methods for testing **********
********************************************/
//  Create and save test data
Vehicle.createTestData = function () {
  Vehicle.instances["VolkswagenGolf22"] = new Vehicle({isbn:"Volkswagen", title:"Golf", year:2022, availability:"Available"});
  Vehicle.instances["HondaIntegra06"] = new Vehicle({isbn:"Honda", title:"Integra", year:2006, availability:"Available"});
  Vehicle.instances["ToyotaGT8615"] = new Vehicle({isbn:"Toyota", title:"GT86", year:2015, availability:"In Maintenance"});
  Vehicle.saveAll();
};
//  Clear data
Vehicle.clearData = function () {
  if (confirm("Do you really want to delete all currently listed vehicles?")) {
    Vehicle.instances = {};
    localStorage.setItem("vehicles", "{}");
  }
};
