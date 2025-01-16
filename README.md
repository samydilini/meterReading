Meter Reading
=============

This is a simple example of a meter reading system. It is a simple system that allows you to read the meter inputs from a input file and create insert statements for a table named meter_readings.

The system is written in Kotlin and uses Gradle as the build system.

The system is designed to be run from the command line and takes an input file name as a parameter.

The input file is a simple CSV file.

How to run
----------

build - `./gradlew clean build`

run   - `./gradlew run --args="src/main/resources/input.csv"`

The system will read the input file and generate the insert statements for the meter_readings table.


Problem Statement
-----------------

* Write a piece of code which reads the example in resource folder and generates insert statements for the meter_readings table below.</br>
* Please ensure the implementation is prepared to handle files of very large sizes.</br>

  * Use any (or no) CSV parser/ORM.</br>
* For this assignment success would mean as close to production grade implementation as possible, which means</br>
  * idiomatic code structuring,
  * readability,
  * performance optimization,
  * basic testing,
  * and anything else that you deem feasible.
* Our estimate for this assignment is about half a day of your time.
* Some aspects of the problem statement are intentionally kept open-ended to allow
  space for bringing your own thought process & strengths to the table and seeing how
  you bind ambiguous aspects of a problem space.
  * You’re encouraged to use the language/tools of your choice that you think can help
    achieve the best outcome for this exercise.
  
###  EXAMPLE DATA
* The format of the input file is NEM12 (reference PDF).
* There is a hierarchy to the lines: for example,
  * multiple `300 records` belong to the `200 record`. Of interest for this specific task are the NMI (second value in the `200 record` ‒ NEM1201009 in this example);
  * the interval length (ninth value in the 200 records ‒ 30 in this example);
  * the interval date (second value in the 300 records ‒ e.g. 20050301);
  * and the interval values, which we call consumption (values 3-50 in the 300
records ‒ e.g. 0.461).

300 record: A row in the sample input that starts with 300.</br>
200 record: A row in the sample input that starts with 200.

   ###  meter_readings TABLE


CREATE TABLE STATEMENT:

``
create table meter_readings (
id uuid default gen_random_uuid() not null,
"nmi" varchar(10) not null,
"timestamp" timestamp not null,
"consumption" numeric not null,
constraint meter_readings_pk primary key (id),
constraint meter_readings_unique_consumption unique ("nmi", "timestamp")
);
``