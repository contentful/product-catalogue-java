[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy?template=https://github.com/contentful/contentful-java-fullstack)

# Contentful Java Fullstack Getting Started

[https://www.contentful.com](Contentful) is a content management platform for web applications, mobile apps and connected devices. It allows you to create, edit & manage content in the cloud and publish it anywhere via powerful API. Contentful offers tools for managing editorial teams and enabling cooperation between organizations.

This repository shows you how to use Contentful and Java Spring Boot together.

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

### Cloning from GitHub or downloading the zip

Use the following command to clone this repository:

```bash
git clone git@github.com:contentful/contentful-java-fullstack.git
```

Or you can download the code as a [zip file from GitHub](https://github.com/contentful/contentful-java-fullstack/archive/master.zip).

### Run it locally

Once you have the source code, run it locally with the following command:

```bash
./gradlew run
```

This will install all dependencies and run a local tomcat server on port `8080`, which you can open in your browser at _http://localhost:8080_.

You should see an HTML page loaded with products from our example space. You can click on them to see more details.

## Structure of the example

The page contains products with a title, image, category, description, brand and tags. In Contentful, this is called a 'content type', and each content type is part of a space's 'content model' that allows you to relate resources for one project together. [Read more about our content model](https://www.contentful.com/developers/docs/concepts/data-model/).

We developed this example using the content model that comes pre-loaded in our "Product Catalogue" space template. Next you'll create your own space and replace the content of our example with your entries, so you can edit them and understand how Contentful works with your content.

## Create a Space

To create a new space, follow these steps:

- Open, and log in to [Contentful's web app](https://app.contentful.com), select the _APIs_ tab, and then _website key_. On this page you can see your 'space id' and 'API keys'.
- Create an example space selecting the "product catalogue" template.
- Open _Main.java_, and replace the values of `SPACE_ID` and `ACCESS_TOKEN` with your new values.
- Close all running instances of the app and re-run `./gradlew run` to update the app with the newest changes.

Hit _refresh_ in your browser and you\'re done! You\'re now running the application reading entries from your own Contentful space. In the next step we will explain how to deploy your application to Heroku and access your site from an external URL.

## Update your Heroku app

Now that you have verified that the webserver runs the way it should To upload your app to Heroku you will need the [Heroku toolbelt](https://devcenter.heroku.com/articles/heroku-command-line) and depending on how you downloaded the source code, you will need to follow different steps.

### Cloned from Heroku

Run the following commands to upload to Heroku:

```bash
git add . git commit -m 'Changed credentials'
git push heroku master
```

Now heroku will build and run the new sample. Once the command completes, continue with [opening it remotely](#opening-the-remote-app).

### Cloned from Github or downloaded as a ZIP archive

You need to create a new heroku app and add the changes to it's git repository:

```bash
heroku create
```

Watch the output for the name of your newly created app, it will look something like _https://warm-beyond-45568.herokuapp.com_ and _https://git.heroku.com/warm-beyond-45568.git_ for the git repository. In this case, the new app is called `warm-beyond-45568`.

If you downloaded this app as a zip file, you will also need to create a git repository (ignore this step if you cloned the GitHub repository):

```bash
git init . # only when downloaded as a zip
```

To commit your changes to heroku, use these commands:

```bash
git add .
git commit -m 'Changed credentials'
```

Now you have a git repository with your new changes and you can create the remote deploy target:

```bash
heroku git:remote --app warm-beyond-45568 # Replace with the name of your app
```

When this is complete, you can deploy the code to heroku, build and run it remotely:

```bash
git push heroku master
```

Now you see the app running your content on a remote heroku machine:

```bash
heroku open
```

## Deployed successfully

And that's it! Your own custom application is now running remotely and consuming content from Contentful. We suggest you now take a look inside the code to see how it works.
