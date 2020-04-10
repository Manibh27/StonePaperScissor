<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html> 
    <body>
        <h5 align="right"><a href="http://localhost:8080/start">play again</a></h5>
        <h5 align="left"><a href="http://localhost:8080/homePage">Home Page</a></h5>
        <h1 align = "center">Result</h1>
        <div align = "center"> Winner is Player ${matchResult.winner.playerNumber}</div>
        <div>
        <table  cellpadding = "10">
          <tr>
            <c:forEach var="player" items="${matchResult.players}">
                <tr>
                  <td>Player Number : ${player.playerNumber}</td>
                  <td>Total Score : ${player.totalScore}</td>
                </tr>       
                <c:forEach var="round" items="${player.rounds}">
                        <td>Round Number: ${round.roundNumber}</td>
                        <td>${round.score}</td>
                </c:forEach>
            </c:forEach>
          </tr>
          </table>  
        </div>
    </body>
</html>

