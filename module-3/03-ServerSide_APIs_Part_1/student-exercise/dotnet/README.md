# Server-Side APIs: Part 1 Exercise (C#)

Previously, you created a command-line application that made requests to an API server. In this exercise, you'll re-create the API server in C# to handle `GET` and `POST` requests.

## Step One: Open solution and explore starting code

Open `Server-Side-APIs-Part-1-Exercise.sln` and expand the folders in the `AuctionApp` project.

### Models

In the `Models` folder, there's an `Auction.cs` model that has the same properties as the `Auction` class you've been working with.

### DAO

In the `DAO` folder, there's an `AuctionDao.cs` class that provides data access code. To reduce complexity, a static `List` is used instead of a real database. Also, there are some methods in there that you'll call from the controller.

### Controllers

In the `Controllers` folder, there's an `AuctionsController.cs` class that you'll work in today. You'll create the action methods for the API. The controller class has already been decorated with the `[Route]` and `[ApiController]` attributes.

Note the value `[Route]` attribute. The name of the controller is `AuctionsController`—this means the route for the controller is `/auctions`.

### Unit tests

In the `AuctionApp.Tests` project, you'll find the unit tests for the methods you'll write today. After you complete each step, more tests pass.

If you also want to run the server and test with Postman or the browser, feel free to do so. However, you should primarily focus on having the unit tests pass.

## Step Two: Implement the `List()` action

This method's purpose is to return a list of all auctions.

In `AuctionsController.cs`, create a method named `List()` that returns a `List<Auction>`. Then add the HTTP attribute to have this method respond to `GET` requests for `/auctions`.

All this method needs to do is return `_dao.List()`.

If completed properly, the `ListMethod_ExpectList` test passes.

## Step Three: Implement the `Get()` action

This method's purpose is to return a specific auction based on the value passed to it.

In `AuctionsController.cs`, create a method named `Get()` that accepts an `int` and returns an `Auction`.

Add the HTTP attribute to have this method respond to `GET` requests for `/auctions` with a number following it—for example, `/auctions/7`. You'll need to pass a value to the attribute to tell it to accept a dynamic parameter.

Have this method return an `Auction` from `_dao.Get()`, passing it the `int` that was passed to the action method.

If completed properly, the `GetMethod_SpecificAuction_ExpectAuction` and `GetMethod_NonExistentAuction_ExpectNull` tests pass.

## Step Four: Implement the `Create()` action

This method's purpose is to add the auction that's passed to it.

In `AuctionsController.cs`, create a method named `Create()` that accepts an `Auction` and returns an `Auction`.

Add the HTTP attribute to have this method respond to `POST` requests for `/auctions`.

Next, have this method call `_dao.Create()`, passing it the `Auction` that was passed to the action method. Set the return value from `_dao.Create()` to a new `Auction` object.

Then check the returned object's `.IsValid` property. If it's `true`, return the new object; if `false` return `null`.

If completed properly, the `CreateMethod_ExpectSuccess` test passes.

## Step Five: Add searching by title

This method's purpose is to enable searching by title. You'll pass in an optional query string parameter that returns all auctions with the search term in the title.

In `AuctionsController.cs`, return to the `List()` action method. Add a `string` parameter with the name `title_like`. You'll need to make this parameter optional, which means you set a default value for it in the parameter declaration. In this case, you want to set the default value to an empty string `""`. Your parameter declaration should look like `string title_like = ""`.

In the `List()` method, before `_dao.List()` is called, add an `if` statement to check if `title_like` isn't an empty string. If it's not empty, return `_dao.SearchByTitle()` passing it `title_like`; else you return `_dao.List()` just like before.

If completed properly, the `SearchByTitle_ExpectList` and `SearchByTitle_ExpectNone` tests pass.

## Step Six: Add searching by price

This method's purpose is to enable searching by price. You'll pass in an optional query string parameter that returns all auctions with the current bid less than or equal to the value passed to it.

In `AuctionsController.cs`, return to the `List()` action method. Add another optional parameter after `title_like`—this time a `double` with the name `currentBid_lte`. Set the default value to `0`. Based on how `title_like` was declared, you should be able to figure out how to declare `currentBid_lte`.

In the `List()` method, add another `if` statement to check if `currentBid_lte` is greater than zero. If it's greater than zero, return `_dao.SearchByPrice()`, passing it `currentBid_lte`.

If completed properly, the `SearchByPrice_ExpectList` and `SearchByPrice_ExpectNone` tests pass.
