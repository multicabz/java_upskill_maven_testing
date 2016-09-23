/**
 * Created by Multi Cabz on 9/15/2016.
 */
/*var mySubmitBtn = document.getElementById("submitBtn");

mySubmitBtn.onclick = function(event){
     event.preventDefault();

     var divs = document.getElementsByTagName("div");

     mySubmitBtn.style.display = "none";

     for(var i=0;i<=divs.length;i++){
     //divs[i].style.backgroundColor = 'blue';
     }

     setTimeout(function(){

     },1000);
 }*/


/*$mySubmitBtn = $("#submitBtn");
$divs        = $("div");

$mySubmitBtn.click(function(event){
    event.preventDefault();


});*/

//onload
$("#regForm").validate();

if(localStorage.getItem("formSubmitted")){
    disableBSubmitBtn();
}

$("#submitBtn").click(function(){

    if ($("#regForm").valid()){



        $.ajax({
            url : "js/object.json",
            dataType: "json",
            error: function(){
                alert("Fail");
            },
            success: function(responseData,status,response){
                savedata();
            }
        });

        return false;
    }


});

//remove storage
$(".alert-report a").click(function(e){
    e.preventDefault();

    localStorage.removeItem("formSubmitted");
});

function disableBSubmitBtn(){
        $("#submitBtn").hide();
        $(".alert-report").fadeIn('slow');
        $(".alert-report span").fadeIn("slow").html("Thanks for registering!");
}

function savedata() {
        localStorage.setItem("formSubmitted", true);
        return true;
}

//Canvas
canvasF();
function canvasF(){
    var v = document.getElementById('myTune');
    var canvas = document.getElementById('myCanvas');
    var context = canvas.getContext('2d');

    var cw = Math.floor(canvas.clientWidth / 10);
    var ch = Math.floor(canvas.clientHeight / 10);
    canvas.width = cw;
    canvas.height = ch;

    v.addEventListener('play', function(){
        draw(this,context,cw,ch);
    },false);

};

function draw(v,c,w,h) {
    if(v.paused || v.ended) return false;
    c.drawImage(v,0,0,w,h);
    setTimeout(draw,200,v,c,w,h);
}

function audioControl(task) {
    var myAudio = document.getElementById("myTune");
    if(task == "play_pause") {
        if (myAudio.paused) {
            myAudio.play();
            $("#play_pause").html("PAUSE");
        } else {
            myAudio.pause();
            $("#play_pause").html("PLAY");
        }
    }

    if(task == "stop"){
        $("#play_pause").html("PLAY");
        $("#myTune").trigger('pause');
        $("#myTune").prop("currentTime",0);
    }
}

