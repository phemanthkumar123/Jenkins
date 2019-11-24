/* function for date picker */
$( function() {
    $( "#datepicker" ).datepicker({
      /*dateFormat: 'dd-mm-yyyy',*/
      changeMonth: true,
      changeYear: true
    });
  } );

/* function to validate form */
//Wait for the DOM to be ready
$(function() {
  // Initialize form validation on the registration form.
  // It has the name attribute "registration"
  $("form[name='register-owner-form']").validate({
    // Specify validation rules
    rules: {
      // The key name on the left side is the name attribute
      // of an input field. Validation rules are defined
      // on the right side
      ssn1: "required",
      ssn2: "required",
      ssn3: "required",
      firstName: "required",
      lastName: "required",
      gender:"required",  
      email: {
        required: true,
        // Specify that email should be validated
        // by the built-in "email" rule
        email: true
      },
      dob: "required", 
      phoneNumber: {
    	  required: true,
          minlength: 10,
          maxlength: 10
      }
    },
    // Specify validation error messages
    messages: {
      ssn_1: "Please enter your first 3 digits of ssn",
      ssn_2: "Please enter your second 2 digits of ssn",
      ssn_3: "Please enter your last 4 digits of ssn",
      firstName: "Please provide your firstname",
      lastName: "Please provide your lasttname",
      gender: "please selct your gender",
      email: "Please enter a valid email address",
      dob: "please provide your dateofbirth",
      phoneNumber: {
    	  required: "Please provide your phone number",
          minlength: "Your phone number must be 10 characters long",
          maxlength: "Your phone number must be 10 characters long"
      }
    },
    // Make sure the form is submitted to the destination defined
    // in the "action" attribute of the form when valid
    submitHandler: function(form) {
      form.submit();
    }
  });
});
