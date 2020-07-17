using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Claims;
using System.Threading;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using SampleApi.DAL;
using SampleApi.Models;

namespace SampleApi.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class GameController : ControllerBase
    {
        private IGameDAO gameDAO;
        public GameController(IGameDAO dao)
        {
            gameDAO = dao;
        }

        [Authorize]
        [HttpPost("joingame")]
        public IActionResult JoinGame([FromBody]String gameId)
        {
            return gameDAO.JoinGame(GetLoggedInUserId(), gameId) ? Ok() : ValidationProblem();
        }

        [Authorize]
        [HttpPost("startthegame")]
        public IActionResult startthegame([FromBody]String gameId)
        {
            return gameDAO.StartGame(gameId) ? Ok() : ValidationProblem();
        }

        [Authorize]
        [HttpGet("getPlayerList/{gameId}")]
        public IActionResult getPlayerList(String gameId)
        {
            return Ok(gameDAO.GetPlayerListForGameId(gameId));
        }

        [Authorize]
        [HttpGet("{gameId}")]
        public IActionResult WaitForNext(String gameId)
        {
            //find the game the user is waiting on            

            //if it's in progress then send what's next
            //otherwise wait 1 second and check again
            while (gameDAO.IsGameWaiting(gameId))
            {
                Thread.Sleep(1000);
            }

            //we're going to send a 409 once the game is over to show the results
            if (gameDAO.IsGameOver(gameId))
            {
                return new ConflictResult();
            }

            //once it's in progress, then send the info
            return Ok(gameDAO.GetNextRoundForPlayer(User.Identity.Name));

        }

        [Authorize]
        [HttpPost("submitround/{gameId}")]
        public IActionResult SubmitRound([FromBody] Round fromUser,string gameid)
        {
            gameDAO.AddRoundResults(fromUser, gameid,GetLoggedInUserId());
            return Ok();
        }

        [Authorize]
        [HttpPost("finishedPads/{gameId}")]
        public IActionResult getPads(string gameid)
        {            
            return Ok(gameDAO.GetFinishedPadsForGame(gameid));
        }

        [HttpPost("deleteGame/{gameId}")]
        public IActionResult deleteGame(string gameid)
        {
            gameDAO.DeleteGame(gameid);
            return Ok();
        }

        private string GetLoggedInUserId()
        {
            return User.Identity.Name;
        }
    }
}