Problem Description:

Imagine we have a system that stores files, and these files can be grouped into collections. We are interested in knowing where our resources are 
being taken up.  

For this system we would like to generate a report that lists:

The total size of all files stored; and
The top N collections (by file size), where N can be a user-defined value 
An example input into your report generator might look like:  

1 file1.txt (size: 100)
2 file2.txt (size: 200) in collection "collection1"
3 file3.txt (size: 300) in collection "collection2"
4 file4.txt (size: 200) in collection "collection1"
5 files.txt (size: 10)

==================================================================================================
You should encourage candidates to transform the above into an in-memory representation of their choice (e.g. List<File> or File[]).

Some mental model: It can sometimes be helpful to clarify by saying something along the lines of "you can think of collections as being like tags for files".

Files may not be in a collection. How does the candidate deal with that? Do they pick up on it?
