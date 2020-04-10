<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html> 
    <head>
        <link href="css/main.css"
              rel="stylesheet">
    </head>
    <body bgcolor="#E6E6FA">
      <div>
        <div  class ="button" >
          <h4><a href="http://localhost:8080/start">Play again</a></h4>
        </div>
        <div  class ="button" >
          <h4><a href="http://localhost:8080/homePage">Home Page</a></h4>
        </div>
      </div>
        <h1 align = "center">Result</h1>
        <div align = "center" class="header"> Winner is Player ${matchResult.winner.playerNumber}</div>
        <div>
        <table  cellpadding = "10">
          <tr>
            <c:forEach var="player" items="${matchResult.players}">
                <tr>
                  <th>Player Number : ${player.playerNumber}</th>
                  <th>Total Score : ${player.totalScore}</th>
                </tr>       
                <c:forEach var="round" items="${player.rounds}">
                        <td>Round Number: ${round.roundNumber}</td>
                        <td>Score: ${round.score}</td>
                </c:forEach>
            </c:forEach>
          </tr>
          </table>  
        </div>
    </body>
</html>

