using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Threading.Tasks;

namespace SampleApi.Models
{
    public class Round
    {
        public bool IsDraw { get; set; } = false;
        public string Guess { get; set; }
        public string Picture { get; set; }

        public string DoneBy { get; set; }

        public Round()
        { }
        public Round(bool isDraw, string playerName, string data)
        {
            this.IsDraw = isDraw;
            this.DoneBy = playerName;
            if (isDraw)
            {
                this.Guess = data;
            }
            else
            {
                this.Picture = data;
            }
           
        }


    }
}
