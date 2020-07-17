using SampleApi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace SampleApi.DAL
{
    public interface IGameDAO
    {
        /// <summary>
        /// The logged in user will join game 
        /// </summary>
        /// <param name="userid">logged in user id</param>
        /// <param name="gameid">game id to join. will create if doesn't exist</param>
        /// <param name="username">the users name to show while playing</param>
        /// <returns></returns>
        bool JoinGame(string userid, string gameid);

        bool StartGame(string gameid);

        bool IsGameWaiting(string userid);

        bool IsGameOver(string gameid);

        Round GetNextRoundForPlayer(string userid);

        void AddRoundResults(Round result, string gameid, string userid);


        ICollection<string> GetPlayerListForGameId(string gameid);
        ICollection<Pad> GetFinishedPadsForGame(string gameid);
        void DeleteGame(string gameid);
    }
}
