function open_menu() {
    document.getElementById("main").style.marginLeft = "20%";
    document.getElementById("mySidebar").style.width = "20%";
    document.getElementById("mySidebar").style.marginTop = "52px"; 
    document.getElementById("mySidebar").style.display = "block";
}
  
function close_menu() {
   document.getElementById("main").style.marginLeft = "0%";
   document.getElementById("mySidebar").style.display = "none";
   document.getElementById("openNav").style.display = "inline-block";
}

document.getElementById("openNav").addEventListener("click", function() {
    if(document.getElementById("mySidebar").style.display == "none"){
        open_menu();
    }else{
        close_menu();
    }
});

window.onload = function() {
    
    var messageBox = document.querySelector('.success-message-global');
    
    if (!messageBox){
        messageBox = document.querySelector('.error-message-global');
    }

    if (messageBox) {
        setTimeout(function() {
            messageBox.classList.add('hide');
        }, 3000); 
    }
};