using SampleApi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SampleApi.DAL
{
    public class MockGameDAO : IGameDAO
    {
        private IDictionary<String, Game> games = new Dictionary<string, Game>(); //gameid, game
        private IDictionary<string, string> gameParticipants = new Dictionary<string, string>(); //userhash, gameid
        

        public Round GetNextRoundForPlayer(string userid)
        {
            Game g = GetGameByUserId(userid);
            return g.GetNextRoundForPlayer(userid);
            
        }

        public void AddRoundResults(Round result, string gameid,string userid)
        {
            Game g = GetGameByGameId(gameid);
            g.AddRoundResults(result,userid);
        }

        public bool IsGameWaiting(string gameid)
        {
            try
            {
                Game g = games[gameid];
                if (g == null)
                {
                    return true;
                }
                else
                {
                    return (!g.InProgress) || g.IsWaitingOnPlayer;
                }
            }
            catch (Exception e)
            {
                return true;
            }
        }

        public bool JoinGame(string userid, string gameid)
        {
            Game g = GetGameByGameId(gameid);
            if (g.InProgress)
            {
                return false;
            }
            gameParticipants[userid]= gameid; //ok if we accidentally add twice
            g.AddPlayer( userid);
            return true;
        }

        public bool StartGame(string gameid)
        {
            try
            {
                Game g = games[gameid];
                g.Initialize(); //this will create a pad for every player

                return true;
            }
            catch (Exception e)
            {
                return false;
            }
        }


        private Game GetGameByUserId(string userid)
        {
            Game g = null;
            try
            {
                g = games[gameParticipants[userid]];
            }
            catch (Exception e)
            {
                g = new Game();                
            }
            return g;
        }
        private Game GetGameByGameId(string gameId)
        {
            Game g = null;
            try
            {
                g = games[gameId];
            }
            catch (Exception e)
            {
                g = new Game();
                games[gameId] = g;
            }
            return g;
        }

        public ICollection<string> GetPlayerListForGameId(string gameid)
        {
            try
            {
                return games[gameid].Players;
            }
            catch(Exception e)
            {
                return null;
            }
        }

        public bool IsGameOver(string gameid)
        {
            try
            {
                Game g = games[gameid];
                if (g == null)
                {
                    return true;
                }
                else
                {
                    return g.IsOver;
                }
            }
            catch (Exception e)
            {
                return true;
            }
        }

        public ICollection<Pad> GetFinishedPadsForGame(string gameid)
        {
            try
            {
                return games[gameid].Pads;
            }
            catch (Exception e)
            {
                return null;
            }
        }

        public void DeleteGame(string gameid)
        {
            games.Remove(gameid);
        }
    }
}
