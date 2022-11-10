/***********************************************
***  Methods for the use case createVehicle  ******
************************************************/
pl.view.createVehicle = {
  setupUserInterface: function () {
    var saveButton = document.forms['Vehicle'].commit;
    // load all vehicle objects
    Vehicle.loadAll();
    // Set an event handler for the save/submit button
    saveButton.addEventListener("click", 
        pl.view.createVehicle.handleSaveButtonClickEvent);
    window.addEventListener("beforeunload", function () {
        Vehicle.saveAll(); 
    });
  },
  // save user input data
  handleSaveButtonClickEvent: function () {
    var formEl = document.forms['Vehicle'];
    var slots = { isbn: formEl.isbn.value, 
        title: formEl.title.value, 
        year: formEl.year.value,
        availability: formEl.availability.value};
    Vehicle.add( slots);
    formEl.reset();
  }
};