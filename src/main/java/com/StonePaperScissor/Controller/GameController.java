package com.StonePaperScissor.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.StonePaperScissor.Common.Constants;
import com.StonePaperScissor.Entity.Match;
import com.StonePaperScissor.Service.GameService;


/**
 * Entire game is controlled here.
 * @author Mani Bharathi.M
 *
 */
@Controller
public class GameController {
	@Autowired
    private GameService gameService;
	
	/**
	 * Redirect to home page.
	 * @return
	 */
	@RequestMapping(value = Constants.HOMAE_PAGE, method = RequestMethod.GET)
	public String redirectToHome() {
		return Constants.INDEX_JSP;
	}
	
	/**
	 * When new game is started, new players are initialized.
	 * Then redirected to game page.
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Constants.START, method = RequestMethod.GET)  
    public String startGame(Model model) {  
		try {
		    gameService.startGame();
            return Constants.GAME_PAGE_JSP;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return Constants.ERROR_PAGE_JSP;
		}
		
    }
	
	/**
	 * For each round the player informations are updated.
	 * @param request
	 * @param response
	 * @throws IOException
	 */
    @RequestMapping(value = Constants.PLAY, method = RequestMethod.POST)  
    private void playGame(HttpServletRequest request, HttpServletResponse 
            response) throws IOException {    	
    	JSONObject success = gameService.updateRoundInfo(request);
        response.setContentType(Constants.APPLICATION_JSON);
        response.getWriter().write(success.toString());
    }
    
    /**
     * When the player choose to finish the game, result page is shown.
     * @param model
     * @return
     */
	@RequestMapping(value = Constants.FINISH, method = RequestMethod.GET)  
    public String finishGame(Model model) {  
		try {
		    Match matchResult = gameService.getMatchResult();
		    model.addAttribute(Constants.MATCH_RESULT, matchResult);
            return Constants.RESULT_PAGE_JSP;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return Constants.ERROR_PAGE_JSP;
		}
    }  
}
