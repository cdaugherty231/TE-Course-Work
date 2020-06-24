using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Collections.Generic;
using FluentAssertions;
using Moq;
using AuctionApp.Models;
using AuctionApp.DAO;
using AuctionApp.Controllers;
using System;

namespace AuctionApp.Tests
{
    [TestClass]
    public class AuctionsControllerTests
    {
        [TestMethod]
        public void ListMethod_ExpectList()
        {
            List<Auction> expected = new List<Auction>
            {
                new Auction() { Id = 1, Title = "Bell Computer Monitor", Description = "4K LCD monitor from Bell Computers, HDMI & DisplayPort", User = "Queenie34", CurrentBid = 100.39 },
                new Auction() { Id = 4, Title = "Annie Sunglasses", Description = "Keep the sun from blinding you", User = "Sallie_Kerluke4", CurrentBid = 69.67 },
                new Auction() { Id = 7, Title = "Molex Gold Watch", Description = "Definitely not fake gold watch", User = "Stuart27", CurrentBid = 188.39 },
                new Auction() { Id = 10, Title = "Dragon Plush", Description = "Not a real dragon", User = "Bernice", CurrentBid = 19.50 }
            };

            Mock<IAuctionDao> mockDao = new Mock<IAuctionDao>();
            mockDao.Setup(dao => dao.List()).Returns(expected);
            AuctionsController controller = new AuctionsController(mockDao.Object);

            //IEnumerable<Auction> actual = controller.List();

            //because parameters will be added to this method, we will need to try with different amounts of parameters
            object actual = SafeReflection.InvokeMethod(controller, "List", new object[] { string.Empty, 0 });

            if (actual == null)
                actual = SafeReflection.InvokeMethod(controller, "List", new object[] { string.Empty });

            if (actual == null)
                actual = SafeReflection.InvokeMethod(controller, "List", new object[] { });

            Assert.IsNotNull(actual);
            Assert.IsInstanceOfType(actual, typeof(IEnumerable<Auction>));
            expected.Should().BeEquivalentTo(actual as IEnumerable<Auction>);
        }

        [TestMethod]
        public void GetMethod_SpecificAuction_ExpectAuction()
        {
            Auction expected = new Auction() { Id = 10, Title = "Dragon Plush", Description = "Not a real dragon", User = "Bernice", CurrentBid = 19.50 };

            Mock<IAuctionDao> mockDao = new Mock<IAuctionDao>();
            mockDao.Setup(dao => dao.Get(It.IsAny<int>())).Returns(expected);
            AuctionsController controller = new AuctionsController(mockDao.Object);

            //Auction actual = controller.Get(10);

            object actual = SafeReflection.InvokeMethod(controller, "Get", new object[] { 10 });

            Assert.IsNotNull(actual);
            expected.Should().BeEquivalentTo(actual);
        }

        [TestMethod]
        public void GetMethod_NonExistentAuction_ExpectNull()
        {
            Mock<IAuctionDao> mockDao = new Mock<IAuctionDao>();
            mockDao.Setup(dao => dao.Get(It.IsAny<int>()));
            AuctionsController controller = new AuctionsController(mockDao.Object);

            //Auction actual = controller.Get(23);

            object actual = SafeReflection.InvokeMethod(controller, "Get", new object[] { 23 });

            //if this assertion fails, method or parameter has not yet been added. Need this test because `actual` will be null if method or parameter doesn't exist, and give a false positive
            Assert.IsTrue(SafeReflection.HasMethodWithParameterTypes(controller.GetType(), "Get", new Type[] { typeof(int) }));

            Assert.IsNull(actual);
        }

        [TestMethod]
        public void CreateMethod_ExpectSuccess()
        {
            Auction input = new Auction() { Id = null, Title = "Dragon Plush", Description = "Not a real dragon", User = "Bernice", CurrentBid = 19.50 };
            Auction expected = new Auction() { Id = 10, Title = "Dragon Plush", Description = "Not a real dragon", User = "Bernice", CurrentBid = 19.50 };

            Mock<IAuctionDao> mockDao = new Mock<IAuctionDao>();
            mockDao.Setup(dao => dao.Create(input)).Returns(expected);
            AuctionsController controller = new AuctionsController(mockDao.Object);

            //Auction actual = controller.Create(input);

            object actual = SafeReflection.InvokeMethod(controller, "Create", new object[] { input });

            Assert.IsNotNull(actual);
            Assert.IsInstanceOfType(actual, typeof(Auction));
            Assert.IsTrue((actual as Auction).Id == 10);
            expected.Should().BeEquivalentTo(actual);
        }

        [TestMethod]
        public void SearchByTitle_ExpectList()
        {
            List<Auction> expected = new List<Auction>
            {
                new Auction() { Id = 2, Title = "Pineapple Smart Watch", Description = "Pears with Pineapple ePhone", User = "Miller.Fahey", CurrentBid = 377.44 },
                new Auction() { Id = 7, Title = "Molex Gold Watch", Description = "Definitely not fake gold watch", User = "Stuart27", CurrentBid = 188.39 }
            };

            Mock<IAuctionDao> mockDao = new Mock<IAuctionDao>();
            mockDao.Setup(dao => dao.SearchByTitle("watch")).Returns(expected);
            AuctionsController controller = new AuctionsController(mockDao.Object);

            //IEnumerable<Auction> actual = controller.List("watch");

            //because parameters will be added to this method, we will need to try with different amounts of parameters
            object actual = SafeReflection.InvokeMethod(controller, "List", new object[] { "watch", 0 });

            if (actual == null)
                actual = SafeReflection.InvokeMethod(controller, "List", new object[] { "watch" });

            Assert.IsNotNull(actual);
            Assert.IsInstanceOfType(actual, typeof(IEnumerable<Auction>));
            expected.Should().BeEquivalentTo(actual as IEnumerable<Auction>);
        }

