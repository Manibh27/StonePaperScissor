<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>  
    <head>
        <script src="https://code.jquery.com/jquery-1.10.2.js"
	         type="text/javascript"></script> 
    </head>
    <body>
        <h1 align = "center">Lets Play</h1>
        <div id="roundInfo">
            <input id="round-number-hidden" type='hidden' value='1'/>
            <div id="round-number" align = "center">Round 1</div>
            <input id="player-number-hidden" type='hidden' value='1'/>
            <div id="player-number" align = "center">Player 1</div>
        </div>
        <div align = "center">
            choose your choise.
        </div>
        <div align = "center">
            <div onclick="updatePlayerChoice(1)">
                <a>Stone</a>
            </div>
            <div onclick="updatePlayerChoice(2)">
                <a>Paper</a>
            </div>
            <div onclick="updatePlayerChoice(3)">
                <a>Scissor</a>
            </div>
        </div>
        <h5 align = "center"><a href="http://localhost:8080/finish">exit</a></h5>
    </body>
    <script>
        var player1 = {id: '1', name: 'player1'};
        var player2 = {id: '2', name: 'player2'};
        var player3 = {id: '3', name: 'player3'};
        var player4 = {id: '4', name: 'player4'};
    
        // When ever a player choose an option it is updated in his object.
        function updatePlayerChoice(choice) {
    	    var playerNumber = document.getElementById("player-number-hidden").value; 
    	    if (playerNumber != '4') {
    	    	nextNumber = (playerNumber * 1) + 1;
    		    document.getElementById("player-number").innerHTML = "Player " + nextNumber;
        	    document.getElementById("player-number-hidden").value = nextNumber;
    	    }

    	    if (playerNumber == '1') {
    		    player1.choice = choice;    		
    	    } else if (playerNumber == '2') {
    		    player2.choice = choice;
    	    } else if (playerNumber == '3') {
    		    player3.choice = choice;
         	} else if (playerNumber == '4') {
    	    	player4.choice = choice;
    		    updateRoundInfo();
    	    }
    	
        }
    
        // When all players played one round then, the next round is started.
        function updateRoundInfo() {
        	roundInfo = {
        			playerOneChoice : player1.choice,
        	        playerTwoChoice : player2.choice,
        	        playerThreeChoice : player3.choice,
        	        playerFourChoice : player4.choice     	
        	}
   	    $.ajax({
    			url : 'play',
    			type: "POST",
    			data : roundInfo,
    			success : function(responseText) {
    	    	    document.getElementById("player-number-hidden").value = 1;
    	    	    document.getElementById("player-number").innerHTML = "Player 1";
    	    	    roundNumber = document.getElementById("round-number-hidden").value;
    	    	    nextNumber = (roundNumber * 1) + 1;
    	    	    document.getElementById("round-number").innerHTML = "Round " + nextNumber;
    	    	    document.getElementById("round-number-hidden").value = nextNumber;
    	    	    console.log(player1);
    	    	    console.log(player2);
    	    	    console.log(player3);
    	    	    console.log(player4);
    				console.log(responseText);
    			},
    	        error : function(responseText) {
    	        	window.location.replace("http://localhost:8080/errorPage.jsp");
    	        }
    		});

        }
    </script>
</html>


