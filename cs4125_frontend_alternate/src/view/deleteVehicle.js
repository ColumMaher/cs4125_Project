/***********************************************
***  Methods for the use case "delete vehicle"  ***
************************************************/
pl.view.deleteVehicle = {
  setupUserInterface: function () {
    var deleteButton = document.forms['Vehicle'].commit;
    var selectEl = document.forms['Vehicle'].selectVehicle;
    var key="", keys=[], vehicle=null, optionEl=null, i=0;
    // load all vehicle objects
    Vehicle.loadAll();
    keys = Object.keys( Vehicle.instances);
    // populate the selection list with vehicles
    for (i=0; i < keys.length; i++) {
      key = keys[i];
      vehicle = Vehicle.instances[key];
      optionEl = document.createElement("option");
      optionEl.text = vehicle.title;
      optionEl.value = vehicle.isbn;
      selectEl.add( optionEl, null);
    }
    deleteButton.addEventListener("click", 
        pl.view.deleteVehicle.handleDeleteButtonClickEvent);
    window.addEventListener("beforeunload", function () {
        Vehicle.saveAll(); 
    });
  },
  // Event handler for deleting a vehicle
  handleDeleteButtonClickEvent: function () {
    var selectEl = document.forms['Vehicle'].selectVehicle;
    var isbn = selectEl.value;
    if (isbn) {
      Vehicle.destroy( isbn);
      // remove deleted vehicle from select options
      selectEl.remove( selectEl.selectedIndex);
    }
  }
};