        [TestMethod]
        public void SearchByTitle_ExpectNone()
        {
            string gibberish = "aergergvdasc";
            Mock<IAuctionDao> mockDao = new Mock<IAuctionDao>();
            mockDao.Setup(dao => dao.SearchByTitle(gibberish));
            AuctionsController controller = new AuctionsController(mockDao.Object);

            //IEnumerable<Auction> actual = controller.List(gibberish);

            //because parameters will be added to this method, we will need to try with different amounts of parameters
            object actual = SafeReflection.InvokeMethod(controller, "List", new object[] { gibberish, 0 });

            if (actual == null)
                actual = SafeReflection.InvokeMethod(controller, "List", new object[] { gibberish });

            //if this assertion fails, parameter has not yet been added to method. Need this test because `actual` will be null if parameter doesn't exist and give a false positive
            Assert.IsTrue(SafeReflection.HasMethodWithParameters(controller.GetType(), "List", new Dictionary<string, Type>() { { "title_like", typeof(string) } }));

            Assert.IsNull(actual);
        }

        [TestMethod]
        public void SearchByPrice_ExpectList()
        {
            List<Auction> expected200 = new List<Auction>
                {
                    new Auction() { Id = 1, Title = "$100.39 item", Description = "$100.39 item", User = "User1", CurrentBid = 100.39 },
                    new Auction() { Id = 4, Title = "$69.67 item", Description = "$69.67 item", User = "User2", CurrentBid = 69.67 },
                    new Auction() { Id = 7, Title = "$188.39 item", Description = "$188.39 item", User = "User4", CurrentBid = 188.39 }
                };
            List<Auction> expected150 = new List<Auction>
                {
                    new Auction() { Id = 1, Title = "$100.39 item", Description = "$100.39 item", User = "User1", CurrentBid = 100.39 },
                    new Auction() { Id = 4, Title = "$69.67 item", Description = "$69.67 item", User = "User2", CurrentBid = 69.67 }
                };
            List<Auction> expected100 = new List<Auction>
                {
                    new Auction() { Id = 4, Title = "$69.67 item", Description = "$69.67 item", User = "User2", CurrentBid = 69.67 }
                };

            Mock<IAuctionDao> mockDao = new Mock<IAuctionDao>();
            mockDao.Setup(dao => dao.SearchByPrice(200)).Returns(expected200);
            mockDao.Setup(dao => dao.SearchByPrice(150)).Returns(expected150);
            mockDao.Setup(dao => dao.SearchByPrice(100)).Returns(expected100);
            AuctionsController controller = new AuctionsController(mockDao.Object);

            //List<Auction> actual200 = controller.List(currentBid_lte: 200);
            //List<Auction> actual150 = controller.List(currentBid_lte: 150);
            //List<Auction> actual100 = controller.List(currentBid_lte: 100);

            object actual200 = SafeReflection.InvokeMethod(controller, "List", new object[] { string.Empty, 200d });
            object actual150 = SafeReflection.InvokeMethod(controller, "List", new object[] { string.Empty, 150d });
            object actual100 = SafeReflection.InvokeMethod(controller, "List", new object[] { string.Empty, 100d });

            Assert.IsNotNull(actual200);
            Assert.IsNotNull(actual150);
            Assert.IsNotNull(actual100);

            Assert.IsInstanceOfType(actual200, typeof(IEnumerable<Auction>));
            expected200.Should().BeEquivalentTo(actual200 as IEnumerable<Auction>);

            Assert.IsInstanceOfType(actual150, typeof(IEnumerable<Auction>));
            expected150.Should().BeEquivalentTo(actual150 as IEnumerable<Auction>);

            Assert.IsInstanceOfType(actual100, typeof(IEnumerable<Auction>));
            expected100.Should().BeEquivalentTo(actual100 as IEnumerable<Auction>);
        }

        [TestMethod]
        public void SearchByPrice_ExpectNone()
        {
            Mock<IAuctionDao> mockDao = new Mock<IAuctionDao>();
            mockDao.Setup(dao => dao.SearchByPrice(0.01));
            AuctionsController controller = new AuctionsController(mockDao.Object);

            //List<Auction> actual = controller.List(currentBid_lte: 0.01);

            object actual = SafeReflection.InvokeMethod(controller, "List", new object[] { null, 0.01 });

            //if this assertion fails, parameter has not yet been added to method. Need this test because `actual` will be null if parameter doesn't exist and give a false positive
            Assert.IsTrue(SafeReflection.HasMethodWithParameters(controller.GetType(), "List", new Dictionary<string, Type>() { { "currentBid_lte", typeof(double) } }));

            Assert.IsNull(actual);
        }
    }
}
