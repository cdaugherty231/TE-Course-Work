using System.Collections.Generic;
using Microsoft.AspNetCore.Mvc;
using AuctionApp.Models;
using AuctionApp.DAO;

namespace AuctionApp.Controllers
{
    [Route("[controller]")]
    [ApiController]
    public class AuctionsController : ControllerBase
    {
        private readonly IAuctionDao _dao;

        public AuctionsController(IAuctionDao auctionDao = null)
        {
            if (auctionDao == null)
                _dao = new AuctionDao();
            else
                _dao = auctionDao;
        }


    }
}
