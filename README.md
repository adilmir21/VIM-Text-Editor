VIM Text Editor - Java
It is a term project with is a clone of VIM with some functionalities. 

1. Save
Summary: A user can save the written text to a file.
Actors: user
Preconditions: Text editor is currently running in command mode
Description: When a user saves the text. It stores the file by default
name.
Postconditions: The file is created and saved.

2. Save As
Summary: A user can save the written text to a file with desired file name.
Actors: user
Preconditions: Text editor is currently running in command mode.
Description: When a user saves the text, it stores the file by the desired
name. This is
done by pressing sav and giving the filename.
Postconditions: The file is created and saved by desired name.

3. Quit
Summary: User can quit editor
Actors: User
Preconditions: The editor must be opened / running in command mode
Description: A user can quit the editor. If file is not saved then a save pop
up will
appear.
Post conditions: User quits the file.

4. Movement commands
Summary: User can move up, down, left, right.
Actors: User
Preconditions: The file must be in normal mode.
Description: The user can move to any desired position.
Post conditions: User has modified its position to the desired line.

5. Copy
Summary: User can copy text, line, lines
Actors: User
Preconditions: Current line must contain some data.
Description: The user can copy the current line/ word/ lines.
Post conditions: Current line / word/ lines is copied

6. Paste
Summary: User can paste the copied data
Actors: User.
Preconditions: Data to be pasted must be present in the database.
Description: The user can paste the data in the specified location.
Post conditions: Data is pasted to the desired location in the file.

7. Enter edit mode
Summary: User will enter in edit mode
Actors: User
Preconditions: The file can only be viewed.
Description: The user can enter into the edit mode and edit file.
Post conditions: The file can both be viewed and edit.

8. Leave Edit Mode
Summary: User exits edit mode
Actors: User
Preconditions: The user was in edit mode
Description: User leaves edit mode and can no longer use edit mode functionalities.
Post conditions: The file can only be viewed.

9. Insert a line and Enter edit mode
Summary: User will insert a line and enter in edit mode
Actors: User
Preconditions: The file can only be viewed.
Description: The user can enter into the edit mode and edit file i.e insert a line.
Post conditions: The file can both be viewed and edited.

10. Edit Text
Summary: User can edit text.
Actors: User
Preconditions: user in edit mode.
Description: The user can enter into the edit mode and edit text.
Post conditions: The file can both be viewed and edited.

11. Insert
Summary: User will enter in edit mode to insert keys.
Actors: User
Preconditions: The file can only be viewed.
Description: The user can enter into the edit mode and edit file i.e insert any key.
Post conditions: The file can both be viewed and edited.

12. Delete
Summary: User will delete line in normal mode.
Actors: User
Preconditions: The file can only be viewed.
Description: The user can enter into the normal mode to select and delete a line.
Post conditions: The file can both be viewed and edited.
User Has multiple options.
1. UI version
2. Console Version

UI version uses javaFX and Java while the console version only uses Java.
Another way the user can run the application is throug ".Jar" file.

