Data Quality in a Big Data Context
==================================

Also tentative title: Measuring Data Quality on Social Network Feeds

Also tentative title: Measuring Data Quality on Twitter

This project proposes a methodology to model and measure Data Quality in a Big Data context, in particular, a stream of Twitter feeds. We aim to quantify its quality by using a formal system defined in the article, and use it to classify the users based on the quality of their feeds given a particular hashtag.

Find the complete article at article.pdf.

Program Architecture
--------------------

Our program will contain 3 major modules and 2 storages:

* Feeds Ingestors: These are the services that gather data from Twitter and format it to a structure we will be able to process. Then, saves the processed feeds in the Feeds Storage. (Note that we say "feed" and not "tweet", as this service my also be able to stream and process Facebook feeds, for example)

* Data Quality Analyzers: These services gather the saved feeds by user and analyze the different quality dimentions of the data. Then it updates the calcuated data quality of the user in the Users Storage.

* Users API: These service exposes the information that the Users Storage saved, we will use it to query the Users Storage and find out the bests users for a given hashtag.

* Feeds Storage: Storage of the feeds by user. An inmemory key-word database like Redis my work for these needs, saving <user, feed> entries.

* Users Storage: Storage of the users profiles, with their computed data quality values. A MongoDB or Postgres should feets these needs.


Bibliography
------------

* Quality is Free, Crosby.
* I HAVE MORE, THIS SECTION IS NOT YET UPDATED
