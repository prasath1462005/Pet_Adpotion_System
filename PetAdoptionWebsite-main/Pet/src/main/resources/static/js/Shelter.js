document.getElementById('signupForm').addEventListener('submit', function(event) {
    event.preventDefault();
    validateForm();
});

function validateForm() {
    var id = document.getElementById('id').value;
    var name = document.getElementById('name').value;
    var phone = document.getElementById('phone').value;
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;
    var confirmPassword = document.getElementById('confirmPassword').value;

    var errorMessage = '';

    if (!id || !name || !phone || !email || !password || !confirmPassword) {
        errorMessage += 'All fields are required.\n';
    }

    if (password !== confirmPassword) {
        errorMessage += 'Passwords do not match.\n';
    }

    if (errorMessage) {
        alert(errorMessage);
    } else {
        alert('Form submitted successfully!');
        // You can submit the form to the server here
    }
}
