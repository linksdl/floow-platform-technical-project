## Floow platform technical challenge project

**==================== Editor log ======================**
|Date|Author|Description|Version|
|----|----|----|
|25/06/2021|Daolin Sheng|Create and implement the project|0.0.1|


### Table of Contents
- 1, Objectives
- 2, The APIs of Function
- 3, The structure of project
- 4, 


Objective:
> The objective of this challenge is to create a simple REST service that will manage details of drivers for use
within a hypothetical insurance service. For the purposes of this challenge, a driver record consists of the
following information:
- A unique ID for the driver
- Fisrt Name
- Last Name
- Date of Birth
- Creation Date

Details of drivers should be stored in a simple flat file. You may store dates in any format you wish.

### The APIs for Driver operations in a SpringBoot

|Operation|Path| Description|
|----|----|----|
|POST|/drive  | An POST endpoint to allow new drivers to be created and stored. |
|GET |/drives | A GET endpoint which returns a list of all existing drivers in JSON format.|
|GET |/drivers/byDate?date=<date>|A GET endpoint which returns a list of all drivers created after the specified date. Again, the list should be returned in JSON format. Again, the date parameter should use the format YYYY-MM-DD.|






