document.addEventListener("DOMContentLoaded", function(event) {
    var messageDiv = document.getElementById('successMessage');
    if (messageDiv.textContent.trim() !== '') {

        alert(messageDiv.textContent.trim());
    }
});