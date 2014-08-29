Photopic
========

Photopic is a simple photo topic manager written to learn Clojure.

Getting started
---------------

To simply run the application:

	$ mvn compile clojure:run

Alternatively, to create and run a distributable:

	$ mvn package
	$ java -jar target/photopic-0.1.0-SNAPSHOT-jar-with-dependencies.jar

Or, to run within the Clojure REPL:

	$ mvn process-resources clojure:repl

	user=> (use 'photopic)
	user=> (run)

Then visit <http://localhost:8080/>.
