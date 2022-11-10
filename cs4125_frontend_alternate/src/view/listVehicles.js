/**
 * @fileOverview  Contains various view functions for the use case listVehicles
 * @author Adam Butler
 */
 pl.view.listVehicles = {
  setupUserInterface: function () {
    var tableBodyEl = document.querySelector("table#vehicles>tbody");
    var keys=[], key="", row={}, i=0;
    // load all vehicle objects
    Vehicle.loadAll();
    keys = Object.keys( Vehicle.instances);
    // for each vehicle, create a table row with a cell for each attribute
    for (i=0; i < keys.length; i++) {
      key = keys[i];
      row = tableBodyEl.insertRow();
      row.insertCell(-1).textContent = Vehicle.instances[key].isbn;      
      row.insertCell(-1).textContent = Vehicle.instances[key].title;  
      row.insertCell(-1).textContent = Vehicle.instances[key].year;
      row.insertCell(-1).textContent = Vehicle.instances[key].availability;
    }
  }
};