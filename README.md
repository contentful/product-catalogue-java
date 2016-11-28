[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy?template=https://github.com/contentful/contentful-java-fullstack)

Contentful Java Fullstack Getting Started
=========================================
>>>>>>> Creating heroku button

# Contentful Java Fullstack Getting Started

This repository is used for showing how to use Contentful and Java Spring Boot together.

## Running the app

An easy way to deploy this application is using Heroku.

1. Click this heroku button: [![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy)
1. Log into Heroku, or sign up
1. Give the app a nice name, or decide not to, and take a predifined one.
1. Watch the app depoy

Just follow these few simple steps once you have successfully [signed up](https://id.heroku.com/signup/www-header) and [installed the Heroku toolbelt](https://toolbelt.heroku.com/):

*TBD*

This is a simple Product Catalogue, that you can use to run your site powered by Contentful immediately.

To deploy this example for free on Heroku, click this button:
 Deploy
 Then set the apiToken and spaceKey variables in our example apps to your Heroku URL (it'll be in the format https://my-example-app.herokuapp.com).
 Your site is ready!

## Geting Started Locally

### Download the example

To get started with your website running Java with Spring Boot, download the Product Catalog example source code. It allows you to fetch content from Contentful and display it on your pages. You can either download the zip or clone our repository:

> git clone git@github.com:contentful/contentful-java-fullstack.git

### Run it locally

Open a terminal, point it to your project location and run the following commands

> ./gradlew run

To see the content in your browser (home page with all the blog posts or products), run

> xdg-open https://localhost:8080

on Linux, or

> open https://localhost:8080

on Mac

You should see an HTML page loaded with Products of our example Space. You can click on them to see more details.


## Structure of the example

Our page contains some products with title, image, category, description, brand and tags. This is what we call content model in Contentful.
Content in Contentful is organized into spaces, so that related resources for one project can be grouped together into one repository. Each space has its own content model (read more: https://www.contentful.com/developers/docs/concepts/data-model/).
This example was developed using the content model that comes pre loaded in our "Product Catalogue" space template.
Let\'s now create your own space so you can replace the content of our example with your entries, so you can edit them and understand better how Contentful works.

### Create a Space

* Access [Contentful's Web App](https://app.contentful.com)
** Still in Contentful's UI
** Select APIs Tab
** Select Website Key
** In this page you can see your Space ID and API Keys. These values will be used in the next step.
* Create an example space selecting the "Product Catalogue" template
* Replace the API Keys

Open the file `Main.java`
Replace the `SPACE_ID` and `ACCESS_TOKEN` with your values ..

*REPLACE WITH CONFIGURATION FILES*

> [CTRL + C]
> ./gradlew run

Hit refresh in your browser and you're done! You're now running your Ruby application reading your own Contentful Space.
On the next step we will explain how to deploy your application and access your site from external URLs.

Show how to deploy the example application on Heroku
----------------------------------------------------

Show how to access the example app from an external URL (not localhost)
