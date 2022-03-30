---
layout: page
title: User Guide
---

Reache is a desktop app that helps busy working professionals manage their large list of contacts by providing an easy-to-use interface to store contacts and organize meetings. Reache is especially suited for professionals who would like to optimize their contact management by using a Command Line Interface (CLI).

## Table of Contents
* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## 1. Quick start

1. Ensure you have Java `11` or above installed in your Computer.

2. Download the latest `reache.jar` from [here](https://github.com/AY2122S2-CS2103T-W12-4/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your Reache.

4. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds.<br>

   ![Ui](images/Ui.png)

5. Refer to the [Features](#3-features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## 2. Introduction
### 2.1 Overview
Reache is a contact manager application that helps you:
- Store and organize contacts
- Easily sort and search through your contact list
- Plan and keep track of upcoming meetings

<br>

### 2.2 Interface Guide
#### 2.2.1 Main Window
Upon launching Reache, you will see the Main Window, which is depicted below. The Main Window displays your entire contact list as well as all upcoming meetings you have planned.

![Main Window](images/MainWindow.png)

The Main Window contains the following elements:
1. **Menu Bar**: Contains Reache's options and help.
2. **Command Box**: A dialog box from which you can type commands to use Reache.
3. **Result Display**: When you use the Command Box to enter a command, Reache will show the result of that command here.
4. **Contact List**: A list of all your contacts, sorted alphabetically. Each contact has a corresponding index number, which you can use to refer to that contact in commands.
5. **Meeting List**: A list of all your upcoming meetings, sorted chronologically. As with contacts, each meeting has a corresponding index number for use in commands.

<br>

#### 2.2.2 Contact Details Window
The Contact Details Window, which is depicted below, displays all the contact information associated with a specific contact.

![Contact Details Window](images/ContactDetailsWindow.png)

The Contact Details Window contains many of the same elements as the Main Window, like the Menu Bar, Command Box, and Result Display. In addition, it contains the following elements:
1. **Particulars**: Consists of their name, pronouns, job title, company, and tags. Tags are descriptive keywords that help you identify a person. For example, you might assign a contact the tag “Friend” to indicate that they are your friend.
2. **Contact Information**: A contact's phone numbers, email addresses, and physical addresses. Reache lets you assign *custom labels* to these fields to help you organize a contact's information. For example, a person might have a *personal* phone number and an *office* phone number.
3. **Meetings with Contact**: Whereas the Meeting List in the Main Window displays all your upcoming meetings, the Contact Details Window only displays upcoming meetings that involve the contact being viewed.

Now that you are familiar with Reache's interface, we recommend visiting [Getting Started With Reache]() to begin using the application.

<br>

## 3. Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>
- Words in `<UPPER_CASE>` are the parameters to be supplied by the user. <br>
  e.g. in `add n/<NAME>`, `NAME` is a parameter which can be used as `add n/Alex Dunphy`.

- Items in square brackets are optional. <br>
  e.g `n/NAME [t/TAG]` can be used as `n/Alex Dunphy t/Likes Science` or as `n/Alex Dunphy`.

- Items with ... after them can be used multiple times including zero times.
  e.g. `[ph/<PHONE_NUMBER> l/<LABEL>]...` can be used as ` `(i.e. 0 times), `ph/12345678 l/personal`, `ph/90123456 l/office ph/78901234` etc.

- Parameters can be in any order.

- `l/` is used to label parameters. They are optional.

</div>

### 3.1 Managing Contacts
#### 3.1.1 Adding a contact: `add`
Adds a person to the contact list.

Format: `add n/<NAME> [ph/<PHONE_NUMBER> l/<LABEL>]... [e/<EMAIL> l/<LABEL>]... [a/<ADDRESS> l/LABEL]... [t/TAG]...`

After adding a person to the contact list, you will be navigated to their contact details page. 
From this page, you can edit their contact details using the commands found under the [Editing Information](#33-editing-information) section.

Example: `add n/Alex Dunphy`

<br>

#### 3.1.2 Clearing your address book: `clear`
Clears all contacts and meetings from the address book.

Format: `clear`

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
This action is irreversible.
</div>

<br>

#### 3.1.3 Deleting a contact: `del`
Deletes the specified person from the address book.

Format: `del <INDEX NO>`

Example: `del 66`

<br>

#### 3.1.4 Editing a contact: `edit`
Enters editing mode to modify contact details in the address book.

Format: `edit <ANY NUMBER AND TYPE OF FIELDS IN ANY ORDER> `

Information about the details that can be added is found under the [Editing Information](#33-editing-information) section.

Example: `edit n/Alex ph/98765432 t/has kids`

<br>

#### 3.1.5 Editing the data file
_Reache_ data is saved as JSON files at /data/addressbook.json and /data/meetingbook.json. Advanced users are welcome to update data directly by editing the data file.
   
<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, _Reache_ will discard all data and start with empty data files at the next run.
</div>

<br>

#### 3.1.6 Saving changes
_Reache_ saves to the hard disk automatically after any command is issued that changes the data. There is no need to save manually.

<br>

### 3.2 Finding Contacts
#### 3.2.1 Finding contacts: `find`
Finds a person based on a search field and keywords provided. Searchable categories can be found in the [Editing Information](#33-editing-information) section.

Format: `find <OPTIONAL_FIELD> <KEYWORDS>`

Examples:<br>
`find c/Tesla SpaceX` Finds all contacts who work in `Tesla` or `SpaceX`.<br>
`find n/Katy Cathy Cate` Finds all contacts with the name `Katy` or `Cathy` or `Cate`.<br>
`find t/supplier` Finds all contacts who are tagged as `Supplier`. <br>
`find Alexandra` Finds all contacts who have `Alexandra` somewhere in their contact information.

**Note: `find` expects at least one keyword to match.**

<br>

#### 3.2.2 Listing all contacts: `list`
Shows a list of all contacts in the address book.

Format: `list`

<br>

#### 3.2.3 Viewing a person's full details: `view`
Displays the specified person's contact information and allows the contact to be edited.

Format: `view <INDEX NO>`

Example: `view 34`

<br>

#### 3.2.4 Returning after viewing a person's full details: `back`
Returns to the list of all contacts after viewing and/or editing a person's contact details.

Format: `back`

<br>

### 3.3 Editing Information
*Note:*
1. To edit existing information, adding a new entry with the same category/label as the existing entry will overwrite it with the new one. 
2. Difference between tags and labels: Labels distinguish multiple entries in the same field whereas tags group together any number of contacts based on some criterion.

#### 3.3.1 Symbols Legend

| Symbol | Meaning |
| --- | --- | 
| ... | Indicates that the preceding entry can be provided multiple times. |
| / | Used to indicate a label for the preceding field. <br> Labels are optional and if not provided, a default label will be assigned. <br> E.g. `ph/ 12345678 l/personal` labels the given number as "personal". |
| <...> | Indicates the argument that the user should provide in that area |

<br>

#### 3.3.2 Add/Edit phone numbers: `phone`
Format: `ph/<NUMBER 1> l/<LABEL> ph/<NUMBER 2> l/<LABEL>...`

Example: `ph/8765432 l/Personal ph/9753468 l/Office`

<br>

#### 3.3.3 Add/Edit emails: `email`
Format:  `e/<EMAIL 1> l/<LABEL> e/<EMAIL 2> l/<LABEL>...`

Example: `e/alex@reache.com l/Official; e/alex98@gmail.com`

<br>

#### 3.3.4 Add/Edit address: `address`

Format: `a/<ADDRESS 1> l/<LABEL>; a/<ADDRESS 2> l/<LABEL>...`

Example: `a/28 Francis Mine, Sacramento, CA - 654321 l/Home`  

<br>

#### 3.3.5 Add/Edit company: `company`

Format: `c/<COMPANY>`

Example: `c/Tesla`

<br>

#### 3.3.6 Add/Edit job title: `job`

Format: `j/<JOB TITLE>`

Example: `j/Software Engineer` 

<br>

#### 3.3.7 Add/Edit tags: `tag`

Format: `t/<TAG 1> t/<TAG 2>...`

Example: `t/Media Contact t/Has kids`

<br>

#### 3.3.8 Add/Edit pronoun: `pronoun`

Format: `pr/<PRONOUN 1> pr/<PRONOUN 2>...`

Example: `pr/He pr/Him`

<br>

#### 3.3.9 Delete field: `del`

Format: `del <TYPE 1> <LABEL 1> <TYPE 2> <LABEL 2>...`

`<TYPE>` refers to the category of information you wish to delete, as indicated by its command word.

Without a `<LABEL>`, the command will delete all information stored in `<TYPE>`.

Examples:

`del ph/ personal` -    Deletes the personal phone number of the contact.

`del a/` -         Deletes all addresses of the contact.

`del e/ Official` -   Deletes the Official email of the contact.

<br>

### 3.4 Managing Meetings
#### 3.4.1 Creating a meeting: `meet`
Create a meeting by specifying the following information:
- Agenda
- Meeting place
- Meeting date and time: in DD-MM-YYYY HH:mm format
- Attendees: in the form of index numbers of people on the displayed list

_Note:_ All fields are compulsory.

Format: `meet for/<AGENDA> in/<MEETING PLACE> on/<MEETING DATE AND TIME> with/<ATTENDEE 1 INDEX> [<ATTENDEE 2 INDEX>]…`

Example: `meet for/Project Discussion in/UTown on/28-04-2022 13:30 with/1 3 4`

<br>

#### 3.4.2 Updating meeting details: `update`
Update any of the meeting’s details by indicating the following:
- Meeting index: The index of the meeting you want to edit on the meetings list
- Any of the meeting details given under [2.4.1 Creating a meeting](#341-creating-a-meeting).

Format: `update <MEETING INDEX> [in/<MEETING PLACE> on/<MEETING DATE AND TIME> with/<ATTENDEE 1 INDEX>...]`

Example: `update 2 in/COM2 on/29-04-2022 20:00`

<br>

#### 3.4.3 Canceling a meeting: `cancel`
Cancel a meeting by specifying its index on the meetings list.

Format: `cancel <MEETING INDEX>`

Example: `cancel 2`

<br>

#### 3.4.4 Canceling all meetings: `cancel-all`
Clear your meetings list by canceling all meetings.

Format: `cancel-all`

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
This action is irreversible.
</div>

<br>

### 3.5 Viewing help: `help`
Shows a message explaining how to access the help page.

Format: `help`

<br>

### 3.6 Exiting the program: `exit`
Exits the program.

Format: `exit`

<br>

## 4. Command Summary

| **Action**              | **Format, Example**                                                                                                                                                                                                     |
|-------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add Contact**         | Format: `add n/<NAME>` <br> Example: `add n/Alex Dunphy`                                                                                                                                                                |
| **Edit Contact Info**   | Format: `edit <ANY NUMBER AND TYPE OF FIELDS IN ANY ORDER>` <br> Example: `edit n/Michael J Wolf pr/her j/Farmer c/FarmingInc ph/999 l/Police t/friend ph/123456`                                                       |
| **Delete Contact Info** | **Delete specific contact** <br> Format: `del <INDEX NO>` <br> Example: `del 88` <br> <br> **Delete contact fields** <br> Format: `del <ANY NUMBER AND TYPE OF FIELDS IN ANY ORDER>` <br> Example: `del p/ personal e/` |
| **Clear Address Book**  | Format: `clear`                                                                                                                                                                                                         |
| **Find Contacts**       | Format: `find <FIELD> <VALUE>` <br> Example: `find n/ Michael Scott`                                                                                                                                                    |
| **View Contact**        | Format: `view <INDEX>` <br> Example: `view 5`                                                                                                                                                                           |
| **Back**                | Format: `back`                                                                                                                                                                                                          |
| **List**                | Format: `list`                                                                                                                                                                                                          |
| **Create Meeting**      | Format: `meet <ALL FIELDS IN ANY ORDER` <br> Example: `meet for/Project Discussion in/UTown on/28-04-2022 13:30 with/1 3 4`                                                                                             |
| **Update Meeting**      | Format: `update <MEETING INDEX> <ANY FIELDS IN ANY ORDER` <br> Example: `update 2 in/COM2 on/29-04-2022 20:00`                                                                                                          |
| **Cancel Meeting**      | **Cancel specific meeting** <br> Format: `cancel <MEETING INDEX>` <br> Example: `cancel 2` <br> <br> **Cancel all meetings** <br> Format: `cancel-all`                                                                  |
| **Help**                | Format: `help`                                                                                                                                                                                                          |
| **Exit**                | Format: `exit`                                                                                                                                                                                                          |

## 5. Contact Fields Summary

| **Field**        | **Mandatory** | **Format, Example**                                                                                                            |
|------------------|---------------|--------------------------------------------------------------------------------------------------------------------------------|
| **Name**         | Yes           | Format: `n/<NAME>` <br> Example: `n/Alex Dunphy`                                                                               |
| **Phone Number** | No            | Format: `ph/<NUMBER 1> l/<LABEL> ph/<NUMBER 2> l/<LABEL>...` <br> Example: `ph/98765432 l/Personal ph/9753468 l/Office`        |
| **Email ID**     | No            | Format: `e/<EMAIL 1> l/<LABEL> e/<EMAIL 2> l/<LABEL>...` <br> Example: `e/alex@reache.com l/Official e/alex98@gmail.com`       |
| **Address**      | No            | Format: `a/<ADDRESS 1> l/<LABEL> a/<ADDRESS 2> l/<LABEL>...` <br> Example: `a/28 Francis Mine, Sacramento, CA - 654321 l/Home` |
| **Company**      | No            | Format: `c/<COMPANY>` <br> Example: `c/Tesla`                                                                                  |
| **Job Title**    | No            | Format: `j/<JOB TITLE>` <br> Example: `j/Software Engineer`                                                                    |
| **Tags**         | No            | Format: `t/<TAG 1> t/<TAG 2>...` <br> Example: `t/MediaContact t/HasKids`                                                      |
| **Pronouns**     | No            | Format: `pr/<PRONOUNS>` <br> Example: `pr/They pr/Them`                                                                        |


## 6. Meeting Fields Summary

| **Field**         | **Mandatory** | **Format, Example**                                                                 |
|-------------------|---------------|-------------------------------------------------------------------------------------|
| **Agenda**        | Yes           | Format: `for/<AGENDA>` <br> Example: `for/Project Consulation`                      |
| **Meeting Place** | Yes           | Format: `in/<MEETING PLACE>` <br> Example: `in/Zoom`                                |
| **Meeting Time**  | Yes           | Format: `on/<MEETING TIME AS DD-MM-YYYY HH:mm>` <br> Example: `on/14-04-2022 14:00` |
| **Attendees**     | Yes           | Format: `with/<ATTENDEE 1 INDEX>...` <br> Example: `with/1 3 5`                     |
