#Website for finding cars



##Description

The program accepts a txt file filled in a certain way and performs the following operations:

[Registration](#registration)

[Change password](#Change password)

[Data change](#Data-change)

[Obtaining user information](#Obtaining-user-information)

##General rules for filling in the txt file

Each client must enter the following mandatory numbers (string) during registration:
0. description of the client's request: registration; data_renewal; password_recovery; get_information
1. login
2. password // password has at least 6 characters, (numbers, symbols, Latin letters) [0-9 +! @ # $% ^ & * + A-Z]
3.name
3. surname
4. year of birth


Each client can enter the following data (string):
6. brand of machine
7. it is the machine code
8. code word (for password recovery).
9. new password - always at position 9 (if necessary password recovery)

Maximum position in the file (number of lines): 20 - if you want to add other information;

Numbering according to the principle of using the index in the array (0 index is the first line).


##Algorithm of program operation.
1. Main class - reads the path of the file and passes it to the Read class
2. Read reads the information in the file and passes it to the Check class
3. The Scheck class is responsible for the following:
   -is there a correctly specified word of the client's request (registration, obtaining data ...)
   -if yes, whether the file meets all the requirements (for example, during registration, whether the password meets the requirements, whether the client
   already created and so on)
4. If all is well, the client is written to the database using the Write class (as well as during
   registrations are added to the data set Clients static Map <String, List <String>> clients)


###Registration
class Registration
before registration, the Clients static Map <String, List <String>> clients database is checked.
if your login already exists - you are denied registration.
At registration the data are entered from 0 to 8 lines

Example query:

registration

bohdan1987

111111

Bohdan

Shchehliuk

1987

mazda

22222

mazda2008


###Data update - Renewal class.
If you enter the correct password and login, the program overwrites the data.
When updating data, information is entered from 0 to 8 lines

Example query:

data_renewal

bohdan1987

111111

Bohdan

Shchehliuk

1987

mazda3

3333

magicWord

###Password update - Password_renewal class.
The user must point the solo command to 0 positions, specify the information he remembers
from the 1st to the 8th position and on the 9th position specify a new password.
If the number of points he will score as a result of the test> 100, as well as the password
meets certain criteria (the same as during registration), its data will be overwritten in a file.

Example query:

password_renewal

bohdan1987

b // everything the user remembers from the password
Bohdan

Shchehliuk

1987

mazda

22222

magic_word

b1987№% 22222

###Receiving information - class Get_information
The user must enter the correct command word, login and password.
As a result, he will receive information about his data from the database.

Example query:

get_information

bohdan1987

b1987№% 22222







