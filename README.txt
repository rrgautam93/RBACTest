Hello,

This is a program written to be able to use CLI to check if a user has authorization to perform an action on a resource.

==========
Code description:

There are no frameworks.

The list of Users,Resource vs Role mappings are in UserandResourcevsRole class in StorageService package. There are mappings for each of the 3 roles.
Note, the roles have to be in order as we use this order to start from the minimum role and then move on to the maximum role.

There is a mapping for Developer who can read and write to S3
The Analyst can read only from S3
The Admin can do R/W/D
There is a user Cleanup with dual(R+D) role. This is to see if we are only using minimum role for the required job.

The accesses allowed for each Roles are in the Roles enum description. 

==========
Assumptions:

Higher Roles have more access types in addition to a lower role. i.e Higher roles cannot miss out on any lesser role's access(If i am owner, I should have read and write access too)

The 'lesser' role is determined by its order in the role enum, which is silly but we do have a method to take input and then order it. This can be solved by having a role priority value.

User is authenticated already, we only deal with authorization

There are no Users with same name in company(can be fixed by creating a user id object). Also name is case sensitive.

Is it production ready? It works, is right, and should be fast for small number of data.

==========
Running the program:

Run the main in RBAC class.

It takes first input as the number of cases you wish to check for:
2 (e.g)
Then for each case it will ask you to enter User, S3(only one resource is available so enter it) and the access being requested for.
By default available users: Developer, Admin, Analyst, Cleanup
Only Resource available: S3 (You can change this in the StorageService package)
Access types can only be of READ , WRITE , DELETE and is case sensitive
Then after entering this the program will give an output which consists of 1 explain statement, and 1 true or false for the query. This will go on for as many cases as you have entered.



Thanks,
Gautam
