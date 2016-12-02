[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy?template=https://github.com/contentful/contentful-java-fullstack)

# Contentful Java Fullstack Getting Started

[https://www.contentful.com](Contentful) is a content management platform for web applications, mobile apps and connected devices. It allows you to create, edit & manage content in the cloud and publish it anywhere via powerful API. Contentful offers tools for managing editorial teams and enabling cooperation between organizations.

This repository shows you how to use Contentful and Java Spring Boot together.

## Structure of the example

The page created contains products with a title, image, category, description, brand and tags. In Contentful, this is called a 'content type', and each content type is part of a space's 'content model' that allows you to relate resources for one project together. [Read more about our content model](https://www.contentful.com/developers/docs/concepts/data-model/).

We developed this example using the content model that comes pre-loaded in our "Product Catalogue" space template. Next you'll create your own space and replace the content of our example with your entries, so you can edit them and understand how Contentful works with your content.

## Running the app

You can deploy the app using Heroku to see how it works and experiment.

![Deploy your app to Heroku](/assets/deploying-to-heroku.gif)

1. Click this Heroku button -> [![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy).
2. [Sign up or sign in](https://id.heroku.com/signup/www-header) to Heroku.
3. Give the app a name, or use a pre-difined one.
4. Watch the app deploy.
5. Open the app.

This app uses our Product Catalogue example, which you can use to power your own sites.

## Getting started locally

### Download the example

To run the app locally you will need the source code, which you can get the source code for this app by cloning this repository or from Heroku.

### Cloning from heroku

To download the source from heroku you need the [heroku command line, or heroku toolbelt](https://devcenter.heroku.com/articles/heroku-command-line) and use the following commands:

```bash
heroku login # login to you heroku account
heroku git:clone ./ -a <contentful_app_id> # clone the app from heroku to your local filesystem
```

### Run it locally

Once you have the source code, run it locally with the following command:

```bash
./gradlew run
```

This will install all dependencies and run a local tomcat server on port `8080`, which you can open in your browser at _http://localhost:8080_.

You should see an HTML page loaded with products from our example space. You can click on them to see more details.

## Create a Space

To create a new space, follow these steps:

- Open, and log in to [Contentful's web app](https://app.contentful.com), select the _APIs_ tab, and then _website key_. On this page you can see your 'space id' and 'API keys'.
- Create an example space selecting the "product catalogue" template.
- Open _Main.java_, and replace the values of `SPACE_ID` and `ACCESS_TOKEN` with your new values.
- Close all running instances of the app and re-run `./gradlew run` to update the app with the newest changes.

Hit _refresh_ in your browser and you\'re done! You\'re now running the application reading entries from your own Contentful space. In the next step we will explain how to deploy your application to Heroku and access your site from an external URL.

## Update your Heroku app

Now that you have verified that the webserver runs the way it should To upload your app to Heroku you will need the [Heroku toolbelt](https://devcenter.heroku.com/articles/heroku-command-line) and run the following commands to upload to Heroku:

```bash
git add . git commit -m 'Changed credentials'
git push heroku master
```

To see your app running your content on a remote heroku machine, do the following:

```bash
heroku open
```

## Deployed successfully

And that's it! Your own custom application is now running remotely and consuming content from Contentful. We suggest you now take a look inside the code to see how it works.
