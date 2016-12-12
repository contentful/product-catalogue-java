[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy)

Contentful Java Fullstack Getting Started
=========================================

This repository is used for showing how to use Contentful and Java Spring Boot together.

## Running the app

An easy way to deploy this application is using Heroku (Click image to enlarge)


<img src="/assets/deploying-to-heroku.gif" alt="click to enlarge" height="300">


1. Click this heroku button: [![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy).
1. [sign up](https://id.heroku.com/signup/www-header) to heroku
1. Give the app a nice name, or decide not to, and take a predifined one.
1. Watch the app depoy.
1. Open the just deployed app.

This is a simple Product Catalogue, that you can use to run your site powered by Contentful immediately.

# Geting Started Locally

## Download the example

To get started with your website running Java with Spring Boot, download the Product Catalog example source code. This can be done by either using the source of the just deployed heroku app or by cloning this repository.

### Cloning from heroku

To download the source from heroku you need the [heroku command line, or heroku toolbelt](https://devcenter.heroku.com/articles/heroku-command-line) and the following two commands to download your source:

```shell
 heroku login # login to you heroku account
 heroku git:clone ${FOLDER} -a ${MY_CONTENTFUL_APP} # clone the app from heroku to your local filesystem
```

### Cloning from github or downloading the zip

With git installed, please use the following command line to clone this repository:

```shell
 git clone git@github.com:contentful/contentful-java-fullstack.git
```

Lastly you could also download the source via a [zip file from github](https://github.com/contentful/contentful-java-fullstack/archive/master.zip).

## Run it locally

Once you got the source downloaded some way, please feel free to run it locally:

```shell
 ./gradlew run
```

This will install all dependencies and run a local tomcat server at address 8080, serving the content. To see the content in your browser open this url after starting the server [http://localhost:8080](http://localhost:8080), by either clicking the link, or typing either

```shell
 xdg-open https://localhost:8080
```
on Linux, or

```shell
 open https://localhost:8080
```

on Mac.

You should see an HTML page loaded with products of our example space. You can click on them to see more details.


## Structure of the example

Our page contains some products with title, image, category, description, brand and tags. This is what we call content model in Contentful.
Content in Contentful is organized into spaces, so that related resources for one project can be grouped together into one repository. Each space has its own content model [read more on our docs](https://www.contentful.com/developers/docs/concepts/data-model/).

This example was developed using the content model that comes pre loaded in our "Product Catalogue" space template.
Let\'s now create your own space so you can replace the content of our example with your entries, so you can edit them and understand better how Contentful works.

# Using your own content

In order to interact more with Contentful, it is recommended, that you use your own space in Contentful, so that you can change it and see how the app reacts.

## Create a Space

To create a new space to be used, please follow these steps:

* Open and log in to [Contentful's Web App](https://app.contentful.com)
** Select APIs tab.
** Select website key.
** In this page you can see your space id and api keys.
* Create an example space selecting the "product catalogue" template
* Replace the API Keys
** Open the file `Main.java` on your local system.
** Replace the `SPACE_ID` and `ACCESS_TOKEN` with your values the values from above.
* Rerun the app
** close all runing instances of the app (`[CTRL + C]`)
** rerun `./gradlew run` to update the app with the newest changes.

Hit refresh in your browser and you\'re done! You\'re now running your spring application reading your own Contentful space.
On the next step we will explain how to deploy your application to heroku and access your site from external URLs.

# Update your Heroku App

Now that you have verified that the webserver runs the way it should locally, it is time to upload it to heroku. To do this you need the [heroku command line, or heroku toolbelt](https://devcenter.heroku.com/articles/heroku-command-line). Depending on how you downloaded the source code before, you need to follow different steps.

## Cloned from Heroku

Perfect, you simply run

```shell
 git add .
 git commit -m 'Changed credentials to mine'
 git push heroku master
```

to upload the changes to heroku. Now heroku will build and run the new sample. Once the command returns, continue with [opening it remotely](#opening-the-remote-app).

## Cloned from Github or Downloaded as a ZIP archive

You need to create a new heroku app and add the changes to it's git.

```shell
 heroku create
```

Creates a new app on heroku. Please look in the output for the name of your newly created app, it will look something like:

```shell
 heroku create
 Creating app... done, ⬢ warm-beyond-45568
 https://warm-beyond-45568.herokuapp.com/ | https://git.heroku.com/warm-beyond-45568.git
```

In this case, the new app is called `warm-beyond-45568`. If you downloaded this app as a zip file, please also create a git repository: (Please ignore this step if you clone the github repository):

```shell
 git init . # only when downloaded as a zip
```
To now commit your changes to be uploaded to heroku, please use these commands:

```shell
 git add .
 git commit -m 'Changed credentials to mine'
```

Now that we have a git repository with our new changes, either by cloining it, or creating a complete new one, we can create the remote (the deploy target):

```shell
 heroku git:remote --app warm-beyond-45568 #remember that `warm-beyond-45568` is the name of your app...
```

Once this is done, you can now instruct git to deploy the code to heroku, build it an run it remotely:
```shell
 git push heroku master
```

This will upload your changes, and with the last step you can finally see it running your content on a remote heroku machine:

## Opening the Remote App

```shell
 heroku open
```

## Deployed successfully

Congratulations, you just followed all the steps needed from deploying a sample app to heroku, to changing it to use your content and the seeing it run remotely.
