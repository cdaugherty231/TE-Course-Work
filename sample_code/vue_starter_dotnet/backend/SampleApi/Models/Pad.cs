using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Threading.Tasks;

namespace SampleApi.Models
{
    public class Pad
    {
        private static int totalPadCount=0;

        private int padNum;
        public string Original_Owner { get;  }
        public string Original_Word { get; }

        public string InTheHandsOf { get; set; }
        
        public string LastGuess { get { return rounds.Count>0?rounds.Last().Guess:Original_Word; } }
        public string LastDrawing { get { return rounds.Last().Picture; } }

        private List<Round> rounds = new List<Round>();
        public Round[] Rounds { get { return rounds.ToArray(); } }

        public void AddRound(Round r)
        {
            rounds.Add(r);
        }

        public Pad(string owner,string word)
        {
            Original_Owner = owner;
            Original_Word = word;
            InTheHandsOf = owner;
            padNum = totalPadCount++; //number the pads to make them easier to find later
        }

     }
}
