
// -- dark mode -- 
const darkModeSwith = document.getElementById("light-switch")
document.addEventListener("DOMContentLoaded",isDarkMode)


darkModeSwith.addEventListener("change",toDarkMode)

function toDarkMode() {
    
    const currentLight = document.body.classList.contains("dark-mode");
    if (currentLight) {
        localStorage.setItem("darkMode","disabled")    
    } else {
        localStorage.setItem("darkMode","enabled")
    };
    document.body.classList.toggle("dark-mode");
    console.log("Dark mode is " + localStorage.getItem("darkMode"))
}

function isDarkMode() {
    if (localStorage.getItem("darkMode") === "enabled") {
        darkModeSwith.checked = true;
        document.body.classList.add("dark-mode");
    } else {
        darkModeSwith.checked = false;
    }
}

// -- user credentials --
const usernameInput = document.getElementById("username")
const passwordInput = document.getElementById("password")

// -- log in --
const credentialsContainer = document.getElementById("user-credentials")
const loginBtn = document.getElementById("login-button")

loginBtn.addEventListener("click", attemptLogin)

function attemptLogin() {
    if (usernameInput.value.trim() === "" || passwordInput.value.trim() === "") {
        const warningMessage = document.createElement("p")
        warningMessage.textContent = "**Must provide username and login**"
        warningMessage.setAttribute("id","login-warning")
        credentialsContainer.appendChild(warningMessage)
        setTimeout(function() {
            credentialsContainer.removeChild(warningMessage);
        }, 5000);
    } else {
        localStorage.setItem("username",usernameInput.value);
        localStorage.setItem("password",passwordInput.value);
        window.location.href = "../home/home.html";
        usernameInput.value = "";
        passwordInput.value = "";
    }
}