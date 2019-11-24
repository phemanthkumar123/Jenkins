/* function to validate form */
//Wait for the DOM to be ready
$(function() {
  // Initialize form validation on the registration form.
  // It has the name attribute "registration"
  $("form[name='register-owner-address-form']").validate({
    // Specify validation rules
    rules: {
      // The key name on the left side is the name attribute
      // of an input field. Validation rules are defined
      // on the right side
      homeNo: "required",
      street: "required",
      city: "required",
      zipCode: "required",
    },
    // Specify validation error messages
    messages: {
      homeNo: "Please enter your home number",
      street: "Please enter your street",
      city: "Please enter your city",
      zipCode: "Please provide your zip code"
    },
    // Make sure the form is submitted to the destination defined
    // in the "action" attribute of the form when valid
    submitHandler: function(form) {
      form.submit();
    }
  });
});
