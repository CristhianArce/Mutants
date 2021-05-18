**Mutants**
----
  This API is designed to validate a DNA sequence if it is from a human or a mutant, the validation method will store the DNA sequence as a unique key.<br><br>
  The API also can retrieve information about the poblation stored.

* **URL**

  /mutant/

* **Method:**
  
  `POST`
  
* **Data Params**

  The body payload to execute this endpoint properly is showed as follow:

  `
  { "dna": [ "ATGCGA", "CCGTGC", "TTATGT", "AGAAGG", "CCCATA", "TCACTG" ] }
  `
  
  The given data will only contain the following characters 'A', 'T', 'C', 'G', and every sequence must have the same length as the whole dna array length as a NxN matrix. <br><br>
  
  If the DNA sequence has more than one subsequence with the following criteria (given a DNA object if it has the same nitrogenous base four times continuously either horizontally, vertically or diagonally it means that the person is a mutant).
  
* **Success Response:**
  
  If the DNA sequence given is from a mutant the API will return a Http status code 200 OK.

  * **Code:** 200 OK <br />
 
* **Error Response:**

  If the DNA sequence given is from a human the API will return a Http status code 403 FORBIDDEN, also if the DNA sequence is not NxN (Symmetric) or if the given DNA does not have a correct nitrogenous base the response will be a Http status code 403 FORBIDDEN.
  
  * **Code:** 403 FORBIDDEN <br />
----

* **URL**

  /stats/

* **Method:**
  
  `GET`
  
* **Data Params**

  Not body required.
  
* **Success Response:**
  
  This endpoint returns a object with the general info about the poblation stored in the database.

  * **Code:** 200 OK<br />
    **Content:** `{
    "count_mutant_dna": 1,
    "count_human_dna": 1,
    "ratio": 1.0
    }`
 
  

* **Notes:**

  The Database for this project is too limited, for that reason i only have **5mb of database storage**.
