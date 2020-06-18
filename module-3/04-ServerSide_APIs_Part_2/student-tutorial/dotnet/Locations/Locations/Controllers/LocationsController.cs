using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

using Locations.DAO;
using Locations.Models;

namespace Locations.Controllers
{
    [Route("[controller]")]
    [ApiController]
    public class LocationsController : ControllerBase
    {
        private readonly ILocationDao _dao;

        public LocationsController(ILocationDao locationsDao = null)
        {
            if (locationsDao == null)
                _dao = new LocationDao();
            else
                _dao = locationsDao;
        }

        [HttpGet]
        public List<Location> List()
        {
            return _dao.List();
        }

        [HttpGet("{id}")]
        public ActionResult<Location> Get(int id)
        {
            Location location = _dao.Get(id);
            if (location != null)
            {
                return Ok(location);
            }
            else
            {
                return NotFound("Location does not exist");
            }
        }

        [HttpPost]
        public Location Add(Location location)
        {
            if (location != null)
            {
                Location returnLocation = _dao.Create(location);
                return returnLocation;
            }
            return null;
        }


    }
}
