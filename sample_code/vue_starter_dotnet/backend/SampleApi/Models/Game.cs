using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Threading.Tasks;

namespace SampleApi.Models
{
    public class Game
    {
        public bool InProgress { get; set; } = false;
        private int numPlayersUnsubmitted = 0;
      
        public bool IsWaitingOnPlayer { get; private set; }
        
        private IList<string> players = new List< string>();
        public string[] Players { get { return players.ToArray<string>(); } }

        private IList<Pad> pads = new List<Pad>();
        public Pad[] Pads { get { return pads.ToArray(); } }

        private IDictionary<string, Pad> passThePads = new Dictionary<string, Pad>();

        private int roundNum = 0;

        public bool IsOver { get { return roundNum == players.Count; } }

     
        private string[] randomWords;
        private HashSet<string> usedWords = new HashSet<string>();

        public void Initialize()
        {
            string [] easyWords = ReadFromFile("Easy.txt");    
            string[] medWords = ReadFromFile("Medium.txt");
            randomWords = new string[easyWords.Length + medWords.Length];
            Array.Copy(easyWords, 0, randomWords, 0, easyWords.Length);
            Array.Copy(medWords, 0, randomWords, easyWords.Length, medWords.Length);
            foreach (string player in players)
            {
                pads.Add(new Pad(player, GenerateRandomWord()));
            }
            InProgress = true;
            IsWaitingOnPlayer = false;
        }

        private string[] ReadFromFile(string fileName)
        {
            try
            {
                string fullPath = Path.Combine(Environment.CurrentDirectory, "Data",fileName);
                return System.IO.File.ReadAllLines(fullPath);
            }
            catch (Exception e)
            {
                return new string[] { "error reading word file" };
            }
        }

        public Round GetNextRoundForPlayer(string playerName)
        {            
            Pad playersPad = GetNextPadForPlayer(playerName);
            Round r = null;
            if (roundNum%2 == 0)
            {                
                r = new Round(true, playerName,playersPad.LastGuess);  //if it's a drawing round, they should have the last guess            
            }
            else
            {
                r = new Round(false, playerName, playersPad.LastDrawing);//if it's a guessing round, they should have the last drawing
            }
            passThePads[playerName]= playersPad;
            numPlayersUnsubmitted++;
            if (numPlayersUnsubmitted==players.Count) //once we've given out the next round to everyone, pass the pads and wait for everyone to respond before givign out the next round
            {
                PassThePads();
                IsWaitingOnPlayer = true;
            }
            return r;
        }

        private void PassThePads()
        {
            foreach (KeyValuePair<string, Pad> kvp in passThePads)
            {
                kvp.Value.InTheHandsOf = kvp.Key;
            }
        }

        public void AddRoundResults(Round result,string userid)
        {
            Pad p = GetPadInTheHandsOf(userid);
            p.AddRound(result);
            numPlayersUnsubmitted--;
            if (numPlayersUnsubmitted == 0)
            {
                roundNum++;
                IsWaitingOnPlayer = false;
            }
        }

        public bool AddPlayer(string userid)
        {
            if (!InProgress)
            {             
                if (!players.Contains(userid))
                {
                    players.Add(userid);
                }
                return true;
            }
            else
            {
                return false;
            }            
        }

 
        private string GenerateRandomWord()
        {
            Random r = new Random();
            string randomWord = "";
            while (randomWord.Length==0 || usedWords.Contains(randomWord))
            {
                randomWord =randomWords[r.Next(0, randomWords.Length)];
            }
            return randomWord;
        }

        private Pad GetNextPadForPlayer(string userId)
        {
            string getThePadFrom = userId; //assume round 1 it's your own
            if (roundNum>0)
            {
                int pi = players.IndexOf(userId);
                getThePadFrom = players[(pi + 1) % players.Count];//the last player gets a pad from player 0               
            }
            return GetPadInTheHandsOf(getThePadFrom);
        }

        private Pad GetPadInTheHandsOf(string userId)
        {
            return pads.FirstOrDefault(p => p.InTheHandsOf == userId);
        }
    }
}
