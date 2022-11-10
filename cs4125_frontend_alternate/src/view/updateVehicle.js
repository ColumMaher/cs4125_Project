/***********************************************
***  Methods for the use case updateVehicle  ******
************************************************/
pl.view.updateVehicle = {
  setupUserInterface: function () {
    var formEl = document.forms['Vehicle'],
        saveButton = formEl.commit,
        selectVehicleEl = formEl.selectVehicle;
    var key="", keys=[], vehicle=null, optionEl=null, i=0;
    // load all vehicle objects
    Vehicle.loadAll();
    // populate the selection list with vehicles
    keys = Object.keys( Vehicle.instances);
    for (i=0; i < keys.length; i++) {
      key = keys[i];
      vehicle = Vehicle.instances[key];
      optionEl = document.createElement("option");
      optionEl.text = vehicle.title;
      optionEl.value = vehicle.isbn;
      selectVehicleEl.add( optionEl, null);
    }
    // when a vehicle is selected, populate the form with the vehicle data
    selectVehicleEl.addEventListener("change", function () {
        var vehicle=null, key = selectVehicleEl.value;
        if (key) {
          vehicle = Vehicle.instances[key];
          formEl.isbn.value = vehicle.isbn;
          formEl.title.value = vehicle.title;
          formEl.year.value = vehicle.year;
        } else {
          formEl.reset();
        }
    });
    saveButton.addEventListener("click", 
        pl.view.updateVehicle.handleSaveButtonClickEvent);
    window.addEventListener("beforeunload", function () {
        Vehicle.saveAll(); 
    });
  },
  // save data
  handleSaveButtonClickEvent: function () {
    var formEl = document.forms['Vehicle'];
    var slots = { isbn: formEl.isbn.value, 
          title: formEl.title.value, 
          year: formEl.year.value
        };
    Vehicle.update( slots);
    formEl.reset();
  }
};